import java.io.PrintWriter;

public class Experiments {
    public static void main(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        String section = "~~~~~~~~~~~~~~~~~~~~~~";
        byte[] b = "alyssa".getBytes();
        byte[] m = "maya".getBytes();
        byte[] c = "bob".getBytes();
        byte[] d = "joe".getBytes();
        Hash hash1 = new Hash(b);
        Hash hash2 = new Hash(m);
        Hash hash3 = new Hash(c);
        Hash hash4 = new Hash(d);
        //hash1.calculateHash((long) 3478);

        pen.println((new Hash (b)).toString());
        pen.println((new Hash (b)).isValid());
        pen.println(section);
        pen.println((new Hash (m)).toString());
        pen.println((new Hash (m)).isValid());
        pen.println(section);
        pen.println((new Hash (b)).equals(new Hash (b))); 
        pen.println((new Hash (m)).equals(new Hash (m))); 
        pen.println((new Hash (b)).equals(new Hash (m))); 
        pen.println(section);

        Block blk1 = new Block(0, 100, hash1);
        pen.println(blk1.toString());
        Block blk2 = new Block(1, 12, hash2);
        pen.println(blk2);
        Block blk3 = new Block(2, 1000, hash3);
        pen.println(blk3.toString());
        Block blk4 = new Block(3, 120, hash4);
        pen.println(blk4);
        // pen.println("0: " + blk1.getNum());
        // pen.println("100: " + blk1.getAmount());
        // pen.println("Nonce: " + blk1.getNonce());
        // pen.println("616c..." + blk1.getPrevHash());
        // pen.println("Hash " + blk1.getHash());
        
        pen.println(section);

        BlockChain blockChain = new BlockChain(300);
        //pen.println(blockChain);
        blockChain.append(blk1);
        //pen.println(blockChain);
        blockChain.append(blk2);
        blockChain.append(blk3);
        blockChain.append(blk4);
        //pen.println(blockChain);
        pen.println(blockChain.getSize());
        //pen.println(blockChain.mine(100));
        pen.println(section);
        //pen.println(blockChain.removeLast());
        pen.println(blockChain);
        pen.println(blockChain.getHash());
        pen.println(blockChain.isValidBlockChain());
        blockChain.printBalances(pen);

        //blockChain.append(blk1);

        pen.println("a");
        
        

    }
} 
