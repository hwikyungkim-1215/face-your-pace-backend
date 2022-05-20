package com.example.faceYourPace.cmd;

import com.example.faceYourPace.domain.member.Member;
import com.example.faceYourPace.domain.music.Music;
import com.example.faceYourPace.service.MusicService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PythonTest {

    @GetMapping("/python/call")
    public void main()  {
        //System.out.println("musicStart: " + music.getMusicStart());
        //System.out.println("musicEnd: " + music.getMusicEnd());
        //System.out.println("musicRepeat: " + music.getMusicRepeat());

        System.out.println("Python Call");
        String[] command = new String[6];
        command[0] = "python";
        //command[1] = "\\workspace\\java-call-python\\src\\main\\resources\\test.py";
        //command[1] = "/Users/ykkim/workspace/java-call-python/src/main/resources/test.py";
        command[1] = "/Users/hwikyung/Desktop/study/face-your-pace-backend/bpm_recommendTest.py";
        //command[2] = member.getUserAge();
        command[2] = "20";
        command[3] = "170";
        //command[3] = member.getUserHeight();
        command[4] = "360"; // target_pace
        command[5] = "110"; // stride


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
        int result = executor.execute(commandLine);
        //System.out.println("result: " + result);
        System.out.println("output: " + outputStream.toString());

    }

}


