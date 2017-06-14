package jiyun.com.doctorsixsixsix.modle.bean;

import com.google.gson.Gson;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.json.JSONException;
import org.json.JSONObject;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/14 11:30
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
@Entity
public class XueYa {

    /**
     * app_data : temp_automactily_device_identify
     * app_user_id :
     * datatime : 1497410700
     * heart : 0.0
     * high : 128.0
     * low : 56.0
     * shou_data : temp_handly_device_identify
     * xywy_userid : 116924108
     */
    @Id(autoincrement = true)
    private Long id;
    private String app_data;
    private String app_user_id;
    private long datatime;
    private double heart;
    private double high;
    private double low;
    private String shou_data;
    private String xywy_userid;


    @Generated(hash = 1368759655)
    public XueYa(Long id, String app_data, String app_user_id, long datatime,
            double heart, double high, double low, String shou_data,
            String xywy_userid) {
        this.id = id;
        this.app_data = app_data;
        this.app_user_id = app_user_id;
        this.datatime = datatime;
        this.heart = heart;
        this.high = high;
        this.low = low;
        this.shou_data = shou_data;
        this.xywy_userid = xywy_userid;
    }

    @Generated(hash = 1682362419)
    public XueYa() {
    }


    public String getApp_data() {
        return app_data;
    }

    public void setApp_data(String app_data) {
        this.app_data = app_data;
    }

    public String getApp_user_id() {
        return app_user_id;
    }

    public void setApp_user_id(String app_user_id) {
        this.app_user_id = app_user_id;
    }

    public long getDatatime() {
        return datatime;
    }

    public void setDatatime(long datatime) {
        this.datatime = datatime;
    }

    public double getHeart() {
        return heart;
    }

    public void setHeart(double heart) {
        this.heart = heart;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public String getShou_data() {
        return shou_data;
    }

    public void setShou_data(String shou_data) {
        this.shou_data = shou_data;
    }

    public String getXywy_userid() {
        return xywy_userid;
    }

    public void setXywy_userid(String xywy_userid) {
        this.xywy_userid = xywy_userid;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
