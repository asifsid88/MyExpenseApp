package com.asifsid88.myexpense.app.service;

import lombok.Data;

/**
 * Created by mhussaa on 6/2/17.
 */
@Data
public class WebServiceResponseModel<T> {
    private String statusCode;
    private String statusMessage;
    private T data;
}
