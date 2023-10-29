package ProblemSolving.CSES.SortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Apartments {

    private static int validOffer(Integer desiredSize, Integer apartmentSize, long maxDiff) {
        if (desiredSize >= apartmentSize - maxDiff && desiredSize <= apartmentSize + maxDiff)
            return 0;
        else if (desiredSize < apartmentSize)
            return 1;
        else
            return 2;
    }

    public static int solve(List<Integer> applicants, List<Integer> apartments, int maxDiff) {
        Collections.sort(applicants);
        Collections.sort(apartments);

        int j = 0;
        int maxElements = 0;
        for (int i = 0; i < applicants.size() && j < apartments.size() ;) {
            int validationResult = validOffer(applicants.get(i), apartments.get(j), maxDiff);

            switch (validationResult) {
                case 0 -> {
                    i++;
                    j++;
                    maxElements++;
                }
                case 1 -> i++;
                case 2 -> j++;
            }
        }

        return maxElements;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputFirstLine  = bufferedReader.readLine().split(" ");
        String[] applicantsInput = bufferedReader.readLine().split(" ");
        String[] apartmentsInput = bufferedReader.readLine().split(" ");

        int applicantSize  = Integer.parseInt(inputFirstLine[0]);
        int apartmentSize  = Integer.parseInt(inputFirstLine[1]);
        int maxAllowedDiff = Integer.parseInt(inputFirstLine[2]);

        List<Integer> applicants = new ArrayList<>((int) (applicantSize / 0.75f));
        List<Integer> apartments = new ArrayList<>((int) (apartmentSize / 0.75f));


        for (int i = 0; i < applicantSize; i++)
            applicants.add(Integer.parseInt(applicantsInput[i]));

        for (int i = 0; i < apartmentSize; i++)
            apartments.add(Integer.parseInt(apartmentsInput[i]));

        System.out.println(solve(applicants, apartments, maxAllowedDiff));
    }

}
