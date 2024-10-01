package sv.cuong.store_eat.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    private int userID;
    private int restaurantID;
    private int[] foodIDs;


}
