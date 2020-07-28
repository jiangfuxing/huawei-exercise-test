package com.study.mooc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

/**
 * @author jingfuxing
 * @version 1.0
 * @FUNCTION
 * @date 2020/7/17 11:14
 */
public class Reciever {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(3000);
        byte[] bts = new byte[1024];
        DatagramPacket rdp = new DatagramPacket(bts,1024);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("recieving...");
            datagramSocket.receive(rdp);
            String host = rdp.getAddress().getHostAddress()+":"+rdp.getPort();
            String info  = new String(rdp.getData(),"UTF-8");
            System.out.println("来自："+host);
            System.out.println("信息："+info);
            String sendInfo = scanner.nextLine();
            System.out.println("我发送："+sendInfo);
            byte[] sendBytes = sendInfo.getBytes("UTF-8");
            DatagramPacket sdp = new DatagramPacket(sendBytes,sendBytes.length,rdp.getAddress(),rdp.getPort());
            datagramSocket.send(sdp);
            if(info.equals("finished")){
                System.out.println("finished");
                break;
            }
        }
        System.out.println("聊天结束");

    }
}
