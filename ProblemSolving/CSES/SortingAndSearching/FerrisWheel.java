
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class FerrisWheel {

    public static int solve(ArrayList<Integer> weights, int maxAllowedWeight) {
        int numberOfGondolas = 0;
        Collections.sort(weights);

        for (int i = 0, j = weights.size() - 1; i <= j; j--) {
            if (weights.get(i) + weights.get(j) <= maxAllowedWeight) {
                numberOfGondolas++;
                i++;
            } else if (weights.get(j) <= maxAllowedWeight)
                numberOfGondolas++;
        }

        return numberOfGondolas;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLineInput = bufferedReader.readLine().split(" ");

        int numberOfChildren = Integer.parseInt(firstLineInput[0]);
        int maxAllowedWeight = Integer.parseInt(firstLineInput[1]);

        ArrayList<Integer> weights = new ArrayList<>((int) (numberOfChildren / 0.75f));

        String[] weightInput = bufferedReader.readLine().split(" ");

        for (int i = 0; i < numberOfChildren; i++) {
            int weight = Integer.parseInt(weightInput[i]);

            if (weight <= maxAllowedWeight)
                weights.add(weight);
        }

        System.out.println(solve(weights, maxAllowedWeight));
    }

}
