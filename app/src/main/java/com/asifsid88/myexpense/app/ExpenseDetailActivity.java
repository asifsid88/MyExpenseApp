package com.asifsid88.myexpense.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.asifsid88.myexpense.app.model.Expense;

public class ExpenseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Expense expense = (Expense) intent.getSerializableExtra(Constants.EXPENSE_MODEL);
        inflateLayout(expense);
    }

    private void inflateLayout(Expense expense) {
        setTextViewContent(R.id.expense_detail_expense_type, expense.getExpenseType());
        setTextViewContent(R.id.expense_detail_amount, expense.getAmount());
        setTextViewContent(R.id.expense_detail_description, expense.getDescription());
        setTextViewContent(R.id.expense_detail_comment, expense.getComment());
        setTextViewContent(R.id.expense_detail_expense_date, expense.getDate());
    }

    private void setTextViewContent(int textViewId, String textValue) {
        TextView expenseDate = (TextView) findViewById(textViewId);
        expenseDate.setText(textValue);
    }

    public void close(View view) {
        this.onBackPressed();
    }

    public void edit(View view) {
        Intent intent = new Intent(this, ExpenseDetailEditActivity.class);
        //intent.putExtra(Constants.EXPENSE_MODEL, expense);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}


