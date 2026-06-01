import random

def get_suggestion(books):

    random_book = random.randint(0, len(books) - 1)
    random_page = random.randint(1, 100)

    return "\nBook for the Day\n" + "Book Title: " + books[random_book] + "\nPage: " + str(random_page)


def add_book(books, new_book):

    found = False

    for count in range(len(books)):

        if books[count].lower() == new_book.lower():
            found = True

    if found:
        return "Book already exists!"

    books.append(new_book)
    return "Book added successfully!"


def remove_book(books, book_title):

    for count in range(len(books)):

        if books[count].lower() == book_title.lower():

            books.pop(count)
            return "Book removed successfully!"

    return "Book not found!"


def update_book(books, old_title, new_title):

    for count in range(len(books)):

        if books[count].lower() == old_title.lower():

            books[count] = new_title
            return "Book updated successfully!"

    return "Book not found!"


def show_books(books):

    all_books = "\nAll Books\n"

    for count in range(len(books)):

        all_books = all_books + str(count + 1) + ". " + books[count] + "\n"

    return all_books


books = []

books.append("The Hobbit")
books.append("The Mystery")
books.append("Animal Farm")
books.append("Brave Kingdom")

operation = 0

while operation != 6:

    print("\nWelcome to the Book Suggestion System!")
    print("1. Get Suggestions")
    print("2. Add Book")
    print("3. Remove Book")
    print("4. Update Book")
    print("5. Show All Books")
    print("6. Exit")


    user_input = input("Enter operation: ")


    match user_input:
        case "1":
            answer = "yes"
            while answer.lower() == "yes":
                print(get_suggestion(books))
                answer = input("Would you like another suggestion? (yes/no): ")

        case "2":
            new_book = input("Enter book title: ")
            print(add_book(books, new_book))

        case "3":
            book_title = input("Enter book title to remove: ")
            print(remove_book(books, book_title))

        case "4":
            old_title = input("Enter old title: ")
            new_title = input("Enter new title: ")
            print(update_book(books, old_title, new_title))

        case "5":
            print(show_books(books))

        case "6":
            print("Goodbye!")
            operation = 6

        case _:
            print("Invalid option!")

