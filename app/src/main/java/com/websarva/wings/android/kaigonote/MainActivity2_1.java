package com.websarva.wings.android.kaigonote;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity2_1 extends AppCompatActivity {

    private int _kaigoId = -1;
    private String _kaigoName = "";
    private DatabaseHelper _helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);
        ListView kaigo = findViewById(R.id.kaigo);
        kaigo.setOnItemClickListener(new ListItemClickListner());
        _helper = new DatabaseHelper(MainActivity2_1.this);
    }

    @Override
    protected void onDestroy(){
    //DBヘルパーオブジェクトの解放。
    _helper.close();
    super.onDestroy();
    }
         // stmo = findViewById(R.id.stmo);
        //stmo2 = findViewById(R.id.stmo2);
       // sqLiteDatabase = databaseHelper.getWritableDatabase();
    public void onSaveButtonClick(View view){
        //名前を習得。
        EditText stmo = findViewById(R.id.stmo);
        String note = stmo.getText().toString();
        stmo.setText("");

        EditText stmo2 = findViewById(R.id.stmo2);
        stmo2.setText("");

        Button tv_name1 = findViewById(R.id.tv_name1);
        tv_name1.setEnabled(false);
    }




    private class ListItemClickListner implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?>parent,View view,int position,long id){
            _kaigoId = position;
            _kaigoName = (String) parent.getItemAtPosition(position);
            TextView tv_name = findViewById(R.id.tv_name);
            tv_name.setText(_kaigoName);
            Button tv_name1 = findViewById(R.id.tv_name1);
            tv_name1.setEnabled(true);

            SQLiteDatabase db = _helper.getWritableDatabase();
            String sql = "INSERT　INTO  Kaigomemo　VALUES　('排泄')" ;
            String note;
            try (Cursor cursor = db.rawQuery(sql, null)) {
                note = "";

                while (cursor.moveToNext()) {
                    int idxNote = cursor.getColumnIndex("note");
                    note = cursor.getString(idxNote);
                }
            }
            EditText stmo = findViewById(R.id.stmo);
            stmo.setText(note);

        }
    }
}