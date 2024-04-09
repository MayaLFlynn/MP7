import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.ByteBuffer;
import java.util.Random;

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
        long randNonce = rand.nextLong();
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

  public int getNum() {
    return this.num;
  } // getNum()

  public int getAmount() {
    return this.amount;
  } // getAmount()

  public long getNonce() {
    return this.nonce;
  } // getNonce

  public Hash getPrevHash() {
    return this.prevHash;
  } // getPrevHash()

  public Hash getHash() {
    return this.curHash;
  } // getHash()

  public String toString() {
    return "Block " + num + " (Amount: " + amount + ", Nonce: " + nonce + ", prevHash: " + prevHash + ", hash: "
        + curHash + ")";
  } // toString()

  // this might go to experiments
  /*
   * long count = 0;
   * long startTime = System.currentTimeMillis();
   * Hash hash;
   * long nonce;
   * do {
   * nonce = rand.nextLong();
   * hash = computeHash(num, amount, prevHash, nonce);
   * ++count;
   * if (VERBOSE && (0 == (count % 100000))) {
   * System.err.printf("Generated %d nonces in %d milliseconds.\n",
   * count,
   * System.currentTimeMillis() - startTime);
   * }
   * } while (! hash.isValid());
   * /*
   */

} // class Block