import java.io.PrintWriter;
import java.util.Scanner;

public class BlockChainDriver {


  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    String section = "~~~~~~~~~~~~~~~~~~~~~~";
    Scanner sc = new Scanner(System.in);
    String nextLine;
    BlockChain blockChain = new BlockChain(Integer.parseInt(args[0]));

    int alexisAmount = Integer.parseInt(args[0]); // do you know a better way to turn strings to
                                                  // ints? I don't know if this works.
    int blakeAmount = 0; // I don't think these are necessary. I think they can get replace with a
                         // call to

    String validCommands = "mine: disovers the nonce for a given transaction \n"
        + "append: appends a new block onto the end of the chain \n"
        + "remove: removes the last block from the end of the chain \n"
        + "check: checks that the block chain is valid \n"
        + "report: reports the balances of Alexis and Blake \n"
        + "help: prints this list of commands \n" + "quit: quits the program";
    pen.println(validCommands);
    pen.println("Command? ");
    while (!(nextLine = sc.nextLine()).equals("quit")) {

      if (nextLine == "mine") { // mine
        pen.print("Amount transferred? ");
        pen.flush();
        String amountTransfered = sc.nextLine();
        long nonce = 0; ////////////////////////////////////////////////////////// mine a nonce
                        ////////////////////////////////////////////////////////// ///STUB
        pen.println("amount = " + amountTransfered + ", nonce = " + nonce);
      } else if (nextLine == "append") { // append
        pen.print("Amount transferred? ");
        pen.flush();
        String amountTransfered = sc.nextLine();
        pen.print("Nonce? ");
        pen.flush();
        String nonce = sc.nextLine();
        Block blk = new Block(alexisAmount, blakeAmount, blockChain.getHash(), (long) nonce);
        blockChain.append(blk); ///////////////
      } else if (nextLine == "remove") { // remove
        blockChain.removeLast();
      } else if (nextLine == "check") { // check
        // STUB
      } else if (nextLine == "report") { // report
        // STUB
      } else if (nextLine == "help") { // help
        pen.println(validCommands);
      } else if (nextLine == "quit") { // quit
        break;
      } else {
        pen.println("type 'help' for valid commands");
      } // if branch that determines what command is being requested

      pen.println("\n" + blockChain.toString() + "\n");
      pen.print("Command? ");
      pen.flush();
    }


  }
}
