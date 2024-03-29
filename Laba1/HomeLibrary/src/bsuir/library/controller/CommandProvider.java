package bsuir.library.controller;

import java.util.HashMap;
import java.util.Map;

import bsuir.library.command.Command;
import bsuir.library.command.impl.AddDescriptionOfBook;
import bsuir.library.command.impl.AddNewBook;
import bsuir.library.command.impl.Authentication;
import bsuir.library.command.impl.DeleteBook;
import bsuir.library.command.impl.GetListOfBook;
import bsuir.library.command.impl.IsAdmin;
import bsuir.library.command.impl.Registration;
import bsuir.library.command.impl.SearchBook;
import bsuir.library.command.impl.SendBookToAdmin;

final class CommandProvider {

	final private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("AUTHENTICATION", new Authentication());
		commands.put("REGISTRATION", new Registration());
		commands.put("ADD_NEW_BOOK", new AddNewBook());
		commands.put("SEARCH_BOOK", new SearchBook());
		commands.put("SEND_BOOK_TO_ADMIN", new SendBookToAdmin());
		commands.put("ADD_DESCRIPTION_OF_BOOK", new AddDescriptionOfBook());
		commands.put("DELETE_BOOK", new DeleteBook());
		commands.put("IS_ADMIN", new IsAdmin());
		commands.put("GET_LIST_OF_BOOK", new GetListOfBook());

	}

	Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		return command;
	}

}
