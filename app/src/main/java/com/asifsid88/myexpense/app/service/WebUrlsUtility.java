package com.asifsid88.myexpense.app.service;

import java.util.Map;

/**
 * Created by mhussaa on 7/18/17.
 */

final class WebUrlsUtility {

    static String replaceKeyWithValues(String url, Map<String, String> keyValueMap) {
        StringBuilder sb = new StringBuilder(url);
        for(Map.Entry<String, String> entry : keyValueMap.entrySet()) {
            String key = entry.getKey();

            int startIndex = url.indexOf(key);
            int endIndex = startIndex + key.length();

            sb.replace(startIndex-1, endIndex+1, entry.getValue());
        }

        return sb.toString();
    }
}
