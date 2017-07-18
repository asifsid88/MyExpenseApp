package com.asifsid88.myexpense.app.service;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.HttpEntity;

/**
 * Created by mhussaa on 6/1/17.
 */

class ExpenseServiceRestClient {
    private static AsyncHttpClient client = new AsyncHttpClient();

    static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        setHeaders();
        client.get(url, params, responseHandler);
    }

    static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        setHeaders();
        client.post(url, params, responseHandler);
    }

    static void post(Context context, String url, HttpEntity postBody, String contentType, AsyncHttpResponseHandler responseHandler) {
        client.post(context, url, postBody, contentType, responseHandler);
    }

    private static void setHeaders() {
        client.addHeader("Content-Type", "application/json");
    }
}
