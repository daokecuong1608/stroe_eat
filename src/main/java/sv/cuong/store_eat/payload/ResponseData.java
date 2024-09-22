package sv.cuong.store_eat.payload;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseData {
    private int status = 200;
    private  String desc;
    private Object data;
}
