package com.asifsid88.myexpense.app.service.callbacks;

import android.util.Log;

import com.asifsid88.myexpense.app.model.IModel;

/**
 * Created by mhussaa on 6/3/17.
 */

public class ExpenseServiceCallback implements ICallback {
    @Override
    public void execute(boolean success, IModel result) {
        // now reprint the expenseDetail page with updated response
        Log.d("ExpenseServiceCallback", "Callback executed :: " + result);
    }
}
