package com.asifsid88.myexpense.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.asifsid88.myexpense.app.component.DatePicker;
import com.asifsid88.myexpense.app.model.Expense;

public class ExpenseDetailEditActivity extends AppCompatActivity {

    private Expense expense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_detail_edit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        expense = (Expense) intent.getSerializableExtra(Constants.EXPENSE_MODEL);
        setLayoutFields();
    }

    private void setLayoutFields() {
        // Populate the expense type spinner
        //setTextViewContent(R.id.expense_detail_expense_type, expense.getExpenseType());
        Spinner spinner = (Spinner) findViewById(R.id.expense_type_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.expense_type_list, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //>>> Do the thing when user select the spinner value --> take the selected value in a variable (edit ke time pe kaam ayega)

        String compareValue = expense.getExpenseType();
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinner.setSelection(spinnerPosition);
        }


        setTextViewContent(R.id.expense_detail_amount, expense.getAmount());
        setTextViewContent(R.id.expense_detail_description, expense.getDescription());
        setTextViewContent(R.id.expense_detail_comment, expense.getComment());



        // set the already selected expense date
        //setTextViewContent(R.id.expense_detail_expense_date, expense.getDate());
        new DatePicker(this, R.id.expense_detail_expense_date);
    }

    private void setTextViewContent(int textViewId, String textValue) {
        TextView expenseDate = (TextView) findViewById(textViewId);
        expenseDate.setText(textValue);
    }

    public void close(View view) {
        this.onBackPressed();
    }

    public void update(View view) {
        // Get all the information and call the REST API to update the expense
    }
}
