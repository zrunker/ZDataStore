package cc.ibooker.sqlite.bean;

/**
 * 朋友-实体类
 * Created by 邹峰立 on 2017/9/23 0023.
 */
public class Friend {
    private long fId;// ID
    private String fGname;// 组名
    private long fUid;// 用户ID

    public Friend() {
        super();
    }

    public Friend(long fId, String fGname, long fUid) {
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
}
