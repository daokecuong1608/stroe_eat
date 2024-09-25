package sv.cuong.store_eat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor

@Setter
@Entity(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name = "is_freeship")
    private boolean isFreeship;

    @Column(name = "address")
    private String address;

    @Column(name = "open_date")
    private Date openDate;

    @OneToMany(mappedBy = "restaurants")
    private Set<RatingRestaurant> listRatingRestaurants;

    @OneToMany(mappedBy = "restaurants")
    private Set<Orders> listOrders;

    @OneToMany(mappedBy = "restaurant")
    private Set<MenuRestaurant> listMenuRestaurants;

    @OneToMany(mappedBy = "restaurant")
    private Set<Promo> listPromos;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public String getAddress() {
        return address;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public Set<RatingRestaurant> getListRatingRestaurants() {
        return listRatingRestaurants;
    }

    public Set<Orders> getListOrders() {
        return listOrders;
    }

    public Set<MenuRestaurant> getListMenuRestaurants() {
        return listMenuRestaurants;
    }

    public Set<Promo> getListPromos() {
        return listPromos;
    }
}