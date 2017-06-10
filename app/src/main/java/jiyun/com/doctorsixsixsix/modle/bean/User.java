package jiyun.com.doctorsixsixsix.modle.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import jiyun.com.doctorsixsixsix.base.BaseBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/10 8:47
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class User extends BaseBean implements Parcelable {

    /**
     * state : 200
     * userid : 116924108
     * isregister : 1
     * phonenum : 15712820818
     * height : 0
     * sex : 女
     * birthday : 0000-00-00
     */

    private int state;
    private String userid;
    private int isregister;
    private String phonenum;
    private int height;
    private String sex;
    private String birthday;


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getIsregister() {
        return isregister;
    }

    public void setIsregister(int isregister) {
        this.isregister = isregister;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.state);
        dest.writeString(this.userid);
        dest.writeInt(this.isregister);
        dest.writeString(this.phonenum);
        dest.writeInt(this.height);
        dest.writeString(this.sex);
        dest.writeString(this.birthday);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.state = in.readInt();
        this.userid = in.readString();
        this.isregister = in.readInt();
        this.phonenum = in.readString();
        this.height = in.readInt();
        this.sex = in.readString();
        this.birthday = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
