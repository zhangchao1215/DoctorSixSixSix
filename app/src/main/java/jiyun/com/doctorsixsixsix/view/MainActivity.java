package jiyun.com.doctorsixsixsix.view;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.base.BaseFragment;
import jiyun.com.doctorsixsixsix.modle.adapter.MainAdapter;
import jiyun.com.doctorsixsixsix.presenter.PerSonlPresenter;
import jiyun.com.doctorsixsixsix.presenter.PersonlPresenterlmp;
import jiyun.com.doctorsixsixsix.view.fragment.PersonlFragment;
import jiyun.com.doctorsixsixsix.view.fragment.TestFragment;

import static android.R.attr.path;

/**
 * Created by dell on 2017/6/9.
 */

public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private List<BaseFragment> mList=new ArrayList<>();
    private File tempFile;
    private PersonlFragment personlFragment;
    private String file;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mViewPager= (ViewPager) findViewById(R.id.Main_ViewPager);
        mTabLayout= (TabLayout) findViewById(R.id.Main_Tab);
        mList.add(new TestFragment());
        mList.add(new TestFragment());
        personlFragment=new PersonlFragment();
        mList.add(personlFragment);
        MainAdapter adapter=new MainAdapter(getSupportFragmentManager(),mList);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.getTabAt(0).setCustomView(getText("医生在线",R.mipmap.doctor_head_normal));
        mTabLayout.getTabAt(1).setCustomView(getText("血压管理",R.mipmap.blood_manger_normal));
        mTabLayout.getTabAt(2).setCustomView(getText("个人中心",R.mipmap.persional_normal));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
    private TextView getText(String str,int drawableID){
        TextView textView= (TextView) LayoutInflater.from(this).inflate(R.layout.text_item,null).findViewById(R.id.Main_Text);
        Drawable drawable=getResources().getDrawable(drawableID);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(null, drawable, null, null);
        textView.setText(str);
        return textView;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {        //此处的 RESULT_OK 是系统自定义得一个常量
            return;
        }
        switch (requestCode){
            case 1:
                startPhotoZoom(data.getData());
                break;
            case 2:
                personlFragment.presenter.upLoadImage(file);
                break;
            case 3:
               startPhotoZoom(PersonlPresenterlmp.uri);
                break;
        }
    }

    private void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");

        intent.setDataAndType(uri, "image/*");

        intent.putExtra("crop", "true");

        intent.putExtra("aspectX", 2);

        intent.putExtra("aspectY", 1);

        intent.putExtra("outputX", 200);

        intent.putExtra("outputY", 200);

        intent.putExtra("scale", true);

        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        intent.putExtra("return-data", false);

        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());

        intent.putExtra("noFaceDetection", true); // no face detection

        file="/sdcard/ll1x/"+ Calendar.getInstance().getTimeInMillis()+".jpg";
        tempFile=new File(file); // 以时间秒为文件名
        File temp = new File("/sdcard/ll1x/");//自已项目 文件夹
        if (!temp.exists()) {
            temp.mkdir();
        }
        intent.putExtra("output", Uri.fromFile(tempFile));  // 专入目标文件
        intent.putExtra("outputFormat", "JPEG"); //输入文件格式
        Intent wrapperIntent = Intent.createChooser(intent, "头像"); //开始 并设置标题
        startActivityForResult(wrapperIntent, 2);
    }
}
