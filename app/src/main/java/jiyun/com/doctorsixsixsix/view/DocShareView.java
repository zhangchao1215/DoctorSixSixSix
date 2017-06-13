package jiyun.com.doctorsixsixsix.view;

import java.util.List;

import jiyun.com.doctorsixsixsix.modle.bean.DoctorShareBean;

/**
 * 项目名称: 血压卫士
 * 类描述: 这是专家分享抽取的view接口
 * 创建人: Administrator
 * 创建时间: 2017/6/12 9:38
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public interface DocShareView {

    void DocShare(List<DoctorShareBean.DataBean> lodaList);

}
