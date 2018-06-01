package UI.Text.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Read {
    private static Scanner scanner;
    private static BufferedReader reader;

    public Read() {
        scanner=new Scanner(System.in);
        reader=new BufferedReader(new InputStreamReader(System.in));
    }

    public int option(){
        System.out.println("Choose your option: ");
        while(!scanner.hasNextInt()) scanner.next();
        return scanner.nextInt();
    }

    public String line(){
        String line="";
        try {                    line=reader.readLine().trim();
        } catch (IOException e) {System.out.println(e);}
        return line;
    }
}
