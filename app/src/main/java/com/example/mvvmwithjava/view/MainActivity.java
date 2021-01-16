package com.example.mvvmwithjava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvvmwithjava.R;
import com.example.mvvmwithjava.databinding.ActivityMainBinding;
import com.example.mvvmwithjava.viewmodel.MainActivityViewModel;


public class MainActivity extends AppCompatActivity {
    MainActivityViewModel mainActivityViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new MainActivityViewModel());
        activityMainBinding.executePendingBindings();


    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null)
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}