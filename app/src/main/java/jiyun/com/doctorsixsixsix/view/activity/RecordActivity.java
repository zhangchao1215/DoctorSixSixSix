package jiyun.com.doctorsixsixsix.view.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.modle.bean.XueYa;
import jiyun.com.doctorsixsixsix.presenter.IXueYaPresenter;
import jiyun.com.doctorsixsixsix.presenter.XueYaPresenter;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.RecordView;

/**
 * 项目名称: 血压卫士
 * 类描述:
 * 创建人: dell
 * 创建时间: 2017/6/14 8:58
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class RecordActivity extends BaseActivity implements RecordView {
    @BindView(R.id.record_back)
    ImageView recordBack;
    @BindView(R.id.record_Title)
    TextView recordtitle;
    @BindView(R.id.record_title)
    RelativeLayout recordTitle;
    @BindView(R.id.record_date)
    TextView recordDate;
    @BindView(R.id.record_time)
    TextView recordTime;
    @BindView(R.id.record_nameEdit)
    EditText recordNameEdit;
    @BindView(R.id.record_name)
    LinearLayout recordName;
    @BindView(R.id.record_gaoEdit)
    EditText recordGaoEdit;
    @BindView(R.id.record_gao)
    LinearLayout recordGao;
    @BindView(R.id.record_diEdit)
    EditText recordDiEdit;
    @BindView(R.id.record_di)
    LinearLayout recordDi;
    @BindView(R.id.record_Btn)
    Button recordBtn;
    private int years;
    private int month;
    private int day;
    private int one;
    private int two;
    private XueYaPresenter presenter;
    private XueYa xueya;
    public static final String SECRETKEY_WEIGHT_SCALEF = "213aBc$l;@13";


    @Override
    public void upLoadPressure() {
        AppUtils.toast("上传成功");
        App.getDaoInstant().getXueYaDao().insert(xueya);
        onBackPressed();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_record;
    }

    @Override
    protected void initView() {
        presenter=new IXueYaPresenter(this);
        long l = System.currentTimeMillis();
        years = Integer.parseInt(AppUtils.longToString(l, "yyyy"));
        month = Integer.parseInt(AppUtils.longToString(l,"MM"));
        day= Integer.parseInt(AppUtils.longToString(l,"dd"));
        one=Integer.parseInt(AppUtils.longToString(l,"HH"));
        two=Integer.parseInt(AppUtils.longToString(l,"mm"));
        String time=AppUtils.longToString(l,"HH:mm");
        recordDate.setText(recordDate.getText()+"    "+years+"-"+month+"-"+day);
        recordTime.setText(recordTime.getText()+"    "+time);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.record_back, R.id.record_date, R.id.record_time, R.id.record_name, R.id.record_gao, R.id.record_di, R.id.record_Btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.record_back:
                onBackPressed();
                break;
            case R.id.record_date:
                getDateDialog();
                break;
            case R.id.record_time:
                getTimeDialog();
                break;
            case R.id.record_name:
                break;
            case R.id.record_gao:
                break;
            case R.id.record_di:
                break;
            case R.id.record_Btn:
                upload();
                break;
        }
    }
    private void upload(){
        String id=AppUtils.get().getString("id","");
        List<XueYa> list=new ArrayList<>();
        xueya=new XueYa();
        //[{"app_data":"temp_automactily_device_identify","app_user_id":"","datatime":1497410700,"heart":0.0,"high":128.0,"low":56.0,"shou_data":"temp_handly_device_identify","xywy_userid":"116924108"}]
        xueya.setApp_data("temp_automactily_device_identify");
        xueya.setApp_user_id("");
        long l = System.currentTimeMillis() / 1000;
        xueya.setDatatime(l);
        xueya.setHeart(0.0);
        xueya.setHigh(Double.parseDouble(recordGaoEdit.getText().toString()));
        xueya.setLow(Double.parseDouble(recordDiEdit.getText().toString()));
        xueya.setShou_data("temp_handly_device_identify");
        xueya.setXywy_userid(id);
        list.add(xueya);
        list.add(xueya);
        Gson gson=new Gson();
        String s = gson.toJson(list);
        String sn=SECRETKEY_WEIGHT_SCALEF+id+"xueya"+s+"xywy_tizhong";
        String md5 = md5(sn);
        presenter.uploadXueYa(l+"",id,s,md5);


    }

    private void getDateDialog(){
        Calendar c = Calendar.getInstance();
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(this,
                // 绑定监听器
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        years=year;
                        month=monthOfYear+1;
                        day=dayOfMonth;
                        recordDate.setText(recordDate.getText()+"   "+year + "-" + (monthOfYear+1)
                                + "-" + dayOfMonth);
                    }
                }
                // 设置初始日期
                , c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
                .get(Calendar.DAY_OF_MONTH)).show();
    }

    private void getTimeDialog(){
        View v=LayoutInflater.from(this).inflate(R.layout.dialog_numone,null);
        NumberPicker numOne= (NumberPicker) v.findViewById(R.id.num_one);
        NumberPicker numTwo= (NumberPicker) v.findViewById(R.id.num_two);
        numOne.setMaxValue(23);
        numOne.setMinValue(0);
        numOne.setValue(one);
        numTwo.setMaxValue(59);
        numTwo.setMinValue(0);
        numTwo.setValue(two);
        numOne.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                one=newVal;
            }
        });
        numTwo.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                two=newVal;
            }
        });
        new AlertDialog.Builder(this)
                .setView(v)
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recordTime.setText(recordTime.getText()+"    "+one+":"+two);
                    }
                }).show();
    }
    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
