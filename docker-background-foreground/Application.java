import java.util.Scanner;

class Application {
    public static void main(String[] args) {
        System.out.println("Hello Docker from Java!");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 1000; i++) {
            System.out.println("Provide next input: ");
            String line = input.nextLine();
            System.out.println("Output " + i + ": " + line);
        }
    }
}
