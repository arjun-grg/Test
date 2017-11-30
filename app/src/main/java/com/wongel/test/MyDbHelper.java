package com.wongel.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by tseringwongelgurung on 11/21/17.
 */

public class MyDbHelper extends SQLiteOpenHelper {
    private Context context;
    public static final String dbName = "PlanetTest";
    public static final int version = 1;

    //Student
    public static final String tblStudnet = "Student";
    public static final String studentId= "id";
    public static final String studentName = "Name";
    public static final String studentRoll = "Roll";

    public static final String createStudent="CREATE TABLE if not exists "+tblStudnet+" ( "+studentId
            +" integer primary key autoincrement, "+studentName+" varchar, "+studentRoll+" integer);";
    public static final String dropStudnet="Drop TABLE is exists "+tblStudnet;

    public MyDbHelper(Context context) {
        super(context, dbName, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createStudent);
        Toast.makeText(context,"ON cREATE",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Toast.makeText(context,"ON Drop",Toast.LENGTH_SHORT).show();
        sqLiteDatabase.execSQL(dropStudnet);
        onCreate(sqLiteDatabase);
    }
}
