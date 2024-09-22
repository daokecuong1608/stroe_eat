package sv.cuong.store_eat.service.impl;

import sv.cuong.store_eat.dto.UserDTO;
import sv.cuong.store_eat.service.LoginService;

import java.util.List;

public interface LoginServiceIpml  {

public List<UserDTO> getAllUser();

public boolean checkLogin(String username, String password);
}
