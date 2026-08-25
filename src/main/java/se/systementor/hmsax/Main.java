package se.systementor.hmsax;

public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome to \"Programmering med Java, grund\"!\n");
        //Notera radbrytning med \n ovan. Nedan bjussar jag på en gratis for-loop
        for (int i = 1; i <= 5; i++) {
            int countdownInt = 5 - i;
            System.out.println("T minus " + (countdownInt + 1)); // Parentes runt operationen för att undvika Strängkonkatenering
            if (countdownInt == 0) {
                System.out.println("TAKEOFF!");
            }
        }
    }
}