import java.util.Scanner;

public class ShapeDrawer {
    public static void main(String[] args) {
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);

        while (repeat) {
            System.out.println("Choose a shape to draw: triangle, square, or diamond");
            String shape = scanner.nextLine().toLowerCase();

            System.out.print("Enter the height of the shape: ");
            int height = scanner.nextInt();

            if (height < 1) {
                System.out.println("Invalid input for height. Please enter a positive integer.");
                continue;
            }

            switch (shape) {
                case "triangle":
                    drawTriangle(height);
                    break;
                case "square":
                    drawSquare(height);
                    break;
                case "diamond":
                    drawDiamond(height);
                    break;
                default:
                    System.out.println("Invalid shape choice. Please choose triangle, square, or diamond.");
                    break;
            }

            System.out.print("Do you want to draw another shape? (yes/no): ");
            String response = scanner.next().toLowerCase();
            repeat = response.equals("yes");

            // Consume the newline character
            scanner.nextLine();
        }

        scanner.close();
    }

    static void drawTriangle(int height) {
        for (int i = 1; i <= height; i++) {
            String spaces = " ".repeat(height - i);
            String stars = "*".repeat(2 * i - 1);
            System.out.println(spaces + stars);
        }
    }

    static void drawSquare(int height) {
        String row = "*".repeat(height);
        for (int i = 0; i < height; i++) {
            System.out.println(row);
        }
    }

    static void drawDiamond(int height) {
        for (int i = 1; i <= height; i += 2) {
            String spaces = " ".repeat((height - i) / 2);
            String stars = "*".repeat(i);
            System.out.println(spaces + stars);
        }

        for (int i = height - 2; i >= 1; i -= 2) {
            String spaces = " ".repeat((height - i) / 2);
            String stars = "*".repeat(i);
            System.out.println(spaces + stars);
        }
    }
}
