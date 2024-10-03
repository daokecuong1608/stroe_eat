package sv.cuong.store_eat.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import sv.cuong.store_eat.dto.CatagoryDTO;
import sv.cuong.store_eat.dto.MenuDTO;
import sv.cuong.store_eat.entity.Category;
import sv.cuong.store_eat.entity.Food;
import sv.cuong.store_eat.repository.CatagoryRepository;
import sv.cuong.store_eat.service.impl.CatagoryServiceIpml;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatagoryService implements CatagoryServiceIpml {

    @Autowired
    private CatagoryRepository catagoryRepository;

    // @Cacheable("catagoryhome")
//luu du lieu lan dau lay vao ram => lan sau goi controller chi vc lay trong ram => ko can truy van
    @Autowired
    private RedisTemplate redisTemplate;


    private Gson gson = new Gson();

    @Override
    public List<CatagoryDTO> getCatagoryHomePage() {
        List<CatagoryDTO> catagoryDTOs = new ArrayList<>();

        //ktra du lieu co tren redis chua
        String dataRedis = (String) redisTemplate.opsForValue().get("catagory");
        if (dataRedis != null) {
            System.out.println("chua co data");
            PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("id"));
            Page<Category> listCategory = catagoryRepository.findAll(pageRequest);
            for (Category category : listCategory) {
                CatagoryDTO catagoryDTO = new CatagoryDTO();
                catagoryDTO.setName(category.getNameCate());
                List<MenuDTO> list = new ArrayList<>();
                for (Food food : category.getListFood()) {
                    MenuDTO menuDTO = new MenuDTO();
                    menuDTO.setTitle(food.getTitle());
                    menuDTO.setFreeShip(food.isFreeship());
                    menuDTO.setImage(food.getImage());
                    list.add(menuDTO);
                }
                catagoryDTO.setMenus(list);
                catagoryDTOs.add(catagoryDTO);
            }
            String dataJSON = gson.toJson(catagoryDTOs);
            //day data len redis de luu tru
            redisTemplate.opsForValue().set("catagory", dataJSON);
        } else {
            Type type = new TypeToken<List<CatagoryDTO>>() {
            }.getType();
            catagoryDTOs = gson.fromJson(dataRedis, type);
            System.out.println("co data base");
        }
        return catagoryDTOs;
    }
}
