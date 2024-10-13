import java.util.Scanner;

public class VotingSystem {
    public static void main(String[] args) {
        // Candidates
        String[] candidates = {"Guled", "Ahmed", "Hassan"};
        int[] votes = new int[candidates.length];

        Scanner scanner = new Scanner(System.in);
        int numberOfVoters;

        System.out.println("Enter the number of voters: ");
        numberOfVoters = scanner.nextInt();

        for (int i = 1; i <= numberOfVoters; i++) {
            System.out.println("Voter " + i + ", please choose a candidate:");
            for (int j = 0; j < candidates.length; j++) {
                System.out.println((j + 1) + ". " + candidates[j]);
            }

            int choice = scanner.nextInt();
            if (choice > 0 && choice <= candidates.length) {
                votes[choice - 1]++;
                System.out.println("You voted for " + candidates[choice - 1] + "\n");
            } else {
                System.out.println("Invalid choice, vote not counted!\n");
            }
        }

        System.out.println("Voting results:");
        for (int i = 0; i < candidates.length; i++) {
            System.out.println(candidates[i] + ": " + votes[i] + " votes");
        }
        
        int maxVotes = -1;
        String winner = "";
        boolean tie = false;

        for (int i = 0; i < candidates.length; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                winner = candidates[i];
                tie = false;
            } else if (votes[i] == maxVotes) {
                tie = true;
            }
        }

        if (tie) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("The winner is: " + winner);
        }

        scanner.close();
    }
}
