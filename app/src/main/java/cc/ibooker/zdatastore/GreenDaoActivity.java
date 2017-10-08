package cc.ibooker.zdatastore;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import cc.ibooker.greendao.entity.User;
import cc.ibooker.greendao.utils.UserDbUtil;

/**
 * greenDao3.0实现orm
 * Created by 邹峰立 on 2017/9/23 0023.
 */
public class GreenDaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserDbUtil userDbUtil = UserDbUtil.getInstance();
        List<User> user = userDbUtil.queryAll();
    }

}
