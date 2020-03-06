package com.example.mysqlitehelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_name;
    EditText edt_email;
    EditText edt_phone;
    Button btn_write;
    Button btn_read;
    Button btn_update;
    Button btn_remove;
    TextView tv_show;
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
        tv_show=findViewById(R.id.tv_show);
        mySQL=new MySQLite(this,"mydb",null,1);
    }

    public void Insert(String name, String msg){

    }
    public void Update(){

    }
    public void find(long id){

    }

    public void btnWrite(View view) {
        long id=0;
        SQLiteDatabase db=mySQL.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",edt_name.getText().toString());
        values.put("email",edt_email.getText().toString());
        values.put("phone",edt_phone.getText().toString());
        id=db.insert("user",null,values);
        db.close();
        if(id!=0){
            Toast.makeText(this,"Writing successful",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Writing failed",Toast.LENGTH_LONG).show();
        }
    }

    public void btnRead(View view) {
        SQLiteDatabase db=mySQL.getWritableDatabase();
        Cursor cursor=db.query("user",null,null,null,null,null,null);
        String str="";
        Toast.makeText(this,cursor.getString(cursor.getColumnIndex("name")),Toast.LENGTH_LONG).show();
        cursor.moveToFirst();
        do{
            str+="Name:"+cursor.getString(cursor.getColumnIndex("name"))+"\n";
            str+="Email:"+cursor.getString(cursor.getColumnIndex("email"))+"\n";
            str+="Phone:"+cursor.getString(cursor.getColumnIndex("phone"))+"\n";
            str+="\n\n";
        }while (cursor.moveToNext());
        tv_show.setText(str);
    }

    public void btnUpdate(View view) {
        SQLiteDatabase db = mySQL.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",edt_name.getText().toString());
        values.put("email",edt_email.getText().toString());
        values.put("phone",edt_phone.getText().toString());
        db.update("user", values, "phone=?", new String[]{edt_phone.getText().toString()});
    }

    public void btnRemove(View view) {
        SQLiteDatabase db=mySQL.getWritableDatabase();
        db.delete("user",null,null);
        tv_show.setText("-no records-");
    }
}
