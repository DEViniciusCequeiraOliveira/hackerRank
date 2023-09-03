package PlusMinus;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        Map<Integer, Long> map = arr.stream().collect(groupingBy(Integer::signum, counting()));
        if (!map.containsKey(0)) map.put(0,0L);
        if (!map.containsKey(1)) map.put(1,0L);
        if (!map.containsKey(-1)) map.put(-1,0L);

        System.out.println(String.valueOf(map.get(1) / new Double(arr.size())));
        System.out.println(String.valueOf(map.get(-1) / new Double(arr.size())));
        System.out.println(String.valueOf(map.get(0)  / new Double(arr.size())));
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}

