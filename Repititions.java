import java.util.Scanner;

public class Repititions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char curChar = ' ';
        long res = 0, repeatingCharCount = 1;

        for(char c: s.toCharArray()) {
            if(curChar != c) {  
                res = Math.max(res, repeatingCharCount);
                repeatingCharCount = 1;
                curChar = c;
            } else {
                repeatingCharCount++;
            }
        }

        System.out.println(Math.max(res, repeatingCharCount));

        scanner.close();
    }
}
