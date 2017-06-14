package jiyun.com.doctorsixsixsix.modle.bean;

import jiyun.com.doctorsixsixsix.base.BaseBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/14 11:49
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Record extends BaseBean {
    private int status;
    private Data data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data{
        public long getDatatime() {
            return datatime;
        }

        public void setDatatime(long datatime) {
            this.datatime = datatime;
        }

        private long datatime;
    }
}
