package sv.cuong.store_eat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.cuong.store_eat.dto.UserDTO;
import sv.cuong.store_eat.entity.Users;
import sv.cuong.store_eat.repository.UserInterface;
import sv.cuong.store_eat.service.LoginService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserInterface userInterface;

    @Autowired
    private LoginService loginService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin() {
        return new ResponseEntity<>(loginService.getAllUser(), HttpStatus.OK);
    }

}
