package jiyun.com.doctorsixsixsix.presenter.information;

import jiyun.com.doctorsixsixsix.modle.bean.Collect;
import jiyun.com.doctorsixsixsix.modle.bean.InforDetailBean;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.information.IInforDetailModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.information.InforDetailModel;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.util.GsonUtils;
import jiyun.com.doctorsixsixsix.view.DetailView;

/**
 * 项目名称: 血压卫士
 * 类描述: 详情数据的请求
 * 创建人: 马杰
 * 创建时间: 2017/6/12 12:02
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class IDetailPresenter implements DetailPresenter {
    private DetailView view;
    private InforDetailModel model;

    public IDetailPresenter(DetailView view) {
        this.view = view;
        model=new IInforDetailModel();
    }

    @Override
    public void getData(String id, String dir) {
        model.getDetail(id, dir, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                InforDetailBean information= (InforDetailBean) GsonUtils.getBean(GsonData,InforDetailBean.class);
                InforDetailBean.DataBean data = information.getData();
                int code = information.getCode();
                if(code==10000){
                    view.getData(data);
                }else{
                    AppUtils.toast("请求出错");
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void shoucang(String meta,String xywy_userid, String category, String title, String categoryid) {
        model.shoucang(meta,xywy_userid, category, title, categoryid, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                Collect collect= (Collect) GsonUtils.getBean(GsonData,Collect.class);
                int state = collect.getState();
                if(state==200){
                    String data = collect.getData();
                    view.collect(true);
                }else{
                    AppUtils.toast(collect.getError());
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void isCollect(String xywy_userid, String categoryid) {
        model.isCollect(xywy_userid, categoryid, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                Collect collect= (Collect) GsonUtils.getBean(GsonData,Collect.class);
                int state = collect.getState();
                if(state==200){
                    String data = collect.getData();
                    if(data.equals("1")){
                        view.isCollect(true);
                    }else{
                        view.isCollect(false);
                    }
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
