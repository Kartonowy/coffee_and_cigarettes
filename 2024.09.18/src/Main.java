import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner r =  new Scanner(new File("./przyklad.txt"));
            FileWriter fw = new FileWriter("./wyniki4.txt");

            //4.1
            int n_of_start_end = 0;
            boolean printed = false;
            int highest_prime_factors = 0;
            int n_of_highest_prime_factors = 0;

            int highest_different_prime_factors = 0;
            int n_of_different_prime_factors = 0;

            ArrayList<Integer> numbers = new ArrayList<>();

            int good3s = 0;
            int howmuch=0;
            while (r.hasNextLine()) {
                try {
                    String number = r.nextLine();
                    if (number.charAt(0) == number.charAt(number.length() -1)) {
                        if (!printed) {
                            printed = true;
                        }
                        n_of_start_end++;
                    }


                    int num = Integer.parseInt(number);
                    numbers.add(num);
                    ArrayList<Integer> prims = GetPrimeFactors(num);
                    ArrayList<Integer> distinct_prims = new ArrayList<>(new HashSet<>(prims));

                    if (prims.size() > n_of_highest_prime_factors) {
                        n_of_highest_prime_factors = prims.size();
                        highest_prime_factors = num;
                    }

                    if (distinct_prims.size() > n_of_different_prime_factors) {
                        n_of_different_prime_factors = distinct_prims.size();
                        highest_different_prime_factors = num;
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("4.1 n: " + n_of_start_end);
            System.out.println("4.2");
            System.out.println(
                    highest_prime_factors + " " +
                            n_of_highest_prime_factors + " "
                            + highest_different_prime_factors + " "
                            + n_of_different_prime_factors
            );
            System.out.println("4.3 " + n_of_threes(numbers.stream().mapToInt(i -> i).toArray()));
            System.out.println("4.3 " + n_of_fives(numbers.stream().mapToInt(i -> i).toArray()));
        } catch (IOException e) {
            System.out.println("An error occured \n");
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> GetPrimeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<>();
        for(int i = 2; i < n; ++i) {
            while(n % i == 0) {
                factors.add(i);
                n = n / i;
            }
        }
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }

    public static boolean IsGoodThree(int[] n) {
        if (n[0] == 0 || n[1] == 0 || n[2] == 0) {
            return false;
        }
        if (n[1] % n[0] == 0 && n[2] % n[1] == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static int n_of_threes(int[] whatever) {
        int n = 0;
        for (int i = 0; i < whatever.length; ++i) {
            for (int j = 0; j < whatever.length; j++) {
                if (whatever[j] % whatever[i] == 0 && i != j) {
                    for (int k = 0; k < whatever.length; ++k) {
                        if (whatever[k] % whatever[j] == 0 && i != k && j != k) {
                            n++;
                        }
                    }
                }
            }
        }
        return n;
    }

    public static boolean IsGoodFive(int[] n) {
        if (n[0] == 0 || n[1] == 0 || n[2] == 0 || n[3] == 0 || n[4] == 0) {
            return false;
        }
        if (n[1] % n[0] == 0 && n[2] % n[1] == 0 && n[3] % n[2] == 0 && n[4] % n[3] == 0) {
            return true;
        } else {
            return false;
        }
    }


    public static int n_of_fives(int[] whatever) {
        int n = 0;
        for (int i = 0; i < whatever.length; ++i) {
            for (int j = 0; j < whatever.length; j++) {
                if (whatever[j] % whatever[i] == 0 && i != j) {
                    for (int k = 0; k < whatever.length; ++k) {
                        if (whatever[k] % whatever[j] == 0 && i != k && j != k) {
                            for (int l = 0; l < whatever.length; ++l) {
                                if (whatever[l] % whatever[k] == 0 &&  l != i && l != j && l!= k) {
                                    for (int m = 0; m < whatever.length; ++m) {
                                        if (whatever[m] % whatever[l] == 0 && m != i && m != j && m != k && m != l) {
                                            n++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return n;
    }
}
