package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        try {
            int sourceRadix = Integer.parseInt(scanner.nextLine());
            String sourceNumber = scanner.nextLine().toLowerCase();
            int targetRadix = Integer.parseInt(scanner.nextLine());
            if (targetRadix < 1 || targetRadix > 36) {
                System.out.println("Error: invalid target radix");
                return;
            }
            if (sourceRadix < 1 || sourceRadix > 36) {
                System.out.println("Error: invalid source radix");
                return;
            }
            System.out.println(NumeralSystemConverter.convertNumber(sourceRadix, sourceNumber, targetRadix));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}