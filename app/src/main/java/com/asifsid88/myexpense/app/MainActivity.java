package com.asifsid88.myexpense.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.asifsid88.myexpense.app.model.Expense;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * TODO: Get the expense details via REST call.
     *
     */
    private List<Expense> getExpenseList() {
        final List<Expense> expenseList = new LinkedList<>();

        for(int i=1; i<=10; i++) {
            expenseList.add(getExpense(i));
        }

        return expenseList;
    }

    private Expense getExpense(int expenseId) {
        Expense expense = new Expense();
        expense.setExpenseId(String.valueOf(expenseId));
        expense.setExpenseType(String.valueOf(expenseId));
        expense.setAmount(String.valueOf(expenseId * 100));
        expense.setExpenseType("Paytm");
        expense.setDescription("The transaction was done for the lunch");
        expense.setComment("Comment: " + expenseId);

        return expense;
    }

}
