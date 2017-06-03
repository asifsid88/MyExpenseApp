package com.asifsid88.myexpense.app.service.callbacks;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import com.asifsid88.myexpense.app.Constants;
import com.asifsid88.myexpense.app.ExpenseDetailActivity;
import com.asifsid88.myexpense.app.model.IModel;

/**
 * Created by mhussaa on 6/3/17.
 */

public class ExpenseServiceCallback implements ICallback {

    private Activity parentContext;

    public ExpenseServiceCallback(Activity parentContext) {
        this.parentContext = parentContext;
    }

    @Override
    public void execute(boolean success, IModel result) {
        Intent intent = new Intent(parentContext, ExpenseDetailActivity.class);
        intent.putExtra(Constants.EXPENSE_MODEL, result);
        parentContext.startActivity(intent);
    }
}
