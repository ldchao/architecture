package service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Administrator on 2017/4/12.
 */
public class test {

    public static void main(String[] args) {
        Date date=new Date(System.currentTimeMillis());
        System.out.println(date.toString());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义格式，不显示毫秒
        Timestamp now = new Timestamp(System.currentTimeMillis());//获取系统当前时间
        String str = df.format(now);
        System.out.println(str);
        System.out.println(now.toString());

        String time = df.format(date);
        Timestamp ts = Timestamp.valueOf(time);
    }

    public int getSum(int  num[]){
        int sum=0;
        for (int i = 0; i < num.length; i++) {
            sum+=num[i]/3;
        }
        return sum;
    }
    //  4 4 4  实际 3 期望 3
    //  4 11 5 实际 5 期望 5
    //  3 5 6  实际 4 期望 2

    public int getSum(int a,int b){
        return a/3+b/4;   //a%3+b%4
    }
    //t1  3 4
    //t2  4 5
    //t3  5 9

}
