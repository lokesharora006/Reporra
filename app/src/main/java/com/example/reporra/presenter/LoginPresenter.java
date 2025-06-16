package com.example.reporra.presenter;

<<<<<<< HEAD
import android.text.TextUtils;

import com.example.reporra.view.contracts.LoginContract;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPresenter implements LoginContract.Presenter {

    private final LoginContract.View view;
    private final FirebaseAuth auth;

    public LoginPresenter(LoginContract.View view, FirebaseAuth auth) {
        this.view = view;
        this.auth = auth;
    }

    @Override
    public void loginWithEmail(String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            view.showLoginError("Email and password must not be empty.");
            return;
        }

        view.showProgress();

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    view.hideProgress();
                    if (task.isSuccessful()) {
                        view.showLoginSuccess("Login successful.");
                    } else {
                        view.showLoginError("Login failed: " + task.getException().getMessage());
                    }
                });
    }
=======

public class LoginPresenter {
>>>>>>> b63e4da909a72e7d409bb75d34ec442eddcf9e9c
}
