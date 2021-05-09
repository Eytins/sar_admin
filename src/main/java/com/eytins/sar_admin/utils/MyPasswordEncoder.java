package com.eytins.sar_admin.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;

/**
 * @Description 为PasswordEncoder准备的实现类，最终没有使用，但可以借助这个类了解一下运行逻辑
 * @Author Eytins
 * @Create 2021/5/9 22:39
 */

public class MyPasswordEncoder implements PasswordEncoder {

    /**
     * 密码加密逻辑
     *
     * @param charSequence 明文字符串
     * @return 加密后的字符串
     */
    @Override
    public String encode(CharSequence charSequence) {
        return md5Encode(charSequence.toString());
    }

    /**
     * 密码匹配逻辑
     *
     * @param charSequence 明文，页面收集的密码
     * @param s            密文，存储在库中的密码
     * @return 是否匹配成功
     */
    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(md5Encode(charSequence.toString()));
    }

    public String md5Encode(String source) {
        char[] HEX =
                {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] sourceBytes = source.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(sourceBytes);
            byte[] md = mdInst.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (byte b : md) {
                str[k++] = HEX[b >>> 4 & 0xf];
                str[k++] = HEX[b & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
