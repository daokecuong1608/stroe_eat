package sv.cuong.store_eat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.cuong.store_eat.service.impl.UserServiceIpml;

@RestController
@RequestMapping("/user")
public class UserController {

@Autowired
private UserServiceIpml userServiceIpml;

    @GetMapping()
    public ResponseEntity<?>getAllUser(){
        return new ResponseEntity(userServiceIpml.getAllUser() , HttpStatus.OK);
    }
}
