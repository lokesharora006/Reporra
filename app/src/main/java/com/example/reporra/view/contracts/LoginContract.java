package com.example.reporra.view.contracts;

public interface LoginContract {



    interface View {
        void showLoginSuccess(String message);

        void showLoginError(String message);

        void showProgress();

        void hideProgress();
    }

    interface Presenter {
        void loginWithEmail(String email, String password);
    }


}
