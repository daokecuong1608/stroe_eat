package sv.cuong.store_eat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sv.cuong.store_eat.entity.Category;
import sv.cuong.store_eat.entity.Food;
import sv.cuong.store_eat.entity.Restaurant;
import sv.cuong.store_eat.repository.FoodRepository;
import sv.cuong.store_eat.service.impl.FileServiceIpml;
import sv.cuong.store_eat.service.impl.MenuServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MenuService implements MenuServiceImpl {

    @Autowired
    private FileServiceIpml fileServiceIpml;

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public boolean createMenu(MultipartFile file, String title, boolean is_freeShip, String time_ship, String price, int cate_id) {
        boolean isInsertSuccess = false;
        try {
            boolean isSucces = fileServiceIpml.saveFile(file);
            if (isSucces) {
                Food food = new Food();
                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setFreeship(is_freeShip);
                food.setTimeShip(time_ship);
                food.setPrice(Double.parseDouble(price));
                Category category = new Category();
                category.setId(cate_id);
                food.setCategory(category);

                foodRepository.save(food);
                isInsertSuccess = true;
            }
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println("error " + e.getMessage());
        }
        return isInsertSuccess;
    }
}
