package LD;

import java.io.File;
import java.sql.*;
import javax.swing.*;

public class ConexionSql 
{
	Connection conn = null;
	
	public static Connection dbConnector ()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");

//			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ALUMNO\\Documents\\Git\\BasketCoach\\BasketCoach\\BasketCoach(Database).s3db");

			File fichero = new File("BasketCoach(Database).s3db");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + fichero.getAbsolutePath());

			JOptionPane.showMessageDialog(null, "Connection Successful");
			return conn;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
	


	public static String DirectorioActual()
	{
	    String directorio = System.getProperty("java.class.path");
	    File dir = new File(directorio);
	    String directorioPadre = dir.getParent();
	    return directorioPadre;
	}
	
}
