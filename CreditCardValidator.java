import java.util.Scanner;

public class CreditCardValidator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Card Number: ");
        String cardNumber = input.nextLine();

        int length = cardNumber.length();

        String cardType = "";

        if (cardNumber.length() > 0){
            if (cardNumber.charAt(0) == '4'){
                cardType = "Visa Card";
            }
            else if (cardNumber.charAt(0) == '5'){
                cardType = "MasterCard";
            }
            else if (cardNumber.charAt(0) == '3' && cardNumber.charAt(1) == '7'){
                cardType = "American Express Card";
            }
            else if (cardNumber.charAt(0) == '6'){
                cardType = "Discover Card";
            }
            else{
                cardType = "Invalid Card";
            }
        }


        int[] digits = new int[length];
        for (int index = 0; index < length; index++){
            digits[index] = cardNumber.charAt(index) - '0';
        }


        int sumOfEvenPlaces = 0;
        int sumOfOddPlaces = 0;


        int counter = 0;
        int currentDigit = 0;
        for (int index = length - 1; index >= 0; index--){
            currentDigit = digits[index];

            if (counter % 2 == 1){
                int doubled = currentDigit * 2;

                if (doubled > 9){
                    int firstDigit = doubled / 10;
                    int secondDigit = doubled % 10;
                    doubled = firstDigit + secondDigit;
                }
                sumOfEvenPlaces += doubled;
            }
            else{
                sumOfOddPlaces += currentDigit;
            }
            
            counter += 1;
        }


        int totalSum = sumOfEvenPlaces + sumOfOddPlaces;
        String validity = "Invalid";
        

        if (length >= 13 && length <= 16 && cardType != "Invalid Card" && totalSum % 10 == 0){
            validity = "Valid";
        }

        System.out.println("**************************************************");
        System.out.println("Credit Card Type: " + cardType);
        System.out.println("Credit Card Number: " + cardNumber);
        System.out.println("Credit Card Digit Length: " + length);
        System.out.println("Credit Card Validity Status: " + validity);
        System.out.println("**************************************************");

    }
}

