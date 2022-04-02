/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bases_2_p1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.*;
/**
 *
 * @author Persona
 */
public class conection {
    Connection con;
    
    public conection(){
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-CIEC5JL:1523:GRP08DB","pd","pd");
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
    public String datos(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Tipo_Colaborador_PK.Buscar}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                datoss += "<option value=" 
                        + resultado.getString("id_tipo")+
                        ">"+
                        resultado.getString("Tipo")
                        +"</option>";
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    public String insertar_Tipo(String nombre){
        try {
            CallableStatement stnt = con.prepareCall("{call Tipo_Colaborador_PK.crearTipo(?,?)}");
            stnt.setString(1, nombre);
            stnt.registerOutParameter(2, OracleTypes.NUMBER);
            stnt.execute();
            int estado = stnt.getInt(2);
            if(estado == 1){
                return "Todo correcto";
            }
            else{
                return "Error al crear";
            }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no se pudo inicializar";
    }
    
    public Connection getConnection(){
        return null;
    }
}
