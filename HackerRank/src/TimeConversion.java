import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.text.SimpleDateFormat;

import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s)  {
        // Write your code here
        DateFormat dt = new SimpleDateFormat("hh:mm:ssaa");
        DateTimeFormatter dtFinal = DateTimeFormatter.ofPattern("HH:mm:ss");
        Date d;
        try {
            d = dt.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return dtFinal.format(LocalDateTime.ofInstant(d.toInstant(), ZoneId.systemDefault()));
    }

}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
