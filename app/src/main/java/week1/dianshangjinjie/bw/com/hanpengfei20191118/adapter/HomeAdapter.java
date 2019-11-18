package week1.dianshangjinjie.bw.com.hanpengfei20191118.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.R;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.HomeEntity;

/**
 * 作者：Han98
 * 创建时间：2019/11/18
 * 描述：TODO
 * 最近修改：2019/11/18 09:50 modify by liujc
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {
    Context context;
    List<HomeEntity.ResultBean> list;

    public HomeAdapter(Context context, List<HomeEntity.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homeitme, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.text_name.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class Holder extends RecyclerView.ViewHolder{
        TextView text_name;
        public Holder(@NonNull View itemView) {
            super(itemView);
            text_name  = itemView.findViewById(R.id.text_name);
        }
    }
}
