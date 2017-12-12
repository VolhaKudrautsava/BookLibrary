package bsuir.library.main;

import java.io.IOException;

import bsuir.library.console.view.ConsoleView;
import bsuir.library.controller.Controller;

public class Main {

	private static Controller controller = new Controller();
	private static ConsoleView view = new ConsoleView();

	public static void showMenuForUser(String login) {
		boolean isEndOfCycle = false;
		String response = null;
		String title = null;
		String request = null;
		String answer = null;
		while (!isEndOfCycle) {
			answer = view.enteringUserMenu();
			switch (answer) {
			case "1":
				title = view.enteringNameOfBook();
				answer = view.enteringTypeOfBook();
				if(answer!=null){
					request = "ADD_NEW_BOOK" + "|" + title + "|" +answer;
					response = controller.doAction(request);
					view.println(response);
				}else {

					view.wrongData();
				}		
				break;
			case "2":
				response = controller.doAction("GET_LIST_OF_BOOK");
				view.println(response);
				break;
			case "3":
				title = view.enteringNameOfBook();
				request = "SEARCH_BOOK" + "|" + title;
				response = controller.doAction(request);
				view.println(response);
				break;
			case "4":
				String location = view.enteringLocationOfBook();
				request = "SEND_BOOK_TO_ADMIN" + "|" + location + "|" + login;
				response = controller.doAction(request);
				view.println(response);
				break;
			case "0": {
				isEndOfCycle = true;
				view.goodBye();
			}
				break;
			default: {
				view.wrongAction();
			}
				break;
			}
		}

	}

	public static void showMenuForAdmin(String login) {
		boolean isEndOfCycle = false;
		String response = null;
		String title = null;
		String answer = null;
		String request = null;
		while (!isEndOfCycle) {
			answer = view.enteringAdminMenu();
			switch (answer) {
			case "1":
				title = view.enteringNameOfBook();
				answer = view.enteringTypeOfBook();
				if(answer!=null){
					request = "ADD_NEW_BOOK" + "|" + title + "|" +answer;
					response = controller.doAction(request);
					view.println(response);
				}else {

					view.wrongData();
				}		
				break;
			case "2":
				response = controller.doAction("GET_LIST_OF_BOOK");
				view.println(response);
				break;
			case "3":
				title = view.enteringNameOfBook();
				request = "SEARCH_BOOK" + "|" + title;
				response = controller.doAction(request);
				view.println(response);
				break;
			case "4":
				String description;
				title = view.enteringNameOfBook();
				try {
					description = view.enteringDescription();
					request = "ADD_DESCRIPTION_OF_BOOK" + "|" + title + "|" + description;
					response = controller.doAction(request);
					view.println(response);
				} catch (IOException e) {
					view.println(e.getLocalizedMessage());
				}
				break;
			case "5":
				title = view.enteringNameOfBook();
				request = "DELETE_BOOK" + "|" + title;
				response = controller.doAction(request);
				view.println(response);
				break;
			case "0": {
				isEndOfCycle = true;
				view.goodBye();
			}
				break;
			default: {
				view.wrongAction();
			}
				break;
			}
		}

	}

	public static void main(String[] argv) {

		Controller controller = new Controller();
		boolean isEndOfCycle = false;
		String response = null;
		String request = null;
		String login = null;
		String password = null;
		String email = null;
		while (!isEndOfCycle) {
			String answer = view.enteringMainChoise();
			switch (answer) {
			case "1":
				login = view.enteringName();
				password = view.enteringPassword();
				request = "AUTHENTICATION" + "|" + login + "|" + password;
				response = controller.doAction(request);
				if (response != null) {
					view.println(response);
					request = "IS_ADMIN" + "|" + login + "|" + password;
					response = controller.doAction(request);
					if (Boolean.parseBoolean(response)) {
						showMenuForAdmin(login);
					} else {
						showMenuForUser(login);
					}
				}
				break;
			case "2":
				login = view.enteringName();
				password = view.enteringPassword();
				email = view.enteringEmail();
				request = "REGISTRATION" + "|" + login + "|" + password + "|" + email;
				response = controller.doAction(request);
				if (response != null) {
					view.println(response);
					showMenuForUser(login);
				}
				break;
			case "0":
				isEndOfCycle = true;
				view.goodBye();
				break;
			default:
				view.wrongAction();
				break;
			}
		}
	}
}
