package sv.cuong.store_eat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.cuong.store_eat.dto.UserDTO;
import sv.cuong.store_eat.entity.Users;
import sv.cuong.store_eat.repository.UserRepository;
import sv.cuong.store_eat.service.impl.UserServiceIpml;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceIpml {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUser() {
       List<Users> listUsers = new ArrayList<>();
       List<UserDTO> userDTOList = new ArrayList<>();

       for (Users users: listUsers){
           UserDTO userDTO = new UserDTO();
           userDTO.setId(users.getId());
           userDTO.setUserName(users.getUserName());
           userDTO.setFullname(users.getFullname());
           userDTO.setPassword(users.getPassword());

           userDTOList.add(userDTO);
       }
       return userDTOList;
    }
}
