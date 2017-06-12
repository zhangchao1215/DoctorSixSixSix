package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.adapter.CollectionAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.Collection;
import jiyun.com.doctorsixsixsix.presenter.collection.CollectionPresenter;
import jiyun.com.doctorsixsixsix.presenter.collection.ICollectionPresenter;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.CollectionView;

/**
 * 项目名称: 血压卫士
 * 类描述: 我的收藏页面
 * 创建人: 马杰
 * 创建时间: 2017/6/11 20:30
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class CollectionActivity extends BaseActivity implements CollectionView {
    @BindView(R.id.collection_back)
    ImageView collectionBack;
    @BindView(R.id.collection_Title)
    TextView collectiontitle;
    @BindView(R.id.collection_title)
    RelativeLayout collectionTitle;
    @BindView(R.id.collection_list)
    ListView collectionList;
    @BindView(R.id.collection_text)
    TextView collectionText;
    private CollectionPresenter presenter;
    private List<Collection.Databean> mList;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_collection;
    }

    @Override
    protected void initView() {
        presenter = new ICollectionPresenter(this);
    }

    @Override
    protected void initListener() {
        collectionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        collectionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Collection.Databean databean = mList.get(position);
                Intent intent=new Intent(CollectionActivity.this,DetailInfor.class);
                intent.putExtra("typeid",databean.getCategoryid());
                intent.putExtra("dir",databean.getMeta().substring(0,10));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        String id = AppUtils.get().getString("id", "");
        presenter.getCollection(id);
    }

    @Override
    public void getList(List<Collection.Databean> list) {
        if (list != null) {
            mList = list;
            CollectionAdapter adapter = new CollectionAdapter(mList);
            collectionList.setAdapter(adapter);
        } else {
            collectionText.setVisibility(View.VISIBLE);
            collectionList.setVisibility(View.GONE);
        }
    }

}
