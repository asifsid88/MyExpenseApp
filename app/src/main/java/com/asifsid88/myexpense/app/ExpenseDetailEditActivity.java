package com.asifsid88.myexpense.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.asifsid88.myexpense.app.component.DatePicker;
import com.asifsid88.myexpense.app.model.Expense;
import com.asifsid88.myexpense.app.service.ExpenseService;

public class ExpenseDetailEditActivity extends AppCompatActivity {

    private Expense expense;
    private String expenseTypeSelected;
    private Boolean isCreateExpense;
    private ExpenseService expenseService;

    public ExpenseDetailEditActivity() {
        expenseService = new ExpenseService(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_detail_edit);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        this.expense = (Expense) intent.getSerializableExtra(Constants.EXPENSE_MODEL);
        this.isCreateExpense = intent.getBooleanExtra(Constants.IS_CREATE_EXPENSE, Boolean.FALSE);
        setLayoutFields();
    }

    private void setLayoutFields() {
        populateExpenseTypeDropDown();
        setTextViewContent(R.id.expense_detail_amount, expense.getAmount());
        setTextViewContent(R.id.expense_detail_description, expense.getDescription());
        setTextViewContent(R.id.expense_detail_comment, expense.getComment());
        setTextViewContent(R.id.expense_detail_expense_date, expense.getDate());
        new DatePicker(this, R.id.expense_detail_expense_date, expense.getDate());

        if(this.isCreateExpense) {
            setButtonText(R.id.expense_detail_create_or_update, getResources().getString(R.string.expense_detail_save_button_text));
        } else {
            setButtonText(R.id.expense_detail_create_or_update, getResources().getString(R.string.expense_detail_update_button_text));
        }
    }

    private void populateExpenseTypeDropDown() {
        Spinner spinner = (Spinner) findViewById(R.id.expense_type_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.expense_type_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new ExpenseTypeSpinnerActivity());

        String compareValue = this.expense.getExpenseType();
        if (compareValue != null) {
            int spinnerPosition = adapter.getPosition(compareValue);
            spinner.setSelection(spinnerPosition);
        }
    }

    private void setTextViewContent(int textViewId, String textValue) {
        TextView textView = (TextView) findViewById(textViewId);
        textView.setText(textValue);
    }

    private void setButtonText(int buttonId, String buttonTextValue) {
        Button button = (Button) findViewById(buttonId);
        button.setText(buttonTextValue);
    }

    public void cancel(View view) {
        this.onBackPressed();
    }

    public void update(View view) {
        // Do validation of fields


        if(this.isCreateExpense) {
            this.expenseService.createExpense(getExpenseValuesFromLayout(null));
        } else {
            this.expenseService.updateExpense(getExpenseValuesFromLayout(this.expense.getExpenseId()));
        }
    }

    private Expense getExpenseValuesFromLayout(String expenseId) {
        Expense expense = new Expense();
        expense.setExpenseId(expenseId);
        expense.setExpenseType(expenseTypeSelected);
        expense.setAmount(getEditTextFieldValue(R.id.expense_detail_amount));
        expense.setDescription(getEditTextFieldValue(R.id.expense_detail_description));
        expense.setDate(getEditTextFieldValue(R.id.expense_detail_expense_date));
        expense.setComment(getEditTextFieldValue(R.id.expense_detail_comment));

        return expense;
    }

    private String getEditTextFieldValue(int editTextFieldId) {
        EditText editText = (EditText) findViewById(editTextFieldId);
        return editText.getText().toString();
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
