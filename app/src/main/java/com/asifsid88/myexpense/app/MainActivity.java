package com.asifsid88.myexpense.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.asifsid88.myexpense.app.model.Expense;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setLayoutFields();
    }

    public void addNewExpense(View view) {
        Intent intent = new Intent(this, ExpenseDetailEditActivity.class);
        intent.putExtra(Constants.EXPENSE_MODEL, new Expense());
        startActivity(intent);
    }

    private void setLayoutFields() {
        populateExpenseDisplayRangeSpinner();
    }

    private void populateExpenseDisplayRangeSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.expense_range_selection_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.expense_display_range, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new ExpenseDisplayRangeSpinnerActivity());
    }

    private class ExpenseDisplayRangeSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        private ExpenseDisplayRangeSpinnerActivity() {

        }

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String noOfExpenseToShow = String.valueOf(parent.getItemAtPosition(pos));
            // now fetch the expenses with this number and refresh the fragment
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
}
