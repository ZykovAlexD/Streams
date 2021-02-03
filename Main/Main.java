package Streams.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] input = {1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4};
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (int x : input) {
            if (x <= 0) continue;
            if (x%2!=0) continue;
            count++;
            if (count > 10) break;
            result.add(x);
            Collections.sort(result);
        }
        System.out.println(result);
    }
}
