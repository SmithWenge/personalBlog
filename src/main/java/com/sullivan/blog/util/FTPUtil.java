package com.sullivan.blog.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sullivan on 2017/7/8.
 */
public class FTPUtil {

    /**
     * 上传文件（可供Action/Controller层使用）
     * @param hostname FTP服务器地址
     * @param port FTP服务器端口号
     * @param username FTP登录帐号
     * @param password FTP登录密码
     * @param pathname FTP服务器保存目录
     * @param fileName 上传到FTP服务器后的文件名称
     * @param inputStream 输入文件流
     * @return
     */
    public static boolean uploadFile(String hostname, int port, String username, String password, String pathname, String fileName, InputStream inputStream){
        boolean flag = false;
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        try {
            //连接FTP服务器
            ftpClient.connect(hostname, port);
            //登录FTP服务器
            ftpClient.login(username, password);
            //是否成功登录FTP服务器
            int replyCode = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyCode)){
                return flag;
            }

            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.makeDirectory(pathname);
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
            ftpClient.logout();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(ftpClient.isConnected()){
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }


    /**
     * 上传文件（可对文件进行重命名）
     * @param hostname FTP服务器地址
     * @param port FTP服务器端口号
     * @param username FTP登录帐号
     * @param password FTP登录密码
     * @param pathname FTP服务器保存目录
     * @param filename 上传到FTP服务器后的文件名称
     * @param originfilename 待上传文件的名称（绝对地址）
     * @return
     */
    public static boolean uploadFileFromProduction(String hostname, int port, String username, String password, String pathname, String filename, String originfilename){
        boolean flag = false;
        try {
            InputStream inputStream = new FileInputStream(new File(originfilename));
            flag = uploadFile(hostname, port, username, password, pathname, filename, inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 上传文件（不可以进行文件的重命名操作）
     * @param hostname FTP服务器地址
     * @param port FTP服务器端口号
     * @param username FTP登录帐号
     * @param password FTP登录密码
     * @param pathname FTP服务器保存目录
     * @param originfilename 待上传文件的名称（绝对地址）
     * @return
     */
    public static boolean uploadFileFromProduction(String hostname, int port, String username, String password, String pathname, String originfilename){
        boolean flag = false;
        try {
            String fileName = new File(originfilename).getName();
            InputStream inputStream = new FileInputStream(new File(originfilename));
            flag = uploadFile(hostname, port, username, password, pathname, fileName, inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 删除文件
     * @param hostname FTP服务器地址
     * @param port FTP服务器端口号
     * @param username FTP登录帐号
     * @param password FTP登录密码
     * @param pathname FTP服务器保存目录
     * @param filename 要删除的文件名称
     * @return
     */
    public static boolean deleteFile(String hostname, int port, String username, String password, String pathname, String filename){
        boolean flag = false;
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        try {
            //连接FTP服务器
            ftpClient.connect(hostname, port);
            //登录FTP服务器
            ftpClient.login(username, password);
            //验证FTP服务器是否登录成功
            int replyCode = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyCode)){
                return flag;
            }
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            ftpClient.dele(filename);
            ftpClient.logout();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(ftpClient.isConnected()){
                try {
                    ftpClient.logout();
                } catch (IOException e) {

                }
            }
        }
        return flag;
    }

    /**
     * 下载文件
     * @param hostname FTP服务器地址
     * @param port FTP服务器端口号
     * @param username FTP登录帐号
     * @param password FTP登录密码
     * @param pathname FTP服务器文件目录
     * @param filename 文件名称
     * @param localpath 本地路径
     * @return
     */
    public static boolean downloadFile(String hostname, int port, String username, String password, String pathname, String filename, String localpath){
        boolean flag = false;
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        try {
            //连接FTP服务器
            ftpClient.connect(hostname, port);
            //登录FTP服务器
            ftpClient.login(username, password);
            //验证FTP服务器是否登录成功
            int replyCode = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyCode)){
                return flag;
            }
            //切换FTP目录
            ftpClient.changeWorkingDirectory(pathname);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            for(FTPFile file : ftpFiles){
                if(filename.equalsIgnoreCase(file.getName())){
                    File localFile = new File(file.getName());
                    OutputStream os = new FileOutputStream(localpath + "/" + localFile);
                    ftpClient.retrieveFile(file.getName(), os);
                    os.close();
                }
            }
            ftpClient.logout();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(ftpClient.isConnected()){
                try {
                    ftpClient.logout();
                } catch (IOException e) {

                }
            }
        }
        return flag;
    }

    /**
     * 获取指定目录下的文件名
     * @param hostname FTP服务器地址
     * @param port FTP服务器端口号
     * @param username FTP登录帐号
     * @param password FTP登录密码
     * @param pathname FTP服务器文件目录
     * @return
     */
    public static List<String> getFileNames(String hostname, int port, String username, String password, String pathname) {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        List<String> list = new ArrayList<>();
        try {
            //连接FTP服务器
            ftpClient.connect(hostname, port);
            //登录FTP服务器
            ftpClient.login(username, password);
            //验证FTP服务器是否登录成功
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.err.println("FTP server refused connection.");
                return null;
            }
            //切换FTP目录
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(pathname);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            System.out.println(ftpFiles);

            for (FTPFile ftpFile : ftpFiles) {
                list.add(ftpFile.getName());
            }

            ftpClient.logout();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }
}