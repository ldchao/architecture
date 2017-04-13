package service.DBbackupAndrestore;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mm on 2017/4/12.
 */
public class DataRestore {
    private static String path="C:\\ProgramData\\MySQL\\MYSQLS~1.7\\Data\\";
    private static String username="root";
    private static String password="141250089";

    public static void main(String[] args){
        DataRestore dataRestore=new DataRestore();
//        dataRestore.backupByMysqldump("c:/Users/mm/first","test");
        dataRestore.restoreByMysql("c:/Users/mm/first","test");
    }

    private void sqlcommand(String cmd){
        try {
            Runtime rt = Runtime.getRuntime();
            // 调用 mysql 的 cmd:
            Process child = rt.exec(cmd);// 设置导出编码为utf8。这里必须是utf8

            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
            InputStreamReader xx = new InputStreamReader(in, "utf8");// 设置输出流编码为utf8。这里必须是utf8，否则从流中读入的是乱码
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // 组合控制台输出信息字符串
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }

            // 别忘记关闭输入输出流
            in.close();
            xx.close();
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void restoreByMysqlbinlogTime(Date starttime,String filename) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String start=simpleDateFormat.format(starttime);
        String cmd="cmd /c mysqlbinlog --no-defaults --start-datetime=\""+start+"\"   "+path+filename+" |mysql -u"+username+" -p"+password;
        sqlcommand(cmd);
    }

    public void restoreByMysqlbinlogTime(String filename,Date stoptime) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String stop=simpleDateFormat.format(stoptime);
        String cmd="cmd /c mysqlbinlog --no-defaults --stop-datetime=\""+stop+"\"   "+path+filename+" |mysql -u"+username+" -p"+password;
        sqlcommand(cmd);
    }

    public void restoreByMysqlbinlogTime(Date starttime,String filename,Date stoptime) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String start=simpleDateFormat.format(starttime);
        String stop=simpleDateFormat.format(stoptime);
        String cmd="cmd /c mysqlbinlog --no-defaults --start-datetime=\""+start+"\"   --stop-datetime=\""+stop+"\"   "+path+filename+" |mysql -u"+username+" -p"+password;
        sqlcommand(cmd);
    }

    public void restoreByMysqlbinlogPosition(int startpos,String filename){
        String cmd="cmd /c mysqlbinlog --no-defaults --start-pos="+startpos+"   "+path+filename+" |mysql -u"+username+" -p"+password;
        sqlcommand(cmd);
    }


    public void restoreByMysqlbinlogPosition(String filename,int stoppos){
        String cmd="cmd /c mysqlbinlog --no-defaults --stop-pos="+stoppos+"   "+path+filename+" |mysql -u"+username+" -p"+password;
        sqlcommand(cmd);
    }


    public void restoreByMysqlbinlogPosition(int startpos,String filename,int stoppos){
        String cmd="cmd /c mysqlbinlog --no-defaults --start-pos="+startpos+"   --stop-pos="+stoppos+"   "+path+filename+" |mysql -u"+username+" -p"+password;
        sqlcommand(cmd);
    }

    public void backupByMysqldump(String path,String database){
        String cmd="cmd /c mysqldump -u"+username+" -p"+password+" --default-character-set=binary "+database+">"+path+".sql";
        sqlcommand(cmd);
    }

    public void restoreByMysql(String path,String database){
        String cmd="cmd /c mysql -u"+username+" -p"+password+" --default-character-set=binary "+database+"<"+path+".sql";
        sqlcommand(cmd);

    }


    public static void setPath(String path) {
        DataRestore.path = path;
    }

    public static void setUsername(String username) {
        DataRestore.username = username;
    }

    public static void setPassword(String password) {
        DataRestore.password = password;
    }


}
