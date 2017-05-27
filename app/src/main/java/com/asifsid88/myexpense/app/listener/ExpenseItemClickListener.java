package com.asifsid88.myexpense.app.listener;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.asifsid88.myexpense.app.ExpenseDetailActivity;
import com.asifsid88.myexpense.app.model.Expense;

import java.util.List;

/**
 * Created by mhussaa on 5/27/17.
 */

public class ExpenseItemClickListener implements AdapterView.OnItemClickListener {

    private Context parentContext;
    private List<Expense> expenseList;

    public ExpenseItemClickListener(Context parentContext, List<Expense> expenseList) {
        this.parentContext = parentContext;
        this.expenseList = expenseList;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Expense expense = expenseList.get(position);
        Intent intent = new Intent(parentContext, ExpenseDetailActivity.class);
        intent.putExtra("expense", expense);
        parentContext.startActivity(intent);
    }
}
