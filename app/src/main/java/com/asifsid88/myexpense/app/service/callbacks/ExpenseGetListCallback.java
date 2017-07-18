package com.asifsid88.myexpense.app.service.callbacks;

import android.app.Activity;

import com.asifsid88.myexpense.app.R;
import com.asifsid88.myexpense.app.fragments.ExpenseFragment;
import com.asifsid88.myexpense.app.model.Expense;

import java.util.List;

/**
 * Created by mhussaa on 6/3/17.
 */

public class ExpenseGetListCallback implements ICallback<List<Expense>> {

    private Activity parentContext;

    public ExpenseGetListCallback(Activity parentContext) {
        this.parentContext = parentContext;
    }

    @Override
    public void execute(boolean success, List<Expense> result) {
        if(success) {
            ExpenseFragment fragment = (ExpenseFragment) parentContext.getFragmentManager().findFragmentById(R.id.expense_fragment);
            fragment.updateExpenseListFrame(result);
        }
    }
}
