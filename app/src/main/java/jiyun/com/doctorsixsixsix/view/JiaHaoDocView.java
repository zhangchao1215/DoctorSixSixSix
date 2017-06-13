package jiyun.com.doctorsixsixsix.view;

import java.util.List;

import jiyun.com.doctorsixsixsix.modle.bean.JiaHaoDocBean;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/13 11:18
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public interface JiaHaoDocView {

    void JiaHao(List<JiaHaoDocBean.DataBean.ScheduleBean.RdtimeBean> lodaList,String  mID);

}
