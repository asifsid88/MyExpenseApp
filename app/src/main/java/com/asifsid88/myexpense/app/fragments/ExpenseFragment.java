package com.asifsid88.myexpense.app.fragments;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.asifsid88.myexpense.app.Constants;
import com.asifsid88.myexpense.app.ExpenseDetailActivity;
import com.asifsid88.myexpense.app.R;
import com.asifsid88.myexpense.app.adapter.ExpenseAdapter;
import com.asifsid88.myexpense.app.model.Expense;
import com.asifsid88.myexpense.app.service.ExpenseService;

import java.util.List;

public class ExpenseFragment extends ListFragment {

    private ExpenseAdapter expenseAdapter;
    private ExpenseService expenseService;

    private static final Integer DEFAULT_EXPENSE_LIST_COUNT = 10;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_expense, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        expenseService = new ExpenseService(getActivity());
        getExpenseList(DEFAULT_EXPENSE_LIST_COUNT);
    }

    /**
     * This is called as a callback: After getting expenseList via RESTService
     * @param expenseList
     */
    public void updateExpenseListFrame(List<Expense> expenseList) {
        if(expenseAdapter == null) {
            expenseAdapter = new ExpenseAdapter(getActivity(), expenseList);
            setListAdapter(expenseAdapter);
            getListView().setOnItemClickListener(new ExpenseItemClickListener(getActivity(), expenseList));
        } else {
            expenseAdapter.addAll(expenseList);
            expenseAdapter.notifyDataSetChanged();
        }
    }

    /**
     * This is called as a callback: After selecting drop-down range count
     * @param expenseListSize
     */
    public void refreshExpenseList(int expenseListSize) {
        expenseAdapter.clear();
        getExpenseList(expenseListSize);
    }

    private class ExpenseItemClickListener implements AdapterView.OnItemClickListener {

        private Context parentContext;
        private List<Expense> expenseList;

        private ExpenseItemClickListener(Context parentContext, List<Expense> expenseList) {
            this.parentContext = parentContext;
            this.expenseList = expenseList;
        }

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Expense expense = expenseList.get(position);
            Intent intent = new Intent(parentContext, ExpenseDetailActivity.class);
            intent.putExtra(Constants.EXPENSE_MODEL, expense);
            parentContext.startActivity(intent);
        }
    }

    private void getExpenseList(int n) {
        expenseService.getExpenseList(n);
    }
}