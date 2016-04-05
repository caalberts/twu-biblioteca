# Design for Biblioteca

## Classes

### Application
Role:
- welcome user
- display menu
- initiate checkout
- initiate return

Attributes
- Library

### Library
Role:
- list books
- checkout book
- return book

Attributes
- Book list

### Book
Role:
- display details
- confirm checkout
- confirm return

Attributes
- title
- author
- year
- available

### Helper
Role:
- prompt and get user input from console
- display output to console


## User Stories
1. Welcome Message  - As a customer, I would like to see a welcome message when I start the application, so that I feel welcome and know that Biblioteca is available.
2. List Books - As a customer, after the welcome message appears I would like to see a list of all library books, so that I can browse for books I might want to check-out. Assume that there is a pre-existing list of books. You don't need to support adding or removing books from the library.
3. Book Details - As a customer, I'd like the list of all books to include each books Author and Year Published, so that I can be confident that I have found the book I am looking for. The book listing should have columns for this information.
4. Main Menu  - As a customer, instead of automatically seeing the book list, I would like to see a list of options and be able to choose one. For now, the only option should be 'List Books'. All future options should be added to this menu also.
5. Invalid Menu Option - As a customer, I would like to be notified when I choose an invalid option with the message “Select a valid option!”, so that I can know when I need to re-enter my choice.
6. Quit - As a customer, I would like to continue choosing options until I choose to 'Quit'.
7. Checkout Book - As a librarian, I would like customers to be able to check-out a book. Checked out books should not appear in the list of all library books.
8. Successful Checkout - As a customer, I would like to know that a book has been checked out by seeing the message “Thank you! Enjoy the book”.
9. Unsuccessful Checkout - As a customer, I would like to be notified if the book I tried to check-out is not available by seeing the message, “That book is not available.”, so that I know that I need to select a different book or fix my spelling error.
10. Return Book - As a librarian, I would like customers to be able to return a book, so that other customers can check that book out. Returned books should appear in the list of library books.
11. Successful Return - As a customer, I would like to be notified if the book I am returning belongs to this library by seeing the message, “Thank you for returning the book.”, so that I know I returned the book to the right library.
12. Unsuccessful Return - As a customer, I would like to be notified if the book I am returning has not been added to this library by seeing the message, “That is not a valid book to return.”, so that I can return it to the correct library or fix my spelling error.
