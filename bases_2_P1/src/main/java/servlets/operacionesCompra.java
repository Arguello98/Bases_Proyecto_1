/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.ProductoCompra;
import clases.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto2.bases_2_p1.conection;

/**
 *
 * @author Persona
 */
@WebServlet(name = "operacionesCompra", urlPatterns = {"/operacionesCompra"})
public class operacionesCompra extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             String valor = request.getParameter("operacion");
            if(valor == ""){
                valor = "-1";
            }
            if(valor.equals("1")){
                
                String tipoProducto = request.getParameter("tipoProducto");
                String cantidad = request.getParameter("cantidad");
                if(tipoProducto != "" && cantidad != ""){
                    conection db = new conection();
                    if(db.verificar_stock_Producto(Integer.valueOf(tipoProducto), Integer.valueOf(cantidad)) == -1){
                        ArrayList<ProductoCompra> productos = (ArrayList<ProductoCompra>)request.getSession().getAttribute("ArregloProductos");
                        if(productos ==null){
                            productos = new ArrayList<ProductoCompra>();
                        }
                        productos.add(new ProductoCompra(Integer.valueOf(tipoProducto),db.buscar_Nombre_Producto(Integer.valueOf(tipoProducto)) ,Integer.valueOf(cantidad)));
                        String tablaCarrito = "<table class="+"table"+">";
                        tablaCarrito +="<tr>"+"<td>"+ "Id"+ "</td>" +
                            "<td>"+ "Nomrbe del Producto"+ "</td>" +
                            "<td>"+ "Cantidad"+ "</td>" +"</tr>";
                        for (int i = 0; i < productos.size(); i++) {
                            tablaCarrito += "<tr>"+"<td>"+ productos.get(i).getId_Producto()+ "</td>" +
                                            "<td>"+ productos.get(i).getNombre()+ "</td>" +
                                            "<td>"+ productos.get(i).getCantidad() + "</td>"+"</tr>";
                        }
                        request.getSession().setAttribute("ArregloProductos", productos);
                        request.getSession().setAttribute("tablaCarrito", tablaCarrito);
                    }
                    else{
                        request.setAttribute("Error", "No hay suficiente stock");
                    } 
                }
                else{
                    request.setAttribute("Error", "Debe especificar una cantidad");
                }
                request.getRequestDispatcher("/Comprar.jsp").forward(request, response); 
            }
            if(valor.equals("2")){
                String opcionesSucursal = request.getParameter("opcionesSucursal");
                if(opcionesSucursal != ""){
                    conection db = new conection();
                    ArrayList<ProductoCompra> productos = (ArrayList<ProductoCompra>)request.getSession().getAttribute("ArregloProductos");
                    if(productos ==null){
                          request.setAttribute("Error", "No hay Productos en el carrito");
                    }
                    else{
                        User usuario = (User)request.getSession().getAttribute("usuario");
                        System.out.println(Integer.valueOf(opcionesSucursal));
                        System.out.println(usuario.getId_Usuario());
                        System.out.println(Date.valueOf(java.time.LocalDate.now()));
                        System.out.println(productos.size());
                        db.comprar(productos, Integer.valueOf(opcionesSucursal),usuario.getId_Usuario(), Date.valueOf(java.time.LocalDate.now()));
                        request.getSession().removeAttribute("ArregloProductos");
                        request.getSession().removeAttribute("tablaCarrito");
                  }
                }
               request.getRequestDispatcher("/Comprar.jsp").forward(request, response);  
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
