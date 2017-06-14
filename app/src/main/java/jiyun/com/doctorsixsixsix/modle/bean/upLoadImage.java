package jiyun.com.doctorsixsixsix.modle.bean;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

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

    /**
     * data : http://xs3.op.xywy.com/api.iu1.xywy.com/ucenter/20170614/4c4b02130873cfc7be5ba138417f991a57147.jpg
     * status : 2
     * message :
     */

    private String data;
    private int status;
    private String message;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
