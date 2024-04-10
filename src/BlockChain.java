import java.io.PrintWriter;
import java.util.ListIterator;

/**
 * BlockChain is a type of linked list that stores blocks in it's nodes.
 * 
 * @author Alyssa Trapp
 * @author Maya Flynn
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
    blockChainIterator.add(blk);
    first = blk;
    last = blk;
    size = 1;
  } // BlockChain(int)

  // METHODS
  /**
   * mine generates a block with the number as the size of the list, the amount as given, and the
   * previous Hash as the hash of the last element in the blockChain. It does NOT add the block to
   * the block chain.
   * 
   * @param amount
   * @return
   */
  public Block mine(int amount) {
    Block blk = new Block(size, amount, blockChainIterator.previous().getHash());
    return blk;
  } // mine(int)

  /**
   * getSize returns the size of the array
   * 
   * @return
   */
  public int getSize() {
    return this.size;
  } // getSize()

  /**
   * Append adds blk to the end of the BlockChain. It modifies the parameters of block as it
   * appends. It changes the num to be the size of the list, forcing the nums in the blockchain to
   * index through. It also changes prevHash of the block to be the hash of the block that was
   * formerly at the end of the block.
   * 
   * @param blk
   * @throws IllegalArgumentException
   */
  public void append(Block blk) throws IllegalArgumentException {
    if (blockChainIterator.hasPrevious()) {
      blk.prevHash = blockChainIterator.previous().getHash();
      blk.num = size;
    } // if
    while (blockChainIterator.hasNext()) {
      blockChainIterator.next();
    } // get to the end of the list
    blockChainIterator.add(blk);
    last = blk;
    size++;
    alexisAmount += blk.getAmount();
    blakeAmount -= blk.getAmount();
  } // append(Block)

  /**
   * removeLast removes the last element in the blockchain and modifies alexisAmount and blakeAmount
   * so that their transaction sum matches what is reflected in the blockchain.
   * 
   * @return
   */
  public boolean removeLast() {
    if (size <= 1) {
      return false;
    } // if
    alexisAmount -= last.getAmount();
    blakeAmount += last.getAmount();
    while (blockChainIterator.hasNext()) {
      blockChainIterator.next();
    } // get to the end
    blockChainIterator.previous();
    blockChainIterator.remove();
    size--;
    blockChainIterator.previous();
    last = blockChainIterator.next();
    return true;
  } // removeLast()

  /**
   * getHash returns the hash of the last block in the chain
   * 
   * @return
   */
  public Hash getHash() {
    return last.getHash();
  } // getHash()

  /**
   * isValidBlockChain determines if the hashes in the blockchain are valid and checks to make sure
   * that all previous Hashes match the hash in the previous node
   * 
   * @return
   */
  public boolean isValidBlockChain() {
    while (blockChainIterator.hasPrevious()) {
      blockChainIterator.previous();
    } // get to the front of the list
    blockChainIterator.next(); // the first element has no prevHash
    while (blockChainIterator.hasNext()) {
      Hash tempHashPrev = blockChainIterator.previous().getHash();
      blockChainIterator.next();
      Hash prevHashThis = blockChainIterator.next().getPrevHash();
      if (!tempHashPrev.equals(prevHashThis) || !prevHashThis.isValid()) {
        return false;
      } // if prevHash doesn't equal the previous hash
    } // while there are elements remaining
    if (!blockChainIterator.previous().getHash().isValid()) {
      return false;
    } // if the last hash is invalid
    return true;
  } // isValidBlockChain

  /**
   * Prints the balances for Alexis and Blake
   * 
   * @param pen
   */
  public void printBalances(PrintWriter pen) {
    pen.println("Alexis: " + alexisAmount + ", Blake: " + blakeAmount);
  } // printBalances(PrintWriter)

  /**
   * Turns the BlockChain into a string
   */
  public String toString() {
    StringBuilder toReturn = new StringBuilder();
    while (blockChainIterator.hasPrevious()) {
      blockChainIterator.previous();
    } // get to the front of the list
    while (blockChainIterator.hasNext()) {
      toReturn.append(blockChainIterator.next().toString() + "\n");
    } // while
    return toReturn.toString();
  } // toString
} // class BlockChain
