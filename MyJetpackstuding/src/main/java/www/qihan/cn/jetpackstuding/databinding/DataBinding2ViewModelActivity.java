package www.qihan.cn.jetpackstuding.databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import www.qihan.cn.jetpackstuding.R;
public class DataBinding2ViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databinding2_view_model);
        DataBinding2ViewModel viewModel = ViewModelProviders.of(this).get(DataBinding2ViewModel.class);
        ActivityDatabinding2ViewModelBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding2_view_model);
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }
}
