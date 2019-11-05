package www.qihan.cn.jetpackstuding.databinding;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * 创建者     彭猛
 * 创建时间   10/16/2019 10:04 PM
 */
public class DataBindingBean {
    int type;
    public final ObservableInt type1 = new ObservableInt();
    public  ObservableField<String> msg = new ObservableField<>();
    String content;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "DataBindingBean{" +
                "type=" + type +
                ", content='" + content + '\'' +
                '}';
    }
}
