package jiyun.com.doctorsixsixsix.presenter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.util.Calendar;

import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.modle.bean.Person;
import jiyun.com.doctorsixsixsix.modle.bean.upLoadImage;
import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.IPersonlModel;
import jiyun.com.doctorsixsixsix.modle.htttp.biz.PersonlModel;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.util.GsonUtils;
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
    private SharedPreferences sharedPreferences;
    //通过静态变量获取相机图片的Uri
    public static Uri uri;

    public PersonlPresenterlmp(PersonlView view) {
        this.view = view;
        model=new IPersonlModel();
        sharedPreferences=AppUtils.get();
    }

    @Override
    public void upLoadImage(String path) {
            model.upLoadImage(path,"submit","", new MyCallBack() {
                @Override
                public void onSuccess(String GsonData) {
                    Log.e("aa",GsonData);
                    upLoadImage bean = (upLoadImage) GsonUtils.getBean(GsonData, upLoadImage.class);
                    int code = bean.getCode();
                    if(code==10000){
                        AppUtils.toast("头像上传成功");
                        view.upLoadImage(bean.getData(),null);
                    }else{
                        AppUtils.toast(bean.getMessage());
                    }
                }
                @Override
                public void onError(String errorMsg) {
                    Log.e("aa",errorMsg);
                }
            });
    }

    @Override
    public void getDialog() {
        final AlertDialog dialog=new AlertDialog.Builder(App.activity).create();
        dialog.show();
        dialog.getWindow().setContentView(R.layout.my_dialog);
        //打开相机
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
        //打开相册
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

    @Override
    public void getPerson(String userid,String sign) {
        model.getPerson(userid, sign,new MyCallBack() {
            @Override
            public void onSuccess(String GsonData) {
                Log.e("aaa",GsonData);
                Person person= (Person) GsonUtils.getBean(GsonData,Person.class);
                int state = person.getState();
                if(state==200) {
                    AppUtils.put().putString("name",person.getAccounts().get(0).getAccountstr());
                    AppUtils.put().putString("date",person.getAccounts().get(0).getBirthday());
                    AppUtils.put().putString("gender",person.getAccounts().get(0).getSex());
                    AppUtils.put().putString("height",person.getAccounts().get(0).getHeight());
                    AppUtils.put().commit();
                    view.upLoadImage(person.getAvatar(),person.getAccounts().get(0).getAccountstr());
                }else{
                    AppUtils.toast("参数出现错误");
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }
}
