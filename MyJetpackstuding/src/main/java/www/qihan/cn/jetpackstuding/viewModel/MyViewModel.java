package www.qihan.cn.jetpackstuding.viewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * 创建者     彭猛
 * 创建时间   10/11/2019 9:41 PM
 */
public class MyViewModel extends ViewModel {
    MutableLiveData<String> name = null;
    public LiveData<String> getName(){
        if(name == null){
            name = new MutableLiveData<String>();
            addName();
        }
        return name;
    }

    private void addName() {
        name.setValue("MyViewModel addName 阿猛");
    }
}
