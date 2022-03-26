/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bases_2_p1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Persona
 */
public class conection {
    Connection con;
    
    public conection(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:ProyectoBD","pr","pr");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void login(String uname, String pass){
        
        try {
            CallableStatement stnt = con.prepareCall("{call prueba_insersion(?,?)}");
            stnt.setString(1, uname);
            stnt.setString(2, pass);
            stnt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        return null;
    }
}
