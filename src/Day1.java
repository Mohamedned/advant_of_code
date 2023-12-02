package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Day1 {
     public static void main(String[] args) throws IOException {


        ArrayList<String> sClm = filter();

        int i = 0;
        for (String str : sClm) {
            i = i + toInt(firstLastDigid(str));
        }
        System.out.println("Result: " + i);
    }

    public static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static String firstLastDigid(String s) {
        int n = s.length();
        char first = s.charAt(0);
        char last = s.charAt(n - 1);
        return first + "" + last;
    }

    public static ArrayList<String> filter() throws IOException {
        ArrayList<String> clb = readFile();
        ArrayList<String> sClm = new ArrayList<>();
        for(String s : clb) {

            String string  = "";
            for (int i = 0; i < s.split("").length; i++) {
                char ch = s.charAt(i);

                if(Character.isDigit(ch)) {
                    string = string + ch;
                }
            }
            sClm.add(string);
        }
        return sClm;
    }

    public static ArrayList<String> readFile() throws IOException {
        File file = new File("C:\\Users\\31644\\Documents\\Software code\\JAVA\\AdvantOfCode2023\\dayone\\src\\calibration_document.txt");    //creates a new file instance
        FileReader fr = new FileReader(file);   //reads the file
        BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream//constructs a string buffer with no characters
        ArrayList<String> clb = new ArrayList<>();
        String line;
        while((line=br.readLine())!=null)
        {
            clb.add(line);
        }

        fr.close();
        return clb;
    }
}