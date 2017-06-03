package com.asifsid88.myexpense.app.service;

import android.app.Activity;

import com.asifsid88.myexpense.app.model.Expense;
import com.asifsid88.myexpense.app.service.callbacks.ExpenseServiceCallback;
import com.asifsid88.myexpense.app.service.callbacks.ICallback;

/**
 * Created by mhussaa on 6/1/17.
 */

public class ExpenseService {

    private ExpenseResponseHandler responseHandler;
    private ICallback callback;

    public ExpenseService(Activity parentContext) {
        this.callback = new ExpenseServiceCallback(parentContext);
        this.responseHandler = new ExpenseResponseHandler(callback);
    }

    public void updateExpense(Expense expense) {
        ExpenseServiceRestClient.get(WebServiceUrls.updateExpense, null, responseHandler);
    }
}
