package UI.Text.Util;

import SiegeCard.Util.Rolls;

import java.util.Scanner;

public final class Print {

    public static void logo(){
        System.out.println("  ___  _____            __  \n" +
                " / _ \\/ ___/__ ________/ /  \n" +
                " \\_, / /__/ _ `/ __/ _  /   \n" +
                "/___/\\___/\\_,_/_/  \\_,_/    \n" +
                "   _____                    \n" +
                "  / __(_)__ ___ ____        \n" +
                " _\\ \\/ / -_) _ `/ -_)       \n" +
                "/___/_/\\__/\\_, /\\__/        \n" +
                "          /___/             ");
    }

    public static void menu(String[] options){
        for (int i = 0; i < options.length; i++)
            System.out.println(i+1+ "-" + options[i]);
    }



}
