package jiyun.com.doctorsixsixsix.modle.bean;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import jiyun.com.doctorsixsixsix.base.BaseBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/10 9:37
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Person extends BaseBean {

    /**
     * state : 200
     * email :
     * pushable : 1
     * avatar : http://xs3.op.xywy.com/api.iu1.xywy.com/ucenter/20170609/bd50e3a21fab60c5f2c08210a735bf3047552.jpg
     * accounts : [{"accountid":0,"accountstr":"啊啊啊","sex":"女","height":"","birthday":"0000-00-00"}]
     */

    private int state;
    private String email;
    private int pushable;
    private String avatar;
    /**
     * accountid : 0
     * accountstr : 啊啊啊
     * sex : 女
     * height :
     * birthday : 0000-00-00
     */

    private List<AccountsBean> accounts;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPushable() {
        return pushable;
    }

    public void setPushable(int pushable) {
        this.pushable = pushable;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<AccountsBean> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountsBean> accounts) {
        this.accounts = accounts;
    }

    public static class AccountsBean {
        private int accountid;
        private String accountstr;
        private String sex;
        private String height;
        private String birthday;

        public int getAccountid() {
            return accountid;
        }

        public void setAccountid(int accountid) {
            this.accountid = accountid;
        }

        public String getAccountstr() {
            return accountstr;
        }

        public void setAccountstr(String accountstr) {
            this.accountstr = accountstr;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }
}
