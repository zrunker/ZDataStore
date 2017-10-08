package cc.ibooker.sqlite.bean;

/**
 * 用户-实体类
 * Created by 邹峰立 on 2017/9/23 0023.
 */
public class User {
    private long uId;
    private String uRealName;
    private String uSex;
    private String uBirthday;
    private float uHeight;
    private float uWeight;
    private String uDomicile;
    private long uPhone;
    private String uEmail;
    private String uWeibo;

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
}
