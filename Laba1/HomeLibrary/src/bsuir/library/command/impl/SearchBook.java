package bsuir.library.command.impl;

import bsuir.library.command.Command;
import bsuir.library.command.exception.CommandException;
import bsuir.library.service.LibraryService;
import bsuir.library.service.ServiceFactory;
import bsuir.library.service.exception.ServiceException;

public class SearchBook implements Command {

	@Override
	public String execute(String request) throws CommandException {
		ServiceFactory servaceFactory = new ServiceFactory();
		LibraryService libraryService = servaceFactory.getLiraryService();
		String title = request.split("\\|")[1];
		String response;
		try {
			response = libraryService.searchBook(title);
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		return response;
	}

}