package edu.princeton.cs.lanqiao;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class 时间显示 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long times = scanner.nextLong();
        times = times - 8*60*60*1000;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        date.setTime(times);
        System.out.println(simpleDateFormat.format(date));


    }
}
