package www.qihan.cn.jetpackstuding.livedata;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import www.qihan.cn.jetpackstuding.Constans;
import www.qihan.cn.jetpackstuding.R;

public class LiveDataActivity extends AppCompatActivity {

    private MutableLiveData<String> mLiveData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        mLiveData = new MutableLiveData<>();
        mLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Log.d(Constans.TAG,"LiveDataActivity onChanged"+s);
            }
        });
        mLiveData.postValue("live data post value 333");
    }
}
