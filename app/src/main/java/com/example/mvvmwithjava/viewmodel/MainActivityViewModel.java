package com.example.mvvmwithjava.viewmodel;

import android.text.TextUtils;
import android.util.Patterns;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.mvvmwithjava.BR;
import com.example.mvvmwithjava.model.User;

public class MainActivityViewModel extends BaseObservable {

    private User user;
    private String successMessage = "Login was Successfull";
    private String errorMessage = "Email or Password not Valid";

    @Bindable
    private String toastMessage = null;


    //for toast
    public String getToastMessage() {
        return toastMessage;
    }

    public void setToastMessage(String toastMessage) {
        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }
    //end toast


    //set useremail
    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }
    //end get user email


    //getuserPassword
    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }
    //set user password


    public MainActivityViewModel(){
        user = new User("", "");
    }


    //from main activity class
    public void onLoginClicked(){
        if(isInputDataValid()){
            setToastMessage(successMessage);
        }
        else {
            setToastMessage(errorMessage);
        }
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }



}
