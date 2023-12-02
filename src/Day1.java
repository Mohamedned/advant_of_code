package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

class Day1 {
     public static void main(String[] args) throws IOException {
        ArrayList<String> filteredString = filter();

        int i = 0;
        for (String str : filteredString) {
            i = i + toInt(firstLastDigid(str));
        }
        System.out.println("Result: " + i);
    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }

    private static String firstLastDigid(String s) {
        int n = s.length();
        char first = s.charAt(0);
        char last = s.charAt(n - 1);
        return first + "" + last;
    }

    private static ArrayList<String> filter() throws IOException {
        ArrayList<String> fileContent = readFile();
        ArrayList<String> filteredString = new ArrayList<>();
        for(String s : fileContent) {

            String string  = "";
            for (int i = 0; i < s.split("").length; i++) {
                char ch = s.charAt(i);

                if(Character.isDigit(ch)) {
                    string = string + ch;
                }
            }
            filteredString.add(string);
        }
        return filteredString;
    }

    private static ArrayList<String> readFile() throws IOException {
        Path currPath = Paths.get("");
        String pathToTxtFile = currPath.toAbsolutePath().toString() + "\\advant_of_code\\resource\\calibration_document.txt";
        File file = new File(pathToTxtFile);   
        FileReader fr = new FileReader(file); 
        BufferedReader br = new BufferedReader(fr); 
        ArrayList<String> fileContent = new ArrayList<>();
        String line;
        while((line=br.readLine())!=null)
        {
            fileContent.add(line);
        }

        fr.close();
        return fileContent;
    }
}