/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.User;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "operacionesProducto", urlPatterns = {"/operacionesProducto"})
public class operacionesProducto extends HttpServlet {

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
                String nombreProducto = request.getParameter("nombreProducto");
                String precioProducto = request.getParameter("precioProducto");
                String stockProducto = request.getParameter("stockProducto");
                String descripcionProducto = request.getParameter("descripcionProducto");
                conection db = new conection();
                if(nombreProducto != "" && precioProducto != "" && stockProducto != "" && descripcionProducto != ""){
                    String result = db.insertar_Producto(nombreProducto, Integer.valueOf(precioProducto), Integer.valueOf(stockProducto), descripcionProducto);
                    if(result.equals("Error al crear")){
                        request.setAttribute("Error", "Ya existe una Sucursal con ese nombre");
                    }
                    else{
                        request.removeAttribute("Error");
                        request.getSession().setAttribute("opcionesProducto", db.buscar_Producto());
                    }
                    request.getRequestDispatcher("/AdministrarProducto.jsp").forward(request, response);
                 
                }
                else{
                   request.setAttribute("Error", "debe llenar todos los campos");
                   request.getRequestDispatcher("/AdministrarProducto.jsp").forward(request, response);
                }
            }
            if(valor.equals("2")){
                String tipoEliminar = request.getParameter("tipoEliminar");
                conection db = new conection();
                db.borrar_Producto(Integer.valueOf(tipoEliminar));
                request.getSession().setAttribute("opcionesProducto", db.buscar_Producto());
                request.getRequestDispatcher("/AdministrarProducto.jsp").forward(request, response);
            }
            if(valor.equals("3")){
                String tipoEliminar = request.getParameter("tipoModificar");
                String valores [] = {"",""};
                conection db = new conection();
                db.buscar_Producto_modificar_Precio(Integer.valueOf(tipoEliminar),valores);
                request.getSession().setAttribute("producto_id",tipoEliminar);
                request.getSession().setAttribute("producto_nombre", valores[0]);
                request.getSession().setAttribute("producto_precio", valores[1]);
                request.getRequestDispatcher("/modificarProductoPrecio.jsp").forward(request, response);
            }
            if(valor.equals("4")){
                String tipoEliminar = request.getParameter("tipoModificar");
                String valores [] = {"",""};
                conection db = new conection();
                db.buscar_Producto_modificar_Descripcion(Integer.valueOf(tipoEliminar),valores);
                request.getSession().setAttribute("producto_id",tipoEliminar);
                request.getSession().setAttribute("producto_nombre", valores[0]);
                request.getSession().setAttribute("producto_descripcion", valores[1]);
                request.getRequestDispatcher("/modificarProductoDescripcion.jsp").forward(request, response);
            }
            if(valor.equals("5")){
                String precio = request.getParameter("producto_precio");
                String id_Producto =request.getParameter("id_modificar");
                User colaborador = (User) request.getSession().getAttribute("usuario");

                conection db = new conection();
                db.actualizar_Producto_Precio(Integer.valueOf(id_Producto), Integer.valueOf(precio) ,colaborador.getId_Usuario());
                request.getSession().setAttribute("opcionesProducto", db.buscar_Producto());
                request.getRequestDispatcher("/AdministrarProducto.jsp").forward(request, response);
            }
            if(valor.equals("6")){
                String descripcion = request.getParameter("producto_descripcion");
                String id_Producto =request.getParameter("id_modificar");
                User colaborador = (User) request.getSession().getAttribute("usuario");
                conection db = new conection();
                System.out.println(descripcion);
                System.out.println(id_Producto);
                System.out.println(colaborador.getId_Usuario());
                db.actualizar_Producto_Descripcion(Integer.valueOf(id_Producto), descripcion,colaborador.getId_Usuario());
                request.getSession().setAttribute("opcionesProducto", db.buscar_Producto());
                request.getRequestDispatcher("/AdministrarProducto.jsp").forward(request, response);
            }
            if(valor.equals("7")){
                String tipoEliminar = request.getParameter("tipoAgregar");
                String cantidad = request.getParameter("stockProducto");
                conection db = new conection();
                db.agregar_stock_Producto(Integer.valueOf(tipoEliminar),Integer.valueOf(cantidad));
                request.getSession().setAttribute("opcionesProducto", db.buscar_Producto());
                request.getRequestDispatcher("/AdministrarProducto.jsp").forward(request, response);
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
