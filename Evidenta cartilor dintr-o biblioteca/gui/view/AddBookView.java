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

public class AddBookView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public AddBookView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 450);
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

		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BookDatabase books = new BookDatabase();
				String[] tags = txtTags.getText().split(" ");
				String response = books.addBook(new Book(txtTitle.getText(), txtAuthor.getText(), txtYear.getText(),
						txtPublisher.getText(), txtCategory.getText(), new ArrayList<String>(Arrays.asList(tags))));
				JOptionPane.showMessageDialog(null, response);

			}
		});
		btnAddBook.setFont(new Font("Tahoma", Font.PLAIN, 35));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtTitle, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
										.addComponent(txtAuthor, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
										.addComponent(txtPublisher, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
										.addComponent(txtYear, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
										.addComponent(txtCategory, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
										.addComponent(txtTags, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))
								.addContainerGap())
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addComponent(btnAddBook).addGap(293)))));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addContainerGap()
												.addComponent(txtTitle, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAddBook)
												.addContainerGap(155, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
