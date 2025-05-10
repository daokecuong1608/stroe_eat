package sv.cuong.store_eat.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.cuong.store_eat.entity.*;
import sv.cuong.store_eat.entity.key.KeyOdersItem;
import sv.cuong.store_eat.payload.request.OrderRequest;
import sv.cuong.store_eat.repository.OrderItemRepository;
import sv.cuong.store_eat.repository.OrderRepository;
import sv.cuong.store_eat.service.impl.OrderServiceIpml;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements OrderServiceIpml {

@Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

//    @Transactional
    @Override
    public boolean insertOrder(OrderRequest orderRequest) {

        try {
            Users users = new Users();
            users.setId(orderRequest.getUserID());

            Restaurant restaurant = new Restaurant();
            restaurant.setId(orderRequest.getRestaurantID());

            Orders orders = new Orders();
            orders.setUsers(users);
            orders.setRestaurants(restaurant);

            orderRepository.save(orders);
            List<OrderItem> orderItems = new ArrayList<>();
            for (int idFood : orderRequest.getFoodIDs()) {
                Food food = new Food();
                food.setId(idFood);

                OrderItem orderItem = new OrderItem();
                KeyOdersItem keyOdersItem = new KeyOdersItem(orders.getId() , idFood);
              orderItem.setKeyOdersItem(keyOdersItem);


                orderItems.add(orderItem);
            }

            orderItemRepository.saveAll(orderItems);
            return true;

        }catch (Exception e){
            System.out.println("loi " + e.getMessage());
            return false;

        }
    }
}

