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
import jiyun.com.doctorsixsixsix.modle.adapter.InforAdapter;
import jiyun.com.doctorsixsixsix.modle.bean.Information;
import jiyun.com.doctorsixsixsix.presenter.information.IInformationPresenter;
import jiyun.com.doctorsixsixsix.presenter.information.InformationPresenter;
import jiyun.com.doctorsixsixsix.view.InformationView;

/**
 * 项目名称: 血压卫士
 * 类描述: 资讯的详情页面
 * 创建人: 马杰
 * 创建时间: 2017/6/12 9:10
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class InforDetail extends BaseActivity implements InformationView {
    @BindView(R.id.inforDetail_back)
    ImageView inforDetailBack;
    @BindView(R.id.inforDetail_Title)
    TextView inforDetailtitle;
    @BindView(R.id.inforDetail_title)
    RelativeLayout inforDetailTitle;
    @BindView(R.id.inforDetail_list)
    ListView inforDetailList;
    private InformationPresenter presenter;
    private List<Information.DataBean> mList;
    private String[] strings={"zhuanti_nk","zhuzhan_ys"};
    private int type;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_infordetail;
    }

    @Override
    protected void initView() {
        Intent intent=getIntent();
        type = intent.getIntExtra("type", 0);
        switch (type){
            case 1:
                presenter=new IInformationPresenter(this);
                presenter.getList("18031","zhuanti_nk");
                break;
            case 2:
                presenter=new IInformationPresenter(this);
                presenter.getList("7938","zhuzhan_ys");
                break;
            case 3:
                presenter=new IInformationPresenter(this);
                presenter.getList("18033","zhuanti_nk");
                break;
            case 4:
                presenter=new IInformationPresenter(this);
                presenter.getList("18035","zhuanti_nk");
                break;
            case 5:
                presenter=new IInformationPresenter(this);
                presenter.getList("18032","zhuanti_nk");
                break;
        }

    }

    @Override
    protected void initListener() {
        inforDetailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        inforDetailList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Information.DataBean dataBean = mList.get(position);
                String id1 = dataBean.getId();
                Intent intent=new Intent(InforDetail.this,DetailInfor.class);
                intent.putExtra("typeid",id1);
                if(type==2){
                    intent.putExtra("dir",strings[1]);
                }else{
                    intent.putExtra("dir",strings[0]);
                }
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    public void getList(List<Information.DataBean> list) {
        mList=list;
        InforAdapter adapter=new InforAdapter(mList,InforDetail.this);
        inforDetailList.setAdapter(adapter);
    }

    @Override
    public void shoucang(boolean boo) {

    }

}
