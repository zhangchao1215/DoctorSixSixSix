package jiyun.com.doctorsixsixsix.presenter;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;

import java.io.File;
import java.net.URI;
import java.util.Calendar;

import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.IPersonlModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.PersonlModel;
import jiyun.com.doctorsixsixsix.view.PersonlView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: 马杰
 * 创建时间: 2017/6/9 16:40
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class PersonlPresenterlmp implements PerSonlPresenter {
    private PersonlView view;
    private PersonlModel model;
    //通过静态变量获取相机图片的Uri
    public static Uri uri;

    public PersonlPresenterlmp(PersonlView view) {
        this.view = view;
        model=new IPersonlModel();
    }

    @Override
    public void upLoadImage(String path) {
        model.upLoadImage(path, null, new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {

            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }

    @Override
    public void getDialog() {
        final AlertDialog dialog=new AlertDialog.Builder(App.activity).create();
        dialog.show();
        dialog.getWindow().setContentView(R.layout.my_dialog);
        dialog.getWindow().findViewById(R.id.my_textOne).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//action is capture
                File tempFile=new File("/sdcard/ll1x/"+ Calendar.getInstance().getTimeInMillis()+".jpg");
                // 以时间秒为文件名
                File temp = new File("/sdcard/ll1x/");//自已项目 文件夹
                if (!temp.exists()) {
                    temp.mkdir();
                }
                uri=Uri.fromFile(tempFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
                App.activity.startActivityForResult(intent, 3);
                dialog.dismiss();
            }
        });
        dialog.getWindow().findViewById(R.id.my_textTwo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("image/*");
                App.activity.startActivityForResult(intent, 1);
                dialog.dismiss();
            }
        });
        dialog.getWindow().findViewById(R.id.my_textThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
}
