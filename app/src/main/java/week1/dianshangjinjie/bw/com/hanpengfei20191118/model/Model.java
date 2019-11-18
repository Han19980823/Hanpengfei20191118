package week1.dianshangjinjie.bw.com.hanpengfei20191118.model;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.Icontract;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.apis.Api;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.apis.ApiService;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.HomeEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.MyEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.PicEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.utils.Utils;

/**
 * 作者：Han98
 * 创建时间：2019/11/18
 * 描述：TODO
 * 最近修改：2019/11/18 09:17 modify by liujc
 */
public class Model {
    public void getUtils(String name,Icontract.IModel iModel){
        Utils.getInstance().create(ApiService.class)
                .sevice(name,1,5)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeEntity>() {
                    @Override
                    public void accept(HomeEntity homeEntity) throws Exception {
                        iModel.success(homeEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iModel.error(throwable.getMessage());
                    }
                });
    }
    public void getMy(Icontract.IShow iModel){
        Utils.getInstance().create(ApiService.class)
                .getData(899,"1574045152582899")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyEntity>() {
                    @Override
                    public void accept(MyEntity myEntity) throws Exception {
                        iModel.my(myEntity);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    public void getPic(MultipartBody.Part fis,Icontract.Pic pic){
        Utils.getInstance().create(ApiService.class)
                .getPic(899,"1574045152582899",fis)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PicEntity>() {
                    @Override
                    public void accept(PicEntity picEntity) throws Exception {
                        pic.setPic(picEntity);
                    }
                });
    }
}
