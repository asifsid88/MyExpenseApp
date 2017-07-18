package com.asifsid88.myexpense.app.service;

/**
 * Created by mhussaa on 6/1/17.
 */

interface WebServiceUrls {
    //String baseUrl = "https://myexpense-asifsid88.herokuapp.com/";
    String baseUrl = "http://10.0.2.2:8080/";

    String getExpenseById = baseUrl + "expense/{expenseId}";
    String getExpenseListBySize = baseUrl + "expense/list/{size}";
    String createExpense = baseUrl + "expense/create";
    String updateExpense = baseUrl + "expense/1";
}
