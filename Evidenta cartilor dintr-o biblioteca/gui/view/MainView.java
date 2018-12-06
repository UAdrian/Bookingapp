package gui.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import data.Book;
import data.BookDatabase;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextArea textArea;
	private JButton btnDeleteBook;
	private JButton btnViewAll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtSearch = new JTextField();
		txtSearch.setToolTipText("Book Search");
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtSearch.getText() != "") {
					BookDatabase books = new BookDatabase();
					ArrayList<Book> booksFound;
					String searchTerm = txtSearch.getText();
					if (searchTerm.contains("-")) {
						String[] strSplit = searchTerm.split("-");
						booksFound = books.searchBetweenYears(Integer.parseInt(strSplit[0]),
								Integer.parseInt(strSplit[1]));
					} else {
						booksFound = books.search(searchTerm);
					}
					if (booksFound == null) {
						textArea.setText(
								"No books within the specified search, click the 'Add Book' button to start adding books!");
					} else {
						String stringToDisp = "";
						for (int i = 0; i < booksFound.size(); i++) {
							Book book = booksFound.get(i);
							stringToDisp += "Title: " + book.getTitle() + " " + "Author: " + book.getAuthor() + " "
									+ "Year: " + book.getPublicationDate() + "\n";
						}
						textArea.setText(stringToDisp);
					}
				}
			}
		});

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 30));
		textArea.setTabSize(10);

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAddBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddBookView bookView = new AddBookView();
				bookView.setVisible(true);
			}
		});

		JButton btnEditBook = new JButton("Edit Book");
		btnEditBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EditBookView edit = new EditBookView();
				edit.setVisible(true);
			}
		});
		btnEditBook.setFont(new Font("Tahoma", Font.PLAIN, 24));

		btnDeleteBook = new JButton("Delete Book");
		btnDeleteBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookDelete bookDelete = new BookDelete();
				bookDelete.setVisible(true);
			}
		});
		btnDeleteBook.setFont(new Font("Tahoma", Font.PLAIN, 24));

		btnViewAll = new JButton("View All");
		btnViewAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookDatabase books = new BookDatabase();
				ArrayList<Book> booksFound = books.getBookList();
				if (booksFound.isEmpty()) {
					textArea.setText(
							"No books are in the database, click the 'Add Book' button to start adding books!");
				} else {
					String stringToDisp = "";
					for (int i = 0; i < booksFound.size(); i++) {
						Book book = booksFound.get(i);
						stringToDisp += "Title: " + book.getTitle() + " " + "Author: " + book.getAuthor() + " "
								+ "Year: " + book.getPublicationDate() + "\n";
					}
					textArea.setText(stringToDisp);
				}
			}
		});
		btnViewAll.setFont(new Font("Tahoma", Font.PLAIN, 24));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(34)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnAddBook)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEditBook)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnDeleteBook)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnViewAll))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 641, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(textArea, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAddBook, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEditBook, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDeleteBook).addComponent(btnViewAll))));
		contentPane.setLayout(gl_contentPane);
	}
}
