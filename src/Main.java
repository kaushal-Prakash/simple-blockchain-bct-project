public class Main {
    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();

        blockchain.addBlock("Transaction 1: A pays B 100");
        blockchain.addBlock("Transaction 2: B pays C 50");
        blockchain.addBlock("Transaction 3: C pays D 25");

        blockchain.printChain();

        System.out.println("Is Blockchain valid? " + blockchain.isChainValid());
    }
}