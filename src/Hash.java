import java.util.Arrays;

/**
 * A Hash is an array of bytes that will be used to compare objects
 * 
 * @author Alyssa Trapp
 * @author Maya Flynn
 * 
 */
public class Hash {


  // FIELDS
  byte[] hasharr;


  // CONTSTRUCTOR
  public Hash(byte[] data) {
    this.hasharr = data;
  } // Hash(byte[])


  // METHODS

  /*
   * Retrieves the byte array
   */
  public byte[] getData() {
    return this.hasharr;
  } // getData()

  /*
   * Checks if it is a valid hash
   */
  public boolean isValid() {
    // checks if the the value at index 0, index 1, or index 2 is at 0
    return ((hasharr[0] == 0) && ((hasharr[1] == 0)) && (hasharr[2] == 0));
  } // isValid


  /*
   * Converts the hash value into a string
   */
  public String toString() {
    // stores temparr
    String[] temparr = new String[hasharr.length];
    StringBuilder toReturn = new StringBuilder();
    // loops for hasharr length
    for (int i = 0; i < hasharr.length; i++) {
      // converts the bytes at the temp arr index to string
      temparr[i] = String.format("%x", Byte.toUnsignedInt(hasharr[i]));
      toReturn.append(temparr[i]);
    } // for
    // returns entire array as a string
    return toReturn.toString();
  } // toString()

  /*
   * Checks to see if an Object is equal to the hash.
   */
  public boolean equals(Object other) {
    if (other instanceof Hash == false) {
      return false;
    } // if
    Hash temphash = (Hash) other;
    return (Arrays.equals(temphash.getData(), this.getData()));
  } // equals (Object)
} // class Hash
