package com.example.faceYourPace.cmd;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class RecommandBpmPython {

// 키 나이 보폭 페이스
    public static String create(String gender, String userAge, String userHeight,String userWeight,  String workout_level, String target_pace, String stride){
        System.out.println("Python Call");
        String[] command = new String[9];
        command[0] = "python3";
        //command[1] = "\\workspace\\java-call-python\\src\\main\\resources\\test.py";
        command[1] = "\"/home/ubuntu/face-your-pace-function/fyp_bpmrecommend/fyp_bpmrecommend.py\"";

        command[2] = gender;
        System.out.println("gender:" + gender);

        command[3] = userAge;
        System.out.println("userAge:" + userAge);

        command[4] = userHeight;
        System.out.println("userHeight:" + userHeight);

        command[5] = userWeight;
        System.out.println("userWeight:" + userWeight);

        command[6] = workout_level;
        System.out.println("workout_level:" + workout_level);

        command[7] = target_pace;
        System.out.println("target_pace:" + target_pace);

        command[8] = stride;
        System.out.println("stride:" + stride);

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

        return outputStream.toString();

    }
}
