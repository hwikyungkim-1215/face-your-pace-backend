package com.example.faceYourPace.cmd;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class RecommandBpmPython {

// 키 나이 보폭 페이스
    public static String create(String userHeight, String userAge, String stride, String target_pace) throws IOException, InterruptedException {
        System.out.println("Python Call");
        String[] command = new String[6];
        command[0] = "python3";
        //command[1] = "\\workspace\\java-call-python\\src\\main\\resources\\test.py";
        command[1] = "/Users/hwikyung/Desktop/hwi/computer/4/face-your-pace-function-main/function/recommend_bpm.py";

        command[2] = userHeight;
        System.out.println("wav_path:" + userHeight);
        //command[2] = "1";
        command[3] = userAge;
        System.out.println("save_path:" + userAge);
        command[4] = stride;
        System.out.println("start:" + stride);
        command[5] = target_pace;
        System.out.println("end:" + target_pace);
        System.out.println(command.toString());
        try {
            execPython(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return execPython(command);
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

        return outputStream.toString();

    }
}
