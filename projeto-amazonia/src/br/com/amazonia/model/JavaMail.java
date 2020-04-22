package br.com.amazonia.model;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {

	public void confirmacaoEmail(Cliente cliente, double valorTotal){
		Properties props = new Properties();
		/** Par�metros de conex�o com servidor Gmail */
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("seu-email-aqui@gmail.com", "sua-senha-aqui");
			}
		});

		/** Ativa Debug para sess�o */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("seu-email-aqui@gmail.com"));
			// Remetente

			Address[] toUser = InternetAddress // Destinat�rio(s)
					.parse(cliente.getCadastro().getEmail());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Amazonia - Confirma��o de compra");// Assunto
			message.setText("Parab�ns por adquirir nossos produtos! Esperamos que aproveite. :)\n"
					+ "Valor total do Pedido: " + valorTotal);
			/** M�todo para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}