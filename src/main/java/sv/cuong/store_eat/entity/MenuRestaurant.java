package sv.cuong.store_eat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sv.cuong.store_eat.entity.key.KeyMenuRestaurant;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "menu_restaurant")
public class MenuRestaurant {

    @EmbeddedId
    KeyMenuRestaurant keys;
    @ManyToOne
    @JoinColumn(name = "cate_id", insertable = false, updatable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "res_id", insertable = false, updatable = false)
    private Restaurant restaurant;

    @Column(name = "create_date", insertable = false, updatable = false)
    private Date createDate;
}