package sv.cuong.store_eat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "craete_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles roles;


    @OneToMany(mappedBy = "users")
    private Set<RatingFood> listRatingFoods;


    @OneToMany(mappedBy = "users")
    private Set<RatingRestaurant> listRatingRestaurants;

    @OneToMany(mappedBy = "users")
    private Set<Orders> listOrders;
}