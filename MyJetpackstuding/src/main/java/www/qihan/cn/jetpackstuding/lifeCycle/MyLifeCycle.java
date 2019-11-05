package www.qihan.cn.jetpackstuding.lifeCycle;


import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import www.qihan.cn.jetpackstuding.Constans;

/**
 * 创建者     彭猛
 * 创建时间   10/11/2019 8:54 PM
 * 描述	      TODO
 * <p>
 * 更新者     Author
 * 更新时间   Date
 * 更新描述   TODO
 */
public class MyLifeCycle implements LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void connectListener() {
        Log.d(Constans.TAG,"MyLifeCycle connectListener");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void disconnectListener() {
        Log.d(Constans.TAG,"MyLifeCycle connectListener");
    }

}
