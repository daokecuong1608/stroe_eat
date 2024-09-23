package sv.cuong.store_eat.service.impl;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceIpml {

    public boolean saveFile(MultipartFile file);

    public Resource loadFile(String filename);

}
