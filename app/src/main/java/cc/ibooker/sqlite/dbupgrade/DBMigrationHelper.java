package cc.ibooker.sqlite.dbupgrade;

import android.database.sqlite.SQLiteDatabase;

import cc.ibooker.sqlite.dbhelper.SQLiteConstant;

/**
 * 数据库升级实现类
 * Created by 邹峰立 on 2017/9/24 0024.
 */
public class DBMigrationHelper extends AbstractMigratorHelper {

    @Override
    public void onUpgrade(SQLiteDatabase db) {
        // 创建t_user临时表t_user2
        db.execSQL(SQLiteConstant.SQL_CREATE_TABLE_USER2);
        // 复制t_user到t_user2
        db.execSQL(SQLiteConstant.SQL_COPY_TABLE_USER_USER2);
        // 删除t_user
        db.execSQL(SQLiteConstant.SQL_DROP_TABLE_USER);
        // 重命名t_user2为t_user
        db.execSQL(SQLiteConstant.SQL_USER2_RENAME_USER);
        // 也可以额外进行其他操作
    }

}
