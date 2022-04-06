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
@WebServlet(name = "operacionesTipo", urlPatterns = {"/operacionesTipo"})
public class operacionesTipo extends HttpServlet {

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
                String nombreTipo = request.getParameter("nombreTipo");
                conection db = new conection();
                String result = db.insertar_Tipo(nombreTipo);
                if(result.equals("Error al crear")){
                    request.setAttribute("Error", "Ya existe un tipo con ese nombre");
                }
                else{
                    request.removeAttribute("Error");
                    request.getSession().setAttribute("opcionesTipo", db.buscar_tipo());
                }
                request.getRequestDispatcher("/AdminTipo.jsp").forward(request, response);
            }
            if(valor.equals("2")){
                String tipoEliminar = request.getParameter("tipoEliminar");
                conection db = new conection();
                db.borrar_Tipo(Integer.valueOf(tipoEliminar));
                request.getSession().setAttribute("opcionesTipo", db.buscar_tipo());
                request.getRequestDispatcher("/AdminTipo.jsp").forward(request, response);
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
