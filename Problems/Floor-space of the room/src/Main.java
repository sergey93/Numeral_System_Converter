import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String shape = scanner.nextLine();
        switch (shape) {
            case "triangle": {
                double a = scanner.nextInt();
                double b = scanner.nextInt();
                double c = scanner.nextInt();
                double p = (a + b + c) / 2;
                System.out.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
                break;
            }
            case "rectangle": {
                double a = scanner.nextInt();
                double b = scanner.nextInt();
                System.out.println(a * b);
                break;
            }
            case "circle": {
                int r = scanner.nextInt();
                System.out.println(3.14 * r * r);
                break;
            }
        }
    }
}