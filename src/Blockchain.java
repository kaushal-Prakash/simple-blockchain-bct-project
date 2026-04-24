import java.util.ArrayList;

public class Blockchain {

    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) {

        // Genesis block
        blockchain.add(new Block("First Block", "0"));

        blockchain.add(new Block("Second Block", blockchain.get(blockchain.size() - 1).hash));

        blockchain.add(new Block("Third Block", blockchain.get(blockchain.size() - 1).hash));

        // Print blockchain
        for (Block block : blockchain) {
            System.out.println("Data: " + block.data);
            System.out.println("Hash: " + block.hash);
            System.out.println("Previous Hash: " + block.previousHash);
            System.out.println("-----------------------------------");
        }
    }
}