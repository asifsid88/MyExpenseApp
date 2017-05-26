package com.asifsid88.myexpense.app.fragments;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.asifsid88.myexpense.app.R;
import com.asifsid88.myexpense.app.model.Expense;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExpenseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expense, container, false);
        createLayout(view);
        return view;
    }

    public void createLayout(View view) {
        TableLayout tableLayout = (TableLayout) view.findViewById(R.id.tablelayout);
        List<Expense> expenseList = getExpenseList();

        List<String> heading = getHeading();
        TableRow headingRow = new TableRow(getActivity());
        for(int i=0; i<heading.size(); ++i) {
            TextView textView = new TextView(getActivity());
            textView.setText(heading.get(i));
            textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.table_border));
            textView.setGravity(Gravity.CENTER);
            textView.setTypeface(null, Typeface.BOLD);
            textView.setPadding(4, 4, 4, 4);

            headingRow.addView(textView);
        }
        tableLayout.addView(headingRow);


        List<List<String>> body = getTableBody();
        for(List<String> row : body) {
            TableRow bodyRow = new TableRow(getActivity());
            for(int i=0; i<row.size(); ++i) {
                TextView textView = new TextView(getActivity());
                textView.setText(row.get(i));
                textView.setBackgroundDrawable(getResources().getDrawable(R.drawable.table_border));
                textView.setGravity(Gravity.CENTER);
                textView.setPadding(4, 4, 4, 4);

                bodyRow.addView(textView);
            }
            tableLayout.addView(bodyRow);
        }
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
        expense.setExpenseType(String.valueOf(expenseId));
        expense.setAmount(String.valueOf(expenseId * 10));
        expense.setExpenseType("Cash");
        expense.setDescription("Description: " + expenseId);
        expense.setComment("Comment: " + expenseId);

        return expense;
    }

    /**
     * TODO: Move this to make it generic, place the column name in properties file to be read
     * and fill the object dynamically
     */
    private List<String> getHeading() {
        List<String> heading = new ArrayList<>();
        heading.add("Expense Type");
        heading.add("Amount");
        heading.add("Date");
        heading.add("Description");

        return heading;
    }

    private List<List<String>> getTableBody() {
        List<List<String>> body = new LinkedList<>();
        List<Expense> expenseList = getExpenseList();
        for(Expense expense : expenseList) {
            List<String> row = new LinkedList<>();
            row.add(expense.getExpenseType());
            row.add(expense.getAmount());
            row.add("21st March 2017");
            row.add(expense.getDescription());
            body.add(row);
        }

        return body;
    }
}