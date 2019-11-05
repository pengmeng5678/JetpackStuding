package www.qihan.cn.jetpackstuding.navigation;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import www.qihan.cn.jetpackstuding.R;
import www.qihan.cn.jetpackstuding.navigation.dummy.DummyContent;

public class NavigationActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    private ItemFragment mItemFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItemFragment = ItemFragment.newInstance(5);
        setContentView(R.layout.activity_navigation);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(NavigationActivity.this,item.details,Toast.LENGTH_SHORT).show();
    }
}
