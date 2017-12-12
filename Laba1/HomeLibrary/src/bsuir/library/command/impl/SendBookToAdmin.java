package bsuir.library.command.impl;

import bsuir.library.command.Command;
import bsuir.library.command.exception.CommandException;
import bsuir.library.service.ServiceFactory;
import bsuir.library.service.UserService;
import bsuir.library.service.exception.ServiceException;

public class SendBookToAdmin implements Command {

	@Override
	public String execute(String request) throws CommandException {
		ServiceFactory servaceFactory = new ServiceFactory();
		UserService userService = servaceFactory.getUserService();
		String location = request.split("\\|")[1];
		String login = request.split("\\|")[2];
		try {
			userService.sendBookToAdmin(location, login);
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		return "����� ������� ����������";
	}

}