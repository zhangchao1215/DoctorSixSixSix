package jiyun.com.doctorsixsixsix.view;

import java.util.List;

import jiyun.com.doctorsixsixsix.modle.bean.Information;

/**
 * 项目名称: 血压卫士
 * 类描述: 资讯的详情页面接口
 * 创建人: 马杰
 * 创建时间: 2017/6/12 9:11
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public interface InformationView {

    void getList(List<Information.DataBean> list);

    void shoucang(boolean boo);
}
