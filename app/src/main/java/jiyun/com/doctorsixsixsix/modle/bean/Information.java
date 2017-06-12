package jiyun.com.doctorsixsixsix.modle.bean;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import jiyun.com.doctorsixsixsix.base.BaseBean;

/**
 * 项目名称: 血压卫士
 * 类描述: 资讯的实体类
 * 创建人: 马杰
 * 创建时间: 2017/6/12 9:31
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class Information extends BaseBean {

    /**
     * id : 1494642
     * title : 高血压冠心病如何保健有效
     * description : 高血压冠心病如何保健?高血压冠心病会严重折磨大家的精神，给患者带来不小的负担，想要规避疾病危害，大家一定要正确的了解疾病，尤其要知道高血压冠心病如何保健，这样才能够帮助大家尽早恢复身体健康，保证大家的安全。高血压冠心病如何保健：1.合理调整饮食
     * pubdate : 1490954642
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String title;
        private String description;
        private String pubdate;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }
    }
}
