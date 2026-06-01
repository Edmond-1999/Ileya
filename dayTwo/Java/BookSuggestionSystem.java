import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BookSuggestionSystem {

    public static String getSuggestion(ArrayList<String> books) {

        Random random = new Random();

        int randomBook = random.nextInt(books.size());
        int randomPage = random.nextInt(100) + 1;

        return "\nBook for the Day\n"
                + "Book Title: " + books.get(randomBook)
                + "\nPage: " + randomPage;
    }

    public static String addBook(ArrayList<String> books, String newBook) {

        boolean found = false;

        for (int count = 0; count < books.size(); count++) {

            if (books.get(count).equalsIgnoreCase(newBook)) {
                found = true;
            }
        }

        if (found) {
            return "Book already exists!";
        }

        books.add(newBook);
        return "Book added successfully!";
    }

    public static String removeBook(ArrayList<String> books, String bookTitle) {

        for (int count = 0; count < books.size(); count++) {

            if (books.get(count).equalsIgnoreCase(bookTitle)) {

                books.remove(count);
                return "Book removed successfully!";
            }
        }

        return "Book not found!";
    }

    public static String updateBook(ArrayList<String> books, String oldTitle, String newTitle) {

        for (int count = 0; count < books.size(); count++) {

            if (books.get(count).equalsIgnoreCase(oldTitle)) {

                books.set(count, newTitle);
                return "Book updated successfully!";
            }
        }

        return "Book not found!";
    }

    public static String showBooks(ArrayList<String> books) {

        String allBooks = "\nAll Books\n";

        for (int count = 0; count < books.size(); count++) {

            allBooks = allBooks + (count + 1) + ". "
                    + books.get(count) + "\n";
        }

        return allBooks;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<String> books = new ArrayList<String>();

        books.add("The Hobbit");
        books.add("The Mystery");
        books.add("Animal Farm");
        books.add("Brave Kingdom");

        int number = 0;

        while (number != 6) {

            System.out.println("\nWelcome to the Book Suggestion System!");
            System.out.println("1. Get Suggestions");
            System.out.println("2. Add Book");
            System.out.println("3. Remove Book");
            System.out.println("4. Update Book");
            System.out.println("5. Show All Books");
            System.out.println("6. Exit");

            System.out.print("Enter action: ");
            number = input.nextInt();
            input.nextLine();


            switch (number) {
                case 1:
                    String answer = "yes";
                    while (answer.equalsIgnoreCase("yes")) {
                        System.out.println(getSuggestion(books));
                        System.out.print("Would you like another suggestion? (yes/no): ");
                        answer = input.nextLine();
                    }
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    String newBook = input.nextLine();
                    System.out.println(addBook(books, newBook));
                    break;

                case 3:
                    System.out.print("Enter book title to remove: ");
                    String bookTitle = input.nextLine();
                    System.out.println(removeBook(books, bookTitle));
                    break;

                case 4:
                    System.out.print("Enter old title: ");
                    String oldTitle = input.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = input.nextLine();
                    System.out.println(updateBook(books, oldTitle, newTitle));
                    break;

                case 5:
                    System.out.println(showBooks(books));
                    break;

                case 6:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}

