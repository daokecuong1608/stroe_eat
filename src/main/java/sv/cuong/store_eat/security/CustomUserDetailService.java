package sv.cuong.store_eat.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sv.cuong.store_eat.entity.Users;
import sv.cuong.store_eat.repository.UserRepository;

import java.util.ArrayList;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUserName(username);
        if (users == null) {
            throw new UsernameNotFoundException("User can't exist");
        }
        //tao chung thuc
        System.out.println("username" + users.getUserName());
        return new User(username, users.getPassword(), new ArrayList<>());
    }
}
