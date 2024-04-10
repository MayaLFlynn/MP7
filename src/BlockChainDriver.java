import java.io.PrintWriter;
import java.util.Scanner;


/**
 * BlockChainDriver provides a system for the user to interact with BlockChain.
 * 
 * @author Alyssa Trapp
 * @author Maya Flynn
 */
public class BlockChainDriver {


  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    Scanner sc = new Scanner(System.in);
    String nextLine;
    BlockChain blockChain = new BlockChain(Integer.parseInt(args[0]));

    String validCommands = "mine: disovers the nonce for a given transaction \n"
        + "append: appends a new block onto the end of the chain \n"
        + "remove: removes the last block from the end of the chain \n"
        + "check: checks that the block chain is valid \n"
        + "report: reports the balances of Alexis and Blake \n"
        + "help: prints this list of commands \n" + "quit: quits the program";


    pen.print("Command? ");
    pen.flush();
    nextLine = sc.nextLine();
    while (!(nextLine.equals("quit"))) {

      if (nextLine.equals("quit")) {
        sc.close();
        pen.close();
        return;
      } else if (nextLine.equals("mine")) { // mine
        pen.print("Amount transferred? ");
        pen.flush();
        String amountTransferedStr = sc.nextLine();
        int amountTransfered = Integer.parseInt(amountTransferedStr);
        long nonce = blockChain.mine(amountTransfered).getNonce();
        pen.println("amount = " + amountTransfered + ", nonce = " + nonce);
      } else if (nextLine.equals("append")) { // append
        pen.print("Amount transferred? ");
        pen.flush();
        String amountTransferedStr = sc.nextLine();
        int amountTransfered = Integer.parseInt(amountTransferedStr);
        pen.print("Nonce? ");
        pen.flush();
        String nonceStr = sc.nextLine();
        long nonce = Integer.parseInt(nonceStr);
        Block blk = new Block(0, amountTransfered, blockChain.getHash(), (long) nonce);
        blockChain.append(blk);
      } else if (nextLine.equals("remove")) { // remove
        blockChain.removeLast();
      } else if (nextLine.equals("check")) { // check
        if (blockChain.isValidBlockChain()) {
          pen.println("Chain is valid!");
        } else {
          pen.println("Chain is invalid!");
        }
      } else if (nextLine.equals("report")) { // report
        blockChain.printBalances(pen);
      } else if (nextLine.equals("help")) { // help
        pen.println(validCommands);
      } else {
        pen.println("type 'help' for valid commands");
      } // if branch that determines what command is being requested

      pen.println("\n" + blockChain.toString() + "\n");
      pen.print("Command? ");
      pen.flush();
      nextLine = sc.nextLine();
    }

    sc.close();
    pen.close();
  } // main(String[])
} // class BlockChainDriver
