package ProblemSolving.HackerRank.TestOcto;

public class OneMinuteDilemma {

    public static int solve(int[] numbers) {
        int[] hashTable = new int[60];
        int counter = 0;

        for (int number : numbers)
            hashTable[number % 60]++;

        // nC2 = n * (n - 1) / 2
        counter += hashTable[0]  * (hashTable[0] - 1)  / 2;
        counter += hashTable[30] * (hashTable[30] - 1) / 2;

        for (int i = 1; i < 30; i++)
            counter += hashTable[i] * hashTable[60 - i];

        return counter;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {20, 40, 60, 60, 60};

        System.out.println(solve(arr)); //4
    }

}
