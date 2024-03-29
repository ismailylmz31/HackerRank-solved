package com.mustafaakurt.hackerrank.algorithms.warmup;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
        int candleCount = candles.size();
        int tallestCandle = candles.get(0);
        int tallestCandleCount = 0;

        for (int i = 0; i < candleCount; i++) {
            if (candles.get(i) > tallestCandle) {
                tallestCandle = candles.get(i);
            }
        }
        for (int j = 0; j < candleCount; j++) {
            if (tallestCandle == candles.get(j)) {
                tallestCandleCount++;
            }
        }
        return tallestCandleCount;
    }

}

public class BirthdayCakeCandles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
