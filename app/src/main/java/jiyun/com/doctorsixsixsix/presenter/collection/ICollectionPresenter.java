package jiyun.com.doctorsixsixsix.presenter.collection;

import android.widget.Toast;

import jiyun.com.doctorsixsixsix.modle.bean.Collection;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.CollectionModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.ICollectionModel;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.util.GsonUtils;
import jiyun.com.doctorsixsixsix.view.CollectionView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/11 20:45
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class ICollectionPresenter implements CollectionPresenter {
    private CollectionModel model;
    private CollectionView view;

    public ICollectionPresenter(CollectionView view) {
        this.view = view;
        model=new ICollectionModel();
    }

    @Override
    public void getCollection(String id) {
        model.getCollection(id, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                Collection collection= (Collection) GsonUtils.getBean(GsonData,Collection.class);
                int state = collection.getState();
                if(state==200){
                    if(collection.getData()!=null) {
                        view.getList(collection.getData());
                    }else{
                        view.getList(null);
                    }
                }else{
                    AppUtils.toast(collection.getError());
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
