package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static Button  registerbtn;

    private static FragmentManager myfragmentManager;
    DatabaseHelper  helper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        helper = new DatabaseHelper(this);
        SQLiteDatabase sb = helper.getWritableDatabase();//this line responsible to call onCreate()
        helper.onCreate(sb);



        //myfragmentManager = getSupportFragmentManager();

        // If savedinstnacestate is null then replace login fragment
        if (savedInstanceState == null) {
//            myfragmentManager
//                    .beginTransaction()
//                    .replace(R.id.frameContainer, new LoginModuleFragment(),
//                            "LoginFragment").commit();
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);




        }
    }




}
