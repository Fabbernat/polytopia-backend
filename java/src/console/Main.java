package console;

import console.app.ConsoleApp;
import console.app.ConsoleAppUtils;
import console.app.main.DesktopApp;

import java.util.Objects;
import java.util.Scanner;

public class Main {

  public static void log(String message) {
    System.out.println(message);
  }

  static String farewellMessage = "Goodbye Mighty Ruler!";

  public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
//      console();
      createLoop(scanner, "desktop");
  }

    private static void desktop(String choice) {
      DesktopApp desktopApp = new DesktopApp(choice);
    }

    private static void console(Scanner scanner) {
        ConsoleApp consoleApp = new ConsoleApp();
        createLoop(scanner, "console");
        exit(scanner);
    }

    public static void exit(Scanner scanner) {
        log("Press any key to exit...");
        scanner.nextLine();
    }

    private static void createLoop(Scanner scanner, String appType) {
        while (true) {
            if ("console".equals(appType)) {
                log("Polytopia CLI started. Type `start \"Game Name\"` or just `start` to start a new game.\n Example: start \"Misty Clouds\"\nType `help` to get the list of available commands.\n`exit` to quit.");
            } else {
                log("Polytopia Desktop app started. Press ENTER to start generating");
            }
            System.out.print ("> ");
            String input = scanner.nextLine().trim();
            input = input.toLowerCase();

            if ("exit".equals(input) || "quit".equals(input)) {
                log(farewellMessage);
                break;
            }
            if ("console".equals(appType)) {
                ConsoleAppUtils.handleCommand(input);
            } else {
                log("""
                  Choose map type!
                  0 - Drylands
                  1 - Lakes
                  2- Conti
                  3 - Archi
                  4 - Water World""");
                String choice = scanner.nextLine();
                desktop(choice);
                log("Press ENTER to continue, type `exit` to quit.");
            }
        }
    }
}
