package week1.dianshangjinjie.bw.com.demo1.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者：Han98
 * 创建时间：2019/11/18
 * 描述：TODO
 * 最近修改：2019/11/18 13:37 modify by liujc
 */
public abstract  class BaseActicity extends AppCompatActivity {
    public Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder == null){
            unbinder.unbind();
        }
    }
}
