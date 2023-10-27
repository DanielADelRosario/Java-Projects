/*
 * CASE STUDY BSIT 2-1 GROUP 5: LIBRARY MANAGEMENT SYSTEM
 * DEL ROSARIO DANIEL 
 * DOLOROSA SHAINA MAE
 * FABABIER RENZ PAUL
 

package JavaOne;
import java.util.LinkedList;
import java.util.Scanner;


class Book // CONTAINS BOOK INFORMATION
{
	private int ID;
	private String Title;
	private String Author;
	private boolean Available;
	
	public Book(int ID, String Title, String Author) // CONSTRUCTOR
	{
		this.ID = ID;
        this.Title = Title;
        this.Author = Author;
        this.Available = true;
	}
	// GETTER
	public int getID()
	{
		return ID;
	}
	public String getTitle()
	{
		return Title;
	}
	public String getAuthor()
	{
		return Author;
	}
	public boolean bookAvailable()
	{
		return Available;
	}
	// SETTER
	public void setAvailable(boolean Available)
	{
		this.Available = Available;
	}
}

class Library // MANAGE BOOKS IN LIBRARY
{
	private LinkedList<Book> books;
	
	public Library()
	{
		books = new LinkedList<>();
	}
	
	public Book SearchBook(int ID)  // VALIDATES IF INPUT IS IN LMS
	{
		for (Book Look: books) // ITERATE COLLECTION OF OBJECTS
		{
			if (Look.getID() == ID)
			{
				return Look;
			}
		}
		return null;
	}
	
	public void AddBook(int ID, String Title, String Author) // ADD BOOK
	{
		Book NewBook = new Book(ID, Title, Author);
		books.add(NewBook);
	}
	public void RemoveBook(int ID) // REMOVE BOOK
	{
		Book Remove = SearchBook(ID);
		if(Remove != null)
		{
			if (Remove.bookAvailable())
			{
				books.remove(Remove);
				System.out.println("Book successfully removed.");
			}
			else
			{
				System.out.println("Error: Book is currently unavailable.");
			}
		}
		else
		{
			System.out.println("Book not found: Invalid ID.");
		}
	}
	public void BorrowBook(int ID) // BORROW BOOK
	{
		Book Borrow = SearchBook(ID);
		if (Borrow != null)
		{
			if (Borrow.bookAvailable())
			{	
				Borrow.setAvailable(false);
				System.out.println("Book borrowed successfully.");
			}
			else 
			{
			System.out.println("Book is Unavailable");
			}
		}
		else 
		{
			System.out.println("Book not found: Invalid ID");
		}
	}
	public void ReturnBook (int ID) // RETURN BOOK
	{
		Book Return = SearchBook(ID);
		if (Return != null)
		{
			if (!Return.bookAvailable())
			{	
				Return.setAvailable(true);
				System.out.println("Book successfully returned.");
			}
			else 
			{
			System.out.println("Book is already available.");
			}
		}
		else 
		{
			System.out.println("Book not found: Invalid ID");
		}
	}
	public void DisplayBooks() // DISPLAY BOOK
	{
		for (Book Look: books)
		{
			if (Look.bookAvailable())
			{
				System.out.println("ID: " + Look.getID() + "\t\tBook Title: " + Look.getTitle() + "\t\tAuthor: " + Look.getAuthor() + "\t\tStatus: Available");
			}
			else
			{
				System.out.println("ID: " + Look.getID() + "\t\tBook Title: " + Look.getTitle() + "\t\tAuthor: " + Look.getAuthor() + "\t\tStatus: Unvailable");
			}
		}
	}
}


public class LibraryManagement
{
	public static void main(String[] args)
	{
		Library library = new Library();
		try (Scanner input = new Scanner(System.in)) {
			// DECLARING VARIABLES
			String BookTitle, BookAuthor;
			int BookID = 1;
			
			while(true)
			{
				System.out.print("\nWelcome to Java Library Management System\n");
				System.out.println("1. Add a Book");
			    System.out.println("2. Remove a Book");
			    System.out.println("3. Borrow a Book");
			    System.out.println("4. Return a Book");
			    System.out.println("5. Display Books Available");
			    System.out.println("6. Exit");
			    System.out.print("\nEnter your choice: ");
			    // ENTER OPTION
			    int option = input.nextInt();
			    input.nextLine();
			    
			    switch(option)
			    {
			    	case 1: // ADD BOOK
			    		System.out.print("Enter Title of Book:  ");
			    		BookTitle = input.nextLine();
			    		System.out.print("Enter Author of Book: ");
			    		BookAuthor = input.nextLine();
			    		library.AddBook(BookID, BookTitle, BookAuthor);
			    		BookID++;
			    		System.out.print("\nA Book was successfully added.\n");
			    		break;
			    	case 2: // REMOVE BOOK
			    		System.out.print("Enter ID of the book to remove: ");
			    		int RemoveBookID = input.nextInt();
			    		input.nextLine();
			    		library.RemoveBook(RemoveBookID);
			    		break;
			    	case 3: // BORROW BOOK
			    		System.out.print("Enter ID of the book to borrow: ");
			    		int BorrowBookID = input.nextInt();
			    		input.nextLine();
			    		library.BorrowBook(BorrowBookID);
			    		break;
			    	case 4: // RETURN BOOK
			    		System.out.print("Enter ID of the book to return: ");
			    		int ReturnBookID = input.nextInt();
			    		input.nextLine();
			    		library.ReturnBook(ReturnBookID);
			    		break;
			    	case 5: // DISPLAY BOOK
			    		System.out.print("\nList of Books Available.\n");
			    		library.DisplayBooks();
			    		break;
			    	case 6: // EXIT PROGRAM
			    		System.exit(0);
			    		break;
			    	default: // VALIDATE INPUT
			    		System.out.print("\nINVALID: Choose another option.\n");
			    		break;
			    }
			}
		}
	}
} */
package JavaOne;
import java.util.LinkedList;
import java.util.Scanner;

