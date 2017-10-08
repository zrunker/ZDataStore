package cc.ibooker.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import cc.ibooker.greendao.DaoSession;
import cc.ibooker.greendao.UserDao;
import cc.ibooker.greendao.FriendDao;

/**
 * 朋友表+实体类
 * Created by 邹峰立 on 2017/9/23 0023.
 */
@Entity(
        // active表示update/delete/refresh 方法是否自动生成,默认为false
        active = true,
        // createInDb表示是否在数据库中创建该表，默认为true
        createInDb = true,
        // generateConstructors表示是否生成构造方法(一般有两个，一个有参数，一个无参数),默认为true
        generateConstructors = true,
        // indexes表示数据表查询返回数据默认排序,name中的字段是该实体在数据表中的列名，value表示改实体的真实名称,unique表示是否唯一(默认为false)
        indexes = {@Index(value = "_id ASC"),@Index(value = "fId DESC")},
        // nameInDb表示数据表的名称默认为实体类的名称
        nameInDb = "t_friend",
        // 表示是否生成get/set方法，默认为true
        generateGettersSetters = true
)
public class Friend {
    @Id(autoincrement = true)
    @Property(nameInDb = "_id")
    private long _id;
    @NotNull
    @Unique
    @Property(nameInDb = "f_id")
    private long fId;// ID
    @NotNull
    @Property(nameInDb = "f_gname")
    private String fGname;// 组名
    @NotNull
    @Property(nameInDb = "f_uid")
    private long fUid;// 用户ID

    @ToOne(joinProperty = "fUid")
    private User user;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 76285035)
    private transient FriendDao myDao;
    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;

    public Friend() {
        super();
    }

    public Friend(long fId, String fGname, long fUid) {
        this.fId = fId;
        this.fGname = fGname;
        this.fUid = fUid;
    }

    @Generated(hash = 1517071117)
    public Friend(long _id, long fId, @NotNull String fGname, long fUid) {
        this._id = _id;
        this.fId = fId;
        this.fGname = fGname;
        this.fUid = fUid;
    }

    public long getfId() {
        return fId;
    }

    public void setfId(long fId) {
        this.fId = fId;
    }

    public String getfGname() {
        return fGname;
    }

    public void setfGname(String fGname) {
        this.fGname = fGname;
    }

    public long getfUid() {
        return fUid;
    }

    public void setfUid(long fUid) {
        this.fUid = fUid;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "fId=" + fId +
                ", fGname='" + fGname + '\'' +
                ", fUid=" + fUid +
                '}';
    }

    public long get_id() {
        return this._id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public long getFId() {
        return this.fId;
    }

    public void setFId(long fId) {
        this.fId = fId;
    }

    public String getFGname() {
        return this.fGname;
    }

    public void setFGname(String fGname) {
        this.fGname = fGname;
    }

    public long getFUid() {
        return this.fUid;
    }

    public void setFUid(long fUid) {
        this.fUid = fUid;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 736394026)
    public User getUser() {
        long __key = this.fUid;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 113038422)
    public void setUser(@NotNull User user) {
        if (user == null) {
            throw new DaoException(
                    "To-one property 'fUid' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.user = user;
            fUid = user.get_id();
            user__resolvedKey = fUid;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1516049992)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFriendDao() : null;
    }
}
