import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Checkout{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);


        ArrayList<String> itemNames = new ArrayList<>();
        ArrayList<Integer> itemQuantities = new ArrayList<>();
        ArrayList<Double> itemPrices = new ArrayList<>();


        System.out.print("What is the customer's name: ");
        String customerName = input.nextLine();

        boolean addMore = true;
        while (addMore){
            System.out.print("What did the customer buy: ");
            String itemName = input.nextLine();

            System.out.print("How many pieces: ");
            int quantity = input.nextInt();

            System.out.print("How much per unit: ");
            double pricePerUnit = input.nextDouble();
            input.nextLine();

            itemNames.add(itemName);
            itemQuantities.add(quantity);
            itemPrices.add(pricePerUnit);

            System.out.print("Add more Items? (yes/no): ");
            String answer = input.nextLine().trim().toLowerCase();
            if (answer.equals("no")) {
                addMore = false;
            }
        }


        System.out.println();

        System.out.print("What is the cashier's name: ");
        String cashierName = input.nextLine();

        System.out.print("How much discount will he get: ");
        double discountPercentage = input.nextDouble();


        double subTotal = 0;
        for (int index = 0; index < itemNames.size(); index++){
            subTotal += itemQuantities.get(index) * itemPrices.get(index);
        }

        double discountAmount = (discountPercentage / 100) * subTotal;

        double vatAmount = 0.075 * subTotal; 
        double billTotal = subTotal - discountAmount + vatAmount;

        //To get the current date and time and to give it a format
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yy HH:mm:ss");
        String formattedDate = now.format(formatter);


        printInvoiceTop(cashierName, customerName, formattedDate);
        printCartItems(itemNames, itemQuantities, itemPrices);
        

        System.out.println("\t\t\tSub Total:\t" + subTotal);
        System.out.println("\t\t\tDiscount:\t" + discountAmount);
        System.out.println("\t\t\tVAT @ 7.5%:\t" + vatAmount);
        System.out.println("=========================================================");
        System.out.println("\t\t\tBill Total:\t" + billTotal);
        System.out.println("=========================================================");
        System.out.println("THIS IS NOT AN RECEIPT KINDLY PAY " + billTotal);
        System.out.println("=========================================================");


        System.out.print("How much did the customer give to you: ");
        double amountPaid = input.nextDouble();
        while (amountPaid < billTotal){
            System.out.print("Insufficient Amount! Pay at least " + billTotal + ". Enter amount: ");
            amountPaid = input.nextDouble();
        }
        double balance = amountPaid - billTotal;


        printInvoiceTop(cashierName, customerName, formattedDate);
        printCartItems(itemNames, itemQuantities, itemPrices);
        

        System.out.println("\t\t\tSub Total:\t" + subTotal);
        System.out.println("\t\t\tDiscount:\t" + discountAmount);
        System.out.println("\t\t\tVAT @ 7.5%:\t" + vatAmount);
        System.out.println("=========================================================");
        System.out.println("\t\t\tBill Total:\t" + billTotal);
        System.out.println("\t\t\tAmount Paid:\t" + amountPaid);
        System.out.println("\t\t\tBalance:\t" + balance);
        System.out.println("=========================================================");
        System.out.println("\t\tTHANK YOU FOR YOUR PATRONAGE");
        System.out.println("=========================================================");
        

    }

    private static void printInvoiceTop(String cashierName, String customerName, String date){
        System.out.println("\nSEMICOLON STORES");
        System.out.println("MAIN BRANCH");
        System.out.println("LOCATION: 312, HERBERT MACAULAY WAY, SABO YABA, LAGOS.");
        System.out.println("TEL: 08044233725");
        System.out.println("Date : " + date);
        System.out.println("Cashier: " + cashierName);
        System.out.println("Customer Name: " + customerName);
        System.out.println("=========================================================");
        System.out.println("ITEM\t\tQTY\tPRICE\t\tTOTAL(NGN)");
        System.out.println("---------------------------------------------------------");
    }

    private static void printCartItems(ArrayList<String> names, ArrayList<Integer> quantity, ArrayList<Double> prices){
        for (int index = 0; index < names.size(); index++) {
            double productTotal = quantity.get(index) * prices.get(index);
            System.out.println(names.get(index) + "\t\t" + quantity.get(index) + "\t" + prices.get(index) + "\t\t" + productTotal);
        }
        System.out.println("---------------------------------------------------------");
    }

}
