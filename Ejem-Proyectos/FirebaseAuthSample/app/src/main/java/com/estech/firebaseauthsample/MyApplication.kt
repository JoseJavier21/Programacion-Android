package com.estech.firebaseauthsample

import android.app.Application
import com.estech.firebaseauthsample.dominio.MyRepository


/**
 * Created by sergi on 08/06/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

class MyApplication: Application() {
    val repository by lazy { MyRepository() }
}