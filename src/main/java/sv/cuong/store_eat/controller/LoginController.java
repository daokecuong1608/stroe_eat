package sv.cuong.store_eat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.cuong.store_eat.payload.ResponseData;
import sv.cuong.store_eat.payload.request.SignUpRequest;
import sv.cuong.store_eat.repository.UserRepository;
import sv.cuong.store_eat.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userInterface;

    @Autowired
    private LoginService loginService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password) {
        ResponseData responseData = new ResponseData();
        if (loginService.checkLogin(username, password)) {
            responseData.setData(true);
        } else {
            responseData.setData(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest) {
        ResponseData responseData = new ResponseData();
        responseData.setData(loginService.addUser(signUpRequest));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
