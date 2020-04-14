/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author user
 */
public class ConnexionBD{
         private static ConnexionBD data;
	private Connection con;
	public String user = "khaoula";
	public String password = "admin";
	public String url = "jdbc:mysql://127.0.0.1:3306/symfony?useUnicode=true&amp;characterEncoding=utf8";
	private ConnexionBD() {

		try {
                    if (System.getProperty("os.name").equals("Linux") )
                        Class.forName("com.mysql.jdbc.Driver");
                    else
                        Class.forName("com.mysql.jdbc.Driver");
                    
                   con = DriverManager.getConnection(url, user, password);
                   System.out.println("Connexion établie!");
		}
             
		catch (SQLException e)  {
			Logger.getLogger("DataSource: "+ e.getMessage());
			
		}
                
                catch (ClassNotFoundException e) {
                    Logger.getLogger("DataSource: " + e.getLocalizedMessage());
                }
	}

	public static ConnexionBD getInstance() {
		
		if (data == null)
			data = new ConnexionBD();
		return data;

	}

	public Connection getCon() {
        try {
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
		return con;
	}}

