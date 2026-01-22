package console;

import console.app.ConsoleApp;
import console.app.ConsoleAppUtils;
import console.app.main.DesktopApp;

import java.util.Scanner;

public class Main {

  public static void log(String message) {
    System.out.println(message);
  }

  static String farewellMessage = "Goodbye Mighty Ruler!";

  public static void main(String[] args) {
      desktop();
//      console();
  }

    private static void desktop() {
      DesktopApp desktopApp = new DesktopApp();
    }

    private static void console() {
        ConsoleApp consoleApp = new ConsoleApp();
        Scanner scanner = new Scanner(System.in);
        log("Polytopia CLI started. Type `start \"Game Name\"` or just `start` to start a new game.\n Example: start \"Misty Clouds\"\nType `help` to get the list of available commands.\n`exit` to quit.");

        while (true) {
            System.out.print ("> ");
            String input = scanner.nextLine().trim();
            input = input.toLowerCase();

            if ("exit".equals(input) || "quit".equals(input)) {
                log(farewellMessage);
                break;
            }

            ConsoleAppUtils.handleCommand(input);
        }
        log("Press any key to exit...");
        scanner.nextLine();
    }
}
