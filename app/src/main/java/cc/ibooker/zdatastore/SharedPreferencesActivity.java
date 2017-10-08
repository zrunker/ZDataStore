package cc.ibooker.zdatastore;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * SharedPreferences存储
 * Created by 邹峰立 on 2017/9/19 0019.
 */
public class SharedPreferencesActivity extends AppCompatActivity {
    private EditText nameEd, passwdEd;
    private CheckBox checkBox;
    private String mKeyPasswd = "passwd";
    private String mKeyName = "name";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);

        initView();
    }

    // 初始化控件
    private void initView() {
        nameEd = findViewById(R.id.ed_name);
        passwdEd = findViewById(R.id.ed_passwd);
        checkBox = findViewById(R.id.checkbox);
        // 赋值
        nameEd.setText(readData(mKeyName).toString());
        passwdEd.setText(readData(mKeyPasswd).toString());
        Button button = findViewById(R.id.btn_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    String name = nameEd.getText().toString().trim();
                    String passwd = passwdEd.getText().toString().trim();
                    boolean nameBool = saveData(name, mKeyName);
                    boolean passwdPool = saveData(passwd, mKeyPasswd);
                    Log.d("bool", nameBool + "--" + passwdPool);
                } else {
                    remove();
                }
                finish();
            }
        });
    }

    // 移除数据
    private void remove() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        // 获取编辑对象
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // 移除
        editor.remove(mKeyPasswd);
        // 提交
        editor.apply();// 后台提交
    }

    // 清空数据
    private void clearAll() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        // 获取编辑对象
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // 清空
        editor.clear();
        // 提交
        editor.apply();// 后台提交
    }

    /**
     * 保存数据
     *
     * @param obj 待保存数据
     * @return true/false
     */
    private boolean saveData(Object obj, String key) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        // 获取编辑对象
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // 添加数据
        editor.putString(key, obj.toString());
        // 提交保存
        // editor.apply();// 后台提交
        return editor.commit();// 马上提交
    }

    /**
     * 读取值
     *
     * @param key 键值
     * @return 待读取内容
     */
    private Object readData(String key) {
        SharedPreferences sharedPreferences = getSharedPreferences();
        // 获取值
        return sharedPreferences.getString(key, "");
    }

    // 获取sharedPreferences对象
    private SharedPreferences getSharedPreferences() {
//        SharedPreferences sharedPreferences = getSharedPreferences("mName", Context.MODE_PRIVATE);
//        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // 如果不需要如其他模块数据共享使用
        return getPreferences(Activity.MODE_PRIVATE);
    }
}
