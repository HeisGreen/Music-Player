package com.codewithgreen;
import  javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        File file = new File("Asake_-_Organise.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        String response ="";
        
        while (!response.equals("Q")){
            System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
            System.out.print("Enter your Choice : ");

            response = scanner.next();
            response = response.toUpperCase(Locale.ROOT);

            switch (response){
                case ("P") : clip.start();
                break;
                case ("S"): clip.stop();
                break;
                case ("R") : clip.setMicrosecondPosition(0);
                break;
                case ("Q") : clip.close();
                break;
                case ("N") : clip.loop(20);
                break;
                default:
                    System.out.println("Not a valid Response");
            }
        }

        System.out.println("Ended!!");
    }
}
