package cc.ibooker.sqlite.dbhelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import cc.ibooker.sqlite.bean.User;

/**
 * 数据库访问接口实现类，注意在修改方法前加上synchronized（同步）
 * Created by 邹峰立 on 2017/2/16 0016.
 */
public class SQLiteDaoImpl implements SQLiteDao {
    private SQLiteHelper dbHelper = null;

    /**
     * 构造方法
     *
     * @param context 上下文对象
     */
    public SQLiteDaoImpl(@NonNull Context context) {
        dbHelper = SQLiteHelper.getSqliteHelper(context);
    }

    /**
     * 获取用户集合
     */
    @Override
    public synchronized List<User> selectUser() {
        SQLiteDatabase db = dbHelper.openDatabase(); // 获取一个可读的数据库
        Cursor cursor = db.rawQuery("select * from t_user", null);
        List<User> users = new ArrayList<>();
        while (cursor.moveToNext()) {
            User user = new User();
            user.setuId(cursor.getLong(cursor.getColumnIndex("u_id")));
            user.setuPhone(cursor.getLong(cursor.getColumnIndex("u_phone")));
            user.setuRealName(cursor.getString(cursor.getColumnIndex("u_realname")));
            user.setuSex(cursor.getString(cursor.getColumnIndex("u_sex")));
            user.setuHeight(cursor.getFloat(cursor.getColumnIndex("u_height")));
            user.setuWeight(cursor.getFloat(cursor.getColumnIndex("u_weight")));
            user.setuBirthday(cursor.getString(cursor.getColumnIndex("u_birthday")));
            user.setuDomicile(cursor.getString(cursor.getColumnIndex("u_domicile")));
            user.setuEmail(cursor.getString(cursor.getColumnIndex("u_email")));
            user.setuWeibo(cursor.getString(cursor.getColumnIndex("u_weibo")));
            users.add(user);
        }
        cursor.close();
        dbHelper.closeDatabase();
        return users;
    }

    /**
     * 根据用户ID获取用户信息
     *
     * @param uId 用户ID
     */
    @Override
    public synchronized User selectUserByuId(long uId) {
        SQLiteDatabase db = dbHelper.openDatabase(); // 获取一个可读的数据库
        String sql = "select * from t_user where u_id=?";
        Cursor cursor = db.rawQuery(sql, new String[]{uId + ""});
        User user = null;
        while (cursor.moveToNext()) {
            user = new User();
            user.setuId(cursor.getLong(cursor.getColumnIndex("u_id")));
            user.setuPhone(cursor.getLong(cursor.getColumnIndex("u_phone")));
            user.setuRealName(cursor.getString(cursor.getColumnIndex("u_realname")));
            user.setuSex(cursor.getString(cursor.getColumnIndex("u_sex")));
            user.setuHeight(cursor.getFloat(cursor.getColumnIndex("u_height")));
            user.setuWeight(cursor.getFloat(cursor.getColumnIndex("u_weight")));
            user.setuBirthday(cursor.getString(cursor.getColumnIndex("u_birthday")));
            user.setuDomicile(cursor.getString(cursor.getColumnIndex("u_domicile")));
            user.setuEmail(cursor.getString(cursor.getColumnIndex("u_email")));
            user.setuWeibo(cursor.getString(cursor.getColumnIndex("u_weibo")));
        }
        cursor.close();
        dbHelper.closeDatabase();
        return user;
    }

    /**
     * 根据用户ID修改用户信息
     */
    @Override
    public synchronized void updateUserByuId(User user) {
        SQLiteDatabase db = dbHelper.openDatabase(); // 获取一个可写的数据库
        String sql = "update t_user set u_phone=? ,u_realname=?"
                + ", u_sex=? ,u_height=? ,u_weight=? ,u_birthday=?, u_domicile=?"
                + ", u_email=? ,u_weibo=? where u_id = ?";
        db.execSQL(sql, new Object[]{user.getuPhone(), user.getuRealName(), user.getuSex(),
                user.getuHeight(), user.getuWeight(), user.getuBirthday(),
                user.getuDomicile(), user.getuEmail(), user.getuWeibo(), user.getuId()});
        dbHelper.closeDatabase();
    }

    /**
     * 插入用户信息
     */
    @Override
    public synchronized void insertUser(User user) {
        SQLiteDatabase db = dbHelper.openDatabase(); // 获取一个可写的数据库
        String sql = "insert into t_user(u_id, u_phone,  u_realname"
                + ", u_sex ,u_height ,u_weight ,u_birthday"
                + ", u_domicile, u_email ,u_weibo)"
                + "values(?,?,?,?,?,?,?,?,?,?)";
        db.execSQL(sql, new Object[]{user.getuId(), user.getuPhone(), user.getuRealName(),
                user.getuSex(), user.getuHeight(), user.getuWeight(),
                user.getuBirthday(), user.getuDomicile(), user.getuEmail(), user.getuWeibo()});
        dbHelper.closeDatabase();
    }

    /**
     * 根据用户ID删除用户ID
     *
     * @param uId 用户ID
     */
    @Override
    public synchronized void deleteUserByUid(long uId) {
        SQLiteDatabase db = dbHelper.openDatabase(); // 获取一个可写的数据库
        String sql = "delete from t_user where u_id=?";
        db.execSQL(sql, new Long[]{uId});
        dbHelper.closeDatabase();
    }

}
