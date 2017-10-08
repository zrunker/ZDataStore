package cc.ibooker.sqlite.dbhelper;

import java.util.List;

import cc.ibooker.sqlite.bean.User;

/**
 * 数据库访问接口
 * Created by 邹封立 on 2017/2/16 0016.
 */
public interface SQLiteDao {

    /**
     * 获取用户集合
     */
    List<User> selectUser();

    /**
     * 根据用户ID获取用户信息
     *
     * @param uId 用户ID
     */
    User selectUserByuId(long uId);

    /**
     * 根据用户ID修改用户信息
     */
    void updateUserByuId(User user);

    /**
     * 插入用户信息
     */
    void insertUser(User user);

    /**
     * 根据用户ID删除用户ID
     *
     * @param uId 用户ID
     */
    void deleteUserByUid(long uId);
}
