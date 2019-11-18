package week1.dianshangjinjie.bw.com.hanpengfei20191118.apis;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.HomeEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.MyEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.PicEntity;

/**
 * 作者：Han98
 * 创建时间：2019/11/18
 * 描述：TODO
 * 最近修改：2019/11/18 09:32 modify by liujc
 */
public interface ApiService {
    @GET("techApi/information/v1/findInformationByTitle")
    Observable<HomeEntity> sevice(@Query("title")String title,@Query("page") int page,@Query("count") int count);
    @GET("techApi/user/verify/v1/getUserInfoByUserId")
    Observable<MyEntity> getData(@Header("userId") int uid,@Header("sessionId") String sid);
    @POST("techApi/user/verify/v1/modifyHeadPic")
    @FormUrlEncoded
    Observable<PicEntity> getPic(@Header("userId") int uid, @Header("sessionId") String sid, @Part MultipartBody.Part fis);

}
