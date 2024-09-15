import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Matura informatyka rozszerzona maj 2019 2
        try {
            Scanner r = new Scanner(new File("./liczby.txt"));
            FileWriter fw = new FileWriter("./wyniki4.txt");
            int n_of_pow3 = 0;
            while (r.hasNextLine()) {
                try {
                    int number = Integer.parseInt(r.nextLine());
                    System.out.println(number);
                    // 4.1
                    if (isPowerofThree(number)) {
                        n_of_pow3++;
                    }
                    // 4.2
                    if (isEqualToFactorial(number)) {
                        System.out.println("is equal to factorial: " + number);
                    }
                } catch ( NumberFormatException e ) {}
            }
            System.out.println("n:" + n_of_pow3);
        } catch (IOException e) {
            System.out.println("An error occured: \n");
            e.printStackTrace();
        }




    }
    public static boolean isPowerofThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n % 3 == 0) {
            return isPowerofThree(n / 3);
        }
        if (n == 1) {
            return true;
        }
        return false;
    }

    public static boolean isEqualToFactorial(int n) {
        int total = 0;
        for (char ch: String.valueOf(n).toCharArray()) {
            total += factorial(ch - '0');
        }
        return n == total;
    }
    public static int factorial(int n) {
        if (n > 1) {
            return n * factorial(n - 1);
        } else {
            return n;
        }
    }

}

