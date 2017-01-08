package LN;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class clsMensaje{
 
	
	protected static ArrayList<clsUsuario>usuario;
	protected static LinkedList<clsBebida>bebida;
	protected static LinkedList<clsAlimento>alimento;
	protected static ArrayList<clsAdquisicion>compras;
	
	public static void correoU( )
	{
  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     
  Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
     final String username = "anne.idigoraspagola@gmail.com";//
     final String password = "tontoelquelolea2";
     try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator()
     {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                return new PasswordAuthentication(username, password);
                             }});

   // Crear mensaje
     Message msg = new MimeMessage(session);

  // Seleccionamos emisor y receptor
     msg.setFrom(new InternetAddress("anne.idigoraspagola@gmail.com"));
     msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(clsAdministrador.Correo,false));
     msg.setSubject("Estadísticas");
     msg.setText("Adjuntamos los datos de los siguientes usuarios:");
     usuario=clsGestor.leerUsuario();
     for(clsUsuario aux:usuario)
     {
    	 msg.setText( " Nombre: "+ aux.getNombre()+  " Apellido: "+ aux.getApellido()+ " Dni: "+ aux.getDni());
     }
     
     msg.setSentDate(new Date());
     Transport.send(msg);
     System.out.println("Message sent.");
  }
     catch (MessagingException e)
     { System.out.println("Error de envío por: " + e);}
  }
	public static void correo_identificacion( )
	{
  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     
  Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
     final String username = "anne.idigoraspagola@gmail.com";//
     final String password = "tontoelquelolea2";
     try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator()
     {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                return new PasswordAuthentication(username, password);
                             }});

   // Crear mensaje
     Message msg = new MimeMessage(session);

  // Seleccionamos emisor y receptor
     msg.setFrom(new InternetAddress("anne.idigoraspagola@gmail.com"));
     msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(clsAdministrador.Correo,false));
     msg.setSubject("Identificación administrador");
     msg.setText("Adjuntamos el nombre de usuario y la contraseña para ingresar a la plataforma de la maquina expendedora: \n" +" Usuario: admin \n"+" Contraseña: hola");
     msg.setSentDate(new Date());
     Transport.send(msg);
     System.out.println("Message sent.");
  }
     catch (MessagingException e)
     { System.out.println("Error de envío por: " + e);}
  }
	
	public static void correoB( )
	{
  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     
  Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
     final String username = "anne.idigoraspagola@gmail.com";//
     final String password = "tontoelquelolea2";
     try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator()
     {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                return new PasswordAuthentication(username, password);
                             }});

   // Crear mensaje
     Message msg = new MimeMessage(session);

  // Seleccionamos emisor y receptor
     msg.setFrom(new InternetAddress("anne.idigoraspagola@gmail.com"));
     msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(clsAdministrador.Correo,false));
     msg.setSubject("Estadísticas");
     msg.setText("Adjuntamos los datos de las bebidas registradas:");
     bebida=clsGestor.BebidasGuardadas();
     for(clsBebida aux:bebida)
     {
    	 msg.setText( " Nombre: "+ aux.getNombreP()+  " ID: "+ aux.getId()+ " Precio: "+ aux.getPrecioP());
     }
     
     msg.setSentDate(new Date());
     Transport.send(msg);
     System.out.println("Message sent.");
  }
     catch (MessagingException e)
     { System.out.println("Error de envío por: " + e);}
  }
	public static void correoA( )
	{
  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     
  Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
     final String username = "anne.idigoraspagola@gmail.com";//
     final String password = "tontoelquelolea2";
     try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator()
     {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                return new PasswordAuthentication(username, password);
                             }});

   // Crear mensaje
     Message msg = new MimeMessage(session);

  // Seleccionamos emisor y receptor
     msg.setFrom(new InternetAddress("anne.idigoraspagola@gmail.com"));
     msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(clsAdministrador.Correo,false));
     msg.setSubject("Estadísticas");
     msg.setText("Adjuntamos los datos de las bebidas registradas:");
     alimento=clsGestor.AlimentosGuardados();
     for(clsAlimento aux:alimento)
     {
    	 msg.setText( alimento.size()+" Nombre: "+ aux.getNombreP()+  " ID: "+ aux.getId()+ " Precio: "+ aux.getPrecioP()+"Cantidad: "+aux.getNum());
     }
     
     msg.setSentDate(new Date());
     Transport.send(msg);
     System.out.println("Message sent.");
  }
     catch (MessagingException e)
     { System.out.println("Error de envío por: " + e);}
  }
	
	public static void correoC( )
	{
  final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
  // Get a Properties object
     
  Properties props = System.getProperties();
     props.setProperty("mail.smtp.host", "smtp.gmail.com");
     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
     props.setProperty("mail.smtp.socketFactory.fallback", "false");
     props.setProperty("mail.smtp.port", "465");
     props.setProperty("mail.smtp.socketFactory.port", "465");
     props.put("mail.smtp.auth", "true");
     props.put("mail.debug", "true");
     props.put("mail.store.protocol", "pop3");
     props.put("mail.transport.protocol", "smtp");
     final String username = "anne.idigoraspagola@gmail.com";//
     final String password = "tontoelquelolea2";
     try{
     Session session = Session.getDefaultInstance(props, 
                          new Authenticator()
     {
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                return new PasswordAuthentication(username, password);
                             }});

   // Crear mensaje
     Message msg = new MimeMessage(session);

  // Seleccionamos emisor y receptor
     msg.setFrom(new InternetAddress("anne.idigoraspagola@gmail.com"));
     msg.setRecipients(Message.RecipientType.TO, 
                      InternetAddress.parse(clsAdministrador.Correo,false));
     msg.setSubject("Estadísticas");
     msg.setText("Adjuntamos los datos de las compras registradas:");
     compras=clsGestor.leerAdquisicion();
     for(clsAdquisicion aux:compras)
     {
    	 
    	 msg.setText( " Nombre: "+ aux.getDni_usuario()+  " ID: "+aux.getId_producto() );
     }
     
     msg.setSentDate(new Date());
     Transport.send(msg);
     System.out.println("Message sent.");
  }
     catch (MessagingException e)
     { System.out.println("Error de envío por: " + e);}
  }
	
	
}
