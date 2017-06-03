package com.asifsid88.myexpense.app.service;

import com.asifsid88.myexpense.app.model.Expense;
import com.asifsid88.myexpense.app.service.callbacks.ICallback;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Created by mhussaa on 6/3/17.
 */

public class ExpenseResponseHandler extends BaseJsonHttpResponseHandler<Expense> {

    private ICallback callback;

    public ExpenseResponseHandler(ICallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, Expense response) {
        callback.execute(Boolean.TRUE, response);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, Expense errorResponse) {
        callback.execute(Boolean.FALSE, errorResponse);
    }

    @Override
    protected Expense parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
        WebServiceResponseModel<Expense> model = ResponseModelUtil.prepareModel(new TypeToken<WebServiceResponseModel<Expense>>(){}, rawJsonData);
        return model.getData();
    }
}
