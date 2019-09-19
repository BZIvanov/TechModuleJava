package company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class eListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String line = sc.nextLine();

        while (!line.equals("end")) {
            String[] tokens = line.split(" ");
            String cmd = tokens[0];
            switch (cmd) {
                case "Contains":
                    int element = Integer.parseInt(tokens[1]);
                    if (nums.contains(element)) {
                        System.out.print("Yes");
                    } else {
                        System.out.print("No such number");
                    }
                    break;
                case "Print":
                    String parity = tokens[1];
                    if (parity.equals("even")) {
                        nums.stream().filter(n -> n % 2 == 0).forEach(e -> System.out.print(e + " "));
                    } else {
                        nums.stream().filter(n -> n % 2 == 1).forEach(e -> System.out.print(e + " "));
                    }
                    break;
                case "Get":
                    // if Present is needed to check if there is something to reduce and not empty list for example
                    nums.stream().reduce((e1, e2) -> e1 + e2).ifPresent(System.out::print);
                    break;
                case "Filter":
                    String condition = tokens[1];
                    int number = Integer.parseInt(tokens[2]);
                    if (condition.equals("<")) {
                        nums.stream().filter(e -> e < number).forEach(e -> System.out.print(e + " "));
                    } else if (condition.equals(">")) {
                        nums.stream().filter(e -> e > number).forEach(e -> System.out.print(e + " "));
                    } else if (condition.equals(">=")) {
                        nums.stream().filter(e -> e >= number).forEach(e -> System.out.print(e + " "));
                    } else {
                        nums.stream().filter(e -> e <= number).forEach(e -> System.out.print(e + " "));
                    }
                    break;
                default:
                        break;
            }
            System.out.println();
            line = sc.nextLine();
        }
    }
}
