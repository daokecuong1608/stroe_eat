package sv.cuong.store_eat.payload;


import lombok.*;


public class ResponseData {
    private int status = 200;
    private String desc;
    private Object data;
    private boolean isSuccess=true;

    public ResponseData(int status, String desc, Object data, boolean isSuccess) {
        this.status = status;
        this.desc = desc;
        this.data = data;
        this.isSuccess = isSuccess;
    }

    public ResponseData() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
