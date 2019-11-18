package week1.dianshangjinjie.bw.com.hanpengfei20191118;

import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.HomeEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.MyEntity;
import week1.dianshangjinjie.bw.com.hanpengfei20191118.entity.PicEntity;

/**
 * 作者：Han98
 * 创建时间：2019/11/18
 * 描述：TODO
 * 最近修改：2019/11/18 09:38 modify by liujc
 */
public interface Icontract {
    //m层
    interface  IModel{
        void success(HomeEntity homeEntity);
        void error(String er);

    }

    interface Iview{
        void success(HomeEntity homeEntity);
    }

    interface IMy{
        void success(MyEntity myEntity);
    }
    interface  IShow{
        void my(MyEntity myEntity);
    }

    interface Pic{
        void setPic(PicEntity pic);
    }
    interface Ip{
        void success(PicEntity pic);
    }
}
