package sv.cuong.store_eat.payload.request;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String fullName;
    private String email;
    private String password;
private  int roleseId;

}
