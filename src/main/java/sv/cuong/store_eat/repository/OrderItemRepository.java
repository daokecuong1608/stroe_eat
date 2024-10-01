package sv.cuong.store_eat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.cuong.store_eat.entity.OrderItem;
import sv.cuong.store_eat.entity.key.KeyOdersItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem , KeyOdersItem> {
}
