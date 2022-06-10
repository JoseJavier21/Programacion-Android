package com.estech.firebaseauthsample.dominio


/**
 * Created by sergi on 08/06/2022.
 * Copyright (c) 2022 Qastusoft. All rights reserved.
 */

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String?, data: T? = null) : Resource<T>(data, message)
}