package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by daffy on 7/2/16.
 */
public class InitialSetupActivity extends AppCompatActivity {
    private ImageButton addbtn;
    private EditText et1,et2;
    public static View initialsetupview;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initialsetupmodulefragment);
        TextView fullname = (TextView)findViewById(R.id.usernamefragment);
        fullname.setText("Welcome, " );
        fullname.append(getIntent().getStringExtra("username"));
        addbtn = (ImageButton) findViewById(R.id.moreImageButton);
        Log.d("addbtn ", addbtn.toString());
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Ssdsad ", " asass");
                et1.setVisibility(View.VISIBLE);
                et2.setVisibility(View.VISIBLE);
            }
        });

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

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder1.setTitle("Application Logout ");
            builder1.setMessage("Are you sure that you wish to logout?");
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Yes",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            logout();
                        }
                    });

            builder1.setNegativeButton(
                    "No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = builder1.create();
            alert11.show();




//            Intent i = new Intent(this,LoginActivity.class);
//            startActivity(i);
//            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void logout(){
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
        finish();
    }
}
