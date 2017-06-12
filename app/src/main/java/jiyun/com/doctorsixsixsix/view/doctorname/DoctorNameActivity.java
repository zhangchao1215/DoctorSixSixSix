package jiyun.com.doctorsixsixsix.view.doctorname;


import android.view.Gravity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: admin
 * 创建时间: 2017/6/10 11:48
 * 修改人:
 * 修改内容:
 * 修改时间:
 */
public class DoctorNameActivity extends BaseActivity {

    private MyGridLayout mGridLayout;
    private List<String> mList;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_dactor_name;
    }

    @Override
    protected void initView() {
        mGridLayout = (MyGridLayout) findViewById(R.id.mygridlayout);
    }

    @Override
    protected void initData() {
        mGridLayout.setDragAble(true);
        mList = new ArrayList<String>();
        mList.add("不限");
        mList.add("主任医师");
        mList.add("副主任医师");
        mList.add("主任医生");
        mList.add("医师");
        mGridLayout.setItems(mList);
    }

    @Override
    protected void initListener() {

    }
    public void showPopFormBottom(View view) {
        TakePhotoPopWin takePhotoPopWin = new TakePhotoPopWin(this, onClickListener);
        //showAtLocation(View parent, int gravity, int x, int y)
        takePhotoPopWin.showAtLocation(findViewById(R.id.view), Gravity.CENTER, 0, 0);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.yes:
                    System.out.println("btn_take_photo");
                    break;

            }
        }
    };
}
