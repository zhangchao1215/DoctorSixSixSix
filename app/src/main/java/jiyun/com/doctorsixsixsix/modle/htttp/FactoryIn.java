package jiyun.com.doctorsixsixsix.modle.htttp;

import android.widget.ImageView;

import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.util.Map;

import jiyun.com.doctorsixsixsix.modle.callback.MyCallBack;

/**
 * Created by dell on 2017/6/9.
 */

public interface FactoryIn {

    void GET(String url, Map<String,String> map , String cookie, MyCallBack callBack);

    void POST(String url, Map<String,String> map , String cookie, MyCallBack callBack);

    void downLoad(String url,MyCallBack callBack);

    void loadImage(String url, ImageView view, boolean boo);
}
