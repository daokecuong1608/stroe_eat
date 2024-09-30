package sv.cuong.store_eat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sv.cuong.store_eat.payload.ResponseData;
import sv.cuong.store_eat.repository.FoodRepository;
import sv.cuong.store_eat.service.impl.FileServiceIpml;
import sv.cuong.store_eat.service.impl.MenuServiceImpl;

@CrossOrigin("*")
@RequestMapping("/menu")
@RestController
public class MenuController {

  @Autowired
  private MenuServiceImpl muMenuService;

  @Autowired
  private FileServiceIpml fileServiceIpml;

    @PostMapping("")
    public ResponseEntity<?> createMenu(
            @RequestParam MultipartFile file,
            @RequestParam String title,
            @RequestParam boolean is_freeShip,
            @RequestParam String time_ship,
            @RequestParam String price,
            @RequestParam int cate_id) {
        ResponseData responseData = new ResponseData();

        responseData.setData(muMenuService.createMenu(file, title, is_freeShip, time_ship, price, cate_id));
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename) {
        Resource resource = fileServiceIpml.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);

    }
}
