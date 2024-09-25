package sv.cuong.store_eat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sv.cuong.store_eat.entity.Restaurant;
import sv.cuong.store_eat.repository.RestaurantRespository;
import sv.cuong.store_eat.service.impl.FileServiceIpml;
import sv.cuong.store_eat.service.impl.RestaurantServiceIpml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class RestaurantService implements RestaurantServiceIpml {

    @Autowired
    private RestaurantRespository restaurantRespository;
    @Autowired
    private FileServiceIpml fileServiceIpml;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description,  boolean is_freeship, String address, String open_date) {
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
}
