package sv.cuong.store_eat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sv.cuong.store_eat.entity.Users;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users , Integer> {


    public List<Users> findByUserNameAndPassword(String useName, String password);
//    public Users findByUserName(String userName);

}
