import java.io.PrintWriter;
import javax.print.event.PrintEvent;
import java.util.ListIterator;

/**
 * 
 * Node is from a lab /////
 */

public class BlockChain {
  // FIELDS
  SimpleDLL<Block> blockChain;
  ListIterator<Block> blockChainIterator;

  Block first;
  Block last;

  int size;

  int alexisAmount;
  int blakeAmount;


  // CONSTRUCTORS
  BlockChain(int initial) {
    blockChain = new SimpleDLL<>();
    Block blk = new Block(size, initial, null);
    this.blockChainIterator = blockChain.listIterator();
    this.alexisAmount = initial;
    this.blakeAmount = 0;
    first = blk;
    last = blk;
    size = 1; 
  } // BlockChain

  // METHODS
  public Block mine(int amount) {
    Block blk = new Block(size, amount, blockChainIterator.next().getHash());
    return blk;
  } // mine

  public int getSize() {
    return this.size;
  } // getSize()


  public void append(Block blk) throws IllegalArgumentException {
    if (blockChainIterator.hasPrevious() && size > 1) {
      blk.prevHash = blockChainIterator.previous().getHash();
    } // if
    blockChainIterator.add(blk);
    last = blk;
    size++;
    alexisAmount += blk.getAmount();
    blakeAmount -= blk.getAmount();
  } // append(Block)

  public boolean removeLast() {
    if (size <= 1) {
      return false;
    }
    alexisAmount -= last.getAmount();
    blakeAmount += last.getAmount();
    blockChainIterator.remove(); ////Does it work if you remove twice in a row?
    last = blockChainIterator.previous();
    size--;
    return true; 
  } // removeLast()

  public Hash getHash() {
    return last.getHash();
  } // getHash

  public boolean isValidBlockChain() { 
    while(blockChainIterator.hasPrevious()) {
      blockChainIterator.previous();
    } // get to the front of the list
    blockChainIterator.next(); //the first element has no prevHash
    while(blockChainIterator.hasNext()) {
      if(!blockChainIterator.previous().getHash().equals(blockChainIterator.next().getPrevHash())) {
        return false;
      } // if prevHash doesn't equal the previous hash 
    } // while there are elements remaining
    return true;
  } // isValidBlockChain

  public void printBalances(PrintWriter pen) {
    pen.println("Alexis: " + alexisAmount + ", Blake: " + blakeAmount);
  } // printBalances(PrintWriter)

  public String toString() {
    StringBuilder toReturn = new StringBuilder();
    while(blockChainIterator.hasPrevious()) {
      blockChainIterator.previous();
    } // get to the front of the list
    while(blockChainIterator.hasNext()) {
      toReturn.append(blockChainIterator.next().toString() + "\n");
    }
    return toReturn.toString();
  }
} // BlockChain