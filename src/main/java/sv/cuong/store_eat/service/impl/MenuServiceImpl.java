package sv.cuong.store_eat.service.impl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImpl {

    public boolean createMenu(
            MultipartFile file,
            String title,
            boolean is_freeShip,
            String time_ship,
            String price,
            int cate_id
    );

}
