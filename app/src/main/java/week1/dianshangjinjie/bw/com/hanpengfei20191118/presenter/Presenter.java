package week1.dianshangjinjie.bw.com.hanpengfei20191118.presenter;

import okhttp3.MultipartBody;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.Icontract;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.base.BasePresenter;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.HomeEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.MyEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.PicEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.fragment.HomeFragment;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.fragment.MyFragment;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.model.Model;

/**
 * 作者：Han98
 * 创建时间：2019/11/18
 * 描述：TODO
 * 最近修改：2019/11/18 09:17 modify by liujc
 */
public class Presenter extends BasePresenter {
    Model model;

    public Presenter() {
        model = new Model();
    }

    public void  getModel(String name){
        model.getUtils(name,new Icontract.IModel() {
            @Override
            public void success(HomeEntity homeEntity) {
                HomeFragment fragment = (HomeFragment) v;
                fragment.success(homeEntity);
            }

            @Override
            public void error(String er) {

            }
        });
    }
    public void getView(){
        model.getMy(new Icontract.IShow() {
            @Override
            public void my(MyEntity myEntity) {
                MyFragment  fragment = (MyFragment) v;
                fragment.success(myEntity);
            }
        });
    }

    public void getPhoto(MultipartBody.Part filse) {
        model.getPic(filse, new Icontract.Pic() {
            @Override
            public void setPic(PicEntity pic) {
                MyFragment  fragment = (MyFragment) v;
                fragment.success(pic);
            }
        });
    }
}
