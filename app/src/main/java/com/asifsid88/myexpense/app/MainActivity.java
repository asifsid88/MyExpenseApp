package com.asifsid88.myexpense.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.asifsid88.myexpense.app.model.Expense;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNewExpense(View view) {
        Intent intent = new Intent(this, ExpenseDetailEditActivity.class);
        intent.putExtra(Constants.EXPENSE_MODEL, new Expense());
        startActivity(intent);
    }
}
