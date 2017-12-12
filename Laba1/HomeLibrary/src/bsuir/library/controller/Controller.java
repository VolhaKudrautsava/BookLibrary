package bsuir.library.controller;

import bsuir.library.command.Command;
import bsuir.library.command.exception.CommandException;

public class Controller {
	private final CommandProvider provider = new CommandProvider();

	public String doAction(String request) {


		String response=null;
		String commandName=request.split("\\|")[0];
		try {
			Command command = provider.getCommand(commandName);
			response = command.execute(request);
		} catch (CommandException e) {
			System.out.print( "error:"+e.getLocalizedMessage()+"\n");
		}
		return response;

	}
}
