package week1.dianshangjinjie.bw.com.hanpengfei20191118.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.Icontract;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.R;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.adapter.HomeAdapter;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.base.BaseFragment;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.base.BasePresenter;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.custom.MyView;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.HomeEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.presenter.Presenter;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.view.App;

/**
 * 作者：Han98
 * 创建时间：2019/11/18
 * 描述：TODO
 * 最近修改：2019/11/18 09:02 modify by liujc
 */
public class HomeFragment extends BaseFragment implements Icontract.Iview {
    @BindView(R.id.recy_id)
    RecyclerView recy_id;
    @BindView(R.id.my_view)
    MyView myView;
    private Presenter presenter;

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        presenter.getModel("一");
        return presenter;
    }

    @Override
    protected int initLayout() {
        return R.layout.home_layout;
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager manager = new LinearLayoutManager(App.context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        if (recy_id!=null){
            recy_id.setLayoutManager(manager);
        }
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void success(HomeEntity homeEntity) {
        Toast.makeText(getContext(), homeEntity.getMessage(), Toast.LENGTH_SHORT).show();
        HomeAdapter adapter = new HomeAdapter(getContext(), homeEntity.getResult());
        recy_id.setAdapter(adapter);

    }
}
