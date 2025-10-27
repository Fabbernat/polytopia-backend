package console.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static console.Main.log;

public class App {
  static int guid = 1;
  List<String> games = new ArrayList<>();
  public App(){
    readGuidDotTxt();
    readGamesDotTxt();
  }


  private void readGuidDotTxt() {
    try (Scanner scanner = new Scanner(new File("guid.txt"))) {
      if (scanner.hasNextLine()) {
        try {
          String line = scanner.nextLine();
          log(line);
          guid = Integer.parseInt(line);
        } catch (NumberFormatException numberFormatException) {
          numberFormatException.printStackTrace();
        }
      }
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }
  }

  private void readGamesDotTxt() {
    try {
      List<String> lines = Files.readAllLines(Paths.get("games.txt"));
      for (String line : lines) {
        System.out.println(line);
      }
      games.addAll(lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
