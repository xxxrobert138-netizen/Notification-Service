package com.example.Notification.Service.util;

import java.util.Date;

public abstract class ConsoleHelper {
    public enum MessageType {
        INFO,WARN
    }

    public static void printInformation(String information, MessageType type) {
        Date date = new Date();
        System.out.printf("%20s --- [%4s] --- %s\n", date.toString(), type.toString(), information);
    }

    public static void printGreetings() {
        System.out.println("+------------------------------+\n" +
                "|                              |\n" +
                "|      [ROBERT PYRSKI]         |\n" +
                "|                              |\n" +
                "+------------------------------+");
    }
}
