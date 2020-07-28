package com.study.mooc.udp;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/17 11:14
 */
public class Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        byte[] bts = new byte[1024];
        while (true){
            String s = scanner.nextLine();
            System.out.println("Sender发送："+s);
            byte[] gbks = s.getBytes("UTF-8");
            DatagramPacket dp = new DatagramPacket(gbks,gbks.length, InetAddress.getByName("127.0.0.1"),3000);
            ds.send(dp);
            System.out.println("发送完成");

            System.out.println("receving...");
            DatagramPacket rdp = new DatagramPacket(bts,bts.length);
            ds.receive(rdp);
            String host = rdp.getAddress().getHostAddress()+":"+rdp.getPort();
            String info = new String(rdp.getData(),"UTF-8");
            System.out.println("收到"+host+":"+info);
            if(info.equals("finished")){
                System.out.println("finished");
                break;
            }
        }
        System.out.println("聊天结束！");

    }
}
