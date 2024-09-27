package sv.cuong.store_eat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sv.cuong.store_eat.dto.CatagoryDTO;
import sv.cuong.store_eat.dto.MenuDTO;
import sv.cuong.store_eat.entity.Category;
import sv.cuong.store_eat.entity.Food;
import sv.cuong.store_eat.repository.CatagoryRepository;
import sv.cuong.store_eat.service.impl.CatagoryServiceIpml;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatagoryService implements CatagoryServiceIpml {

    @Autowired
    private CatagoryRepository catagoryRepository;


    @Override
    public List<CatagoryDTO> getCatagoryHomePage() {
        PageRequest pageRequest = PageRequest.of(0, 2, Sort.by("id"));
        Page<Category> result = catagoryRepository.findAll(pageRequest);
        List<CatagoryDTO> resultList = new ArrayList<>();
        for (Category category : result) {
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
            resultList.add(catagoryDTO);
        }

        return resultList;
    }
}
