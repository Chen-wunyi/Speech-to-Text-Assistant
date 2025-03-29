package com.example.speechre;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

public class CommonActivity extends AppCompatActivity {
    //activity加入androidManifest:點兩下選取class名然後alt+enter即可自動註冊
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        final String DataBaseName = "db";
        final int DataBaseVersion = 1;
        String DataBaseTable = "CommonTable";
        SQLiteDatabase db ;
        DBOpenHelper dBOpenHelper;
        SimpleAdapter listItemAdapter;
        // 建立SQLiteOpenHelper物件
        dBOpenHelper = new DBOpenHelper(this,DataBaseName,null,DataBaseVersion,DataBaseTable);
        db = dBOpenHelper.getWritableDatabase(); // 開啟資料庫

        //ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();//取得所有資料
       // ArrayList<HashMap<String, String>> getNowArray = new ArrayList<>();//取得被選中的項目資料
        String id = null,common= null;



        Cursor c = db.rawQuery(" SELECT * FROM " + DataBaseTable, null);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while (c.moveToNext()) {
            HashMap<String, String> hashMap = new HashMap<>();

            id = String.valueOf(c.getInt(0));
            common = String.valueOf(c.getBlob(1));

            hashMap.put("id", id);
            hashMap.put("split", common);

            arrayList.add(hashMap);
        }




        ArrayAdapter<HashMap<String, String>>adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,arrayList);

        ListView listView=(ListView)findViewById(R.id.lvS);
        listView.setAdapter(adapter);


        
        //Btn add
        Button addBtnS = (Button) findViewById(R.id.addBtnS);
        addBtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editText = new String();
                ContentValues contentValues = new ContentValues();
                byte[] arr = new byte[0];
                try {
                    arr = editText.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                contentValues.put("common", arr);

                db.insert(DataBaseTable, null, contentValues);
            }
        });

        //Btn delete
        Button deleteBtnS = (Button) findViewById(R.id.deleteBtnS);
        //String finalSplit = split;
        String finalId = id;
        deleteBtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // db.delete(DataBaseTable,"id="+id,null);
                //db.delete(DataBaseTable,"_id="+ finalId,null);
                db.delete(DataBaseTable,"id="+ finalId,null);
            }
        });

        //Btn back
        Button backBtnS = (Button) findViewById(R.id.backBtnS);
        backBtnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(CommonActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }


}