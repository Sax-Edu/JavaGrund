package se.systementor.hmsax.lektion4.ovningsuppgifter;

import java.util.Scanner;

public class VG4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Täljare: ");
        String strTaljare = scanner.nextLine();

        System.out.print("Nämnare: ");
        String strNamnare = scanner.nextLine();

        beraknaDivision(strTaljare, strNamnare);

    }

    public static void beraknaDivision(String strTaljare, String strNamnare) {
        try {
            int taljare = Integer.parseInt(strTaljare);
            int namnare = Integer.parseInt(strNamnare);

            if (namnare == 0) {
                throw new ArithmeticException("Kan inte dela med noll.");
            }

            int resultat = taljare / namnare;
            System.out.println(taljare + "/" + namnare + "=" + resultat);

        } catch (NumberFormatException e) {
            // Identifiera vilken variabel som orsakade felet för rätt utskrift
            try {
                Integer.parseInt(strTaljare);
                System.out.println("\"" + strNamnare + "\" är inget tal.");
            } catch (NumberFormatException e2) {
                System.out.println("\"" + strTaljare + "\" är inget tal.");
            }
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
