package jiyun.com.doctorsixsixsix.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.bean.InforDetailBean;
import jiyun.com.doctorsixsixsix.presenter.information.DetailPresenter;
import jiyun.com.doctorsixsixsix.presenter.information.IDetailPresenter;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.DetailView;

/**
 * 项目名称: 血压卫士
 * 类描述: 详情主页面
 * 创建人: 马杰
 * 创建时间: 2017/6/12 11:59
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class DetailInfor extends BaseActivity implements DetailView {
    @BindView(R.id.infor_title)
    TextView inforTitle;
    @BindView(R.id.infor_order)
    TextView inforOrder;
    @BindView(R.id.infor_date)
    TextView inforDate;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.Detail_back)
    ImageView DetailBack;
    @BindView(R.id.Detail_Title)
    TextView Detailtitle;
    @BindView(R.id.Detail_shoucang)
    ImageView DetailShoucang;
    @BindView(R.id.Detail_title)
    RelativeLayout DetailTitle;
    private DetailPresenter presenter;
    private boolean boo=false;
    private String categoryid;
    private String id;
    private String title;
    private Handler handler=new Handler();

    @Override
    protected int getLayoutId() {
        return R.layout.infor_itemone;
    }

    @Override
    protected void initView() {
        textView2.setVisibility(View.GONE);
        DetailShoucang.setVisibility(View.VISIBLE);
        presenter = new IDetailPresenter(this);

    }

    @Override
    protected void initListener() {
        DetailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        DetailShoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(boo){
                    presenter.shoucang(null,id,"0",title,categoryid);
                }else{
                    presenter.shoucang("zhuanti_nk,18032",id,"1",title,categoryid);
                }
            }
        });
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String typeid = intent.getStringExtra("typeid");
        String dir = intent.getStringExtra("dir");
        presenter.getData(typeid, dir);
        id = AppUtils.get().getString("id", "");

    }


    @Override
    public void getData(final InforDetailBean.DataBean dataBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                categoryid=dataBean.getId();
                title=dataBean.getTitle();
                inforTitle.setText(dataBean.getTitle());
                inforOrder.setText(Html.fromHtml(dataBean.getBody()));
                inforDate.setText(AppUtils.longToString(dataBean.getPubdate(), "yyyy年M月dd日 hh:mm:ss"));
            }
        });
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                presenter.isCollect(id,categoryid);
            }
        },200);

    }

    @Override
    public void isCollect(boolean boo) {
        this.boo=boo;
         if(boo){
             DetailShoucang.setImageResource(R.mipmap.shoucang_03);
             AppUtils.toast("该文章已经收藏");
         }else{
             DetailShoucang.setImageResource(R.mipmap.img_collect);
             AppUtils.toast("该文章未收藏");
         }
    }

    @Override
    public void collect(boolean boo) {
        if(boo){
            this.boo=!this.boo;
            if(this.boo) {
                DetailShoucang.setImageResource(R.mipmap.shoucang_03);
                AppUtils.toast("收藏成功");
            }else{
                DetailShoucang.setImageResource(R.mipmap.img_collect);
                AppUtils.toast("取消收藏");
            }
        }else{
            AppUtils.toast("出现错误");
        }
    }

}
