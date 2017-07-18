package com.asifsid88.myexpense.app.service.callbacks;

/**
 * Created by mhussaa on 6/3/17.
 */

public interface ICallback<T> {
    void execute(boolean success, T result);
}
