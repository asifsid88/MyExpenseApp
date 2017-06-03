package com.asifsid88.myexpense.app.service;

/**
 * Created by mhussaa on 6/1/17.
 */

interface WebServiceUrls {
    String baseUrl = "https://myexpense-asifsid88.herokuapp.com/";

    String getExpenseById = baseUrl + "/expense/{expenseId}";
    String getExpenses = baseUrl + "";
    String updateExpense = baseUrl + "/expense/1";
}
