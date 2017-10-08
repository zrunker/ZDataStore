package cc.ibooker.sqlite.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.concurrent.atomic.AtomicInteger;

import cc.ibooker.sqlite.dbupgrade.AbstractMigratorHelper;
import cc.ibooker.sqlite.dbupgrade.DBMigrationHelper;

/**
 * SQLiteOpenHelper作用：
 * 1.提高onCreate onUpgrade等创建数据库和更新数据库方法
 * 2.提供了获取数据库对象的函数
 *
 * @author 邹峰立
 */
class SQLiteHelper extends SQLiteOpenHelper {
    private AtomicInteger mOpenCounter = new AtomicInteger(0);
    private SQLiteDatabase mDatabase;

    private static SQLiteHelper SQLiteHelper;

    /**
     * 获取MySqliteHelper，单列模式
     *
     * @param context 上下文对象
     */
    static synchronized SQLiteHelper getSqliteHelper(Context context) {
        if (SQLiteHelper == null)
            SQLiteHelper = new SQLiteHelper(context);
        return SQLiteHelper;
    }

    /**
     * 打开数据库
     */
    synchronized SQLiteDatabase openDatabase() {
        if (mOpenCounter.incrementAndGet() == 1) {
            mDatabase = SQLiteHelper.getWritableDatabase();
        }
        return mDatabase;
    }

    /**
     * 关闭数据库
     */
    synchronized void closeDatabase() {
        if (mOpenCounter.decrementAndGet() == 0) {
            mDatabase.close();
        }
    }

    /**
     * 构造函数
     *
     * @param context 上下文对象
     * @param name    创建数据库的名称
     * @param factory 游标工厂
     * @param version 创建数据库版本 >= 1
     */
    private SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private SQLiteHelper(Context context) {
        // 创建数据库
        this(context, SQLiteConstant.DB_NAME, null, SQLiteConstant.DB_VERSION);
    }

    /**
     * 当数据库创建时回调的函数
     *
     * @param db 数据库对象
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建数据表
        db.execSQL(SQLiteConstant.SQL_CREATE_TABLE_USER);
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
        if (newVersion > oldVersion) {
            AbstractMigratorHelper migratorHelper = new DBMigrationHelper();
            migratorHelper.onUpgrade(db);
        }

//        /* i represent the version where the user is now and the class named with this number implies that is upgrading from i to i++ schema */
//        for (int i = oldVersion; i < newVersion; i++) {
//            try {
//                /* New instance of the class that migrates from i version to i++ version named DBMigratorHelper{version that the db has on this moment} */
//                AbstractMigratorHelper migratorHelper = (AbstractMigratorHelper) Class.forName("cc.ibooker.dbupgrade.DBMigrationHelper" + i).newInstance();
//                if (migratorHelper != null) {
//                    /* Upgrade de db */
//                    migratorHelper.onUpgrade(db);
//                }
//            } catch (ClassNotFoundException | ClassCastException | IllegalAccessException | InstantiationException e) {
//                /* If something fail prevent the DB to be updated to future version if the previous version has not been upgraded successfully */
//                break;
//            }
//        }
    }

}
