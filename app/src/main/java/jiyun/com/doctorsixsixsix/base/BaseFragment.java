package jiyun.com.doctorsixsixsix.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import jiyun.com.doctorsixsixsix.util.NetWorkUtils;

/**
 * Created by dell on 2017/6/9.
 */

public abstract class BaseFragment extends Fragment {
    protected Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
        initView(view);
    }

    @Override
    public void onResume() {
        super.onResume();
        initListener();
        if(NetWorkUtils.getInstance().checkNetworkState()){
            initData();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void initView(View view);

    protected abstract void initListener();

    protected abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
