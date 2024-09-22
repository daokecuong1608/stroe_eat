package sv.cuong.store_eat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.cuong.store_eat.dto.UserDTO;
import sv.cuong.store_eat.entity.Users;
import sv.cuong.store_eat.repository.UserInterface;

import java.util.ArrayList;
import java.util.List;

@Service //xử lý logic code
public class LoginService {

    @Autowired
private UserInterface userInterface;

    public List<UserDTO> getAllUser(){

        List<Users> list = new ArrayList<Users>();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (Users users : list) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setUserName(users.getUserName());
            userDTO.setFullname(users.getFullname());
            userDTO.setCreateDate(users.getCreateDate());
            userDTO.setPassword(users.getPassword());
            userDTOList.add(userDTO);

        }
return userDTOList;
    }

}
