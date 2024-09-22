package sv.cuong.store_eat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.cuong.store_eat.entity.Restaurant;

@Repository
public interface RestaurantRespository extends JpaRepository<Restaurant , Integer> {
}
