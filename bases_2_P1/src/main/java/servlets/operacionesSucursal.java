/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

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
@WebServlet(name = "operacionesSucursal", urlPatterns = {"/operacionesSucursal"})
public class operacionesSucursal extends HttpServlet {

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
            if(valor == null){
                valor = "-1";
            }
            if(valor.equals("1")){
                String nombreSucursal = request.getParameter("nombreSucursal");
                String descripcion = request.getParameter("direccionSucursal");
                conection db = new conection();
                String result = db.insertar_Sucursal(nombreSucursal,descripcion);
                if(result.equals("Error al crear")){
                    request.setAttribute("Error", "Ya existe una Sucursal con ese nombre");
                }
                else{
                    request.removeAttribute("Error");
                    request.getSession().setAttribute("opcionesSucursal", db.buscar_Sucursal());
                }
                request.getRequestDispatcher("/AdminSucursal.jsp").forward(request, response);
            }
            if(valor.equals("2")){
                String tipoEliminar = request.getParameter("tipoEliminar");
                conection db = new conection();
                db.borrar_Sucursal(Integer.valueOf(tipoEliminar));
                request.getSession().setAttribute("opcionesSucursal", db.buscar_Sucursal());
                request.getRequestDispatcher("/AdminSucursal.jsp").forward(request, response);
            }
            if(valor.equals("3")){
                String tipoEliminar = request.getParameter("tipoModificar");
                String valores [] = {"",""};
                conection db = new conection();
                db.buscar_Sucursal_modificar(Integer.valueOf(tipoEliminar),valores);
                request.getSession().setAttribute("sucursal_id",tipoEliminar);
                request.getSession().setAttribute("sucursal_nombre", valores[0]);
                request.getSession().setAttribute("sucursal_descripcion", valores[1]);
                request.getRequestDispatcher("/modificarSucursal.jsp").forward(request, response);
            }
            if(valor.equals("4")){
                String nombreNuevo = request.getParameter("sucursal_nombre");
                String direccion = request.getParameter("sucursal_descripcion");
                String id_Sucursal =request.getParameter("id_modificar");
                conection db = new conection();
                db.actualizar_Sucursal(Integer.valueOf(id_Sucursal), nombreNuevo, direccion);
                request.getSession().setAttribute("opcionesSucursal", db.buscar_Sucursal());
                request.getRequestDispatcher("/AdminSucursal.jsp").forward(request, response);
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
