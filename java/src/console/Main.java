package console;

import console.utils.MainUtils;

import java.util.Scanner;

public class Main {

  public static void log(String message) {
    System.out.println(message);
  }

  static String farewellMessage = "Goodbye Mighty Ruler!";

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

      MainUtils.handleCommand(input);
    }
    log("Press any key to exit...");
    scanner.nextLine();
  }
}
