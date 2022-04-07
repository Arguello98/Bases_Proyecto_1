/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import proyecto2.bases_2_p1.conection;

/**
 *
 * @author Persona
 */
@WebServlet(name = "cambioPantalla", urlPatterns = {"/cambioPantalla"})
public class cambioPantalla extends HttpServlet {

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
            String a = request.getParameter("cambio");
            if(a.equals("0")){
                request.getRequestDispatcher("/dashboardAdmin.jsp").forward(request, response);
            }
            if(a.equals("1")){
                request.getRequestDispatcher("/AdminTipo.jsp").forward(request, response);
            }
            if(a.equals("2")){
               request.getRequestDispatcher("/AdminSucursal.jsp").forward(request, response); 
            }
            if(a.equals("3")){
                request.getRequestDispatcher("/AdministrarProducto.jsp").forward(request, response); 
            }
            if(a.equals("4")){
                request.getRequestDispatcher("/AdministrarProveedor.jsp").forward(request, response); 
            }
            if(a.equals("5")){
                conection db = new conection();
                request.getSession().setAttribute("tablaColaboradores",db.buscar_Colaborador());
                request.getRequestDispatcher("/AdministrarColaborador.jsp").forward(request, response); 
            }
            if(a.equals("6")){
                conection db = new conection();
                request.getSession().setAttribute("tablaBitacora",db.buscar_Bitacora());
                request.getRequestDispatcher("/Administrarbitacora.jsp").forward(request, response); 
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
