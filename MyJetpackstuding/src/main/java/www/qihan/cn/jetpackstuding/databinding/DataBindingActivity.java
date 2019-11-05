package www.qihan.cn.jetpackstuding.databinding;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import www.qihan.cn.jetpackstuding.R;
@BindingMethods({
        @BindingMethod(type = android.widget.ImageView.class,
                attribute = "app:srcCompat",
                method = "setImageDrawable") })
public class DataBindingActivity extends AppCompatActivity {
    int i= 0;
    int j= 0;
    private ActivityDataBindingBinding mBinding;
    private DataBindingBean mDataBindingBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        mDataBindingBean = new DataBindingBean();
        ObservableField<String> msg = new ObservableField<>();
        msg.set("leftbutton");
        mDataBindingBean.msg = msg;
        mBinding.btBingdingLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = mDataBindingBean.msg.get();
                if(i++ %2==0){
                    msg = msg.toUpperCase();
                }else{
                    msg = msg.toLowerCase();
                }

                mDataBindingBean.msg.set(msg);
            }
        });
        mBinding.btBingdingRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.tvBingdingMsg2.setText("rightButton num="+j++);
            }
        });

        mBinding.setBindingBean(mDataBindingBean);
    }

    public void BtDatabindingCenter(View view) {
        mDataBindingBean.type1.set(mDataBindingBean.type1.get()+1);
    }
}
