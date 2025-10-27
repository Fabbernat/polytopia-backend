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
    readGuidReferenceDotTxt();
    readGamesDotTxt();
  }


  private void readGuidReferenceDotTxt() {
    try (Scanner scanner = new Scanner(new File("guidReference.txt"))) {
      if (scanner.hasNextLine()) {
        try {
          String line = scanner.nextLine();
          log("Read in guid reference: " + line);
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
      log("Read in games: ");
      for (String line : lines) {
        log(line);
      }
      games.addAll(lines);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
