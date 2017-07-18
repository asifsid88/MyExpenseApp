package com.asifsid88.myexpense.app.service.responsehandlers;

import com.asifsid88.myexpense.app.model.Expense;
import com.asifsid88.myexpense.app.service.ResponseModelUtil;
import com.asifsid88.myexpense.app.service.WebServiceResponseModel;
import com.asifsid88.myexpense.app.service.callbacks.ICallback;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.BaseJsonHttpResponseHandler;

import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by mhussaa on 6/3/17.
 */

public class ExpenseGetListResponseHandler extends BaseJsonHttpResponseHandler<List<Expense>> {

    private ICallback callback;

    public ExpenseGetListResponseHandler(ICallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, String rawJsonResponse, List<Expense> response) {
        callback.execute(Boolean.TRUE, response);
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, String rawJsonData, List<Expense> errorResponse) {
        callback.execute(Boolean.FALSE, errorResponse);
    }

    @Override
    protected List<Expense> parseResponse(String rawJsonData, boolean isFailure) throws Throwable {
        WebServiceResponseModel<List<Expense>> model = ResponseModelUtil.prepareModel(new TypeToken<WebServiceResponseModel<List<Expense>>>(){}, rawJsonData);
        return model.getData();
    }
}
