import java.util.ArrayList;
import java.util.HashMap;

public class Blockchain {

    private ArrayList<Block> chain;
    private HashMap<String, Integer> balances;

    public Blockchain() {

        chain = new ArrayList<>();
        balances = new HashMap<>();

        // Initial balances
        balances.put("A", 1000);
        balances.put("B", 1000);
        balances.put("C", 1000);

        chain.add(createGenesisBlock());
    }

    private Block createGenesisBlock() {
        return new Block("Genesis Block", "0");
    }

    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    public void addTransaction(String sender, String receiver, int amount) {

        // Check users
        if (!balances.containsKey(sender) || !balances.containsKey(receiver)) {

            System.out.println("Invalid user!");
            return;
        }

        // Check balance
        if (balances.get(sender) < amount) {

            System.out.println("Insufficient balance!");
            return;
        }

        // Update balances
        balances.put(sender, balances.get(sender) - amount);
        balances.put(receiver, balances.get(receiver) + amount);

        String data = sender + " pays " + receiver + " " + amount;

        Block newBlock = new Block(data, getLatestBlock().getHash());

        chain.add(newBlock);

        System.out.println("Transaction Added Successfully!");
    }

    public void checkBalance(String user) {

        if (balances.containsKey(user)) {

            System.out.println(user + " Balance: " + balances.get(user));

        } else {

            System.out.println("User not found!");
        }
    }

    public boolean isChainValid() {

        for (int i = 1; i < chain.size(); i++) {

            Block current = chain.get(i);

            Block previous = chain.get(i - 1);

            // Check current hash
            if (!current.getHash().equals(current.calculateHash())) {

                return false;
            }

            // Check previous hash link
            if (!current.getPreviousHash().equals(previous.getHash())) {

                return false;
            }
        }

        return true;
    }

    public void printChain() {

        for (Block block : chain) {

            System.out.println("Data: " + block.getData());

            System.out.println("Hash: " + block.getHash());

            System.out.println("Previous Hash: " + block.getPreviousHash());

            System.out.println("--------------------------------");
        }
    }
}