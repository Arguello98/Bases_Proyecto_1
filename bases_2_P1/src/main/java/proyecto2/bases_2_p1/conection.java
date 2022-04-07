/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.bases_2_p1;

import clases.ProductoCompra;
import clases.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    
    //Tipo
    
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
    public void borrar_Tipo(int id_tipo){
        try {
            CallableStatement stnt = con.prepareCall("{call Tipo_Colaborador_PK.borrarTipo(?)}");
            stnt.setInt(1, id_tipo);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String buscar_tipo(){
        
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
    //sucursal
    public String insertar_Sucursal(String nombre, String direccion){
        try {
            CallableStatement stnt = con.prepareCall("{call Sucursal_Package.crear_Sucursal(?,?,?)}");
            stnt.setString(1, nombre);
            stnt.setString(2, direccion);
            stnt.registerOutParameter(3, OracleTypes.NUMBER);
            stnt.execute();
            int estado = stnt.getInt(3);
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
    public void borrar_Sucursal(int id){
        try {
            CallableStatement stnt = con.prepareCall("{call Sucursal_Package.borrar_Sucursal(?)}");
            stnt.setInt(1, id);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizar_Sucursal(int id,String nombre, String direccion){
        try {
            CallableStatement stnt = con.prepareCall("{call Sucursal_Package.Actualizar(?,?,?)}");
            stnt.setInt(1, id);
            stnt.setString(2, nombre);
            stnt.setString(3, direccion);
            stnt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String buscar_Sucursal(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Sucursal_Package.Buscar}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                datoss += "<option value=" 
                        + resultado.getString("id_sucursal")+
                        ">"+
                        resultado.getString("nombre")
                        +"</option>";
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    public void buscar_Sucursal_modificar(int id_sucursal,String [] arguments){
        
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Sucursal_Package.Buscar_id(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2, id_sucursal);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                arguments[0] =resultado.getString("NOMBRE");
                arguments[1] =resultado.getString("DIRECCION");
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //proveedor
    public String insertar_Proveedor(String nombre, Date fecha){
        try {
            CallableStatement stnt = con.prepareCall("{call Proveedor_Package.crear_Proveedor(?,?,?)}");
            stnt.setString(1, nombre);
            stnt.setDate(2,fecha);
            stnt.registerOutParameter(3, OracleTypes.NUMBER);
            stnt.execute();
            int estado = stnt.getInt(3);
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
    public void borrar_Proveedor(int id){
        try {
            CallableStatement stnt = con.prepareCall("{call Proveedor_Package.borrar_Proveedor(?)}");
            stnt.setInt(1, id);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizar_Proveedor(int id,String nombre){
        try {
            CallableStatement stnt = con.prepareCall("{call Proveedor_Package.Actualizar(?,?)}");
            stnt.setInt(1, id);
            stnt.setString(2, nombre);
            stnt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String buscar_Proveedor(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Proveedor_Package.Buscar}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                datoss += "<option value=" 
                        + resultado.getString("id_proveedor")+
                        ">"+
                        resultado.getString("nombre")
                        +"</option>";
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    //Producto
    public String insertar_Producto(String nombre, int precio ,int stock ,String descipcion){
        try {
            CallableStatement stnt = con.prepareCall("{call Producto_Package.crear_Producto(?,?,?,?,?)}");
            stnt.setString(1, nombre);
            stnt.setInt(2, precio);
            stnt.setInt(3, stock);
            stnt.setString(4, descipcion);
            stnt.registerOutParameter(5, OracleTypes.NUMBER);
            stnt.execute();
            int estado = stnt.getInt(5);
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
    public void borrar_Producto(int id){
        try {
            CallableStatement stnt = con.prepareCall("{call Producto_Package.borrar_Producto(?)}");
            stnt.setInt(1, id);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizar_Producto_Descripcion(int id_producto,String Descripcion, int id_colaborador){
        try {
            CallableStatement stnt = con.prepareCall("{call Producto_Package.Actualizar_Descripcion(?,?)}");
            stnt.setInt(1, id_producto);
            stnt.setString(2, Descripcion);
            stnt.execute();
            CallableStatement stnt2 = con.prepareCall("{call Bitacora_Package.Terminar_Bitacora(?)}");
            stnt2.setInt(1, id_colaborador);
            stnt2.execute();
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar_Producto_Precio(int id_producto,int precio, int id_colaborador){
        try {
            CallableStatement stnt = con.prepareCall("{call Producto_Package.Actualizar_Precio(?,?)}");
            stnt.setInt(1, id_producto);
            stnt.setInt(2, precio);
            stnt.execute();
            CallableStatement stnt2 = con.prepareCall("{call Bitacora_Package.Terminar_Bitacora(?)}");
            stnt2.setInt(1, id_colaborador);
            stnt2.execute();
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public String buscar_Producto(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Producto_Package.Buscar}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                datoss += "<option value=" 
                        + resultado.getString("ID_PRODUCTO")+
                        ">"+
                        resultado.getString("nombre")
                        +"</option>";
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
     public String buscar_Nombre_Producto(int id_Producto){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Producto_Package.Buscar_id(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2,id_Producto);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                datoss += resultado.getString("nombre");
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
     public void buscar_Producto_modificar_Precio(int id_sucursal,String [] arguments){
        
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Producto_Package.Buscar_id(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2, id_sucursal);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                arguments[0] =resultado.getString("NOMBRE");
                arguments[1] =resultado.getString("PRECIO");
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscar_Producto_modificar_Descripcion(int id_sucursal,String [] arguments){
        
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Producto_Package.Buscar_id(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2, id_sucursal);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                arguments[0] =resultado.getString("NOMBRE");
                arguments[1] =resultado.getString("DESCRIPCION");
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void agregar_stock_Producto(int id_producto,int cantidad){
        try {
            CallableStatement stnt = con.prepareCall("{call Producto_Package.Agregar_Stock(?,?)}");
            stnt.setInt(1, id_producto);
            stnt.setInt(2, cantidad);
            stnt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public int verificar_stock_Producto(int id_producto,int cantidad){
        try {
            CallableStatement stnt = con.prepareCall("{? = call Producto_Package.Verificar(?,?)}");
            stnt.setInt(2, id_producto);
            stnt.setInt(3, cantidad);
            stnt.registerOutParameter(1,OracleTypes.NUMBER);
            stnt.execute();
            int estado = stnt.getInt(1);
            return estado;
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int comprar_Producto(int id_producto,int cantidad){
        try {
            CallableStatement stnt = con.prepareCall("{? = call Producto_Package.Comprar(?,?)}");
            stnt.setInt(2, id_producto);
            stnt.setInt(3, cantidad);
            stnt.registerOutParameter(1,OracleTypes.NUMBER);
            stnt.execute();
            int estado = stnt.getInt(1);
            return estado;
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    } 
    
     //proovedorxproducto
     public void insertar_RelacionProdxProv(int id_producto ,int id_provedor){
        try {
            CallableStatement stnt = con.prepareCall("{call ProductoxProveedor_Package.crear_Relacion(?,?)}");
            stnt.setInt(1, id_producto);
            stnt.setInt(2, id_provedor);
            stnt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void borrar_RelacionProdxProv(int id_producto ,int id_provedo){
        try {
            CallableStatement stnt = con.prepareCall("{call ProductoxProveedor_Package.borrar_Relacion(?,?)}");
            stnt.setInt(1, id_producto);
            stnt.setInt(2, id_provedo);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //colaborador
    public String insertar_Colaborador(int id_tipo, int id_sucursal,  String nombre, String apellido1,  String apellido2, String direccion, Date fecha_nacimiento,
                                        int telefono, String email, String contraseña){
        try {
            CallableStatement stnt = con.prepareCall("{call Colaborador_Package.crear_Colaborador(?,?,?, ?,?,?, ?,?,?, ?,?)}");
            stnt.setInt(1, id_tipo);
            stnt.setInt(2, id_sucursal);
            stnt.setString(3, nombre);
            stnt.setString(4, apellido1);
            stnt.setString(5, apellido2);
            stnt.setString(6, direccion);
            stnt.setDate(7, fecha_nacimiento);
            stnt.setInt(8, telefono);
            stnt.setString(9, email);
            stnt.setString(10, contraseña);
            stnt.registerOutParameter(11, OracleTypes.NUMBER);
            stnt.execute();
            int estado = stnt.getInt(11);
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
    
    public void borrar_Colaborador(int id){
        try {
            CallableStatement stnt = con.prepareCall("{call Colaborador_Package.borrar_Colaborador(?)}");
            stnt.setInt(1, id);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizar_Colaborador(int id_colaborador,int id_tipo, int id_sucursal,  String nombre, String apellido1,  String apellido2, String direccion, Date fecha_nacimiento,
                                        int telefono, String email, String contraseña){
        try {
            CallableStatement stnt = con.prepareCall("{call Colaborador_Package.Actualizar_Colaborador(?,?,?, ?,?,?, ?,?,?, ?,?)}");
            
            stnt.setInt(1, id_colaborador);
            stnt.setInt(2, id_tipo);
            stnt.setInt(3, id_sucursal);
            stnt.setString(4, nombre);
            stnt.setString(5, apellido1);
            stnt.setString(6, apellido2);
            stnt.setString(7, direccion);
            stnt.setDate(8, fecha_nacimiento);
            stnt.setInt(9, telefono);
            stnt.setString(10, email);
            stnt.setString(11, contraseña);
            stnt.execute();
    
    }   catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public User Login_Colaborador(String correo, String contraseña){
        User colaborador = null;
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Colaborador_Package.Login(?,?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setString(2, correo);
            stnt.setString(3, contraseña);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                colaborador= new User(resultado.getInt("ID_COLABORADOR"),
                                resultado.getInt("ID_TIPO"),
                                resultado.getInt("ID_SUCURSAL"),
                                resultado.getString("NOMBRE"),
                                resultado.getString("APELLIDO_1"),
                                resultado.getString("APELLIDO_2"),
                                resultado.getString("DIRECCION"),
                                resultado.getDate("FECHA_NACIMIENTO"),
                                resultado.getInt("TELEFONO"),
                                resultado.getString("EMAIL"),
                                resultado.getString("CONTRASEÑA")
                                );
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return colaborador;
    }
    
    public String buscar_Colaborador(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Colaborador_Package.Buscar}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table class="+"table"+">";
            datoss += "<tr>"+"<td>"+ "Id"+ "</td>" +
                        "<td>"+ "Id Tipo"+ "</td>" +
                        "<td>"+ "Id Sucursal"+ "</td>" +
                        "<td>"+ "Nombre"+ "</td>" +
                        "<td>"+ "Apellido"+ "</td>" +
                        "<td>"+ "Segundo apellido"+ "</td>" +
                        "<td>"+ "Direccion"+ "</td>" +
                        "<td>"+ "Fecha de nacimiento"+ "</td>" +
                        "<td>"+ "Telefono"+ "</td>" +
                        "<td>"+ "Correo"+ "</td>" +
                        "<td>"+ "Contraseña"+ "</td>" +"</tr>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "<td>"+ resultado.getString(5)+ "</td>" +
                        "<td>"+ resultado.getString(6)+ "</td>" +
                        "<td>"+ resultado.getString(7)+ "</td>" +
                        "<td>"+ resultado.getString(8)+ "</td>" +
                        "<td>"+ resultado.getString(9)+ "</td>" +
                        "<td>"+ resultado.getString(10)+ "</td>" +
                        "<td>"+ resultado.getString(11)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    public String buscar_Colaborador_id(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Colaborador_Package.Buscar}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                datoss += "<option value=" 
                        +resultado.getString(1)+
                        ">"+
                       resultado.getString(1)
                        +"</option>";
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    public String buscar_Colaborador_por_Sucursal(int id_Sucursal){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Colaborador_Package.Buscar_por_sucursal(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2,id_Sucursal);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "<td>"+ resultado.getString(5)+ "</td>" +
                        "<td>"+ resultado.getString(6)+ "</td>" +
                        "<td>"+ resultado.getString(7)+ "</td>" +
                        "<td>"+ resultado.getString(8)+ "</td>" +
                        "<td>"+ resultado.getString(9)+ "</td>" +
                        "<td>"+ resultado.getString(10)+ "</td>" +
                        "<td>"+ resultado.getString(11)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    
    public String buscar_Colaborador_por_Tipo(int id_Tipo){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Colaborador_Package.Buscar_por_tipo(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2,id_Tipo);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "<td>"+ resultado.getString(5)+ "</td>" +
                        "<td>"+ resultado.getString(6)+ "</td>" +
                        "<td>"+ resultado.getString(7)+ "</td>" +
                        "<td>"+ resultado.getString(8)+ "</td>" +
                        "<td>"+ resultado.getString(9)+ "</td>" +
                        "<td>"+ resultado.getString(10)+ "</td>" +
                        "<td>"+ resultado.getString(11)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    
    public String buscar_Colaborador_por_correo(String email){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Colaborador_Package.Buscar_por_correo(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setString(2,email);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "<td>"+ resultado.getString(5)+ "</td>" +
                        "<td>"+ resultado.getString(6)+ "</td>" +
                        "<td>"+ resultado.getString(7)+ "</td>" +
                        "<td>"+ resultado.getString(8)+ "</td>" +
                        "<td>"+ resultado.getString(9)+ "</td>" +
                        "<td>"+ resultado.getString(10)+ "</td>" +
                        "<td>"+ resultado.getString(11)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    
    public String buscar_Colaborador_por_nombre(String nombre){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Colaborador_Package.Buscar_por_Nombre(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setString(2,nombre);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "<td>"+ resultado.getString(5)+ "</td>" +
                        "<td>"+ resultado.getString(6)+ "</td>" +
                        "<td>"+ resultado.getString(7)+ "</td>" +
                        "<td>"+ resultado.getString(8)+ "</td>" +
                        "<td>"+ resultado.getString(9)+ "</td>" +
                        "<td>"+ resultado.getString(10)+ "</td>" +
                        "<td>"+ resultado.getString(11)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    //cliente
    public String insertar_Cliente(String nombre, String apellido1,  String apellido2, String direccion, Date fecha_nacimiento,
                                        int telefono, String email, String contraseña){
        try {
            CallableStatement stnt = con.prepareCall("{call Cliente_Package.crear_Cliente(?,?,? ,?,?,?, ?,?,?)}");
            stnt.setString(1, nombre);
            stnt.setString(2, apellido1);
            stnt.setString(3, apellido2);
            stnt.setString(4, direccion);
            stnt.setDate(5, fecha_nacimiento);
            stnt.setInt(6, telefono);
            stnt.setString(7, email);
            stnt.setString(8, contraseña);
            stnt.registerOutParameter(9, OracleTypes.NUMBER);
            stnt.execute();
            int estado = stnt.getInt(9);
            if(estado == 1){
                return "Todo correcto";
            }
            else{
                return "correo ya en uso";
            }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "no se pudo inicializar";
    }
    
    public void actualizar_Cliente(int id_cliente, String nombre, String apellido1,  String apellido2, String direccion, Date fecha_nacimiento,
                                        int telefono, String email, String contraseña){
        try {
            CallableStatement stnt = con.prepareCall("{call Cliente_Package.Actualizar_Cliente(?,?,? ,?,?,?, ?,?,?)}");
            stnt.setInt(1, id_cliente);
            stnt.setString(2, nombre);
            stnt.setString(3, apellido1);
            stnt.setString(4, apellido2);
            stnt.setString(5, direccion);
            stnt.setDate(6, fecha_nacimiento);
            stnt.setInt(7, telefono);
            stnt.setString(8, email);
            stnt.setString(9, contraseña);
            stnt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrar_Cliente(int id_cliente){
        try {
            CallableStatement stnt = con.prepareCall("{call Cliente_Package.borrar_Cliente(?)}");
            stnt.setInt(1, id_cliente);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrar_Cliente_Correo(String correo){
        try {
            CallableStatement stnt = con.prepareCall("{call Cliente_Package.borrar_Cliente_Correo(?)}");
            stnt.setString(1, correo);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String buscar_Cliente(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Cliente_Package.Buscar}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "<td>"+ resultado.getString(5)+ "</td>" +
                        "<td>"+ resultado.getString(6)+ "</td>" +
                        "<td>"+ resultado.getString(7)+ "</td>" +
                        "<td>"+ resultado.getString(8)+ "</td>" +
                        "<td>"+ resultado.getString(9)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    
    public String buscar_Cliente_por_Correo(String correo){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Cliente_Package.Buscar_por_correo(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setString(2, correo);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                         "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "<td>"+ resultado.getString(5)+ "</td>" +
                        "<td>"+ resultado.getString(6)+ "</td>" +
                        "<td>"+ resultado.getString(7)+ "</td>" +
                        "<td>"+ resultado.getString(8)+ "</td>" +
                        "<td>"+ resultado.getString(9)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    public User Login_Cliente(String correo, String contraseña){
        User colaborador = null;
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Cliente_Package.Login(?,?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setString(2, correo);
            stnt.setString(3, contraseña);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            while(resultado.next()){
                colaborador= new User(resultado.getInt("ID_CLIENTE"),
                                -1,
                                -1,
                                resultado.getString("NOMBRE"),
                                resultado.getString("APELLIDO_1"),
                                resultado.getString("APELLIDO_2"),
                                resultado.getString("DIRECCION"),
                                resultado.getDate("FECHA_NACIMIENTO"),
                                resultado.getInt("TELEFONO"),
                                resultado.getString("EMAIL"),
                                resultado.getString("CONTRASEÑA")
                                );
             }
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return colaborador;
    }
    //factura
       public int insertar_Factura(int id_Sucursal ,int id_Cliente, Date fecha_compra){
           int id= -1;
        try {
            CallableStatement stnt = con.prepareCall("{call Factura_Package.crear_Factura(?,?,?,?)}");
            stnt.setInt(1, id_Sucursal);
            stnt.setInt(2, id_Cliente);
            stnt.setDate(3, fecha_compra);
            stnt.registerOutParameter(4, OracleTypes.INTEGER);
            stnt.execute();
            id = stnt.getInt(4);
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public void borrar_Factura(int id_factura){
        try {
            CallableStatement stnt = con.prepareCall("{call Factura_Package.borrar_Factura(?)}");
            stnt.setInt(1,id_factura);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String buscar_Factura(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Factura_Package.Buscar}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    
    public String buscar_Factura_Fecha(Date fecha_inicio, Date fecha_final){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Factura_Package.Buscar_Fecha(?,?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setDate(2, fecha_inicio);
            stnt.setDate(3, fecha_final);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    
    
    public String buscar_Factura_Sucursal(int id_Sucursal){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Factura_Package.Buscar_Sucursal(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2, id_Sucursal);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    
    public String buscar_Factura_Sucursal_Fecha(int id_Sucursal, Date fecha_inicio, Date fecha_final){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Factura_Package.Buscar_Sucursal_Fecha(?,?,?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2, id_Sucursal);
            stnt.setDate(3, fecha_inicio);
            stnt.setDate(4, fecha_final);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                       "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    
    public String buscar_Factura_Cliente(int id_Cliente){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Factura_Package.Buscar_Cliente(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2, id_Cliente);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    
    public String buscar_Factura_Cliente_Fecha(int id_Cliente, Date fecha_inicio, Date fecha_final){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Factura_Package.Buscar_Cliente_Fecha(?,?,?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2, id_Cliente);
            stnt.setDate(3, fecha_inicio);
            stnt.setDate(4, fecha_final);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    //Detalle
    public void insertar_Detalle(int id_factura ,int id_producto, int cantidad){
        try {
            CallableStatement stnt = con.prepareCall("{call Detalle_Package.crear_Detalle(?,?,?)}");
            stnt.setInt(1, id_factura);
            stnt.setInt(2, id_producto);
            stnt.setInt(3, cantidad);
            stnt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrar_Detalle(int id_Detalle){
        try {
            CallableStatement stnt = con.prepareCall("{call Detalle_Package.borrar_Detalle(?)}");
            stnt.setInt(1,id_Detalle);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void borrar_Detalle_por_Factura(int id_Factura){
        try {
            CallableStatement stnt = con.prepareCall("{call Detalle_Package.borrar_Detalle(?)}");
            stnt.setInt(1,id_Factura);
            stnt.execute();
            } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public String buscar_Detalle_por_Factura(int id_Factura){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Detalle_Package.Buscar_Factura(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2, id_Factura);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
     
     public String buscar_Detalle_por_Producto(int id_Producto){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Detalle_Package.Buscar_Producto(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2, id_Producto);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
    
     public String buscar_Detalle_por_Producto_Todos(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Detalle_Package.Buscar_Producto_todos}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
     
     public String buscar_Detalle_por_Sucursal(int id_Sucursal){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Detalle_Package.Buscar_Sucursal(?)}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.setInt(2, id_Sucursal);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
     
     public String buscar_Detalle_por_Sucursal_Todos(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Detalle_Package.Buscar_Sucursal_todas}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
    }
     //bitacora
      public String buscar_Bitacora(){
        
        String datoss = "";
        try {
            CallableStatement stnt = con.prepareCall("{ ? = call Bitacora_Package.Buscar}");
            stnt.registerOutParameter(1,OracleTypes.CURSOR);
            stnt.execute();
            ResultSet resultado = (ResultSet) stnt.getObject(1);
            datoss += "<table class="+"table"+">";
            datoss += "<tr>"+"<td>"+ "Id"+ "</td>" +
                        "<td>"+ "Nombre Producto"+ "</td>" +
                        "<td>"+ "Valor Anterior"+ "</td>" +
                        "<td>"+ "Valor Nuevo"+ "</td>" +
                        "<td>"+ "ID Colaborador"+ "</td>" +
                        "<td>"+ "Fecha de Modificacion"+ "</td>" +
                        "</tr>";
            while(resultado.next()){
                datoss += "<tr>" +
                        "<td>"+ resultado.getString(1)+ "</td>" +
                        "<td>"+ resultado.getString(2)+ "</td>" +
                        "<td>"+ resultado.getString(3)+ "</td>" +
                        "<td>"+ resultado.getString(4)+ "</td>" +
                        "<td>"+ resultado.getString(5)+ "</td>" +
                        "<td>"+ resultado.getString(6)+ "</td>" +
                        "</tr>";
             }
            datoss += "</table>";
        } catch (SQLException ex) {
            Logger.getLogger(conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datoss;
      }
     public void comprar(ArrayList<ProductoCompra> productos,int id_Sucursal, int id_Cliente, Date fechaCompra){
         int id_Factura = this.insertar_Factura(id_Sucursal, id_Cliente, fechaCompra);
         for (int i = 0; i < productos.size(); i++) {
             this.comprar_Producto(productos.get(i).getId_Producto(), productos.get(i).getCantidad());
             this.insertar_Detalle(id_Factura,productos.get(i).getId_Producto(), productos.get(i).getCantidad());
         }
     }
    public Connection getConnection(){
        return this.con;
    }
     
}
