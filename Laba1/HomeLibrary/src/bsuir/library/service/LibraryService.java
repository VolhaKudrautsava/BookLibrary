package bsuir.library.service;

import bsuir.library.domain.TypeBook;
import bsuir.library.service.exception.ServiceException;

public interface LibraryService {
	void addNewBook(String title, TypeBook typeOfBook) throws ServiceException;
	String searchBook(String name) throws ServiceException;
	String getListOfBook() throws ServiceException;
	void addDescriptionOfBook(String title, String description)throws ServiceException;
	void deleteBook(String title) throws ServiceException;
}
