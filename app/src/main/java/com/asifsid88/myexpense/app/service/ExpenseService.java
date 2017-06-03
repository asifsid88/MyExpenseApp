package com.asifsid88.myexpense.app.service;

import android.util.Log;

import com.asifsid88.myexpense.app.model.Expense;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by mhussaa on 6/1/17.
 */

public class ExpenseService {

    public void updateExpense(Expense expense) {
        ExpenseServiceRestClient.get(WebServiceUrls.updateExpense, null, new BaseJsonHttpResponseHandler<Expense>() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Expense response) {
                Log.d("ExpenseService", "rawJsonResponse >> " + rawJsonResponse);
                Log.d("ExpenseService", "Object Response >> " + response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Expense errorResponse) {

            }

            @Override
            protected Expense parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
                WebServiceResponseModel<Expense> model = ResponseModelUtil.prepareModel(new TypeToken<WebServiceResponseModel<Expense>>(){}, rawJsonData);
                return model.getData();
            }
        });
    }
}
