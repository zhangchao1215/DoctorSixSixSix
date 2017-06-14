package jiyun.com.doctorsixsixsix.view.activity.kechengbiao;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import jiyun.com.doctorsixsixsix.modle.bean.OutCallBeans;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: Administrator
 * 创建时间: 2017/6/14 15:33
 * 修改人:  张超
 * 修改内容:
 * 修改时间:
 */

public class OutCallPreImpl implements IoutcallPrestener {
    private IOutCallView callView;
    private IKeChengModel model;

    public OutCallPreImpl(IOutCallView callView) {
        this.callView = callView;
        model = new KeChengModelImpl();
    }

    @Override
    public void KeCheng(String id) {
      model.KeCheng(id, new MyCallBack() {
          @Override
          public void onSuccess(String GsonData) {
              Gson gson = new Gson();

              OutCallBeans beans = null;
              try{
                  beans = gson.fromJson(GsonData, OutCallBeans.class);

                  callView.loadData(beans);
              }catch (JsonSyntaxException e){

              }


          }

          @Override
          public void onError(String errorMsg) {

          }
      });


    }
}
