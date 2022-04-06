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
import proyecto2.bases_2_p1.conection;

/**
 *
 * @author Persona
 */
@WebServlet(name = "Registro", urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

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
             if(request.getParameter("registro").equals("1")){
                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String lastname1 = request.getParameter("lastname1");
                String lastname2 = request.getParameter("lastname2");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String birthDate = request.getParameter("birthDate");
                String password = request.getParameter("password");
             
                
                
                request.setAttribute("email", email);
                request.setAttribute("name", name);
                request.setAttribute("lastname1", lastname1);
                request.setAttribute("lastname2", lastname2);
                request.setAttribute("phone", phone);
                request.setAttribute("address", address);
                request.setAttribute("birthDate", birthDate);
                request.setAttribute("password", password);
                conection db = new conection();
                
                if(email != "" && name != "" && lastname1 != "" && lastname2 != "" && phone != "" && address != "" && birthDate != "" && password != ""){
                    String mensaje = db.insertar_Cliente(name, lastname1, lastname2, address, Date.valueOf(birthDate), Integer.valueOf(phone), email, password);
                    if(mensaje.equals("Todo correcto")){
                        request.getSession().removeAttribute("email");
                        request.getSession().removeAttribute("name");
                        request.getSession().removeAttribute("lastname1");
                        request.getSession().removeAttribute("lastname2");
                        request.getSession().removeAttribute("phone");
                        request.getSession().removeAttribute("address");
                        request.getSession().removeAttribute("birthDate");
                        request.getSession().removeAttribute("password");
                        request.getRequestDispatcher("/index.jsp").forward(request, response);
                    }
                    else{
                        String error = mensaje;
                        request.setAttribute("Error", error);
                        request.getRequestDispatcher("/register.jsp").forward(request, response);
                    }
                }
                else{  
                    String error = "Debe lenar todos los campos";
                    request.setAttribute("Error", error);
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
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
