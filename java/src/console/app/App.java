package console.app;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static console.Main.log;

public class App {
  static int guid = 1;
  static List<String> games = new ArrayList<>();

  public App() {
    readGuidReference();
    readGames();
  }


  private void readGuidReference() {
      try (InputStream input = App.class.getResourceAsStream("/guidReference.txt")) {
          if (input == null) {
              log("guidReference.txt not found!");
              return;
          }
          log(input.toString());

          List<String> lines = new java.io.BufferedReader(
                  new java.io.InputStreamReader(input)
          ).lines().toList();

          log("Read in guid reference:");
          lines.forEach(System.out::println);

          guid = Integer.parseInt(lines.getFirst().trim());

      } catch (Exception e) {
          e.printStackTrace();
      }
  }

    private void readGames() {
        try (InputStream input = App.class.getResourceAsStream("/games.txt")) {
            if (input == null) {
                log("games.txt not found!");
                return;
            }

            List<String> lines = new java.io.BufferedReader(
                    new java.io.InputStreamReader(input)
            ).lines().toList();

            log("Read in games:");
            games.clear();
            games.addAll(lines);
            reportGames();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void reportGames() {
    games.forEach(System.out::println);
  }

}
