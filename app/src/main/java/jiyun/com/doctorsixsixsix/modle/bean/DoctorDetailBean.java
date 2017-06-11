package jiyun.com.doctorsixsixsix.modle.bean;

import java.util.List;

import jiyun.com.doctorsixsixsix.base.BaseBean;

/**
 * 项目名称: 血压卫士
 * 类描述:  这是换一换点击详情的实体类
 * 创建人: Administrator
 * 创建时间: 2017/6/11 19:54
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class DoctorDetailBean extends BaseBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * document_id : 1493
         * title : 得了干燥综合症现在能怀孕吗？
         * club_id : 8542328
         * reply : 你好。看到编辑转来你的咨询信息，因未见到病人，意见仅供参考。治疗干燥综合征的药物有激素、免疫抑制剂、中药等。需要根据病情和实验室检查综合治疗。除西药外，可以服用中药调节。还要注意情绪，不要着急生气，思想负担不要太大。本病不能治愈，但是可以控制病情。积极治疗。定期复查。血沉快、不知免疫球蛋白、肝肾功能、自身抗体等如何？目前不宜怀孕。最好还是先到当地大医院风湿免疫科就诊。
         */

        private String document_id;
        private String title;
        private String club_id;
        private String reply;

        public String getDocument_id() {
            return document_id;
        }

        public void setDocument_id(String document_id) {
            this.document_id = document_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getClub_id() {
            return club_id;
        }

        public void setClub_id(String club_id) {
            this.club_id = club_id;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }
    }
}
