package com.sharpandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String str = "45454121212312121284764864564564564654564";
        //密钥，长度要是8的倍数
        String password = "9588028820109132570743325311898426347857298773549468758875018579537757772163084478873699447306034466200616411960574122434059469100235892702736860872901247123456";

        byte[] result = DES.encrypt(str.getBytes(),password);
        String strBase64 = new String(Base64.encode(result, Base64.DEFAULT));
        System.out.println("加密后："+strBase64);

        //直接将如上内容解密
        try {
            byte[] decryResult = DES.decrypt(result, password);
            System.out.println("解密后："+new String(decryResult));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
