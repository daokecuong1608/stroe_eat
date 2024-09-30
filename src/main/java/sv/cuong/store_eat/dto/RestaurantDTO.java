package sv.cuong.store_eat.dto;

import lombok.Getter;
import lombok.Setter;
import sv.cuong.store_eat.entity.Category;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RestaurantDTO {
    private String image;
    private String title;
    private double rating;
    private String subtitle;
    private boolean isFreeShip;
    private Date openDay;
    private List<CatagoryDTO> catagoryDTOS;

}
