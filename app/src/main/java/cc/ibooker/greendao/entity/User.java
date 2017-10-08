package cc.ibooker.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import cc.ibooker.greendao.DaoSession;
import cc.ibooker.greendao.FriendDao;
import cc.ibooker.greendao.UserDao;

/**
 * 用户表+实体类
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
        indexes = {@Index(value = "_id ASC"),@Index(value = "uId DESC")},
        // nameInDb表示数据表的名称默认为实体类的名称
        nameInDb = "t_user",
        // 表示是否生成get/set方法，默认为true
        generateGettersSetters = true
)
public class User  {
    @Id(autoincrement = true)
    @Property(nameInDb = "_id")
    private long _id;
    @NotNull
    @Unique
    @Property(nameInDb = "u_id")
    private long uId;
    @Property(nameInDb = "u_realname")
    private String uRealName;
    @Property(nameInDb = "u_sex")
    private String uSex;
    @Property(nameInDb = "u_birthday")
    private String uBirthday;
    @Property(nameInDb = "u_height")
    private float uHeight;
    @Property(nameInDb = "u_weight")
    private float uWeight;
    @Property(nameInDb = "u_domicile")
    private String uDomicile;
    @Property(nameInDb = "u_phone")
    private long uPhone;
    @Property(nameInDb = "u_email")
    private String uEmail;
    @Property(nameInDb = "u_weibo")
    private String uWeibo;

    // 一堆多
    @ToMany(referencedJoinProperty = "fUid")
    private List<Friend> friends;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    public User() {
        super();
    }

    public User(long uId, String uRealName, String uSex, String uBirthday, float uHeight, float uWeight, String uDomicile, long uPhone, String uEmail, String uWeibo) {
        this.uId = uId;
        this.uRealName = uRealName;
        this.uSex = uSex;
        this.uBirthday = uBirthday;
        this.uHeight = uHeight;
        this.uWeight = uWeight;
        this.uDomicile = uDomicile;
        this.uPhone = uPhone;
        this.uEmail = uEmail;
        this.uWeibo = uWeibo;
    }

    @Generated(hash = 1833956104)
    public User(long _id, long uId, String uRealName, String uSex, String uBirthday, float uHeight, float uWeight, String uDomicile, long uPhone, String uEmail,
            String uWeibo) {
        this._id = _id;
        this.uId = uId;
        this.uRealName = uRealName;
        this.uSex = uSex;
        this.uBirthday = uBirthday;
        this.uHeight = uHeight;
        this.uWeight = uWeight;
        this.uDomicile = uDomicile;
        this.uPhone = uPhone;
        this.uEmail = uEmail;
        this.uWeibo = uWeibo;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public String getuRealName() {
        return uRealName;
    }

    public void setuRealName(String uRealName) {
        this.uRealName = uRealName;
    }

    public String getuSex() {
        return uSex;
    }

    public void setuSex(String uSex) {
        this.uSex = uSex;
    }

    public String getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(String uBirthday) {
        this.uBirthday = uBirthday;
    }

    public float getuHeight() {
        return uHeight;
    }

    public void setuHeight(float uHeight) {
        this.uHeight = uHeight;
    }

    public float getuWeight() {
        return uWeight;
    }

    public void setuWeight(float uWeight) {
        this.uWeight = uWeight;
    }

    public String getuDomicile() {
        return uDomicile;
    }

    public void setuDomicile(String uDomicile) {
        this.uDomicile = uDomicile;
    }

    public long getuPhone() {
        return uPhone;
    }

    public void setuPhone(long uPhone) {
        this.uPhone = uPhone;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuWeibo() {
        return uWeibo;
    }

    public void setuWeibo(String uWeibo) {
        this.uWeibo = uWeibo;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", uRealName='" + uRealName + '\'' +
                ", uSex='" + uSex + '\'' +
                ", uBirthday='" + uBirthday + '\'' +
                ", uHeight=" + uHeight +
                ", uWeight=" + uWeight +
                ", uDomicile='" + uDomicile + '\'' +
                ", uPhone=" + uPhone +
                ", uEmail='" + uEmail + '\'' +
                ", uWeibo='" + uWeibo + '\'' +
                '}';
    }

    public long get_id() {
        return this._id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public long getUId() {
        return this.uId;
    }

    public void setUId(long uId) {
        this.uId = uId;
    }

    public String getURealName() {
        return this.uRealName;
    }

    public void setURealName(String uRealName) {
        this.uRealName = uRealName;
    }

    public String getUSex() {
        return this.uSex;
    }

    public void setUSex(String uSex) {
        this.uSex = uSex;
    }

    public String getUBirthday() {
        return this.uBirthday;
    }

    public void setUBirthday(String uBirthday) {
        this.uBirthday = uBirthday;
    }

    public float getUHeight() {
        return this.uHeight;
    }

    public void setUHeight(float uHeight) {
        this.uHeight = uHeight;
    }

    public float getUWeight() {
        return this.uWeight;
    }

    public void setUWeight(float uWeight) {
        this.uWeight = uWeight;
    }

    public String getUDomicile() {
        return this.uDomicile;
    }

    public void setUDomicile(String uDomicile) {
        this.uDomicile = uDomicile;
    }

    public long getUPhone() {
        return this.uPhone;
    }

    public void setUPhone(long uPhone) {
        this.uPhone = uPhone;
    }

    public String getUEmail() {
        return this.uEmail;
    }

    public void setUEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getUWeibo() {
        return this.uWeibo;
    }

    public void setUWeibo(String uWeibo) {
        this.uWeibo = uWeibo;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 329954286)
    public List<Friend> getFriends() {
        if (friends == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FriendDao targetDao = daoSession.getFriendDao();
            List<Friend> friendsNew = targetDao._queryUser_Friends(_id);
            synchronized (this) {
                if (friends == null) {
                    friends = friendsNew;
                }
            }
        }
        return friends;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1638260638)
    public synchronized void resetFriends() {
        friends = null;
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
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }
}
