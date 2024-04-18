import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Application {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Katalog do przeskanowania:");
        String dir = scanner.nextLine();
        Path dirPath = Path.of(dir);
        if (Files.exists(dirPath)) {
            try (Stream<Path> paths = Files.walk(dirPath)) {
                String allFiles = paths
                        .map(path -> path.getFileName().toString())
                        .collect(Collectors.joining("\n"));
                if (allFiles.isEmpty()) {
                    System.out.println("Brak plików");
                } else {
                    System.out.println(allFiles);
                }
            }
        } else {
            System.out.println("Katalog nie istnieje");
        }
    }
}
