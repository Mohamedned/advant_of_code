package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day1_partTwo {
    public static void main(String[] args) throws IOException {
        ArrayList<String> file = readFile();
        int result = 0;
        for (String s : file) {
            result = result + toInt(concatFirstLast(s));
        }   
        
        System.out.println("Result = " + result);
    }
        private static String concatFirstLast(String s) {
            
            Map<Integer, String> hMap = getNumbers(s);
            String first = "";
            String last = "";
            
            for (Map.Entry<Integer, String> entry : hMap.entrySet()) {
                Integer key = entry.getKey();
                String value = entry.getValue();
                if (key.equals(0)) {
                    first = value;
                }
                if(key.equals(hMap.size() - 1)) {
                    last = value;
                }
            }
            
            if(!isDigitFL(first)) {
                first = fromStringToInt(first);
            } 
            if(!isDigitFL(last)) {
                last = fromStringToInt(last);
            } 
            return first + "" + last;
        }

        private static int toInt(String s) {
            return Integer.parseInt(s);
        }

        private static String fromStringToInt(String s) {
            if (s.equals("one")) {
                return "1";
            }
            if (s.equals("two")) {
                return "2";
            }
            if (s.equals("three")) {
                return "3";
            }
            if (s.equals("four")) {
                return "4";
            }
            if (s.equals("five")) {
                return "5";
            }
            if (s.equals("six")) {
                return "6";
            }
            if (s.equals("seven")) {
                return "7";
            }
            if (s.equals("eight")) {
                return "8";
            }
            if (s.equals("nine")) {
                return "9";
            }
            return "0";
        }
        private static boolean isDigitFL(String s) {
            if(s.length() == 1) {
                char ch = s.charAt(0);
                if(Character.isDigit(ch)) {
                    return true;
                }
            }
            return false;
        }

        private static HashMap<Integer, String> getNumbers(String s) {
              HashMap<Integer, String> hMap = new HashMap<>();
        
             int strL = s.length();
        

            String str = "";
            String str1 = "";
            String str2 = "";
            int hMapKey = 0;
            for (int i = 0; i < strL; i++) {
                str = "";
                str1 = "";
                str2 = "";
                int num_three = i + 3;
                int num_four = i + 4;
                int num_five = i + 5;

                char ch = s.charAt(i);
                if(Character.isDigit(ch)) {
                    hMap.put(hMapKey++, Character.toString(ch));
                }

                if (!(num_three > strL))
                    str = s.substring(i, num_three);

                if (!(num_four > strL))
                    str1 = s.substring(i, num_four);
                
                if (!(num_five > strL))
                    str2 = s.substring(i, num_five);

                if (str.equals("one")) {
                    hMap.put(hMapKey++, str);
                }
                if (str.equals("two")) {
                    hMap.put(hMapKey++, str);
                }
                if (str2.equals("three")) {
                    hMap.put(hMapKey++, str2);
                }

                if (str1.equals("four")) {
                    hMap.put(hMapKey++, str1);
                }  
                if (str1.equals("five")) {
                    hMap.put(hMapKey++, str1);
                }
                if (str.equals("six")) {
                    hMap.put(hMapKey++, str);
                }
                if (str2.equals("seven")) {
                    hMap.put(hMapKey++, str2);
                } 
                if (str2.equals("eight")) {
                    hMap.put(hMapKey++, str2);
                }
                if (str1.equals("nine")) {
                    hMap.put(hMapKey++, str1);
                }         
            }
            return hMap;
        }
        private static ArrayList<String> readFile() throws IOException {
        Path currPath = Paths.get("");
        String pathToTxtFile = currPath.toAbsolutePath().toString() + "\\resource\\calibration_document.txt";
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
