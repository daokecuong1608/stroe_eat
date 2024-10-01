package sv.cuong.store_eat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.cuong.store_eat.payload.request.OrderRequest;
import sv.cuong.store_eat.service.impl.OrderServiceIpml;


@RestController
@RequestMapping("/order")
public class OrderController {

@Autowired
private OrderServiceIpml orderServiceIpml;

    @PostMapping()
    public ResponseEntity<?> oderOrder(@RequestBody OrderRequest orderRequest){


        return new ResponseEntity<>(orderServiceIpml.insertOrder(orderRequest) , HttpStatus.OK);

    }

}
