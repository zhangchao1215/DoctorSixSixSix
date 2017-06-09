package jiyun.com.doctorsixsixsix.modle.bean;

import java.util.List;

/**
 * 项目名称: 血压卫士
 * 类描述: 实体类
 * 创建人: 张超
 * 创建时间: 2017/6/9 10:36
 * 修改人:  张超
 * 修改内容: 主页面显示的医生
 * 修改时间:  6-9 星期五上午
 */

public class MainDoctorBean{
    private int code;
    private int total;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * document_id : 31540
         * score : NaN
         * document_weight : 223.497
         * name : 李明
         * doctorPinyin : gukeliming
         * title : 主任医师
         * teach : 教授
         * goodat : 脊柱侧后凸畸形、颈椎病、腰椎间盘突出症、腰椎管狭窄症、腰椎滑脱症、脊柱骨折、脊柱肿瘤、脊柱结核等外科治疗。
         * app_image : http://static.i2.xywy.com/zhuanjia/20141230/a6f380b3247db39a2f807bfae0b4a67584425_d.jpg
         * hospital : 上海长海医院
         * province : 上海市
         * city : 杨浦
         * level : 三级甲等
         * depart : 骨科
         * uuidDepart : 4902
         * depart_parent : 4901
         * hospitalPinyin : chhospita
         * departPinyin : guke
         * areapinyin : shanghai
         * speciality : [{"id":"74","name":"骨科"}]
         * vote : 5
         * referlist_url : http://z.xywy.com/doc/lmdr/zixun.php
         * article_num : 0
         * plus_num : 33
         * articlelist_url : http://z.xywy.com/doc/lmdr/wenzhang.htm
         * agreeplus : 78
         * is_ask : 1
         * is_plus : 1
         * menzhen : 星期一 上午、星期四 下午
         * refer_num : 0
         * expert_id : 6665
         * club_id : 12114702
         */

        private String document_id;
        private String score;
        private String document_weight;
        private String name;
        private String doctorPinyin;
        private String title;
        private String teach;
        private String goodat;
        private String app_image;
        private String hospital;
        private String province;
        private String city;
        private String level;
        private String depart;
        private String uuidDepart;
        private String depart_parent;
        private String hospitalPinyin;
        private String departPinyin;
        private String areapinyin;
        private String speciality;
        private String vote;
        private String referlist_url;
        private String article_num;
        private String plus_num;
        private String articlelist_url;
        private String agreeplus;
        private String is_ask;
        private String is_plus;
        private String menzhen;
        private String refer_num;
        private String expert_id;
        private String club_id;

        public String getDocument_id() {
            return document_id;
        }

        public void setDocument_id(String document_id) {
            this.document_id = document_id;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getDocument_weight() {
            return document_weight;
        }

        public void setDocument_weight(String document_weight) {
            this.document_weight = document_weight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDoctorPinyin() {
            return doctorPinyin;
        }

        public void setDoctorPinyin(String doctorPinyin) {
            this.doctorPinyin = doctorPinyin;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTeach() {
            return teach;
        }

        public void setTeach(String teach) {
            this.teach = teach;
        }

        public String getGoodat() {
            return goodat;
        }

        public void setGoodat(String goodat) {
            this.goodat = goodat;
        }

        public String getApp_image() {
            return app_image;
        }

        public void setApp_image(String app_image) {
            this.app_image = app_image;
        }

        public String getHospital() {
            return hospital;
        }

        public void setHospital(String hospital) {
            this.hospital = hospital;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getDepart() {
            return depart;
        }

        public void setDepart(String depart) {
            this.depart = depart;
        }

        public String getUuidDepart() {
            return uuidDepart;
        }

        public void setUuidDepart(String uuidDepart) {
            this.uuidDepart = uuidDepart;
        }

        public String getDepart_parent() {
            return depart_parent;
        }

        public void setDepart_parent(String depart_parent) {
            this.depart_parent = depart_parent;
        }

        public String getHospitalPinyin() {
            return hospitalPinyin;
        }

        public void setHospitalPinyin(String hospitalPinyin) {
            this.hospitalPinyin = hospitalPinyin;
        }

        public String getDepartPinyin() {
            return departPinyin;
        }

        public void setDepartPinyin(String departPinyin) {
            this.departPinyin = departPinyin;
        }

        public String getAreapinyin() {
            return areapinyin;
        }

        public void setAreapinyin(String areapinyin) {
            this.areapinyin = areapinyin;
        }

        public String getSpeciality() {
            return speciality;
        }

        public void setSpeciality(String speciality) {
            this.speciality = speciality;
        }

        public String getVote() {
            return vote;
        }

        public void setVote(String vote) {
            this.vote = vote;
        }

        public String getReferlist_url() {
            return referlist_url;
        }

        public void setReferlist_url(String referlist_url) {
            this.referlist_url = referlist_url;
        }

        public String getArticle_num() {
            return article_num;
        }

        public void setArticle_num(String article_num) {
            this.article_num = article_num;
        }

        public String getPlus_num() {
            return plus_num;
        }

        public void setPlus_num(String plus_num) {
            this.plus_num = plus_num;
        }

        public String getArticlelist_url() {
            return articlelist_url;
        }

        public void setArticlelist_url(String articlelist_url) {
            this.articlelist_url = articlelist_url;
        }

        public String getAgreeplus() {
            return agreeplus;
        }

        public void setAgreeplus(String agreeplus) {
            this.agreeplus = agreeplus;
        }

        public String getIs_ask() {
            return is_ask;
        }

        public void setIs_ask(String is_ask) {
            this.is_ask = is_ask;
        }

        public String getIs_plus() {
            return is_plus;
        }

        public void setIs_plus(String is_plus) {
            this.is_plus = is_plus;
        }

        public String getMenzhen() {
            return menzhen;
        }

        public void setMenzhen(String menzhen) {
            this.menzhen = menzhen;
        }

        public String getRefer_num() {
            return refer_num;
        }

        public void setRefer_num(String refer_num) {
            this.refer_num = refer_num;
        }

        public String getExpert_id() {
            return expert_id;
        }

        public void setExpert_id(String expert_id) {
            this.expert_id = expert_id;
        }

        public String getClub_id() {
            return club_id;
        }

        public void setClub_id(String club_id) {
            this.club_id = club_id;
        }
    }
}
