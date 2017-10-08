package cc.ibooker.zdatastore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button spBtn = findViewById(R.id.btn_sp);
        spBtn.setOnClickListener(this);
        Button fileBtn = findViewById(R.id.btn_file);
        fileBtn.setOnClickListener(this);
        Button sqliteBtn = findViewById(R.id.btn_sqlite);
        sqliteBtn.setOnClickListener(this);
        Button greendaoBtn = findViewById(R.id.btn_greendao);
        greendaoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sp:// SharedPreferences
                Intent intent_sp = new Intent(this, SharedPreferencesActivity.class);
                startActivity(intent_sp);
                break;
            case R.id.btn_file:// File
                Intent intent_file = new Intent(this, FileActivity.class);
                startActivity(intent_file);
                break;
            case R.id.btn_sqlite:// SQLite
                Intent intent_sqlite = new Intent(this, SQLiteActivity.class);
                startActivity(intent_sqlite);
                break;
            case R.id.btn_greendao:// GreenDao
                Intent intent_greendao = new Intent(this, GreenDaoActivity.class);
                startActivity(intent_greendao);
                break;
        }
    }
}
