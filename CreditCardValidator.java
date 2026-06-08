public class CreditCardValidator{

    public static void main(String[] args){


        String cardNumber = "468368746945295";

        System.out.println("**************************************************");
        System.out.println("Credit Card Type: " + getCardType(cardNumber));
        System.out.println("Credit Card Number: " + cardNumber);
        System.out.println("Credit Card Digit Length: " + getCardLength(cardNumber));
        System.out.println("Credit Card Validity Status: " + getCardValidity(cardNumber));
        System.out.println("**************************************************");

    }

    public static String getCardType(String cardNumber){
        String cardType = "";

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
        
        return cardType;

    }

    public static int getCardLength(String cardNumber){
        int length = cardNumber.length();
        return length;
    }

    public static int lhunAlgorithm(String cardNumber){

        int cardLength = getCardLength(cardNumber);

        int[] digits = new int[cardLength];
        for (int index = 0; index < cardLength; index++){
            digits[index] = cardNumber.charAt(index) - '0';
        }


        int sumOfEvenPlaces = 0;
        int sumOfOddPlaces = 0;


        int counter = 0;
        int currentDigit = 0;
        for (int index = cardLength - 1; index >= 0; index--){
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

        return totalSum;
    }

    public static String getCardValidity(String cardNumber){
        String cardType = getCardType(cardNumber);
        int cardLength = getCardLength(cardNumber);
        int luhnAlgorithm = lhunAlgorithm(cardNumber);

        String validity = "Invalid";

        if(cardLength >= 13 && cardLength <= 16 && cardType != "Invalid Card" && luhnAlgorithm % 10 == 0){
            validity = "Valid";
        }

        return validity;
    }
}


