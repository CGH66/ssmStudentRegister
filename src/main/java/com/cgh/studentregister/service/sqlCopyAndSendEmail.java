package com.cgh.studentregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class sqlCopyAndSendEmail {
    @Autowired
    private JavaMailSender mailSender;
    /**
     * 发送纯文本邮件
     * @param to       收件人地址
     * @param subject  邮件标题
     * @param text     邮件内容
     */
    public void sendSimpleEmail(String from,String to,String subject,String text){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setUsername("*****");//寄件人
        javaMailSender.setPassword("******");//授权码
        javaMailSender.setHost("smtp.qq.com");
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);

    }


    public void dataBaseDump(String host, String port, String username, String password, String dbName, String currentDate) throws Exception {
        //定义备份路径文件夹
        String path="D:\\sql\\数据库备份";
        File f=new File(path);
        //如果该文件夹不存在，就自己创建
        if(!f.exists())
        {
            f.mkdirs();
        }
        //创建当前备份数据库的.sql文件，名称后面加上当前时间
        File datafile = new File(path,dbName+currentDate+".sql");

        //如果.sql文件已经存在，则结束程序并输出提示信息
        if (datafile.exists()) {
            System.out.println(dbName+"_"+currentDate+ "文件名已存在，请更换");
            return;
        }
      datafile.createNewFile();
        //拼接备份的cmd命令
        String cmd="cmd /c mysqldump -h" + host + " -P" + port + " -u " + username + " -p" + password + " " + dbName + " > " + datafile;
        System.out.println(cmd);
        Process exec = Runtime.getRuntime().exec(cmd);
        //备份成功，发送验证码模板文件
       sendSimpleEmail("寄件人","收件人",currentDate+"数据备份",dbName+"备份数据库成功!");
        //输出备份成功提醒
        System.out.println("数据库备份成功");
    }
    @Scheduled(cron = "0 0 0 ? * 7")
    public void dump()throws Exception{
        System.out.println("aaaa");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd_hh-mm-ss");
        String currentData=simpleDateFormat.format(new Date());
        System.out.println(currentData);
        dataBaseDump("localhost","3306","root","123456","student",currentData);
    }
}
