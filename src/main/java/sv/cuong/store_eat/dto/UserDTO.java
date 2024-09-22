package sv.cuong.store_eat.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int id;
    private String userName;
    private String password;
    private String fullname;
    private Date createDate;
}
