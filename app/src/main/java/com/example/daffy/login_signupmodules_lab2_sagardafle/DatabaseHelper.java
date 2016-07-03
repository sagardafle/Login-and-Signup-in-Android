package com.example.daffy.login_signupmodules_lab2_sagardafle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by daffy on 7/1/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    static SQLiteDatabase db;

    private static final int DATABASE_VERSION = 3;
    private static final String DATABASE_NAME = "userdata.db";
    private static final String TABLE_NAME = "userdetails";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FULLNAME = "fullname";
    private static final String COLUMN_EMAILID = "emailid";
    private static final String COLUMN_MOBILENO = "mobileno";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_PASSWORD = "password";

    private static final String CREATE_TABLE = "create table IF NOT EXISTS userdetails (id integer primary key not null , " +
            "fullname text not null , emailid text not null, age integer not null, password text not null, mobileno text not null);" ;


    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME, null , DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        this.db =db;
        Log.d("Table created","created");
    }


    public void insertData(UserData userdata){
        ContentValues values = new ContentValues();
        values.put(COLUMN_FULLNAME,userdata.getFullname());
        values.put(COLUMN_EMAILID,userdata.getEmailid());
        values.put(COLUMN_MOBILENO,userdata.getMobile());
        values.put(COLUMN_AGE,userdata.getAge());
        values.put(COLUMN_PASSWORD,userdata.getPassword());

        try{
            db.insert(TABLE_NAME, null ,values);
            Log.d("Insert SUCCESS", values.toString());
        } catch (Exception e){
            Log.d("Insert FAILURE", e.toString());
        }
        //db.close();
    }

    public boolean userExists(String emailid,String password){
        //db = this.getReadableDatabase();
        String fetchuser = "Select emailid,password from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(fetchuser, null);
        String a,b = "not found";
        Log.d("received emailid", emailid);
        Log.d("Cursor count", String.valueOf(cursor.getCount()));
        if(cursor.moveToFirst()){
            Log.d("Select " , " clause");
            do{
                a= cursor.getString(0);
                Log.d("a " , a);
                if (a.equals(emailid)){
                    Log.d("emailid  If loop" , a);
                    b = cursor.getString(1);
                    Log.d("b " , b);
                    break;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
                }
            }
            while(cursor.moveToNext());
        }
        if (b.equals(password)) {
            Log.d("Returning "," true");
            return true;
        }
        else return false;
    }




    public String getUserName(String emailid){
        //db = this.getReadableDatabase();
        String fetchuser = "Select "+COLUMN_EMAILID+", "+COLUMN_FULLNAME+" from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(fetchuser, null);
        String a,b = "not found";
        Log.d("received emailid", emailid);
        Log.d("Cursor count", String.valueOf(cursor.getCount()));
        if(cursor.moveToFirst()){
            Log.d("Select " , " clause");
            do{
                a= cursor.getString(0);
                Log.d("a " , a);
                if (a.equals(emailid)){
                    Log.d("emailid  If loop" , a);
                    b = cursor.getString(1);
                    Log.d("b " , b);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        return b;

    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String dropquery= "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(dropquery);
        this.onCreate(db);
    }
}
