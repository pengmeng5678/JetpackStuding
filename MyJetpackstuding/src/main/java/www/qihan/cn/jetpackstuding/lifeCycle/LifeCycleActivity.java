package www.qihan.cn.jetpackstuding.lifeCycle;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import www.qihan.cn.jetpackstuding.Constans;
import www.qihan.cn.jetpackstuding.R;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        getLifecycle().addObserver(new MyLifeCycle());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(Constans.TAG,"LifeCycleActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(Constans.TAG,"LifeCycleActivity onPause");
    }
}
