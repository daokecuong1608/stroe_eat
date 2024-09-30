package sv.cuong.store_eat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sv.cuong.store_eat.dto.CatagoryDTO;
import sv.cuong.store_eat.dto.MenuDTO;
import sv.cuong.store_eat.dto.RestaurantDTO;
import sv.cuong.store_eat.entity.Food;
import sv.cuong.store_eat.entity.MenuRestaurant;
import sv.cuong.store_eat.entity.RatingRestaurant;
import sv.cuong.store_eat.entity.Restaurant;
import sv.cuong.store_eat.repository.RestaurantRespository;
import sv.cuong.store_eat.service.impl.FileServiceIpml;
import sv.cuong.store_eat.service.impl.RestaurantServiceIpml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RestaurantService implements RestaurantServiceIpml {

    @Autowired
    private RestaurantRespository restaurantRespository;
    @Autowired
    private FileServiceIpml fileServiceIpml;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description, boolean is_freeship, String address, String open_date) {
        boolean isInsertSuccess = false;
        try {
            boolean isSucces = fileServiceIpml.saveFile(file);
            if (isSucces) {
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDescription(description);
                restaurant.setImage(file.getOriginalFilename());
                restaurant.setFreeship(is_freeship);
                restaurant.setAddress(address);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                Date openDate = simpleDateFormat.parse(open_date);
                restaurant.setOpenDate(openDate);
                restaurantRespository.save(restaurant);
                isInsertSuccess = true;
            }
        } catch (ParseException e) {
//            throw new RuntimeException(e);
            System.out.println("error " + e.getMessage());
        }
        return isInsertSuccess;
    }

    @Override
    public List<RestaurantDTO> getHomePageRestaurants() {
        List<RestaurantDTO> restaurantDTOS = new ArrayList<RestaurantDTO>();
        PageRequest pageRequest = PageRequest.of(0, 6);
        Page<Restaurant> listData = restaurantRespository.findAll(pageRequest);
        for (Restaurant restaurant : listData) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setImage(restaurant.getImage());
            restaurantDTO.setTitle(restaurant.getTitle());
            restaurantDTO.setSubtitle(restaurant.getSubtitle());
            restaurantDTO.setFreeShip(restaurant.isFreeship());
            restaurantDTO.setRating(calculateRating(restaurant.getListRatingRestaurants()));
            restaurantDTOS.add(restaurantDTO);
        }
        return restaurantDTOS;
    }

    //lay tong so danh gia
    private double calculateRating(Set<RatingRestaurant> listrating) {
        double totalPoint = 0;
        for (RatingRestaurant restaurant : listrating) {
            totalPoint += restaurant.getRate_point();
        }
        return totalPoint / listrating.size();
    }


    //Optional : có hay ko đều đc
    @Override
    public RestaurantDTO getDetailRestaurant(int id) {
        Optional<Restaurant> restaurant = restaurantRespository.findById(id);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        if (restaurant.isPresent()) {
            List<CatagoryDTO> catagoryDTOList = new ArrayList<>();

            restaurantDTO.setTitle(restaurant.get().getTitle());
            restaurantDTO.setSubtitle(restaurant.get().getSubtitle());
            restaurantDTO.setImage(restaurant.get().getImage());
            restaurantDTO.setFreeShip(restaurant.get().isFreeship());
            restaurantDTO.setRating(calculateRating(restaurant.get().getListRatingRestaurants()));
            restaurantDTO.setOpenDay(restaurant.get().getOpenDate());

            //category
            for (MenuRestaurant menuRestaurant : restaurant.get().getListMenuRestaurants()) {
                CatagoryDTO catagoryDTO = new CatagoryDTO();
                catagoryDTO.setName(menuRestaurant.getCategory().getNameCate());
                List<MenuDTO> menuDTOList = new ArrayList<>();
                for (Food food : menuRestaurant.getCategory().getListFood()) {
                    MenuDTO menuDTO = new MenuDTO();
                    menuDTO.setImage(food.getImage());
                    menuDTO.setTitle(food.getTitle());
                    menuDTO.setFreeShip(food.isFreeship());
                    menuDTOList.add(menuDTO);
                }
                catagoryDTO.setMenus(menuDTOList);
                catagoryDTOList.add(catagoryDTO);
            }
            restaurantDTO.setCatagoryDTOS(catagoryDTOList);
        }
        return null;
    }
}
