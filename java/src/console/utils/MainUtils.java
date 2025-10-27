package console.utils;

import static console.Main.log;

public class MainUtils {
  public static void handleCommand(String input){
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
  private static final String tabulators = "\t\t\t\t\t\t\t\t";

  private static void report() {
    log("|--- " + stars + " stars | " + score + " score | " + turn + "th turn" + " ---|" + tabulators + "\n");
  }

  private static void report(String message) {
    log("|--- " + stars + " stars | " + score + " score | " + turn + "th turn" + " ---|" + tabulators + "\n" + message);
  }
}
