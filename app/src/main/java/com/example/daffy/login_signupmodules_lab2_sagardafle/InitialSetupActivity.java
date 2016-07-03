package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by daffy on 7/2/16.
 */
public class InitialSetupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initialsetupmodulefragment);
        TextView fullname = (TextView)findViewById(R.id.usernamefragment);
        fullname.setText("Welcome, " );
        fullname.append(getIntent().getStringExtra("username"));
    }

    //rest of app


@Override
public boolean onCreateOptionsMenu(Menu menu){
    MenuInflater mif = getMenuInflater();
    mif.inflate(R.menu.logout_action,menu);
    return super.onCreateOptionsMenu(menu);
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout_btn) {

            Intent i = new Intent(this,LoginActivity.class);
            startActivity(i);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
