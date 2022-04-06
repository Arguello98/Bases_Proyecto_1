/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import clases.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proyecto2.bases_2_p1.conection;

/**
 *
 * @author Persona
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            String valor = request.getParameter("tipologin");
            if(valor == null){
                valor = "-1";
            }
            if(valor.equals("1")){
                String uname = request.getParameter("username");
                String pass = request.getParameter("password");
                HttpSession session = request.getSession();
                session.setAttribute("username", uname);
                session.setAttribute("password", pass);
                conection db = new conection();
                User colaborador = db.Login_Colaborador(uname, pass);
                if(colaborador != null){
                    session.removeAttribute("username");
                    session.removeAttribute("password");
                    session.setAttribute("opcionesTipo", db.buscar_tipo());
                    session.setAttribute("opcionesSucursal", db.buscar_Sucursal());
                    session.setAttribute("opcionesProducto", db.buscar_Producto());
                    session.setAttribute("opcionesProveedor", db.buscar_Proveedor());
                    session.setAttribute("usuario", colaborador);
                    session.setAttribute("usuarios",db.buscar_Colaborador());
                    request.getRequestDispatcher("/dashboardAdmin.jsp").forward(request, response);
                }
                else{
                    String error = "Usuario o contraseña incorrecto";
                    request.setAttribute("Error", error);
                    request.getRequestDispatcher("/loginadmin.jsp").forward(request, response);
                }   
            }
            else{
                String uname = request.getParameter("username");
                String pass = request.getParameter("password");
                request.getSession().setAttribute("username", uname);
                request.getSession().setAttribute("password", pass);
                conection db = new conection();
                User usuario = db.Login_Cliente(uname, pass);
                if(usuario != null){
                    request.getSession().removeAttribute("username");
                    request.getSession().removeAttribute("password");
                    request.setAttribute("opcionesTipo", db.buscar_tipo());
                    request.setAttribute("opcionesSucursal", db.buscar_Sucursal());
                    request.setAttribute("opcionesProducto", db.buscar_Producto());
                    request.setAttribute("usuario", usuario);
                    request.setAttribute("usuarios",db.buscar_Colaborador());
                    request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
                }
                else{
                    String error = "Usuario o contraseña incorrecto";
                    request.setAttribute("Error", error);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
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
