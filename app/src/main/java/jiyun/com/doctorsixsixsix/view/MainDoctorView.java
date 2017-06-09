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
 *
 */

public interface MainDoctorView {

    //加载数据
    void LoadData(List<MainDoctorBean.DataBean> HostList);

    //吐司

    void SendToast(String msg);

    //加载更多

    void onLoadMore(List<MainDoctorBean.DataBean> LoadList);



}
