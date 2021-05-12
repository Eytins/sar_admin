package com.eytins.sar_admin.framework.ssh;

import com.eytins.sar_admin.framework.constants.Enums;
import com.jcraft.jsch.*;

import java.io.InputStream;

/**
 * @Description 用于连接host并执行shell语句的类，log为host执行shell后输出的语句
 * @Author Eytins
 * @Create 2021/5/13 0:45
 */

public class Exec {

    public Exec(String user, String password, String host) {
        this.USER = user;
        this.PASSWORD = password;
        this.HOST = host;
    }

    private final String USER;
    private final String PASSWORD;
    private final String HOST;
    private int exitStatus = -1;
    private final StringBuilder log = new StringBuilder();

    public StringBuilder getLog() {
        return log;
    }

    /**
     * 连接host并执行shell命令
     *
     * @param command shell命令
     * @return exitStatus（-1为出错了，0为执行完成）
     */
    public int connect(String command) {
        try {
            JSch jsch = new JSch();

            Session session = jsch.getSession(USER, HOST, Enums.DEFAULT_SSH_PORT.getCode());
            session.setPassword(PASSWORD);

            // username and password will be given via UserInfo interface.
            session.setUserInfo(new MyUserInfo());
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            // X Forwarding
            // channel.setXForwarding(true);

            //channel.setInputStream(System.in);
            channel.setInputStream(null);

            //channel.setOutputStream(System.out);

            //FileOutputStream fos=new FileOutputStream("E:/Users/eytin/Desktop");
            //((ChannelExec)channel).setErrStream(fos);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream in = channel.getInputStream();
            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    log.append(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    if (in.available() > 0) {
                        continue;
                    }
                    log.append("exit-status: ").append(channel.getExitStatus());
                    exitStatus = channel.getExitStatus();
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ignored) {
                }
            }
            channel.disconnect();
            session.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
        return exitStatus;
    }

    private static class MyUserInfo implements UserInfo {
        @Override
        public String getPassphrase() {
            System.out.println("getPassphrase");
            return null;
        }

        @Override
        public String getPassword() {
            System.out.println("getPassword");
            return null;
        }

        @Override
        public boolean promptPassword(String s) {
            System.out.println("promptPassword:" + s);
            return false;
        }

        @Override
        public boolean promptPassphrase(String s) {
            System.out.println("promptPassphrase:" + s);
            return false;
        }

        @Override
        public boolean promptYesNo(String s) {
            System.out.println("promptYesNo:" + s);
            return true;//notice here!
        }

        @Override
        public void showMessage(String s) {
            System.out.println("showMessage:" + s);
        }
    }

    public static void main(String[] args) {
        Exec exec = new Exec("root", "292918726Lmz", "eytins.top");
        System.out.println(exec.connect("ls\ncd ..\nls"));
        System.out.println("\n**************\nlog:\n\n" + exec.getLog());
    }
}