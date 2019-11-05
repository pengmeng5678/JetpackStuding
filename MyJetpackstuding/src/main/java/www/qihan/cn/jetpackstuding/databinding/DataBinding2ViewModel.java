package www.qihan.cn.jetpackstuding.databinding;

import androidx.arch.core.util.Function;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import www.qihan.cn.jetpackstuding.util.Popularity;

/**
 * 创建者     彭猛
 * 创建时间   10/19/2019 8:28 AM
 */
public class DataBinding2ViewModel extends ViewModel {
    public MutableLiveData<String> name =  new MutableLiveData<>();
    public MutableLiveData<String> lastName =  new MutableLiveData<>();
    public MutableLiveData<Integer> likes =  new MutableLiveData<>();

    public MutableLiveData<Popularity> popularity;

    public DataBinding2ViewModel() {
        super();
        name.setValue("meng");
        lastName.setValue("peng");
        likes.setValue(0);
        popularity = (MutableLiveData<Popularity>) Transformations.map(likes, new Function<Integer, Popularity>() {
            @Override
            public Popularity apply(Integer input) {
                switch (input.intValue()) {
                    case 4:
                        popularity.setValue(Popularity.POPULAR);
                        break;
                    case 9:
                        popularity.setValue(Popularity.STAR);
                        break;

                    default:
                        popularity.setValue(Popularity.NORMAL);
                        break;
                }
                return null;
            }
        });

    }

    public void onLike(){
        likes.setValue(likes.getValue()+1);
    }

}

