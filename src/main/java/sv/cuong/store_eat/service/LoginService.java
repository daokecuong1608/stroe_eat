package sv.cuong.store_eat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sv.cuong.store_eat.dto.UserDTO;
import sv.cuong.store_eat.entity.Roles;
import sv.cuong.store_eat.entity.Users;
import sv.cuong.store_eat.payload.request.SignUpRequest;
import sv.cuong.store_eat.repository.UserRepository;
import sv.cuong.store_eat.service.impl.LoginServiceIpml;

import java.util.ArrayList;
import java.util.List;

@Service //xử lý logic code
public class LoginService implements LoginServiceIpml {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUser() {

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

    @Override
    public boolean checkLogin(String username, String password) {
        List<Users> listUser = userRepository.findByUserNameAndPassword(username, password);
        return listUser.size() > 0;
    }

    @Override
    public boolean addUser(SignUpRequest signUpRequest) {

        Roles roles= new Roles();
        roles.setId(signUpRequest.getRoleseId());

        Users users = new Users();
        users.setFullname(signUpRequest.getFullName());
        users.setUserName(signUpRequest.getEmail());
        users.setPassword(signUpRequest.getPassword());
        try {
            userRepository.save(users);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
