package cc.ibooker.greendaogenerator;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

/**
 * GreenDao-Generator工具类
 * create by 邹峰立
 */
public class GdGeneratorClass {
    public static void main(String args[]) {
        // 创建一个模式Shcema
        Schema schema = new Schema(1, "cc.ibooker.zdatastore");
        // 添加Entity-相当于表
        Entity user = schema.addEntity("User");
        user.addIdProperty();// 添加ID
        user.addLongProperty("u_id");
        user.addStringProperty("u_realname");
        user.addStringProperty("u_sex");
        user.addStringProperty("u_birthday");
        user.addFloatProperty("u_height");
        user.addFloatProperty("u_weight");
        user.addStringProperty("u_domicile");
        user.addLongProperty("u_phone");
        user.addStringProperty("u_email");
        user.addStringProperty("u_weibo");

        Entity friend = schema.addEntity("Firend");
        friend.addIdProperty();// 添加ID
        friend.addStringProperty("f_gname");
        // 添加外键
        Property fUid = friend.addLongProperty("f_uid").getProperty();
        friend.addToOne(user, fUid);// 一对一
        // friend.addToMany(user, fUid);// 多对一

        // 生成相关文件
        try {
            new DaoGenerator().generateAll(schema, "app/src/main/java/cc/ibooker/orm/greendao");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
