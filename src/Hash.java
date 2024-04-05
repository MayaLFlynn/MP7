import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class does something with Hashs, I don't know
 * 
 * @author Alyssa Trapp
 * @author Maya Flynn
 * 
 * calculateHash was given by Sam R
 */

public class Hash {

public static byte[] calculateHash(String msg) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    md.update(msg.getBytes());
    byte[] hash = md.digest();
    return hash;
} // calculateHash(String)

  //FIELDS
  byte[] hash; //This might be horribly wrong


  //CONTSTRUCTOR
  
  public Hash(byte[] data) {
    //STUB
  } // Hash(byte[])

  public byte[] getData() {
    return this.hash; //STUB
  } // getData()

  public boolean isValid() {
    return true; //STUB
  } // isValid()
  
  public String toString() {
    return "This has definitly been implemented";
  } // toString()

  public boolean equals(Object other) {
    return true; //STUB
  } // equals
}
