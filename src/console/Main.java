import Settings.ValidCommands;

import java.util.Scanner;

public class Main {

  public static void log(String message) {
    System.out.println(message);
  }

  static String farewellMessage = "Goodbye Commander!";

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    log("Polytopia CLI started. Type `start \"Game Name\"` or just `start` to start a new game.\n Example: start \"Misty Clouds\"\nType `help` to get the list of available commands.\n`exit` to quit.");

    while (true) {
      log ("> ");
      String input = scanner.nextLine().trim();
      input = input.toLowerCase();

      if ("exit".equals(input) || "quit".equals(input)) {
        log(farewellMessage);
        break;
      }

      handleCommand(input);
    }
    log("Press any key to exit...");
    scanner.nextLine();
  }

  private static void handleCommand(String input){
    if (input.isEmpty())
      return;

    if (input.equals("help")) {
      log("Available commands:" + ValidCommands.ALL_COMMANDS);
      return;
    }

    // Check menu base commands
    for (String command : ValidCommands.MENU_COMMANDS) {
      if ("start".startsWith(command)) {
        String gameName = getRemainder(input, command);
        report("New game started: " + gameName);
      } else if ("delete".startsWith(command)) {
        String gameName = getRemainder(input, command);
        report("Deleted game: " + gameName);
      }
    }
    if (ValidCommands.MENU_COMMANDS.contains(input)) {
      log("Executed base command: " + input);
      return;
    }
  }

  private static String getRemainder(String input, String cmd) {
    return input.substring(cmd.length()).trim();
  }

  private static int stars = 5;
  private static int score = 500;
  private static int turn = 0;
  private static String tabulators = "\t\t\t\t\t\t\t\t";

  private static void report() {
    log("|--- " + stars + " stars | " + score + " score | " + turn + "th turn" + " ---|" + tabulators + "\n");
  }

  private static void report(String message) {
    log("|--- " + stars + " stars | " + score + " score | " + turn + "th turn" + " ---|" + tabulators + "\n" + message);
  }
}
