package com.asifsid88.myexpense.app.service.callbacks;

import android.app.Activity;
import android.content.Intent;

import com.asifsid88.myexpense.app.Constants;
import com.asifsid88.myexpense.app.ExpenseDetailActivity;
import com.asifsid88.myexpense.app.model.Expense;

/**
 * Created by mhussaa on 6/3/17.
 */

public class ExpenseCreateOrUpdateServiceCallback implements ICallback<Expense> {

    private Activity parentContext;

    public ExpenseCreateOrUpdateServiceCallback(Activity parentContext) {
        this.parentContext = parentContext;
    }

    @Override
    public void execute(boolean success, Expense result) {
        if(success) {
            Intent intent = new Intent(parentContext, ExpenseDetailActivity.class);
            intent.putExtra(Constants.EXPENSE_MODEL, result);
            parentContext.startActivity(intent);
        }
    }
}
