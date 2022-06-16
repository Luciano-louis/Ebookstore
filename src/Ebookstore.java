import java.sql.*;
import java.util.Scanner;
public class Ebookstore {
	public static void main ( String [] args ) {
		try {
	// Connect to the ebooksotre_db database, via the jdbc:mysql: channel on localhost (this PC)
	// Used profile: username: "louis", password "louis".
			Connection connection = DriverManager . getConnection (
			"jdbc:mysql://localhost:3306/ebookstore_db?useSSL=true" ,
			"louis" ,
			"louis"	);
	// Create a direct line to the database for running our queries
			Statement statement = connection . createStatement ();
	//Set loop for returning to menu if user wants to do more than one thing
	//call on methods for main menu and each selection 
			while(true) {
				String User_selection = mainMenu();
				if(User_selection.equals("1"))
					viewAll(statement);
				else if(User_selection.equals("2"))
					addBook(statement);
				else if(User_selection.equals("3"))
					update(statement);
				else if(User_selection.equals("4"))
					remove(statement);
				else if(User_selection.equals("5"))
					search(statement);
				else if(User_selection.equals("0")) {
				System.out.println("Thank you.");
				System.exit(0);
				}
			}
			}
		catch ( SQLException e ) {
		e . printStackTrace ();
		}
}

//Methods used in Main
//Method used for searching using '1 Id', '2 Title', '3 Author', 'return function added
	private static void search(Statement statement) throws SQLException {
		{
			System.out.println("Search the Database for a book Selected");
			System.out.println("Please enter the method you would like to use");
			System.out.println("Please type:");
			System.out.println("'1' If You would like to search for a book using Its Id number");
			System.out.println("'2' If You would like to search for a book using The Title");
			System.out.println("'3' If You would like to search for a book using The Author");
			System.out.println("'Menu' If You would like to return to the main menu");
			System.out.println("");
			Scanner b = new Scanner(System.in);
			String Search_Type = b.nextLine();
			if(Search_Type.equals("1")) {
				System.out.println("Search using Id Selected");
				System.out.println("Please enter the Id of the book you are searching for:");
				Scanner c = new Scanner(System.in);
				int Search = b.nextInt();
				System.out.println("\nSearch results:");
				ResultSet results1 = statement . executeQuery ( "SELECT Id, Title, Author, Qty FROM Books WHERE Id ="+Search);
				while ( results1 . next ()) {
					System.out.println(
							"Book Id: "+ results1 . getInt ( "id" ) + "\n" +
							"Title: "+ results1 . getString ( "title" ) + "\n" +
							"Author: "+ results1 . getString ( "author" ) + "\n" +
							"Amount of units available: "+ results1 . getInt ( "qty" )+ "\n");
				}
				System.out.println("");
				System.out.println("Type 'Menu' to return to the main menu");
				Scanner a = new Scanner(System.in);
				String Return = a.nextLine();
				if(Return.equalsIgnoreCase("menu")) {
					mainMenu();
				}
				else {
					System.out.println("Exiting, Thank you.");
					System.exit(0);
				}
				}
			else if(Search_Type.equals("2")) {
				System.out.println("Search using book Title selected");
				System.out.println("Please enter the Title of the book you are searching for:");
				Scanner c = new Scanner(System.in);
				String Search = b.nextLine();
				System.out.println("\nSearch results:");
				ResultSet results1 = statement . executeQuery ( "SELECT Id, Title, Author, Qty FROM Books WHERE Title='"+Search+"'");
				while ( results1 . next ()) {
					System.out.println(
							"Book Id: "+ results1 . getInt ( "id" ) + "\n" +
							"Title: "+ results1 . getString ( "title" ) + "\n" +
							"Author: "+ results1 . getString ( "author" ) + "\n" +
							"Amount of units available: \n"+ results1 . getInt ( "qty" )+ "\n");
				}
				System.out.println("");
				System.out.println("Type 'Menu' to return to the main menu");
				Scanner a = new Scanner(System.in);
				String Return = a.nextLine();
				if(Return.equalsIgnoreCase("menu")) {
					mainMenu();
				}
				else {
					System.out.println("Exiting, Thank you.");
					System.exit(0);
				}
				}
			else if(Search_Type.equals("3")) {
				System.out.println("Search using book Author selected");
				System.out.println("Please enter the Author of the book you are searching for:");
				Scanner c = new Scanner(System.in);
				String Search = b.nextLine();
				System.out.println("\nSearch results:");
				ResultSet results1 = statement . executeQuery ( "SELECT Id, Title, Author, Qty FROM Books WHERE Author='"+Search+"'");
				while ( results1 . next ()) {
					System.out.println(
							"Book Id: "+ results1 . getInt ( "id" ) + "\n" +
							"Title: "+ results1 . getString ( "title" ) + "\n" +
							"Author: "+ results1 . getString ( "author" ) + "\n" +
							"Amount of units available: \n"+ results1 . getInt ( "qty" )+ "\n");
				}
				System.out.println("");
				System.out.println("Type 'Menu' to return to the main menu");
				Scanner a = new Scanner(System.in);
				String Return = a.nextLine();
				if(Return.equalsIgnoreCase("menu")) {
					mainMenu();
				}
				else {
					System.out.println("Exiting, Thank you.");
					System.exit(0);
				}
				}
			else if(Search_Type.equalsIgnoreCase("Menu")){
				mainMenu();
				}
			else {
				System.out.println("Invalid Selection, Exiting");
				System.exit(0);
			}
			}
	}
	//Method used for deleting a row
	private static void remove(Statement statement) throws SQLException {
		int rowsAffected;
		{
			System.out.println("Remove a Book from Database Selected");
			System.out.println("Please enter the Id Of the book You wish to remove:");
			Scanner b = new Scanner(System.in);
			int New_Id = b.nextInt();
			rowsAffected = statement . executeUpdate (
					"DELETE FROM Books WHERE id="+New_Id
					);
				System.out.println("\nThe book previously listed under Id:"+New_Id+ "\nhas been removed from the Database.");
				System.out.println("Thank you.");
}
	}
	//Method used for updatng information on a specific book
	private static void update(Statement statement) throws SQLException {
		int rowsAffected;
		{
			System.out.println("Update Book Information selected");
			System.out.println("Please enter the Book Id you would like to change:");
			Scanner b = new Scanner(System.in);
			int New_Id = b.nextInt();
			System.out.println("\nThe following Book has been selected:");
			ResultSet results1 = statement . executeQuery (
					"SELECT Id, Title, Author, Qty FROM Books WHERE Id ="+New_Id
					);
					while ( results1 . next ()) {
					System.out.println("Book Id: "+ results1 . getInt ( "id" ) + "\n" +
								   "Title: "+ results1 . getString ( "title" ) + "\n" +
								   "Author: "+ results1 . getString ( "author" ) + "\n" +
								   "Amount of units available: "+ results1 . getInt ( "qty" )+ "\n");
			}
					
			System.out.println("\n");
			System.out.println("Please select from the following to change the information you want to update:");
			System.out.println("'1' - To change the Id of the selected book");
			System.out.println("'2' - To change the Title of the selected book");
			System.out.println("'3' - To change the Author of the selected book");
			System.out.println("'4' - To change the Quantity availablie for the selected book");
			Scanner f = new Scanner(System.in);
			String Update = f.nextLine();
			if(Update.equals("1")) {
				System.out.println("Update Id selected");
				System.out.println("Please enter the new Id:");
				Scanner g = new Scanner(System.in);
				int Change = f.nextInt();
				rowsAffected = statement . executeUpdate (
						"UPDATE Books SET Id="+Change+" WHERE Id="+New_Id
						);	
						System.out.println("\nThe Book listed with the Id: "+New_Id + "\nhas been Updated as Id:\n"+Change+"");
						System.out.println("Thank you.");
			}
			else if(Update.equals("2")) {
				System.out.println("Update Title selected");
				System.out.println("Please enter the new Title:");
				Scanner g = new Scanner(System.in);
				String Change = g.nextLine();
				rowsAffected = statement . executeUpdate (
						"UPDATE Books SET Title='"+Change+"' WHERE Id="+New_Id
						);	
						System.out.println("\nThe listed Title for book with the Id:" + New_Id + "\nhas been updated to:\n" +Change);
						System.out.println("Thank you.");
			}
			else if(Update.equals("3")) {
				System.out.println("Update Author selected");
				System.out.println("Please enter the new Author:");
				Scanner g = new Scanner(System.in);
				String Change = g.nextLine();
				rowsAffected = statement . executeUpdate (
						"UPDATE Books SET Author='"+Change+"' WHERE Id="+New_Id
						);	
						System.out.println("\nThe listed Author for book with the Id:" + New_Id + "\nhas been updated to:\n"+Change);
						System.out.println("Thank you.");
			}
			else if(Update.equals("4")) {
				System.out.println("Update Quantity selected");
				System.out.println("Please enter the new Quantity in stock:");
				Scanner g = new Scanner(System.in);
				int Change = g.nextInt();
				rowsAffected = statement . executeUpdate (
						"UPDATE books SET Qty="+Change+" WHERE id="+New_Id
						);	
						System.out.println("\nThe amount of units listed as available for book with the Id:" + New_Id + "\nhas been updated to:\n"+Change);
						System.out.println("");
						System.out.println("Type 'Menu' to return to the main menu");
						Scanner a = new Scanner(System.in);
						String Return = a.nextLine();
						if(Return.equalsIgnoreCase("menu")) {
							mainMenu();
						}
						else {
							System.out.println("Exiting, Thank you.");
							System.exit(0);
						}
					}
		}
	}
	//Method for adding a new book
	private static void addBook(Statement statement) throws SQLException {
		int rowsAffected;
		{
			System.out.println("Add a New book has been selected");
			System.out.println("Please enter the following information to complete the process:");
			System.out.println("Please enter the book ID: ");
			Scanner b = new Scanner(System.in);
			int New_Id = b.nextInt();
			
			System.out.println("Please enter the Title of the book to be added: ");
			Scanner c = new Scanner(System.in);
			String New_Title = c.nextLine();
			
			System.out.println("Please enter the name of the Author: ");
			Scanner d = new Scanner(System.in);
			String New_Author = d.nextLine();

			System.out.println("Please enter the amount of units available of the new book: ");
			Scanner e = new Scanner(System.in);
			int New_Qty = e.nextInt();
						
			rowsAffected = statement . executeUpdate(
					"Insert into Books VALUES (" +New_Id+ ", '"+New_Title+"', '"+New_Author+"', '"+New_Qty+"')"
					);
					System.out.println("\nThe following has been added to the database:");
					System.out.println("Book Id: "+New_Id);
					System.out.println("Book Title: "+New_Title);
					System.out.println("Book Author: "+New_Author);
					System.out.println("Amount of units available: "+New_Qty);
					System.out.println("Thank you.");
					System.out.println("");
					System.out.println("Type 'Menu' to return to the main menu");
					Scanner a = new Scanner(System.in);
					String Return = a.nextLine();
					if(Return.equalsIgnoreCase("menu")) {
						mainMenu();
					}
					else {
						System.out.println("Exiting, Thank you.");
						System.exit(0);
					}
				}
	}
	//method used for displaying all books in database
	private static void viewAll(Statement statement) throws SQLException {
		{
			System.out.println("The following Books are curently available:\n");
			printAllFromTable (statement);
			System.out.println("");
			System.out.println("Type 'Menu' to return to the main menu");
			Scanner a = new Scanner(System.in);
			String Return = a.nextLine();
			if(Return.equalsIgnoreCase("menu")) {
				mainMenu();
			}
			else {
				System.out.println("Exiting, Thank you.");
				System.exit(0);
			}
		}
	}
	//Method used for the main menu
	private static String mainMenu() {
		System.out.println("Welcome to the EBookstore manager");
		System.out.println("Main menu, The following options are available, Please type: ");
		System.out.println("'1' - To view all currently available books");
		System.out.println("'2' - To add a new book to the store");
		System.out.println("'3' - To update the Id, Title, Aurthor or Quantity available of any book");
		System.out.println("'4' - To remove a book from the store");
		System.out.println("'5' - To search the Database for a book");
		System.out.println("'0' - To exit");
		System.out.println("");

		Scanner a = new Scanner(System.in);
		String User_selection = a.nextLine();
		return User_selection;
	}
public static void printAllFromTable ( Statement statement ) throws
SQLException {
	ResultSet results = statement . executeQuery ( "SELECT Id, Title, Author, Qty FROM Books" );
	while ( results . next ()) {
		System.out.println(
		"Book Id: "+ results . getInt ( "id" ) + "\n" +
		"Title: "+ results . getString ( "title" ) + "\n" +
		"Author: "+ results . getString ( "author" ) + "\n" +
		"Amount of units available: "+ results . getInt ( "qty" )+ "\n");
		}
	}
}
//end