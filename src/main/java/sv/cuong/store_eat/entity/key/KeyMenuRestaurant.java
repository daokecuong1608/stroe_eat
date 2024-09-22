package sv.cuong.store_eat.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class KeyMenuRestaurant implements Serializable {

    @Column(name="cate_id")
    private int cate_id;

    @Column(name = "res_id")
    private int res_id;

    public KeyMenuRestaurant() {
    }

    public KeyMenuRestaurant(int cate_id, int res_id) {
        this.cate_id = cate_id;
        this.res_id = res_id;
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }
}
