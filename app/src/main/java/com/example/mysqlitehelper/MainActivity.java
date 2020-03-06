package com.example.mysqlitehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_name;
    EditText edt_email;
    EditText edt_phone;
    Button btn_write;
    Button btn_read;
    Button btn_update;
    Button btn_remove;
    MySQLite mySQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name=findViewById(R.id.edt_name);
        edt_email=findViewById(R.id.edt_email);
        edt_phone=findViewById(R.id.edt_phone);
        btn_write=findViewById(R.id.btn_write);
        btn_read=findViewById(R.id.btn_read);
        btn_update=findViewById(R.id.btn_update);
        btn_remove=findViewById(R.id.btn_remove);
        mySQL=new MySQLite(this,"mydb",null,1);
    }

    public void Insert(String name, String msg){
        SQLiteDatabase db=mySQL.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(name,msg);
        long id=db.insert("mydb",null,values);
        db.close();
    }
    public void Update(){

    }
    public void find(long id){

    }

    public void btnWrite(View view) {
        Insert("name",edt_name.getText().toString());
        Insert("email",edt_email.getText().toString());
        Insert("phone",edt_phone.getText().toString());
    }

    public void btnRead(View view) {
    }

    public void btnUpdate(View view) {
    }

    public void btnRemove(View view) {
    }
}
