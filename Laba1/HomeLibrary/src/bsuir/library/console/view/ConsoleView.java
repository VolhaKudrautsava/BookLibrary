package bsuir.library.console.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleView {
	private static Scanner in = new Scanner(System.in);

	public void println(String response) {
		if (response != null) {
			System.out.print(response + "\n");
		}
	}

	public String enteringLocationOfBook() {
		System.out.print("������� ������������ �����,������� �� ������ ���������!\n");
		return in.next();
	}

	public String enteringName() {
		System.out.print("������� �����.\n");
		return in.next();
	}

	public String enteringEmail() {
		System.out.print("������� email.\n");
		return in.next();
	}

	public String enteringPassword() {
		System.out.print("������� ������.\n");
		return in.next();
	}

	public String enteringNameOfBook() {
		System.out.print("������� �������� �����!\n");
		return in.next();
	}

	public String enteringTypeOfBook() {
		System.out.print("�������� ��� �����! 1-�����������; 2-��������\n");
		String answer=in.next();
		switch (answer) {
		case "1":
			return "ELECTRONIC";
		case "2":
			return "PAPER";
		default:
			return null;
		}
	}

	public String enteringMainChoise() {
		System.out.print("������� ��������: 1 - A����������� 2 - ��������������� 0 - �����.\n");
		return in.next();
	}

	public void wrongData() {
		System.out.print("�� ����� ������������ ������!\n");
	}

	public String enteringAdminMenu() {
		System.out.print("����: 1- �������� ����� �����; 2- �������� �������;"
				+ "3-����� � ��������; 4-�������� �������� �����; " + "5-������� �����; 0 - �����\n");
		return in.next();
	}

	public String enteringUserMenu() {
		System.out.print("����: 1- �������� ����� �����; 2- �������� �������;"
				+ "3-����� � ��������; 4-������� ����� ��������������� �� �����;" + " 0 - �����\n");
		return in.next();
	}

	public void goodBye() {
		System.out.println("�� ��������!");
	}

	public void wrongAction() {
		System.out.println("�������� ��������! ��������� �������!");
	}
	
	public String enteringDescription() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String description;
		System.out.print("������� ��������!\n");
		try {
			description = br.readLine();
		} catch (IOException e) {
			throw new IOException(e);
		}
		return description;
	}
	
}
