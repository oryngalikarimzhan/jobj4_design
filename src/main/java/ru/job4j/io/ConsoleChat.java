package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> chat = new ArrayList<>();
        Scanner userIn = new Scanner(System.in);
        String botFraze;
        String userFraze;
        String condition = CONTINUE;
        while (!condition.equals(OUT)) {
            if (condition.equals(CONTINUE)) {
                userFraze = userIn.nextLine();
                chat.add(userFraze);
                if (userFraze.equals(OUT) || userFraze.equals(STOP)) {
                    condition = userFraze;
                } else {
                    Random rand = new Random();
                    botFraze = readPhrases().get(rand.nextInt(readPhrases().size()));
                    System.out.println(botFraze);
                    chat.add(botFraze);
                }
            } else {
                userFraze = userIn.nextLine();
                chat.add(userFraze);
                if (userFraze.equals(CONTINUE)) {
                    condition = userFraze;
                    Random rand = new Random();
                    botFraze = readPhrases().get(rand.nextInt(readPhrases().size()));
                    System.out.println(botFraze);
                    chat.add(botFraze);
                } else if (userFraze.equals(OUT)) {
                    condition = userFraze;
                }

            }
        }
        saveLog(chat);
    }

    private List<String> readPhrases() {
        List<String> listOfAnswers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers))) {
            br.lines().forEach(listOfAnswers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfAnswers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/log.txt", "./data/botAnswers.txt");
        cc.run();
    }
}