//package com.example.faceYourPace.cmd;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*

public class ProcessBuilder {
    public static void main(String[] arg) throws IOException {
        String command = "C:\\\Anaconda3\\\envs\\jep\\\python.exe";
        String music = "F:\\src\\hyeon\\latteonterrace\\python\\python-exe\\src\\python\\test.py";

        ProcessBuilder processBuilder = new ProcessBuilder(command, music);

        // Run this on Windows, cmd, /c = terminate after this run
        processBuilder.command("cmd.exe", "/c", "ping -n 3 google.com");

        try {

            Process process = processBuilder.start();

            // blocked :(
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


 */