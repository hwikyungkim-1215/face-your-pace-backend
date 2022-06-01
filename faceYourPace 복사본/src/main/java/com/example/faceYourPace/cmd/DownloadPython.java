package com.example.faceYourPace.cmd;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DownloadPython extends Thread{

    public static String create(String music_url){
        System.out.println("Python Call");
        String[] command = new String[4];
        command[0] = "python3";
        command[1] = "'/home/ubuntu/face-your-pace-function/fyp_download/fyp_download.py'"; // 파이썬 파일 위치
        command[2] = "'"+music_url+"'"; // 음악 링크
        command[3] = "'/home/ubuntu/face-your-pace-function/fyp_download/result'"; // 파일 저장 위치

        System.out.println(music_url);
        System.out.println(command[2]);
        System.out.println(command.toString());

        try {
            return execPython(command);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static String execPython(String[] command) throws IOException, InterruptedException {
        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        int result = executor.execute(commandLine);
        System.out.println("result: " + result);
        System.out.println("output: " + outputStream.toString());
        System.out.println("mp3 파일 다운 완료");

        return outputStream.toString();

    }
}


