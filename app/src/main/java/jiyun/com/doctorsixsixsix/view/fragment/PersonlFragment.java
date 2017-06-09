package jiyun.com.doctorsixsixsix.view.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.htttp.Factory;
import jiyun.com.doctorsixsixsix.presenter.PerSonlPresenter;
import jiyun.com.doctorsixsixsix.presenter.PersonlPresenterlmp;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.PersonlView;

import static android.app.Activity.RESULT_OK;

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
   public PerSonlPresenter presenter;
    private String path;
    private ImageView mImageView;
    @Override
    public void upLoadImage(String msg) {
        Factory.create(Factory.OKHTTP).loadImage(msg,mImageView,true);
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
