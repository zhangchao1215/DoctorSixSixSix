package jiyun.com.doctorsixsixsix.modle.bean;

import jiyun.com.doctorsixsixsix.base.BaseBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/9 20:24
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class upLoadImage extends BaseBean {
    private String data;
    private String status;
    private String message;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
