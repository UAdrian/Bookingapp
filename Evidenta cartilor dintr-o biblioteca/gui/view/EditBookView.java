package gui.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import data.Book;
import data.BookDatabase;

public class EditBookView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public EditBookView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 790, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTextField txtTitle = new JTextField();
		txtTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtTitle.setText("Title");
		txtTitle.setColumns(10);

		JTextField txtAuthor = new JTextField();
		txtAuthor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtAuthor.setText("Author");
		txtAuthor.setColumns(10);

		JTextField txtPublisher = new JTextField();
		txtPublisher.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtPublisher.setText("Publisher");
		txtPublisher.setColumns(10);

		JTextField txtYear = new JTextField();
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtYear.setText("Year");
		txtYear.setColumns(10);

		JTextField txtCategory = new JTextField();
		txtCategory.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtCategory.setText("Category");
		txtCategory.setColumns(10);

		JTextField txtTags = new JTextField();
		txtTags.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtTags.setText("Tags");
		txtTags.setColumns(10);

		JButton btnSaveEdit = new JButton("Save Edit");
		btnSaveEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookDatabase books = new BookDatabase();
				String[] tags = txtTags.getText().split(" ");
				String response = books.editBook(txtTitle.getText(), txtAuthor.getText(), txtYear.getText(),
						txtPublisher.getText(), txtCategory.getText(), new ArrayList<String>(Arrays.asList(tags)));
				JOptionPane.showMessageDialog(null, response);

			}
		});
		btnSaveEdit.setFont(new Font("Tahoma", Font.PLAIN, 26));

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookDatabase books = new BookDatabase();
				String searchTerm = txtTitle.getText();
				ArrayList<Book> booksFound = books.search(searchTerm);
				if (booksFound.size() > 1) {
					JOptionPane.showMessageDialog(null, "Too many results, put the complete title to narrow it down!");
				} else {
					Book book = booksFound.get(0);
					txtTitle.setText(book.getTitle());
					txtAuthor.setText(book.getAuthor());
					txtPublisher.setText(book.getPublisher());
					txtYear.setText(book.getPublicationDate());
					txtCategory.setText(book.getCategory());
					txtTags.setText(book.getTags().toString());
				}
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtTitle, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
										.addComponent(txtAuthor, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
										.addComponent(txtPublisher, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
										.addComponent(txtYear, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
										.addComponent(txtCategory, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
										.addComponent(txtTags, GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(307).addComponent(btnSaveEdit))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(317).addComponent(btnSearch)))
				.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addContainerGap()
												.addComponent(txtTitle, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSearch)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtAuthor, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtPublisher, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtYear, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtCategory, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtTags, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(btnSaveEdit)
												.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

}
