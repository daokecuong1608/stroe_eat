package sv.cuong.store_eat.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import sv.cuong.store_eat.service.impl.FileServiceIpml;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService implements FileServiceIpml {

    @Value("${fileUpload.rootPath}")
    private String fileUploadRootPath;
    private Path root;

    //tao ra folder neu ko ton tai
    public void init() {
        try {
            root = Paths.get(fileUploadRootPath);
            if (Files.notExists(root)) {
                Files.createDirectories(root);

            }
        } catch (Exception e) {
            System.out.println("enter create directory" + e.getMessage());
        }
    }

    @Override
    public boolean saveFile(MultipartFile file) {
        try {
            init();
            Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("error save file" + e.getMessage());
            return false;
        }
    }

    @Override
    public Resource loadFile(String filename) {
        try {
            init();
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
        } catch (Exception e) {
            System.out.println("error load file" + e.getMessage());
        }
        return null;
    }
}
