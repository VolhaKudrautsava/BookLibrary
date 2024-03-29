package bsuir.library.command.impl;

import bsuir.library.command.Command;
import bsuir.library.command.exception.CommandException;
import bsuir.library.service.ServiceFactory;
import bsuir.library.service.UserService;
import bsuir.library.service.exception.ServiceException;

public class IsAdmin implements Command {


	@Override
	public String execute(String request) throws CommandException {
		ServiceFactory servaceFactory = new ServiceFactory();
		UserService userService;
		String login = request.split("\\|")[1];
		String password = request.split("\\|")[2];
		userService = servaceFactory.getUserService();
		Boolean response;
		try {
			 response=userService.isAdmin(login, password);
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		return response.toString();
	}
}
