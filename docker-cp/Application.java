import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

class Application {
    private static final int WRITE = 0;
    private static final int READ = 1;
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Zapisać (0), czy odczytać (1) plik?");
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option == WRITE) {
            writeFile();
        } else if (option == READ) {
            readFile();
        }
    }

    private static void writeFile() {
        System.out.println("Podaj ścieżkę pliku, który chcesz zapisać:");
        String fileName = scanner.nextLine();
        System.out.println("Zawartość pliku:");
        String fileContent = scanner.nextLine();
        Path path = Path.of(fileName);
        try {
            Files.writeString(path, fileContent, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Zapisano plik " + fileName);
        } catch (IOException e) {
            System.err.println("Nie udało się zapisać pliku " + fileName);
        }
    }

    private static void readFile() {
        System.out.println("Podaj ścieżkę do pliku, który chcesz odczytać:");
        String fileName = scanner.nextLine();
        Path filePath = Path.of(fileName);
        if (Files.exists(filePath)) {
            try {
                String fileContent = Files.readString(Path.of(filePath.toUri()));
                System.out.println("Zawartość pliku:");
                System.out.println(fileContent);
            } catch (IOException e) {
                System.err.println("Nie udało się odczytać pliku " + fileName);
            }

        } else {
            System.out.printf("PLik %s nie istnieje%n", fileName);
        }

    }
}
