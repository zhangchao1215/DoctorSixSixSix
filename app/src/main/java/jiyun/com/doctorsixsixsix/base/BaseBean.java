package jiyun.com.doctorsixsixsix.base;

/**
 * Created by dell on 2017/6/9.
 */

public abstract class BaseBean {
    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
