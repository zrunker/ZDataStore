package cc.ibooker.greendao.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import cc.ibooker.greendao.DaoMaster;

/**
 * OpenHelper
 * Created by 邹峰立 on 2017/9/23 0023.
 */
public class DBHelper extends DaoMaster.OpenHelper {
    public static final String DBNAME = "ibookerdata.db";

    public DBHelper(Context context, String name) {
        super(context, name, null);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 当数据库版本更新的时候回调函数
     *
     * @param db         数据库对象
     * @param oldVersion 数据库旧版本
     * @param newVersion 数据库新版本
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        if (newVersion > oldVersion) {
            // 创建临时表
            // 复制旧数据到临时表
            // 数据库（表）删除
            // 临时表重命名
        }
    }
}
