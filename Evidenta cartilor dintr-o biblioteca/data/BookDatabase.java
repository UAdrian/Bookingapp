package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class BookDatabase {
	private ArrayList<Book> bookList;

	/**
	 * Loads the book list from the file
	 */
	public BookDatabase() {
		bookList = new ArrayList<>();
		this.load();
	}

	/**
	 * @return the bookList
	 */
	public ArrayList<Book> getBookList() {
		return bookList;
	}

	@SuppressWarnings("unchecked")
	/**
	 * Loads the list of books
	 */
	private void load() {
		try {
			FileInputStream fis = new FileInputStream("books.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			bookList = (ArrayList<Book>) ois.readObject();
			ois.close();
		} catch (IOException e) {
			// In case there is no file to be opened we create an empty one
			this.save();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Saves the list of books
	 */
	public void save() {
		try {
			new PrintWriter("books.txt").close();
			FileOutputStream fos = new FileOutputStream("books.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bookList);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param book the book to be added
	 * @return a String message informing if the book was added or not
	 */
	public String addBook(Book book) {
		if (this.alreadyExists(book.getTitle()) != null) {
			return "Book already exists!";
		} else {
			bookList.add(book);
			this.save();
			return "Book added!";
		}
	}

	public Book alreadyExists(String searchTerm) {
		Iterator<Book> booksIterator = bookList.iterator();
		Book currentBook;

		while (booksIterator.hasNext()) {
			currentBook = booksIterator.next();
			if (currentBook.getTitle().equals(searchTerm)) {
				return currentBook;
			}
		}
		return null;
	}

	/**
	 * Searches the list of books for the @searchTerm
	 * 
	 * @param searchTerm the term to be searched, it can be the
	 *                   title/author/publisher/year/category/tag for more then 1
	 *                   tag use "," to separate tags
	 * @return a list containing all the books matching the searchTerm or null if
	 *         none is found
	 */
	public ArrayList<Book> search(String searchTerm) {
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		Iterator<Book> booksIterator = bookList.iterator();
		Book currentBook;

		if (searchTerm.contains(",")) {
			String newSearchTerm = searchTerm.replaceAll(" ", "");
			String[] strSplit = newSearchTerm.trim().split(",");
			return this.search(strSplit);
		} else {

			while (booksIterator.hasNext()) {
				currentBook = booksIterator.next();
				if (currentBook.getTitle().equals(searchTerm)) {
					foundBooks.add(currentBook);
				}
				if (currentBook.getAuthor().equals(searchTerm)) {
					foundBooks.add(currentBook);
				}
				if (currentBook.getCategory().equals(searchTerm)) {
					foundBooks.add(currentBook);
				}
				if (currentBook.getPublicationDate().equals(searchTerm)) {
					foundBooks.add(currentBook);
				}
				if (currentBook.getPublisher().equals(searchTerm)) {
					foundBooks.add(currentBook);
				}
				if (currentBook.getTags().contains(searchTerm)) {
					foundBooks.add(currentBook);
				}
			}
			if (foundBooks.isEmpty()) {
				return null;
			}
		}
		return foundBooks;
	}

	/**
	 * Searches the books list for the books published between 2 given years
	 * 
	 * @param yearOne the first year for the search
	 * @param yearTwo the second year for the search
	 * @return the books published between @yearOne and @yearTwo or null if none is
	 *         found
	 */
	public ArrayList<Book> searchBetweenYears(int yearOne, int yearTwo) {
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		Iterator<Book> booksIterator = bookList.iterator();
		Book currentBook;
		while (booksIterator.hasNext()) {
			currentBook = booksIterator.next();
			int year = Integer.parseInt(currentBook.getPublicationDate());
			if (year >= yearOne && year <= yearTwo) {
				foundBooks.add(currentBook);
			}
		}
		if (foundBooks.isEmpty()) {
			return null;
		}
		return foundBooks;
	}

	/**
	 * Overloaded function for tag search
	 * 
	 * @param searchTerm a string array with the tags to be searched
	 * @return the books that contain all the tags specified, to get the books that
	 *         have only one of the tags use the normal search
	 */
	public ArrayList<Book> search(String[] searchTerm) {
		ArrayList<Book> foundBooks = new ArrayList<Book>();
		Iterator<Book> booksIterator = bookList.iterator();
		Book currentBook;

		while (booksIterator.hasNext()) {
			currentBook = booksIterator.next();
			int nTag = 0;
			for (int i = 0; i < searchTerm.length; i++) {
				if (currentBook.getTags().contains(searchTerm[i])) {
					nTag++;
				}
			}
			if (nTag == searchTerm.length) {
				foundBooks.add(currentBook);
			}

		}
		if (foundBooks.isEmpty()) {
			return null;
		}
		return foundBooks;
	}

	public String editBook(String title, String author, String publicationDate, String publisher, String category,
			ArrayList<String> tags) {
		Book book = this.alreadyExists(title);
		if (book != null) {
			bookList.get(bookList.indexOf(book)).setTitle(title);
			bookList.get(bookList.indexOf(book)).setAuthor(author);
			bookList.get(bookList.indexOf(book)).setPublicationDate(publicationDate);
			bookList.get(bookList.indexOf(book)).setPublisher(publisher);
			bookList.get(bookList.indexOf(book)).setCategory(category);
			bookList.get(bookList.indexOf(book)).setTags(tags);
			this.save();
			return "Book succesfully edited!";
		}
		return "Book dosen't exist";
	}

	public String deleteBook(String title) {
		Book book = this.alreadyExists(title);
		if (book != null) {
			bookList.remove(book);
			this.save();
			return "Book has been removed!";
		}

		return "The book dosen't exist!";
	}
}
