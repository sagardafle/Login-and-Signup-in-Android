package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static FragmentManager myfragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myfragmentManager = getSupportFragmentManager();

        // If savedinstnacestate is null then replace login fragment
        if (savedInstanceState == null) {
            myfragmentManager
                    .beginTransaction()
                    .replace(R.id.frameContainer, new LoginModuleFragment(),
                            "LoginFragment").commit();
        }
    }
}
