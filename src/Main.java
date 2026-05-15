import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Blockchain blockchain = new Blockchain();

        while (true) {

            System.out.println("\n===== BLOCKCHAIN MENU =====");

            System.out.println("1. Add Transaction");

            System.out.println("2. Check Balance");

            System.out.println("3. Print Blockchain");

            System.out.println("4. Validate Blockchain");

            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Sender (A/B/C): ");
                    String sender = sc.next();

                    System.out.print("Enter Receiver (A/B/C): ");
                    String receiver = sc.next();

                    System.out.print("Enter Amount: ");
                    int amount = sc.nextInt();

                    blockchain.addTransaction(sender, receiver, amount);

                    break;

                case 2:

                    System.out.print("Enter User (A/B/C): ");

                    String user = sc.next();

                    blockchain.checkBalance(user);

                    break;

                case 3:

                    blockchain.printChain();

                    break;

                case 4:

                    System.out.println(
                            "Is Blockchain Valid? " + blockchain.isChainValid()
                    );

                    break;

                case 5:

                    System.out.println("Exiting...");

                    sc.close();

                    return;

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}