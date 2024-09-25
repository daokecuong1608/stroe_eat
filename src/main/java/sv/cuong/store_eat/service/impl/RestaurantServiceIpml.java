package sv.cuong.store_eat.service.impl;

import org.springframework.web.multipart.MultipartFile;
import sv.cuong.store_eat.dto.RestaurantDTO;

import java.util.Date;
import java.util.List;

public interface RestaurantServiceIpml {

    public boolean insertRestaurant(
            MultipartFile file,
            String title,
            String subtitle,
            String description,
            boolean is_freeship,
            String address,
            String open_date
    );

    List<RestaurantDTO> getHomePageRestaurants();

}
