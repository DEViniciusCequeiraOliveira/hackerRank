import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        // Maior numero, o menor do array não pode estar
        // Menor numero, o maior do array não pode estar


        BigInteger numTotal = arr.stream().map(BigInteger::valueOf).reduce((num1, num2) -> num1.add(num2)).get();
        System.out.println((numTotal.subtract(BigInteger.valueOf(Collections.max(arr).longValue()))) + " " +
                (numTotal.subtract(BigInteger.valueOf(Collections.min(arr).longValue()))));
    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
