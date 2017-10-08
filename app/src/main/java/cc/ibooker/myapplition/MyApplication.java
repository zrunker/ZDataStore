package cc.ibooker.myapplition;

import android.app.Application;

import cc.ibooker.greendao.utils.GreenDaoManager;

/**
 * 自定义MyApplication
 * Created by 邹峰立 on 2017/9/23 0023.
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        // 全局上下文赋值
        instance = this;
        // 初始化数据库
        GreenDaoManager.getInstance();
    }

    // 获取全局上下文对象
    public static MyApplication getInstance() {
        return instance;
    }
}