class Book {
    private final int ID;
    private final String Title;
    private final String Author;
    private boolean Available;

    public Book(int ID, String Title, String Author) {
        this.ID = ID;
        this.Title = Title;
        this.Author = Author;
        this.Available = true;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public boolean bookAvailable() {
        return Available;
    }

    public void setAvailable(boolean Available) {
        this.Available = Available;
    }
}

class Library {
    private final LinkedList<Book> books;

    public Library() {
        books = new LinkedList<>();
    }

    public Book SearchBook(int ID) {
        for (Book Look : books) {
            if (Look.getID() == ID) {
                return Look;
            }
        }
        return null;
    }

    public void AddBook(int ID, String Title, String Author) {
        Book NewBook = new Book(ID, Title, Author);
        books.add(NewBook);
    }

    public void RemoveBook(int ID) {
        Book Remove = SearchBook(ID);
        if (Remove != null) {
            if (Remove.bookAvailable()) {
                String bookTitle = Remove.getTitle();
                books.remove(Remove);
                System.out.println("\n\tBook \u001b[32m"+ bookTitle +"\u001b[0m successfully removed.");
            } else {
                String bookTitle = Remove.getTitle();
                System.out.println("\n\t\u001b[32m[ERR]\u001b[0m Book"+ bookTitle +" is Currently Unavailable!.");
            }
        } else {
            System.out.println("\n\t\u001b[31m[ERR]\u001b[0mBook ID "+ ID +" is not in the Library");
        }
    }

    public void BorrowBook(int ID) {
        Book Borrow = SearchBook(ID);
        if (Borrow != null) {
            if (Borrow.bookAvailable()) {
                String bookTitle = Borrow.getTitle();
                Borrow.setAvailable(false);
                System.out.println("\n\tBook \u001b[32m"+ bookTitle +"\u001b[0m borrowed successfully.");
            } else {
                String bookTitle = Borrow.getTitle();
                System.out.println("\n\tBook \u001b[32m"+ bookTitle +"\u001b[0m is Unavailable to borrow at the moment");
            }
        } else {
            System.out.println("\n\t\u001b[31m[ERR]\u001b[0mBook not found: Invalid ID");
        }
    }

    public void ReturnBook(int ID) {
        Book Return = SearchBook(ID);
        if (Return != null) {
            if (!Return.bookAvailable()) {
                String bookTitle = Return.getTitle();
                Return.setAvailable(true);
                System.out.println("\n\tBook \u001B[32m"+ bookTitle +"\u001B[0m successfully returned.");
            } else {
                String bookTitle = Return.getTitle();
                System.out.println("\n\tBook \u001B[32m"+ bookTitle +"\u001B[0m is still available.");
            }
        } else {
            System.out.println("\n\t\u001b[31m[ERR]\u001b[0mBook not found: Invalid ID");
        }
    }

    public void DisplayBooks() {
        if (books.isEmpty()) {
            System.out.println("\n\t\u001b[31mThere are no books to display yet.\u001b[0m");
        } else {
            System.out.println("\t\t\t\t\t\t\t\t\u001b[35mList of Books\u001b[0m");
            System.out.println("\t\t---------------------------------------------------------------------");
            System.out.printf("\t\t\u001b[36m%-5s %-25s %-25s %-12s\n", "ID", "Book Title", "Author", "Status \u001b[0m");
            System.out.println("\t\t---------------------------------------------------------------------");
            for (Book Look : books) {
                String status = Look.bookAvailable() ? "Available" : "Unavailable";
                System.out.printf("\t\t%-5d %-25s %-25s %-12s\n", Look.getID(), Look.getTitle(), Look.getAuthor(), status);
            }
            System.out.println("\t\t---------------------------------------------------------------------");
        }
    }

    public LinkedList<Book> getBooks() {
        return books;
    }
}

class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        // DECLARING VARIABLES
        String bookTitle, bookAuthor;
        int bookID = 1;
        int choice = 0;
        boolean isValidChoice;

