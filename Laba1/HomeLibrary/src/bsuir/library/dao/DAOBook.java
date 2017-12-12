package bsuir.library.dao;

import java.util.ArrayList;

import bsuir.library.dao.exception.DAOException;
import bsuir.library.domain.Book;
import bsuir.library.domain.TypeBook;

public interface DAOBook {
	
	 void addBook(String title, TypeBook typeOfBook) throws DAOException;
	 ArrayList<Book> searchBook(String name) throws DAOException;
	 ArrayList<Book> getListOfBook() throws DAOException;
	 void addDescriptionOfBook(ArrayList<Book>  book, String description)throws DAOException;
	 void deleteBook(Book book) throws DAOException;	
}
