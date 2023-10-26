
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Apartments {

    private static int validOffer(Long desiredSize, Long apartmentSize, int maxDiff) {
        if (desiredSize >= apartmentSize - maxDiff && desiredSize <= apartmentSize + maxDiff)
            return 0;
        else if (desiredSize < apartmentSize)
            return 1;
        else
            return 2;
    }

    public static int solve(List<Long> applicants, List<Long> apartments, int maxDiff) {
        Collections.sort(applicants);
        Collections.sort(apartments);

        int j = 0;
        int maxElements = 0;
        for (int i = 0; i < applicants.size() && j < apartments.size() ;) {
            int validationResult = validOffer(applicants.get(i), apartments.get(j), maxDiff);

            switch (validationResult) {
                case 0:
                    i++;
                    maxElements++;
                    break;
                case 1:
                    i++;
                    break;
                case 2:
                    j++;
                    break;
            }
        }

        return maxElements;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer maxDiff = Arrays.stream(scanner.nextLine().split(" "))
                                                          .map(Integer::parseInt)
                                                          .collect(Collectors.toList()).get(2);

        List<Long> applicants = Arrays.stream(scanner.nextLine().split(" "))
                                                                .map(Long::parseLong)
                                                                .collect(Collectors.toList());

        List<Long> apartments = Arrays.stream(scanner.nextLine().split(" "))
                                                                .map(Long::parseLong)
                                                                .collect(Collectors.toList());

        System.out.println(solve(applicants, apartments, maxDiff));
    }

}
