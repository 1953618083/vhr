package com.example.vhr.fragment.Publish;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

// ViewModel 类，用于管理发布功能的UI相关数据
public class PublishViewModel extends ViewModel {

    // LiveData 对象，用于保存并观察文本数据
    private final MutableLiveData<String> mText;

    // PublishViewModel的构造函数
    public PublishViewModel() {
        // 初始化 MutableLiveData
        mText = new MutableLiveData<>();
        // 设置初始文本值
        mText.setValue("This is system fragment");
    }

    // 获取文本LiveData的公共方法
    // 允许外部组件订阅文本数据的变化
    public LiveData<String> getText() {
        return mText;
    }
}
