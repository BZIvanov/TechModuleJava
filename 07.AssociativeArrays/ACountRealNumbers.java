import java.util.*;

public class ACountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] nums = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> someMap = new TreeMap<>();

        for (double num : nums) {
            // putIfAbsent method is alternative solution for this if construction
            if (!someMap.containsKey(num)) {
                someMap.put(num, 0);
            }
            int oldValue = someMap.get(num);
            // rewrite previous value increased by 1
            someMap.put(num, oldValue + 1);
        }

        String pattern = "%.0f -> %d";
        for (Map.Entry<Double, Integer> kvp : someMap.entrySet()) {
            System.out.println(String.format(pattern, kvp.getKey(), kvp.getValue()));
        }
    }
}
