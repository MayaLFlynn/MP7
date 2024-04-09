import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * The hash class calculates an identifier which is used to compare objects. 
 * 
 * @author Alyssa Trapp
 * @author Maya Flynn
 * 
 */


 // byte array is being wrapped in the wrapper class already 
 // a hash is just an array of bytes
 // hash: an identifier used to compare objects

public class Hash {


  //FIELDS
  byte[] hasharr;


  //CONTSTRUCTOR
  public Hash(byte[] data) {
    this.hasharr = data;
  } // Hash(byte[])

/*
 * Calculates the hash 
 */
  public static byte[] calculateHash(String msg) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("sha-256");
    md.update(msg.getBytes());
    byte[] hash = md.digest();
    return hash;
  } // calculateHash(String)


//METHODS

/*
 * Retrieves the byte array
 */
  public byte[] getData() {
    return this.hasharr;
  } // getData()

/*
 * Checks if it's a valid hash
 */

  public boolean isValid() {
    // checks if the the value at index 0, index 1, or index 2 is at 0
    return ((hasharr[0] == 0) && ((hasharr[1] == 0)) && (hasharr[2] == 0));
  } //isValid
  

 /*
  * Converts the hash value into a string 
  */
  public String toString() {
    // stores temparr
    String [] temparr = new String[hasharr.length];
    // loops for hasharr length
    for(int i = 0; i < hasharr.length; i++){
    // converts the bytes at the temp arr index to string
       temparr[i] = String.format ("%x", Byte.toUnsignedInt(hasharr[i]));
    } // for
    // returns entire array as a string
    return temparr.toString();
    } //toString()

   /*
    * Checks to see if object is a Hash type or not 
    */
  public boolean equals(Object other) {
    if (other instanceof Hash == false){
      return false;
    } // if
    Hash temphash = (Hash)other;
      return (Arrays.equals (temphash.getData(), this.getData()));
  } // equals (Object)
} // class Hash
