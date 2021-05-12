package com.eytins.sar_admin.framework.ssh;

import com.eytins.sar_admin.framework.constants.Enums;
import com.jcraft.jsch.*;

import java.io.InputStream;

/**
 * @Description 一个SSH连接类
 * @Author Eytins
 * @Create 2021/5/13 0:25
 */

public class Shell {

    public Shell(String user, String password, String host) {
        this.USER = user;
        this.PASSWORD = password;
        this.HOST = host;
    }

    private final String USER;
    private final String PASSWORD;
    private final String HOST;
    /**
     * exec的exitStatus：0为成功
     */
    private int exitStatus = -1;
    /**
     * exec输出的log
     */
    private final StringBuilder log = new StringBuilder();

    public StringBuilder getLog() {
        return log;
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

    /**
     * 连接host到控制台
     */
    public void connect() {
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(USER, HOST, Enums.DEFAULT_SSH_PORT.getCode());
            session.setPassword(PASSWORD);

            UserInfo userInfo = new MyUserInfo();
            session.setUserInfo(userInfo);

            // It must not be recommended, but if you want to skip host-key check, invoke following
            session.setConfig("StrictHostKeyChecking", "no");

            //session.connect();
            //making a connection with timeout.
            session.connect(30000);

            Channel channel = session.openChannel("shell");

            // Enable agent-forwarding.
            //((ChannelShell)channel).setAgentForwarding(true);
            channel.setInputStream(System.in);
            /*// a hack for MS-DOS prompt on Windows.
            channel.setInputStream(new FilterInputStream(System.in) {
                public int read(byte[] b, int off, int len) throws IOException {
                    return in.read(b, off, (len > 1024 ? 1024 : len));
                }
            });*/

            channel.setOutputStream(System.out);

            /*// Choose the pty-type "vt102".
            ((ChannelShell) channel).setPtyType("vt102");*/

            /*// Set environment variable "LANG" as "ja_JP.eucJP".
            ((ChannelShell) channel).setEnv("LANG", "ja_JP.eucJP");*/

            //channel.connect();
            channel.connect(3 * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 连接host并执行shell命令
     *
     * @param command shell命令
     * @return exitStatus（-1为出错了，0为执行完成）
     */
    public int exec(String command) {
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

    public static void main(String[] args) {

        Shell shell = new Shell("root", "292918726Lmz", "eytins.top");
        System.out.println(shell.exec("ls\ncd ..\nls"));
        System.out.println("\n**************\nlog:\n\n" + shell.getLog());

        shell.connect();
    }
}