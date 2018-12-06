/**
 * 
 */
package data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Adrian
 *
 */
@SuppressWarnings("serial")
public class Book implements Serializable {
	private String title;
	private String author;
	private String publicationDate;
	private String publisher;
	private String category;
	private ArrayList<String> tags;

	/**
	 * @param title           the title of the book
	 * @param author          the author of the book
	 * @param publicationDate the date the book was published
	 * @param publisher       the name of the publisher
	 * @param category        the category the book belongs in
	 * @param tags            tags that characterize the book
	 */
	public Book(String title, String author, String publicationDate, String publisher, String category,
			ArrayList<String> tags) {
		this.title = title;
		this.author = author;
		this.publicationDate = publicationDate;
		this.publisher = publisher;
		this.category = category;
		this.tags = tags;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publicationDate
	 */
	public String getPublicationDate() {
		return publicationDate;
	}

	/**
	 * @param publicationDate the publicationDate to set
	 */
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the tags
	 */
	public ArrayList<String> getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return String.format(title + " " + author + " " + publicationDate + " " + publisher + " " + category + " "
				+ tags.toString());
	}
}
