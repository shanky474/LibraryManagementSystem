package dao;

import model.*;

public class Hibernate {

	public static void main(String[] args) {
		Book book = new Book();
		Author author = new Author();
		Publisher publisher = new Publisher();
		book.setIsbn("8175257660");
		book.setTitle("Three Mistakes of my life");
		book.setYear("2007");
		book.setQuantity(4);
		author.setName("Chetan Bhagat");
		publisher.setName("Penguin");
		publisher.setBook(book);
		author.setBook(book);
		book.setAuthor(author);
		book.setPublisher(publisher);
		DaoImpl daoImpl = new DaoImpl();
		daoImpl.save(book);

//		Authentication a = daoImpl.updateUserInfo(auth);
//		daoImpl.deleteUser(auth1);
		// System.out.println(a.getRole());

	}

}
