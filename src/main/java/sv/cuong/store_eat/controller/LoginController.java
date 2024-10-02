package sv.cuong.store_eat.controller;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.cuong.store_eat.payload.ResponseData;
import sv.cuong.store_eat.payload.request.SignUpRequest;
import sv.cuong.store_eat.repository.UserRepository;
import sv.cuong.store_eat.service.LoginService;
import sv.cuong.store_eat.util.JwtUtilHelper;

import javax.crypto.SecretKey;
import java.util.Base64;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private JwtUtilHelper jwtUtilHelper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, @RequestParam String password) {
        ResponseData responseData = new ResponseData();

        logger.trace("Kiem tra trace log");
        logger.debug("Kiem tra debug log");
        logger.info("Kiem tra info log");
        logger.warn("Kiem tra warn log");
        logger.error("Kiem tra error log");

        if (loginService.checkLogin(username, password)) {
            String token = jwtUtilHelper.generateToken(username);
            System.out.println(token);
            responseData.setData(token);
        } else {
            responseData.setData("");
            responseData.setSuccess(false);
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
