package week1.dianshangjinjie.bw.com.hanpengfei20191118.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import butterknife.BindView;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.R;

/**
 * 作者：Han98
 * 创建时间：2019/11/18
 * 描述：TODO
 * 最近修改：2019/11/18 09:41 modify by liujc
 */
public class MyView extends LinearLayout {


    public EditText ed_content;
    public Button btn_sou;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.item, this);
        ed_content = view.findViewById(R.id.ed_content);
        btn_sou = view.findViewById(R.id.btn_sou);
        btn_sou.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.success();
            }
        });

    }

    callBack callBack;
    public void MyV(callBack callBack){
        this.callBack  =callBack;
    }

    public interface callBack{
        void success();
    }
}
