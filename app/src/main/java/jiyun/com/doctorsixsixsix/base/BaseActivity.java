package jiyun.com.doctorsixsixsix.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import jiyun.com.doctorsixsixsix.App;
import jiyun.com.doctorsixsixsix.util.NetWorkUtils;

/**
 * Created by dell on 2017/6/9.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    @Override
    protected void onResume() {
        super.onResume();
        App.activity=this;
        if(NetWorkUtils.getInstance().checkNetworkState()){
            initData();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
