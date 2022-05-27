package com.estech.takephotosample.ViewModelo

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel(){

    val imageUri = MutableLiveData<Uri>()
}