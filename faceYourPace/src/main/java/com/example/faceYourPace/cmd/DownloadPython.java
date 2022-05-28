package com.example.faceYourPace.cmd;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DownloadPython extends Thread{

    public static void create(String musicImg_url){
        System.out.println("Python Call");
        String[] command = new String[3];
        command[0] = "python3";
        //command[1] = "\\workspace\\java-call-python\\src\\main\\resources\\test.py";
        command[1] = "/Users/hwikyung/Desktop/hwi/computer/4/face-your-pace-function-main/download/download_mp3.py";
        command[2] = "'"+musicImg_url+"'"; // 다운
        System.out.println(musicImg_url);
        System.out.println(command[2]);
        System.out.println(command.toString());

        try {
            execPython(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execPython(String[] command) throws IOException, InterruptedException {
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

    }




}

/*
//@Controller
public class PythonTest {

    public static Music music;
    public static Member member;

    //@GetMapping("/python/call")
    public static void main(String[] args) {
        //System.out.println("musicStart: " + music.getMusicStart());
        //System.out.println("musicEnd: " + music.getMusicEnd());
        //System.out.println("musicRepeat: " + music.getMusicRepeat());
        
        System.out.println("Python Call");
        String[] command = new String[3];
        command[0] = "python";
        //command[1] = "\\workspace\\java-call-python\\src\\main\\resources\\test.py";
        //command[1] = "/Users/ykkim/workspace/java-call-python/src/main/resources/test.py";
        command[1] = "/Users/hwikyung/Desktop/hwi/computer/4/face-your-pace-function-main/download/download_mp3.py";
        //command[2] = member.getUserAge();
        //System.out.println("url" + music.getMusicImg_url());
        //command[2] = music.getMusicImg_url();
        command[2] = "'https://soundcloud.com/ferret-lie/only-your-stars-trickstar-ver','/Users/hwikyung/Desktop/hwi/computer/4/face-your-pace-function-main/result'";
        System.out.println(command[2]);
        //command[3] = "170";
        //command[3] = "170";
        //command[4] = "360"; // target_pace
        //command[5] = "110"; // stride


        //int irepeat = music.getMusicRepeat();
        //String repeat = Integer.toString(irepeat);
        //command[4] = repeat;

        try {
            execPython(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void execPython(String[] command) throws IOException, InterruptedException {
        CommandLine commandLine = CommandLine.parse(command[0]);
        for (int i = 1, n = command.length; i < n; i++) {
            commandLine.addArgument(command[i]);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler pumpStreamHandler = new PumpStreamHandler(outputStream);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(pumpStreamHandler);
        //int result = executor.execute(commandLine);
        //System.out.println("result: " + result);
        System.out.println("output: \n" + outputStream.toString());

    }

}


 */

