package com.asifsid88.myexpense.app.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by mhussaa on 6/2/17.
 */

final class ResponseModelUtil {
    static <T> T prepareModel(TypeToken<T> token, String rawJsonData) {
        return new Gson().fromJson(rawJsonData, token.getType());
    }

    static Object getErrorModel(String code, String message) {
        return null;
    }
}
