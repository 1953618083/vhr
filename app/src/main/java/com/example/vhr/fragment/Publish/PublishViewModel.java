package com.example.vhr.fragment.Publish;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PublishViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PublishViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is system fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}