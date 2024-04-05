public class Block {

  //FIELDS
  int num;
  int amount;
  Hash prevHash;
  long nonce;
  Hash curHash;

  Block(int num, int amount, Hash prevHash) {
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    //mines a nonce
    while(true) {
      // if (algorithmToTurnNonceIntoHash(nonce) has three zeros on the front) {
        break;
      // } else {
        // nonce++;
      // }
    } // while
    byte[] zerosHash = {(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}; //figure out how to turn a nonce into a byte[] ie turn nonce into hash
    this.curHash = new Hash(zerosHash); //STUB
  } // Block(int, int, Hash)

  Block(int num, int amount, Hash prevHash, long nonce) {
    this.num = num;
    this.amount = amount;
    this.prevHash = prevHash;
    this.nonce = nonce;
    byte[] zerosHash = {(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}; //figure out how to turn a nonce into a byte[] ie turn nonce into hash
    this.curHash = new Hash(zerosHash); //STUB

  } // Block(int, int, Hash, long)

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
    return "Block " + num + " (Amount: " + amount + ", Nonce: " + nonce + ", prevHash: " + prevHash + ", hash: " + curHash + ")";
  } // toString()
} // class Block
