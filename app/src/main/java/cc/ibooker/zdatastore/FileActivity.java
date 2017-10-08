package cc.ibooker.zdatastore;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/**
 * 文件存储
 * Created by 邹峰立 on 2017/9/19 0019.
 */
public class FileActivity extends AppCompatActivity implements View.OnClickListener {
    private final int PERMISSION_OPER_EXTERNAL_STORAGE = 55;
    private String[] permissions = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private int sdOperType = 0;
    private EditText editText;
    private TextView textView;
    private final String mKey = "mKey";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        initView();
    }

    // 初始化控件
    private void initView() {
        editText = findViewById(R.id.edittext);
        textView = findViewById(R.id.text);
        Button saveMemoryBtn = findViewById(R.id.btn_memory);
        saveMemoryBtn.setOnClickListener(this);
        Button sdBtn = findViewById(R.id.btn_sd);
        sdBtn.setOnClickListener(this);
        Button readMemoryBtn = findViewById(R.id.btn_read_memory);
        readMemoryBtn.setOnClickListener(this);
        Button readSdBtn = findViewById(R.id.btn_read_sd);
        readSdBtn.setOnClickListener(this);
    }

    // 按钮点击事件监听
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_memory:// 保存到内存
                String text = editText.getText().toString().trim();
                if (!TextUtils.isEmpty(text)) {
                    boolean bool = writeMemoryData(text);
                    if (bool) {
                        Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
                        editText.setText("");
                    } else
                        Toast.makeText(this, "写入失败", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_sd:// 保存到SD卡
                applyPermission();
                sdOperType = 1;
                break;
            case R.id.btn_read_memory:// 读取内存
                String str = readMemoryData(mKey).toString();
                textView.setText(str);
                break;
            case R.id.btn_read_sd:// 读取SD卡
                applyPermission();
                sdOperType = 2;
                break;
        }
    }

    /**
     * 保存数据到内存
     *
     * @param obj 待保存数据
     * @return true/false(成功/失败)
     */
    private boolean writeMemoryData(Object obj) {
        boolean bool = false;
        FileOutputStream fos = null;
        try {
            // 构建Properties
            Properties properties = new Properties();
            // Properties添加数据
            properties.put(mKey, obj);
            fos = this.openFileOutput("testmemory.json", Context.MODE_PRIVATE);
            // 将数据写入文件（流）
            properties.store(fos, "测试文件");
            bool = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null)
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return bool;
    }

    /**
     * 读取内存数据
     *
     * @param key 数据对应键值
     * @return 待读取的数据
     */
    private Object readMemoryData(String key) {
        Object obj = null;
        FileInputStream fis = null;
        try {
            // 构建Properties
            Properties properties = new Properties();
            fis = this.openFileInput("testmemory.json");
            // 加载文件
            properties.load(fis);
            obj = properties.get(key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return obj;
    }

    /**
     * 写入SD卡文件
     *
     * @param obj 待写入对象
     */
    private boolean writeSdData(Object obj) {
        boolean bool = false;
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {// 判断外部存储是否可读可写
            RandomAccessFile raf = null;
            try {
                // 获取SD卡路径
                File sdDir = Environment.getExternalStorageDirectory();
                // 获取SD卡目录 /mnt/sdcard。
                String sdPath = sdDir.getAbsolutePath();
                // 创建文件
                File file = new File(sdPath, "testsd.json");
                if (!file.exists()) {
                    boolean bool1 = file.createNewFile();
                    if (!bool1)
                        return false;
                }


//            FileOutputStream fos = null;
//            try {
//                fos = new FileOutputStream(file);
//                fos.write(obj.toString().getBytes());
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (fos != null)
//                        fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }


                // 指定文件创建RandomAccessFile对象
                raf = new RandomAccessFile(file, "rw");
                // 将文件记录指针移动最后
                raf.seek(file.length());
                // 写入内容
                raf.write(obj.toString().getBytes());
                bool = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (raf != null)
                        raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bool;
    }

    /**
     * 读取SD卡文件内容
     */
    private String readSdData() {
        StringBuilder sb = new StringBuilder();
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {// 判断外部存储是否可读可写
            // 获取SD卡路径
            File sdDir = Environment.getExternalStorageDirectory();
            // 获取SD卡目录 /mnt/sdcard。
            String sdPath = sdDir.getAbsolutePath();
            // 创建文件
            File file = new File(sdPath, "testsd.json");

            InputStream is = null;
            try {
                is = new FileInputStream(file);
                int len;
                byte[] buffer = new byte[1024];
                while ((len = is.read(buffer)) != -1) {
                    sb.append(new String(buffer, 0, len));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null)
                        is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    // 判断是否可以操作SD
    private boolean isOperSd() {
        return hasPermission(permissions);
    }

    // Android6.0 动态申请文件读写权限
    private void applyPermission() {
        if (!hasPermission(permissions)) {
            requestPermission(PERMISSION_OPER_EXTERNAL_STORAGE, permissions);
        }
    }

    // 权限请求回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_OPER_EXTERNAL_STORAGE:// SD卡读写权限成功
                switch (sdOperType) {
                    case 1:// 保存数据到SD卡
                        if (isOperSd()) {
                            String text1 = editText.getText().toString().trim();
                            if (!TextUtils.isEmpty(text1)) {
                                boolean bool = writeSdData(text1);
                                if (bool) {
                                    Toast.makeText(this, "写入成功", Toast.LENGTH_SHORT).show();
                                    editText.setText("");
                                } else
                                    Toast.makeText(this, "写入失败", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(this, "你没有操作SD卡权限", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case 2:// 读取SD卡数据
                        if (isOperSd()) {
                            String str1 = readSdData();
                            textView.setText(str1);
                        } else {
                            Toast.makeText(this, "你没有操作SD卡权限", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                break;
        }
    }

    /**
     * 权限检查方法
     */
    public boolean hasPermission(String... permissions) {
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    /**
     * 权限请求方法
     */
    public void requestPermission(int code, String... permissions) {
        ActivityCompat.requestPermissions(this, permissions, code);
    }

}


