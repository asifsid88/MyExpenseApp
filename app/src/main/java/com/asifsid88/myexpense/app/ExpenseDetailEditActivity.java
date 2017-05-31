package com.asifsid88.myexpense.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.asifsid88.myexpense.app.component.DatePicker;
import com.asifsid88.myexpense.app.model.Expense;

public class ExpenseDetailEditActivity extends AppCompatActivity {

    private Expense expense;
    private String expenseTypeSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_detail_edit);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        this.expense = (Expense) intent.getSerializableExtra(Constants.EXPENSE_MODEL);
        setLayoutFields();
    }

    private void setLayoutFields() {
        populateExpenseTypeDropDown();
        setTextViewContent(R.id.expense_detail_amount, expense.getAmount());
        setTextViewContent(R.id.expense_detail_description, expense.getDescription());
        setTextViewContent(R.id.expense_detail_comment, expense.getComment());
        new DatePicker(this, R.id.expense_detail_expense_date, expense.getDate());
    }

    private void populateExpenseTypeDropDown() {
        Spinner spinner = (Spinner) findViewById(R.id.expense_type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.expense_type_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new ExpenseTypeSpinnerActivity());

        String compareValue = expense.getExpenseType();
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinner.setSelection(spinnerPosition);
        }
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

        Toast.makeText(this, "selected Expensetype: " + expenseTypeSelected, Toast.LENGTH_LONG).show();
    }

    private class ExpenseTypeSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        private ExpenseTypeSpinnerActivity() {

        }

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            expenseTypeSelected = String.valueOf(parent.getItemAtPosition(pos));
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
}
