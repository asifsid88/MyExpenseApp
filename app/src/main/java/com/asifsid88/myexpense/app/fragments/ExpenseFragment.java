package com.asifsid88.myexpense.app.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asifsid88.myexpense.app.R;
import com.asifsid88.myexpense.app.adapter.ExpenseAdapter;
import com.asifsid88.myexpense.app.listener.ExpenseItemClickListener;
import com.asifsid88.myexpense.app.model.Expense;

import java.util.LinkedList;
import java.util.List;

public class ExpenseFragment extends ListFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expense, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<Expense> expenseList = getExpenseList();
        ExpenseAdapter expenseAdapter = new ExpenseAdapter(getActivity(), expenseList);
        setListAdapter(expenseAdapter);
        getListView().setOnItemClickListener(new ExpenseItemClickListener(getActivity(), expenseList));
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
        expense.setExpenseType("Paytm");
        expense.setDescription("The transaction was done for the lunch");
        expense.setComment("Comment: " + expenseId);
        expense.setDate("21st May 2017");

        return expense;
    }
}