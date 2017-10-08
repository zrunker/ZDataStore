package cc.ibooker.zdatastore;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cc.ibooker.sqlite.bean.User;
import cc.ibooker.sqlite.dbhelper.SQLiteDaoImpl;

/**
 * SQLite数据库存储
 * Created by 邹峰立 on 2017/9/19 0019.
 */
public class SQLiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SQLiteDaoImpl sqLiteDao = new SQLiteDaoImpl(this);
        List<User> users = sqLiteDao.selectUser();

//        /**
//         * 方式一
//         * @param file
//         * @param factory
//         */
//        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(File file, SQLiteDatabase.CursorFactory factory);
//
//        /**
//         * 方式二
//         * @param path
//         * @param factory
//         * @param flags
//         */
//        SQLiteDatabase db = SQLiteDatabase.openDatabase(String path, SQLiteDatabase.CursorFactory factory, int flags);

//        // 初始化SQLiteDataBase
//        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "ibookerdata.db";
//        SQLiteDatabase db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
//
//        // 创建t_user表
//        String create_user = "CREATE TABLE IF NOT EXISTS t_user(_id INTEGER PRIMARY KEY autoincrement,u_id BIGINT UNSIGNED NOT NULL UNIQUE,u_phone BIGINT NOT NULL UNIQUE,u_realname VARCHAR(21),u_sex VARCHAR(6),u_height FLOAT(5,2),u_weight FLOAT(6,2),u_birthday VARCHAR(10),u_domicile VARCHAR(50),u_email VARCHAR(40),u_weibo VARCHAR(40))";
//        db.execSQL(create_user);
//
//        // 插入数据
//        // 方式一
//        ContentValues insert_values = new ContentValues();
//        insert_values.put("u_id", 1102);
//        insert_values.put("u_phone", 18011111254L);
//        ...
//        insert_values.put("u_weibo", "@zrunker");
//        db.insert("t_user", null, insert_values);
//
//        // 方式二
//        String insert_sql = "insert into t_user(u_id, u_phone,  u_realname, u_sex ,u_height ,u_weight ,u_birthday, u_domicile, u_email ,u_weibo) values(?,?,?,?,?,?,?,?,?,?)";
//        db.execSQL(insert_sql, new Object[]{1102, 18011111254L, "zrunker", "男", 175, 65, "1992-10-63", "fujian", "zrunker@xx.com", "@zrunker"});
//
//        // 修改数据
//        // 方式一
//        ContentValues update_values = new ContentValues();
//        update_values.put("u_phone", 15300025864L);
//        ...
//        update_values.put("u_weibo", "zrunker");
//        db.update("t_user", update_values, "u_id=?", new String[]{"1102"});
//
//        // 方式二
//        String update_sql = "update t_user set u_phone=? ,u_realname=?, u_sex=? ,u_height=? ,u_weight=? ,u_birthday=?, u_domicile=?, u_email=? ,u_weibo=? where u_id = ?";
//        db.execSQL(update_sql, new Object[]{15300025864L, "zrunker1", "女", 173, 62, "1999-10-16", "beijing", "zrunker1@aa.com", "zrunker", 1102});
//
//        // 删除数据
//        // 方式一
//        db.delete("t_user", "u_id=?", new String[]{"1102"});
//
//        // 方式二
//        String delete_sql = "delete from t_user where u_id=?";
//        db.execSQL(delete_sql, new Long[]{1102L});
//
//        // 查询数据
//        // 方式一：定义类User，作为t_user的关系映射对象
//        Cursor cursor = db.rawQuery("select * from t_user", null);
//        List<User> users = new ArrayList<>();
//        while (cursor.moveToNext()) {
//            User user = new User();
//            user.setuId(cursor.getLong(cursor.getColumnIndex("u_id")));
//            user.setuPhone(cursor.getLong(cursor.getColumnIndex("u_phone")));
//            user.setuRealName(cursor.getString(cursor.getColumnIndex("u_realname")));
//            user.setuSex(cursor.getString(cursor.getColumnIndex("u_sex")));
//            user.setuHeight(cursor.getFloat(cursor.getColumnIndex("u_height")));
//            user.setuWeight(cursor.getFloat(cursor.getColumnIndex("u_weight")));
//            user.setuBirthday(cursor.getString(cursor.getColumnIndex("u_birthday")));
//            user.setuDomicile(cursor.getString(cursor.getColumnIndex("u_domicile")));
//            user.setuEmail(cursor.getString(cursor.getColumnIndex("u_email")));
//            user.setuWeibo(cursor.getString(cursor.getColumnIndex("u_weibo")));
//            users.add(user);
//        }
//        cursor.close();
//
//        // 方式二
//        Cursor cursor1 = db.query("t_user", null, null, null, null, null, "u_id desc", "0, 15");
//
//        // 关闭database
//        db.close();
//
//        // 删除数据库
//        this.deleteDatabase("ibookerdata.db");
    }
}
