package com.wongel.test;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase sqLiteDatabase;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;

    private EditText edtName;
    private Button btnAdd;

    private List<Student> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDbHelper databaseHelper = new MyDbHelper(this);
        sqLiteDatabase = databaseHelper.getWritableDatabase();

        findViews();
        init();
        setAdapter(getData());
    }

    public void findViews() {
        recyclerView = findViewById(R.id.recycleView);
        edtName = findViewById(R.id.edtName);
        btnAdd = findViewById(R.id.btnAdd);
    }

    public void init() {
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    edtName.setError("Cannot be empty");
                } else {
                    Student student = new Student(name);
                    insert(student);
                }
            }
        });
    }

    public void setAdapter(final List<Student> l) {
        this.list = l;
        adapter = new MyAdapter(getData(), new OnMyClickListner() {
            @Override
            public void onDelClicked(int position) {
                Student student = list.get(position);
                delete(student.getId());
            }

            @Override
            public void onUpdateClicked(String name, int position) {
                Student student = list.get(position);
                student.setName(name);
                update(student);
            }
        });

        recyclerView.setAdapter(adapter);
    }

    public void insert(Student student) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.studentName, student.getName());
        contentValues.put(MyDbHelper.studentRoll, 123);

        sqLiteDatabase.insert(MyDbHelper.tblStudnet, null, contentValues);
        setAdapter(getData());
    }

    public void update(Student student) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.studentName, student.getName());
        contentValues.put(MyDbHelper.studentRoll, 123);

        String whereClause = MyDbHelper.studentId + "=?";
        String[] whereArgs = {String.valueOf(student.getId())};

        sqLiteDatabase.update(MyDbHelper.tblStudnet, contentValues, whereClause, whereArgs);
        setAdapter(getData());
        setAdapter(getData());
    }

    public void delete(int id) {
        String whereClause = MyDbHelper.studentId + "=?";
        String[] whereArgs = {String.valueOf(id)};
        sqLiteDatabase.delete(MyDbHelper.tblStudnet, whereClause, whereArgs);
        setAdapter(getData());
    }

    public List<Student> getData() {
        Cursor cursor = sqLiteDatabase.query(MyDbHelper.tblStudnet, null, null,
                null, null, null, null);
        List<Student> list = new ArrayList<>();
        while (cursor.moveToNext()) {
            int index0 = cursor.getColumnIndex(MyDbHelper.studentName);
            int index1 = cursor.getColumnIndex(MyDbHelper.studentId);

            String name = cursor.getString(index0);
            int id = cursor.getInt(index1);

            Student student = new Student(name);
            student.setId(id);
            list.add(student);
        }
        cursor.close();
        return list;
    }
}


