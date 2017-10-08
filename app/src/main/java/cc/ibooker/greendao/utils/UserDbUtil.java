package cc.ibooker.greendao.utils;

import android.util.Log;

import org.greenrobot.greendao.query.LazyList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cc.ibooker.greendao.entity.User;
import cc.ibooker.greendao.UserDao;

/**
 * 对数据库t_user进行管理
 * Created by 邹峰立 on 2017/9/23 0023.
 */
public class UserDbUtil {
    private static volatile UserDbUtil mInstance = null;
    private UserDao userDao;

    // 构造方法
    private UserDbUtil() {
        if (mInstance == null) {
            userDao = GreenDaoManager.getInstance().getSession().getUserDao();
        }
    }

    // 单例
    public static UserDbUtil getInstance() {
        if (mInstance == null) {
            synchronized (UserDbUtil.class) {
                if (mInstance == null) {
                    mInstance = new UserDbUtil();
                }
            }
        }
        return mInstance;
    }

    // 查询全部用户信息
    private List<User> queryAll() {
        List<User> users = userDao.queryBuilder().list();
        for (User user : users)
            Log.d("queryAll", user.toString());
        return users;
    }

    // 懒加载-一般用户级联查询-返回所需要的数据-使用完之后需要自行关闭游标
    public List<User> queryLazyList() {
        LazyList<User> users = userDao.queryBuilder().listLazy();
        for (User user : users)
            Log.d("queryLazyList", user.toString());
        users.close();
        return users;
    }

    // 可以筛选想要的数据集
    public List<User> queryIteratorList() {
        List<User> users = new ArrayList<>();
        Iterator iterator = userDao.queryBuilder().listIterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            Log.d("queryIteratorList", user.toString());
            users.add(user);
        }
        return users;
    }

    // uid相等查询eq
    public User queryEqUid(long uId) {
        return userDao.queryBuilder().where(UserDao.Properties.UId.eq(uId)).unique();
    }

    // uid相等查询noteq
    public List<User> queryNotEqUid(long uId) {
        return userDao.queryBuilder().where(UserDao.Properties.UId.notEq(uId)).list();
    }

    // uRealName模糊查询
    public List<User> queryLikeRealName(String uRealName) {
        return userDao.queryBuilder().where(UserDao.Properties.URealName.like(uRealName + "%")).list();
    }

    // uHeight范围查询
    public List<User> queryBetweenHeight(float minHeight, float maxHeight) {
        return userDao.queryBuilder().where(UserDao.Properties.UHeight.between(minHeight, maxHeight)).list();
    }

    // uWeight大于某值集合
    public List<User> queryGtWeight(float uWeight) {
        return userDao.queryBuilder().where(UserDao.Properties.UWeight.gt(uWeight)).list();
    }

    // uWeight大于等于某值集合
    public List<User> queryGeWeight(float uWeight) {
        return userDao.queryBuilder().where(UserDao.Properties.UWeight.ge(uWeight)).list();
    }

    // uBirthday小于某值集合
    public List<User> queryLtBirthday(String uBirthday) {
        return userDao.queryBuilder().where(UserDao.Properties.UBirthday.lt(uBirthday)).list();
    }

    // uBirthday小于等于某值集合
    public List<User> queryLeBirthday(String uBirthday) {
        return userDao.queryBuilder().where(UserDao.Properties.UBirthday.le(uBirthday)).list();
    }

    // 排序查询-倒序
    public List<User> queryListOrderDesc() {
        return userDao.queryBuilder().orderDesc(UserDao.Properties.UBirthday).list();
    }

    // 根据id查找数据
    public User loadUser(long _id) {
        return userDao.load(_id);
    }

    // 根据行号查找数据
    public User loadByRowId(long rowId) {
        return userDao.loadByRowId(rowId);
    }

    // 查找全部数据
    public List<User> loadAll() {
        return userDao.loadAll();
    }

    // 插入数据-当指定主键在表中存在时会发生异常
    public boolean insertUser(User user) {
        long uId = userDao.insert(user);
        return uId > 0;
    }

    // 插入数据-当指定主键在表中存在时会覆盖数据
    public boolean insertOrReplaceUser(User user) {
        long uId = userDao.insertOrReplace(user);
        return uId > 0;
    }

    // 批量插入数据
    public void insertInTxUsers(List<User> users) {
        userDao.insertInTx(users);
    }

    // 删除数据
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    // 指定主键删除数据
    public void deleteByKeyUser(long _id) {
        userDao.deleteByKey(_id);
    }

    // 批量删除数据
    public void deleteInTxUser(List<User> users) {
        userDao.deleteInTx(users);
    }

    // 批量按数据删除数据
    public void deleteByKeyInTxUser(List<Long> _ids) {
        userDao.deleteByKeyInTx(_ids);
    }

    // 删除所有数据
    public void deleteAll() {
        userDao.deleteAll();
    }

    // 修改User-主键需相同
    public void updateUser(User user) {
        userDao.update(user);
    }

    // 批量更新数据
    public void updateInTxUser(List<User> users) {
        userDao.updateInTx(users);
    }
}
