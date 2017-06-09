package jiyun.com.doctorsixsixsix.view;

import java.util.List;

import jiyun.com.doctorsixsixsix.modle.bean.MainDoctorBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 张超
 * 创建时间: 2017/6/9 10:25
 * 修改人:
 * 修改内容: 第一个页面的抽取view
 * 修改时间: 2017-06-09，上午10:25
 */

public interface MainDoctorView {

    // 首先加载数据
    void LoadData(List<MainDoctorBean.DataBean> ShowData);

    //吐司

    void SendToast(String msg);

    //点击加载更多数据,

    void onLoadMore(List<MainDoctorBean.DataBean> LoadList);

    //点击事件,跳转到省份页面

    void getShengFen();

    // 这是点击弹出dialog，医生职称

    void getDoctorTitle();

    //这是点击弹出dialog ，医院等级

    void getHospital();

    /**
     * 关键字搜索,跳转页面
     */

    void getSearch();

    /**
     * 查询专家，跳转页面
     */

    void QueryZhuanJia();

    /*
    免费问医生 图片跳转页面
     */

    void AskDoctor();


    /**
     * 健康顾问，弹出dialog
     */

    void JiankangDialog();


}
