package sv.cuong.store_eat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.cuong.store_eat.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders , Integer> {
}
