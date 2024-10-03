package sv.cuong.store_eat.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sv.cuong.store_eat.payload.ResponseData;
import sv.cuong.store_eat.service.impl.CatagoryServiceIpml;

@CrossOrigin("*")
@RequestMapping("/catagory")
@RestController
public class CatagoryController {

    @Autowired
    private CatagoryServiceIpml catagoryServiceIpml;

    @GetMapping
    public ResponseEntity<?> getCatagoryRestaurant() {
        ResponseData responseData = new ResponseData();
        responseData.setData(catagoryServiceIpml.getCatagoryHomePage());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @CacheEvict(value = "catagoryhome" , allEntries = true)
    @GetMapping("/clear-cache")
    public String  clearCache() {
        return  "Clear Cache";
    }
}
