package se.systementor.hmsax.lektion5.ovningsuppgifter;

public class G1 {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        for (int num : numbers) {
            System.out.println(num);
        }

        System.out.println("Arrayen rymmer " + numbers.length + " tal.");

        //Alternativ lösning nedan

        int[] numbers2 = new int[5];

        for (int i = 0; i < numbers2.length; i++) {
            numbers2[i] = (i+1)*10; //fyll arrayen med jämna 10-tal på rätt indexplats
        }

        for (int num2 : numbers2) {
            System.out.println(num2);
        }

        System.out.println("Array 2 rymmer " + numbers2.length + " tal.");
    }
}
