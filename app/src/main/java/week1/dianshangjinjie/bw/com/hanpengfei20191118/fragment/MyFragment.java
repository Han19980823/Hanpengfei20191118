package week1.dianshangjinjie.bw.com.hanpengfei20191118.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.File;
import java.util.List;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.Icontract;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.R;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.base.BaseFragment;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.base.BasePresenter;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.MyEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.PicEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.presenter.Presenter;

import static android.app.Activity.RESULT_OK;

/**
 * 作者：Han98
 * 创建时间：2019/11/18
 * 描述：TODO
 * 最近修改：2019/11/18 09:03 modify by liujc
 */
public class MyFragment extends BaseFragment implements Icontract.IMy,Icontract.Ip {
    @BindView(R.id.img_view)
    ImageView imgView;
    @BindView(R.id.btn_post)
    Button btnPost;
    @BindView(R.id.pai)
    Button pai;
    @BindView(R.id.photo)
    Button photo;
    @BindView(R.id.canel)
    Button canel;
    @BindView(R.id.fi_laog)
    RelativeLayout fiLaog;

    List<LocalMedia> list;
    private Presenter presenter;
    private File file;
    private MultipartBody.Part part;



    @Override
    protected int initLayout() {
        return R.layout.my_layout;
    }

    @Override
    protected void initView(View view) {


    }
    @OnClick(R.id.pai)
    public void pai(View view){
        fiLaog.setVisibility(View.GONE);
        PictureSelector.create(getActivity())
                .openCamera(PictureMimeType.ofImage())
                .isCamera(true)
                .compress(true)
                .maxSelectNum(1)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }

    @OnClick(R.id.photo)
    public void photo(View view){
        fiLaog.setVisibility(View.GONE);
        PictureSelector.create(getActivity())
                .openGallery(PictureMimeType.ofImage())
                .isCamera(true)
                .compress(true)
                .maxSelectNum(1)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }
    @OnClick(R.id.canel)
    public void canel(View view){
        fiLaog.setVisibility(View.GONE);
    }


    @OnClick(R.id.btn_post)
    public void btn(View view){
        RequestOptions mRequestOptions = RequestOptions.circleCropTransform();
        Glide.with(getContext()).load(Uri.fromFile(new File(list.get(0).getCompressPath()))).apply(mRequestOptions).into(imgView);
    }


    @Override
    protected void initData(Bundle savedInstanceState) {
        if (list != null && list.size() > 0) {
            File file = new File(list.get(0).getCompressPath());
            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            part = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
        }
    }

    @Override
    protected BasePresenter Ipresenter() {
        presenter = new Presenter();
        if (presenter!=null){
            presenter.getView();
            presenter.getPhoto(part);
        }
        return presenter;
    }


    @Override
    public void success(MyEntity myEntity) {
        Toast.makeText(getContext(), myEntity.getMessage(), Toast.LENGTH_SHORT).show();

    }

    //回调
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    list = PictureSelector.obtainMultipleResult(data);
                    break;
            }
        }
    }

    @Override
    public void success(PicEntity pic) {
        Toast.makeText(getContext(), pic.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
