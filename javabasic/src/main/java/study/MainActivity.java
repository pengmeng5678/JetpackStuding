package study;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import study.reflect.InjectUtils;
import study.reflect.OnClick;
import study.reflect.OnLongClick;
import study.reflect.OnTouch;
import study.reflect.R;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reflectPractice();
    }

    private void reflectPractice() {
        InjectUtils.injectEvent(this);
    }

    @OnClick({R.id.btn1, R.id.btn2})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Log.i(TAG, "click: 按钮1");
                break;
            case R.id.btn2:
                Log.i(TAG, "click: 按钮2");
                break;
        }
    }


    @OnLongClick({R.id.btn1, R.id.btn2})
    public boolean longClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Log.i(TAG, "longClick: 按钮1");
                break;
            case R.id.btn2:
                Log.i(TAG, "longClick: 按钮2");
                break;
        }
        return false;
    }

    @OnTouch({R.id.btn1, R.id.btn2})
    public boolean touch(View view,MotionEvent event) {
        switch (view.getId()) {
            case R.id.btn1:
                Log.i(TAG, "touch: 按钮1");
                break;
            case R.id.btn2:
                Log.i(TAG, "touch: 按钮2");
                break;
        }
        return false;
    }
}
