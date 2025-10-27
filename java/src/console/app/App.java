package console.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static console.Main.log;

public class App {
  static int guid = 1;
  List<String> games = new ArrayList<>();

  public App() {
    readGuidReferenceDotTxt();
    readGamesDotTxt();
  }


  private void readGuidReferenceDotTxt() {
    try (InputStream input = App.class.getResourceAsStream("/guidReference.txt")) {
      if (input == null) {
        log("guidReference.txt not found!");
        return;
      }
      List<String> lines = Files.readAllLines(
              Paths.get(Objects.requireNonNull(App.class.getResource("/guidReference.txt")).toURI())
      );
      log("Read in guid reference: ");
      lines.forEach(System.out::println);
      try {
        guid = Integer.parseInt(lines.getFirst());
      } catch (NumberFormatException numberFormatException) {
        numberFormatException.printStackTrace();
      }
    } catch (IOException | URISyntaxException exception) {
      exception.printStackTrace();
    }
    /*try (Scanner scanner = new Scanner(new File("/guidReference.txt"))) {
      if (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        try {
          guid = Integer.parseInt(line);
        } catch (NumberFormatException numberFormatException) {
          numberFormatException.printStackTrace();
        }
      }
    } catch (FileNotFoundException fileNotFoundException) {
      fileNotFoundException.printStackTrace();
    }*/
  }

  private void readGamesDotTxt() {
    try (InputStream input = App.class.getResourceAsStream("/games.txt")) {
      if (input == null) {
        log("games.txt not found!");
        return;
      }
      List<String> lines = Files.readAllLines(
              Paths.get(Objects.requireNonNull(App.class.getResource("/games.txt")).toURI())
      );
      log("Read in games: ");
      lines.forEach(System.out::println);
      games.addAll(lines);
    } catch (IOException | URISyntaxException ioException) {
      ioException.printStackTrace();
    }

    /*try {
      List<String> lines = Files.readAllLines(Paths.get("/games.txt"));
      for (String line : lines) {
        log(line);
      }
      games.addAll(lines);
    } catch (IOException e) {
      e.printStackTrace();
    }*/
  }

}
