package company;

import java.util.Scanner;

public class iSumOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int sum = 0;

        for(int i = 1; i <= n * 2 - 1; i+=2) {
            sum += i;
            System.out.println(i);
        }

        System.out.printf("Sum: %d", sum);
    }
}
