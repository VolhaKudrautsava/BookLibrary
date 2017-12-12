package bsuir.library.dao;

import bsuir.library.dao.exception.DAOException;
import bsuir.library.domain.Book;
import bsuir.library.domain.User;

public interface DAOUser {
    User registerUser(String login, String password, String email) throws DAOException;
    User authenticateUser(String login, String password) throws DAOException;
	void sendBookToAdmin(String location, String login)  throws DAOException;
	void addAdmin(String login, String password,String email) throws DAOException;
	void makeANewsletter(Book book) throws DAOException ;
}
