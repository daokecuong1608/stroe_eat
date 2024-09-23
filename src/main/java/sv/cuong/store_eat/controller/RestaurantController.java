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

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private FileServiceIpml fileServiceIpml;

    @PostMapping("")
    public ResponseEntity<?> createRestaurant(@RequestParam MultipartFile file) {
        ResponseData responseData = new ResponseData();
        boolean isSucces = fileServiceIpml.saveFile(file);
        responseData.setData(isSucces);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename) {
     Resource resource =  fileServiceIpml.loadFile(filename);
        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION , "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);

    }

}
