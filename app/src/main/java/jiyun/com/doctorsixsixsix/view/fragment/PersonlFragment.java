package jiyun.com.doctorsixsixsix.view.fragment;

import android.view.View;
import android.widget.ImageView;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.presenter.PerSonlPresenter;
import jiyun.com.doctorsixsixsix.presenter.PersonlPresenterlmp;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.PersonlView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 马杰
 * 创建时间: 2017/6/9 16:36
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PersonlFragment extends BaseFragment implements PersonlView {
   private PerSonlPresenter presenter;
    private ImageView mImageView;
    @Override
    public void upLoadImage(String msg) {
        AppUtils.toast(msg);
    }

    @Override
    public void dialog() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.mycenter;
    }

    @Override
    protected void initView(View view) {
        presenter=new PersonlPresenterlmp(this);
        mImageView= (ImageView) view.findViewById(R.id.my_image);
    }

    @Override
    protected void initListener() {
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getDialog();
            }
        });
    }

    @Override
    protected void initData() {

    }
}
