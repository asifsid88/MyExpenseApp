package com.asifsid88.myexpense.app.service;

import android.app.Activity;
import android.content.Context;

import com.asifsid88.myexpense.app.model.Expense;
import com.asifsid88.myexpense.app.service.callbacks.ExpenseCreateOrUpdateServiceCallback;
import com.asifsid88.myexpense.app.service.callbacks.ExpenseGetListCallback;
import com.asifsid88.myexpense.app.service.responsehandlers.ExpenseCreateOrUpdateResponseHandler;
import com.asifsid88.myexpense.app.service.responsehandlers.ExpenseGetListResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by mhussaa on 6/1/17.
 */

public class ExpenseService {

    private Context parentContext;
    private ExpenseCreateOrUpdateResponseHandler expenseCreateOrUpdateResponseHandler;
    private ExpenseGetListResponseHandler expenseGetListResponseHandler;

    public ExpenseService(Activity parentContext) {
        this.parentContext = parentContext;
        this.expenseCreateOrUpdateResponseHandler = new ExpenseCreateOrUpdateResponseHandler(new ExpenseCreateOrUpdateServiceCallback(parentContext));
        this.expenseGetListResponseHandler = new ExpenseGetListResponseHandler(new ExpenseGetListCallback(parentContext));
    }

    public void createExpense(Expense expense) {
        try {
            //RequestParams params = new RequestParams();
            JSONObject params = new JSONObject();
            // Create the query params here
            params.put("expenseType", expense.getExpenseType());
            params.put("amount", expense.getAmount());
            params.put("description", expense.getDescription());
            params.put("comment", expense.getDescription());
            params.put("dateOfExpense", expense.getDescription());
            params.put("userId", expense.getDescription());


            ExpenseServiceRestClient.post(parentContext, WebServiceUrls.createExpense, new StringEntity(params.toString()), ContentType.APPLICATION_JSON.toString(), expenseCreateOrUpdateResponseHandler);
            //ExpenseServiceRestClient.post(WebServiceUrls.createExpense, params, expenseCreateOrUpdateResponseHandler);
        } catch(JSONException | UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }

    public void updateExpense(Expense expense) {
        ExpenseServiceRestClient.get(WebServiceUrls.updateExpense, null, expenseCreateOrUpdateResponseHandler);
    }

    public void getExpenseList(int size) {
        Map<String, String> keyValueMap = new HashMap<>();
        keyValueMap.put("size", String.valueOf(size));
        String url = WebUrlsUtility.replaceKeyWithValues(WebServiceUrls.getExpenseListBySize, keyValueMap);
        ExpenseServiceRestClient.get(url, null, expenseGetListResponseHandler);
    }
}
