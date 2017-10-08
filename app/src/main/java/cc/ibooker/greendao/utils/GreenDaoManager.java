package cc.ibooker.greendao.utils;

import org.greenrobot.greendao.query.QueryBuilder;

import cc.ibooker.greendao.DaoSession;
import cc.ibooker.greendao.DaoMaster;
import cc.ibooker.myapplition.MyApplication;

/**
 * GreenDao管理类
 */
public class GreenDaoManager {
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static volatile GreenDaoManager mInstance = null;

    // 构造方法
    private GreenDaoManager() {
        if (mInstance == null) {
            // 重写DBHelper数据库升级，数据不丢失
            // MyApplication.getContext()上下文表示了数据库存储路径为手机内存
            DBHelper helper = new DBHelper(MyApplication.getInstance(), DBHelper.DBNAME, null);
            mDaoMaster = new DaoMaster(helper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
        }
    }

    // 单例模式
    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if (mInstance == null) {
                    mInstance = new GreenDaoManager();
                }
            }
        }
        return mInstance;
    }

    public DaoMaster getMaster() {
        return mDaoMaster;
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    // 获取新的DaoSession
    public DaoSession getNewSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;
    }

    // 打印查询日志
    public static void enableQueryBuilderLog(){
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }
}