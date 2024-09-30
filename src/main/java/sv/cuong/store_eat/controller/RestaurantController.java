package sv.cuong.store_eat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sv.cuong.store_eat.payload.ResponseData;
import sv.cuong.store_eat.service.impl.FileServiceIpml;
import sv.cuong.store_eat.service.impl.RestaurantServiceIpml;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private FileServiceIpml fileServiceIpml;

    @Autowired
    private RestaurantServiceIpml restaurantServiceIpml;

    @PostMapping("")
    public ResponseEntity<?> createRestaurant(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam String subtitle,
            @RequestParam String description,
            @RequestParam boolean is_freeship,
            @RequestParam String address,
            @RequestParam String open_date) {
        ResponseData responseData = new ResponseData();
        boolean isSuccesful = restaurantServiceIpml.insertRestaurant(file, title, subtitle, description, is_freeship, address, open_date);

        responseData.setData(isSuccesful);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllRestaurant() {
        // TODO: Implement logic to get all restaurant
        ResponseData responseData = new ResponseData();
        responseData.setData(restaurantServiceIpml.getHomePageRestaurants());
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }


    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename) {
        Resource resource = fileServiceIpml.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getDetailRestaurant(@RequestParam int id) {
        // TODO: Implement logic to get all restaurant
        ResponseData responseData = new ResponseData();
responseData.setData(restaurantServiceIpml.getDetailRestaurant(id));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
