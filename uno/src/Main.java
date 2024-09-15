import java.io.*;
import java.util.ArrayList;
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
            ArrayList<Integer> nums = new ArrayList<Integer>(500);
            ArrayList<Integer> greatest = new ArrayList<Integer>();
            while (r.hasNextLine()) {
                try {
                    int number = Integer.parseInt(r.nextLine());
                    // 4.1
                    if (isPowerofThree(number)) {
                        n_of_pow3++;
                    }
                    // 4.2
                    if (isEqualToFactorial(number)) {
                        fw.write("4.2: " + number + "\n");
                    }
                    // 4.3
                    if (nums.size() == 1 || nums.isEmpty()) {
                        nums.add(number);
                    } else {
                        int current = gcd_array(nums);
                        if(gcd(gcd_array(nums), number) == current && current > 1) {
                            nums.add(number);
                        } else {
                            if (greatest.size() < nums.size()) {
                                greatest = new ArrayList(nums.subList(0, nums.size()));
                            }
                            var last = nums.getLast();
                            nums.clear();
                            nums.add(last);
                            nums.add(number);
                        }
                    }
//                    System.out.println(gcd_array(new int[]{72, 144, 216}));
                } catch ( NumberFormatException e ) {}
            }
            fw.write("4.1: " +n_of_pow3 + "\n");
            fw.write("4.3: pierwsza liczba ciągu " + greatest.getFirst() + ", długość " + greatest.size() + ", największy wspólny dzielnik " + gcd_array(greatest) + "\n");
            fw.close();
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
    public static int gcd(int n, int m) {
        while (m != 0) {
            int t = n;
            n = m;
            m = t % n;
        }
        return n;
    }
    public static int gcd_array(ArrayList<Integer> arr) {
        if (arr.size() == 1) {
            return arr.getFirst();

        }
        if (arr.size() >= 2) {
            return gcd(arr.getFirst(), gcd_array(new ArrayList<>(arr.subList(1, arr.size()))));
        }
        return 0;
    }
}