        do {
            System.out.print("\n\t\t  --------------------------- \uD83E\uDDE1 ------------------------------");
            System.out.println("\n\t\t\t\t\t\u001b[36m  Group 8 Library Management System");
            System.out.print("\n\t\u001b[36m1. \u001b[0mAdd a Book");
            System.out.print("\t\t\t\u001b[36m2. \u001b[0mRemove a Book");
            System.out.println("\t\t\t\t\u001b[36m3. \u001b[0mBorrow a Book");
            System.out.print("\t\u001b[36m4. \u001b[0mReturn a Book");
            System.out.print("\t\t\u001b[36m5. \u001b[0mDisplay Books Available");
            System.out.println("\t\t\u001b[36m6. \u001b[0mExit");
            System.out.print("\n\tEnter your choice: ");
            String input = scanner.nextLine();
            isValidChoice = true;

            try {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1: // ADD BOOK
                        System.out.print("\n\tEnter Title of Book: ");
                        bookTitle = scanner.nextLine();
                        System.out.print("\tEnter Author of Book: ");
                        bookAuthor = scanner.nextLine();
                        library.AddBook(bookID, bookTitle, bookAuthor);
                        bookID++;
                        System.out.print("\n\tBook titled \u001b[32m" + bookTitle + " by " + bookAuthor + "\u001b[0m was added successfully!\n");
                        break;

                    case 2: // REMOVE BOOK
                        if (library.getBooks().isEmpty()) {
                            System.out.println("\n\t\u001b[31mThere are no books to remove yet.\u001b[0m");
                        } else {
                            boolean isValidInput = false;
                            do {
                                System.out.print("\n\tEnter ID of the book to remove: ");
                                String removed = scanner.nextLine();
                                try {
                                    int removeBookID = Integer.parseInt(removed);
                                    if (removeBookID > 0) {
                                        library.RemoveBook(removeBookID);
                                        isValidInput = true;
                                    } else {
                                        System.out.println("\n\t\u001b[31m[ERR]\u001b[0mInvalid input! Please enter a valid book ID.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("\n\t\u001b[31m[ERR]\u001b[0mInvalid input! Please enter a valid book ID.");
                                }
                            } while (!isValidInput);
                        }
                        break;

                    case 3: // BORROW BOOK
                        if (library.getBooks().isEmpty()) {
                            System.out.println("\n\t\u001b[31mThere are no books to borrow yet.\u001b[0m");
                        } else {
                            boolean isValidInput = false;
                            do {
                                System.out.print("\n\tEnter ID of the book to borrow: ");
                                String borrowed = scanner.nextLine();
                                try {
                                    int borrowBookID = Integer.parseInt(borrowed);
                                    if (borrowBookID > 0) {
                                        library.BorrowBook(borrowBookID);
                                        isValidInput = true;
                                    } else {
                                        System.out.println("\n\t\u001b[31m[ERR]\u001b[0mInvalid input! Please enter a valid book ID.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("\n\t\u001b[31m[ERR]\u001b[0mInvalid input! Please enter a valid book ID.");
                                }
                            } while (!isValidInput);
                        }
                        break;

                    case 4: // RETURN BOOK
                        if (library.getBooks().isEmpty()) {
                            System.out.println("\n\t\u001b[31mThere are no books to be returned yet.\u001b[0m");
                        } else {
                            boolean isValidInput = false;
                            do {
                                System.out.print("\n\tEnter ID of the book to return: ");
                                String returned = scanner.nextLine();
                                try {
                                    int returnBookID = Integer.parseInt(returned);
                                    if (returnBookID > 0) {
                                        library.ReturnBook(returnBookID);
                                        isValidInput = true;
                                    } else {
                                        System.out.println("\n\t\u001b[31m[ERR]\u001b[0mInvalid input! Please enter a valid book ID.");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("\n\t\u001b[31m[ERR]\u001b[0mInvalid input! Please enter a valid book ID.");
                                }
                            } while (!isValidInput);
                        }
                        break;

                    case 5: // DISPLAY BOOK
                        System.out.println();
                        library.DisplayBooks();
                        break;

                    case 6: // EXIT PROGRAM
                        System.out.println("\n Thank you for using our Library Management System \uD83E\uDDE1");
                        System.out.println("\n Group Members:");
                        System.out.println("\u001b[36m Del Rosario,\u001b[0m Daniel");
                        System.out.println("\u001b[36m Dolorosa,\u001b[0m Shaina Mae");
                        System.out.println("\u001b[36m Fababeir,\u001b[0m Renz Paul");
                        System.exit(0);
                        break;

                    default: // VALIDATE INPUT
                        System.out.println("\n\t\u001b[31m[ERR]\u001b[0m Invalid input! Please enter a valid choice.");
                        isValidChoice = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n\t\u001b[31m[ERR]\u001b[0m Invalid input! Please enter a valid choice.");
                isValidChoice = false;
            }
        } while (!isValidChoice || choice != 6);
    }
}
