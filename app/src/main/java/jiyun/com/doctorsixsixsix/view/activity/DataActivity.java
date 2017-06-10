package jiyun.com.doctorsixsixsix.view.activity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.R;
import jiyun.com.doctorsixsixsix.base.BaseActivity;
import jiyun.com.doctorsixsixsix.util.AppUtils;
import jiyun.com.doctorsixsixsix.view.MainActivity;

import static jiyun.com.doctorsixsixsix.R.id.month;
import static jiyun.com.doctorsixsixsix.R.id.year;

/**
 * 项目名称: 血压卫士
 * 类描述:个人的一些信息的设置
 * 创建人: 马杰
 * 创建时间: 2017/6/10 14:46
 * 修改人:
 * 修改内容:
 * 修改时间:
 */

public class DataActivity extends BaseActivity {
    @BindView(R.id.data_back)
    ImageView dataBack;
    @BindView(R.id.data_Title)
    TextView dataTitleOne;
    @BindView(R.id.data_title)
    RelativeLayout dataTitle;
    @BindView(R.id.data_name)
    TextView dataName;
    @BindView(R.id.data_gender)
    TextView dataGender;
    @BindView(R.id.data_height)
    TextView dataHeight;
    @BindView(R.id.data_weight)
    TextView dataWeight;
    @BindView(R.id.data_birsday)
    TextView dataBirsday;
    private int a=1900;
    private int b=1;
    private int c=1;
    private int yourChoice;
    private NumberPicker picker;
    private String height;
    private String weight;

    @Override
    protected int getLayoutId() {
        return R.layout.person_data;
    }

    @Override
    protected void initView() {
        String date = AppUtils.get().getString("date", "");
        String gender = AppUtils.get().getString("gender", "");
        String name=AppUtils.get().getString("name","");
        String height= AppUtils.get().getString("height","");
        String weight=AppUtils.get().getString("weight","");
        dataName.setText("姓名                "+name);
        dataGender.setText("性别                 "+gender);
        dataBirsday.setText("生日                    "+date);
        dataHeight.setText("身高                    "+height);
        dataWeight.setText("体重                     "+weight);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.data_back, R.id.data_Title, R.id.data_title, R.id.data_name, R.id.data_gender, R.id.data_height, R.id.data_weight, R.id.data_birsday})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.data_back:
                onBackPressed();
                break;
            case R.id.data_Title:
                break;
            case R.id.data_title:
                break;
            case R.id.data_name:
                getNameDialog();
                break;
            case R.id.data_gender:
                getGenderDialog();
                break;
            case R.id.data_height:
                getHeightDialog();
                break;
            case R.id.data_weight:
                getWeightDialog();
                break;
            case R.id.data_birsday:
                getDateDialog();
                break;
        }
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
                        dataBirsday.setText("生日" +"                       "+ year + "-" + (monthOfYear+1)
                                + "-" + dayOfMonth);
                        AppUtils.put().putString("date",year+"-"+(monthOfYear+1)
                                + "-" + dayOfMonth);
                        AppUtils.put().commit();
                    }
                }
                // 设置初始日期
                , c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
                .get(Calendar.DAY_OF_MONTH)).show();
    }
    private void getGenderDialog(){
        final String[] items = { "男","女" };
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(this);
        singleChoiceDialog.setTitle("性别");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice = which;
                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (yourChoice != -1) {
                            dataGender.setText("性别"+"                  "+items[yourChoice]);
                            AppUtils.put().putString("gender",items[yourChoice]);
                            AppUtils.put().commit();
                        }
                    }
                });
        singleChoiceDialog.show();
    }
    private void getHeightDialog(){
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_numpicker,null);
        picker= (NumberPicker) view.findViewById(R.id.dialog_picker);
        picker.setMaxValue(199);
        picker.setMinValue(40);
        picker.setValue(160);
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){

            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                                      int newVal) {
                // TODO Auto-generated method stub
                height=newVal+"";
            }

        });
        new AlertDialog.Builder(this)
                .setTitle("选择身高")
                .setView(view)
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataHeight.setText("身高                    " +height);
                        AppUtils.put().putString("height",height);
                    }
                }).show();
    }

    private void getWeightDialog(){
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_numpicker,null);
        picker= (NumberPicker) view.findViewById(R.id.dialog_picker);
        picker.setMaxValue(180);
        picker.setMinValue(40);
        picker.setValue(80);
        picker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener(){

            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                                      int newVal) {
                // TODO Auto-generated method stub
                weight=newVal+"";
            }

        });
        new AlertDialog.Builder(this)
                .setTitle("选择体重")
                .setView(view)
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataWeight.setText("体重                    " +weight);
                        AppUtils.put().putString("weight",weight);
                    }
                }).show();
    }
    private void getNameDialog(){
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_edit,null);
        final EditText edit= (EditText) view.findViewById(R.id.dialog_pwd);
        new AlertDialog.Builder(this)
                .setTitle("输入姓名")
                .setView(view)
                .setNegativeButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dataName.setText("姓名                   "+edit.getText().toString());
                        AppUtils.put().putString("name",edit.getText().toString());
                        AppUtils.put().commit();
                    }
                }).show();
    }

}
