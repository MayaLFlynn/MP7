import java.io.PrintWriter;
import javax.print.event.PrintEvent;

/**
 * 
 * Node is from a lab /////
 */

public class BlockChain {
  // FIELDS
  Node first;
  Node last;
  int size;

  public static class Node {
    /**
     * The previous node.
     */
    Node prev;

    /**
     * The stored value.
     */
    Block value;

    /**
     * The next node.
     */
    Node next;

    // +--------------+------------------------------------------------
    // | Constructors |
    // +--------------+

    /**
     * Create a new node.
     */
    public Node(Node prev, Block value, Node next) {
      this.prev = prev;
      this.value = value;
      this.next = next;
    } // Node(Node, Block, Node)

    /**
     * Create a new node with no previous link. (E.g., the front of some kinds of lists.)
     */
    public Node(Block value, Node next) {
      this(null, value, next);
    } // Node(Block, Node)

    /**
     * Create a new node with no next link. (Included primarily for symmetry.)
     */
    public Node(Node prev, Block value) {
      this(prev, value, null);
    } // Node(Node, Block)

    /**
     * Create a new node with no links.
     */
    public Node(Block value) {
      this(null, value, null);
    } // Node2(T)

    // +---------+-----------------------------------------------------
    // | Methods |
    // +---------+

    /**
     * Insert a new value after this node. Returns the new node.
     */
    public Node insertAfter(Block value) {
      Node tmp = new Node(this, value, this.next);
      if (this.next != null) {
        this.next.prev = tmp;
      } // if
      this.next = tmp;
      return tmp;
    } // insertAfter

    /**
     * Insert a new value before this node. Returns the new node.
     */
    public Node insertBefore(Block value) {
      Node tmp = new Node(this.prev, value, this);
      if (this.prev != null) {
        this.prev.next = tmp;
      } // if
      this.prev = tmp;
      return tmp;
    } // insertBefore

    /**
     * Remove this node.
     */
    public void remove() {
      if (this.prev != null) {
        this.prev.next = this.next;
      }
      if (this.next != null) {
        this.next.prev = this.prev;
      }
      this.prev = null;
      this.next = null;
    } // remove()
  } // class Node

  // CONSTRUCTORS
  BlockChain(int initial) {
    Block blk = new Block(initial, initial, null);
    Node node = new Node (blk, null);
    first = node;
    last = node;
    size = 1;
  } // BlockChain

  // METHODS
  public Block mine(int amount) {
    return first.value; // STUB
  } // mine

  public int getSize() {
    return size;
  } // getSize()

  public void append(Block blk) throws IllegalArgumentException {
    //Node.insertAfter(blk);
    size++;
  } // append(Block)

  public boolean removeLast() {
    return true; // STUB
  } // removeLast()

  public Hash getHash() {
    return getHash();
  } // getHash

  public boolean isValidBlockChain() {
    return true; // STUB
  } // isValidBlockChain

  public void printBalances(PrintWriter pen) {
    pen.println("This is cool");
  } // printBalances(PrintWriter)

  public String toString() {
    return "Why implement so many things";
  }
} // BlockChain