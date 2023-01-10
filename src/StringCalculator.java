import java.util.*;


class StringCalculator {
    private static List<String> delim = new ArrayList<>(List.of(",", ".", "\\n", "\\t", " "));
    private static List<String> negative = new ArrayList<>();

    
    static String[] delimiters(String num) {
        if (num.indexOf("//[") == 0) {
            Collections.addAll(delim, num.substring(3, num.indexOf("]\\n")).split("]\\Q["));
            num = num.substring(num.indexOf("]\\n") + 3);
        }

        for (int i = 0; i < delim.size(); i++) {
            num = num.replaceAll("\\Q" + delim.get(i) + "\\E", ",");
        }
        if (num.contains(",,")) throw new IllegalArgumentException();

        String[] numbers = num.split(",");
        return numbers;
    }


    public int add(String num) {
        String[] numbers = delimiters(num);
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (Integer.parseInt(numbers[i]) >= 1000) {
                numbers[i] = "0";
            }
            else if (Integer.parseInt(numbers[i]) < 0) {
                negative.add(numbers[i]);
                numbers[i] = "0";
            }
            sum += Integer.parseInt(numbers[i]);
        }

        System.out.println("The sum is " + sum);
        if (!negative.isEmpty()) {
            System.out.println("Negative numbers are ");
            for (int j = 0; j < negative.size(); j++) {
                System.out.print(negative.get(j) + " ");
            }
        }
        return sum;
    }
}
