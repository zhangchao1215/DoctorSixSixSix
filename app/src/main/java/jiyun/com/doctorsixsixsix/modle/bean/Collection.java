package jiyun.com.doctorsixsixsix.modle.bean;

import java.util.List;

import jiyun.com.doctorsixsixsix.base.BaseBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/11 20:31
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Collection extends BaseBean {
    private int state;
    private String error;
    private List<Databean> data;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Databean> getData() {
        return data;
    }

    public void setData(List<Databean> data) {
        this.data = data;
    }

    public static class Databean{
        private String categoryid;
        private String document_id;
        private String meta;
        private String title;

        public String getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(String categoryid) {
            this.categoryid = categoryid;
        }

        public String getDocument_id() {
            return document_id;
        }

        public void setDocument_id(String document_id) {
            this.document_id = document_id;
        }

        public String getMeta() {
            return meta;
        }

        public void setMeta(String meta) {
            this.meta = meta;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
