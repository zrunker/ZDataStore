package cc.ibooker.greendao.utils;

import android.util.Log;

import org.greenrobot.greendao.query.LazyList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cc.ibooker.greendao.entity.Friend;
import cc.ibooker.greendao.FriendDao;

/**
 * 朋友表t_friend进行管理
 * Created by 邹峰立 on 2017/9/23 0023.
 */
public class FriendDbUtil {
    private static volatile FriendDbUtil mInstance = null;
    private FriendDao friendDao;

    // 构造方法
    private FriendDbUtil() {
        if (mInstance == null) {
            friendDao = GreenDaoManager.getInstance().getSession().getFriendDao();
        }
    }

    // 单例
    public static FriendDbUtil getInstance() {
        if (mInstance == null) {
            synchronized (UserDbUtil.class) {
                if (mInstance == null) {
                    mInstance = new FriendDbUtil();
                }
            }
        }
        return mInstance;
    }

    // 查询全部朋友信息
    private List<Friend> queryAll() {
        List<Friend> friends = friendDao.queryBuilder().list();
        for (Friend friend : friends)
            Log.d("queryAll", friend.toString());
        return friends;
    }

    // 懒加载-一般用于级联查询-返回所需要的数据-使用完之后需要自行关闭游标
    public List<Friend> queryLazyList() {
        LazyList<Friend> friends = friendDao.queryBuilder().listLazy();
        for (Friend friend : friends)
            Log.d("queryLazyList", friend.toString());
        friends.close();
        return friends;
    }

    // 可以筛选想要的数据集
    public List<Friend> queryIteratorList() {
        List<Friend> friends = new ArrayList<>();
        Iterator iterator = friendDao.queryBuilder().listIterator();
        while (iterator.hasNext()) {
            Friend friend = (Friend) iterator.next();
            Log.d("queryIteratorList", friend.toString());
            friends.add(friend);
        }
        return friends;
    }

    // 插入数据
    public boolean insertFriend(Friend friend) {
        long fId = friendDao.insert(friend);
        return fId > 0;
    }

    // 修改Friend
    public void updateFriend(Friend friend) {
        friendDao.update(friend);
    }
}
