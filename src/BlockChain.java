import java.io.PrintWriter;
import javax.print.event.PrintEvent;

public class BlockChain {
  BlockChain(int initial) {
    //STUB
  } //BlockChain

  public Block mine(int amount) {
    return mine(0); //STUB
  } //mine

  public int getSize() {
    return 0; //STUB
  } // getSize()

  public void append(Block blk) throws IllegalArgumentException {
    //STUB
  } // append(Block)

  public boolean removedLast() {
    return true; //STUB
  } // removeLast()

  public Hash getHash() {
    return getHash();
  } //getHash

  public boolean isValidBlockChain() {
    return true; //STUB
  } // isValidBlockChain

  public void printBalances(PrintWriter pen) {
    pen.println("This is cool");
  } // printBalances(PrintWriter)

  public String toString() {
    return "Why implement so many things";
  }
} // BlockChain
