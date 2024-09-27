package sv.cuong.store_eat.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CatagoryDTO {
    private  String name;
    private List<MenuDTO>  menus;


}
