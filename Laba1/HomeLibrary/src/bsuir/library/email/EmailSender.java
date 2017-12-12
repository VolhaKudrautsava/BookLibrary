package bsuir.library.email;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;

import bsuir.library.domain.Book;
import bsuir.library.email.exception.EmailException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;

public class EmailSender {

	private static String LIBRARY_EMAIL="olencka11@yandex.ru";
	
	public static void sendEmail(Address[] recipeints, Book book) throws EmailException {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.yandex.ru");
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.port", 465);

		Session session = Session.getDefaultInstance(properties,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(LIBRARY_EMAIL, "sichnenkoolay1998");
					}
				});


			Message mess = new MimeMessage(session);
			try {
				mess.setFrom(new InternetAddress(LIBRARY_EMAIL));
				mess.setRecipients(Message.RecipientType.TO, recipeints);
				mess.setSubject("�������� �����");
				mess.setText("������������! � ���������� ��������� �������� ��� �����: "+book.getName()+"  ");
				Transport.send(mess);

			} catch (MessagingException e) {
				throw new EmailException(e);			
			}
	}

	public static void sendEmailWithBook(String locationOfBook,String userEmail, String adminEmail) throws EmailException {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp.yandex.ru");
		properties.put("mail.smtp.port", 465);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.port", 465);

		Session session = Session.getDefaultInstance(properties,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(LIBRARY_EMAIL, "sichnenkoolay1998");
					}
				});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(LIBRARY_EMAIL));
			message.setReplyTo(InternetAddress.parse(userEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(adminEmail));
			message.setSubject("����������� � ���������� ����� � ����������");
		
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setText("������������!�����(�) �� ������ � ����� ���������� ��� �����");

			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			String filename = locationOfBook;// change accordingly
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			multipart.addBodyPart(messageBodyPart2);
			message.setContent(multipart);

			Transport.send(message);

		} catch (MessagingException ex) {
			throw new EmailException(ex);
		}
	}
}
