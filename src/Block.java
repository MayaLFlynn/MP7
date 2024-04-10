import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.ByteBuffer;
import java.util.Random;


/**
 * Block is an object with a number that represents its order in a chain (though that is not
 * enforced), an amount that represent a numerical transaction, a previous Hash , a Hash, and a
 * nonce that together with other blocks helps the user verify if the block is valid.
 * 
 * @author Alyssa Trapp
 * @author Maya Flynn
 */
public class Block {

  // FIELDS
  int num;
  int amount;
  Hash prevHash;
  long nonce;
  Hash curHash;

  // CONSTRUCTORS
  Block(int num, int amount, Hash prevHash) {
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    // loops while it is true
    while (true) {
      try {
        // creates a rand type object
        Random rand = new Random();
        // generates a random long
        long randNonce = rand.nextInt();
        // generates a random hash based on the random nonce
        Hash tempHash = calculateHash(randNonce);
        // if it's a valid hash, set nonce to randNonce and curHash to tempHash
        // if not, keep looping until you do get a valid hash
        if (tempHash.isValid()) {
          nonce = randNonce;
          curHash = tempHash;
          return;
        } // if
      } catch (NoSuchAlgorithmException e) {
      } // catch
    } // while
  } // Block (int, int, Hash)

  Block(int num, int amount, Hash prevHash, long nonce) {
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    this.nonce = nonce;

    try {
      this.curHash = calculateHash(nonce);
    } catch (NoSuchAlgorithmException e) {
    } // catch

  } // Block(int, int, Hash, long)

  /*
   * Calculates the hash
   */
  public Hash calculateHash(long nonce) throws NoSuchAlgorithmException {
    // creates a message digest object
    MessageDigest md = MessageDigest.getInstance("sha-256");
    // intializes byte array of block # you're on
    byte[] numbytes = ByteBuffer.allocate(Integer.BYTES).putInt(this.num).array();
    // updates numbytes array
    md.update(numbytes);
    // intializes byte array of amount # you're on
    byte[] amountbytes = ByteBuffer.allocate(Integer.BYTES).putInt(this.amount).array();
    // update amount bytes array
    md.update(amountbytes);
    // if block # doesn't equal 0, then update it with previous hash
    if (num != 0) {
      md.update(prevHash.getData());
    } // if
    // update lbytes array based on nonce
    byte[] lbytes = ByteBuffer.allocate(Long.BYTES).putLong(nonce).array();
    md.update(lbytes);
    // returns the new hash
    return new Hash(md.digest());
  } // calculateHash(String)

  /**
   * Gets the number of the block, will be the index of the block in a BlockChain
   * 
   * @return
   */
  public int getNum() {
    return this.num;
  } // getNum()

  /**
   * Gets the amount of the block, will be the amount of 'money' transfered in the block
   * 
   * @return
   */
  public int getAmount() {
    return this.amount;
  } // getAmount()

  /**
   * Gets the nonce, the number to calculate the hash with
   * 
   * @return
   */
  public long getNonce() {
    return this.nonce;
  } // getNonce

  /**
   * Gets the previous Hash, will make sure that there were no elements added in the middle of the
   * chain
   * 
   * @return
   */
  public Hash getPrevHash() {
    return this.prevHash;
  } // getPrevHash()

  /**
   * Gets the current Hash, allows the user to control valid nonces and Hashes and track if the
   * following element is correct
   * 
   * @return
   */
  public Hash getHash() {
    return this.curHash;
  } // getHash()

  /**
   * Turns the Block into a string
   */
  public String toString() {
    return "Block " + num + " (Amount: " + amount + ", Nonce: " + nonce + ", prevHash: " + prevHash
        + ", hash: " + curHash + ")";
  } // toString()

} // class Block
