/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

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
 * @author joseg
 */
@WebServlet(name = "colaborador", urlPatterns = {"/colaborador"})
public class colaborador extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            String valor = request.getParameter("operacion");
            if (valor == null) {
                valor = "-1";
            }
            if (valor.equals("1")) {
                String tipo = request.getParameter("tipoColaborador");
                String sucursal = request.getParameter("sucursal");
                String name = request.getParameter("nombreColaborador");
                String lastname1 = request.getParameter("primerApellidoColaborador");
                String lastname2 = request.getParameter("segundoApellidoColaborador");
                String direction = request.getParameter("direccionColaborador");
                String birthDate = request.getParameter("fechaNacimientoColaborador");
                String email = request.getParameter("correoColaborador");
                String password = request.getParameter("passwordColaborador");
                String phoneColaborador = request.getParameter("phoneColaborador");
                conection db = new conection();
                 if(email != "" && name != "" && lastname1 != "" && lastname2 != "" && phoneColaborador != "" && direction != "" && birthDate != "" && password != ""){
                         String result = db.insertar_Colaborador(Integer.valueOf(tipo), Integer.valueOf(sucursal), name, lastname1, lastname2, direction, Date.valueOf(birthDate), Integer.valueOf(phoneColaborador), email, password);
                         System.out.println(result);
                         if (result.equals("Error al crear")) {
                           request.setAttribute("Error", "Colaborador ya existe!");
                        } else {
                            request.removeAttribute("Error");
                            request.getSession().setAttribute("opcionesColaborador", db.buscar_Colaborador_id());
                            request.getSession().setAttribute("tablaColaboradores",db.buscar_Colaborador());
                        }
                        request.getRequestDispatcher("/AdministrarColaborador.jsp").forward(request, response);
                 }
                 else{
                     request.setAttribute("Error", "Debe llenar todos los campos!");
                     request.getRequestDispatcher("/AdministrarColaborador.jsp").forward(request, response);
                 }
            }
            if (valor.equals("2")) {
                String tipoEliminar = request.getParameter("tipoEliminar");
                conection db = new conection();
                db.borrar_Colaborador(Integer.valueOf(tipoEliminar));
                request.getSession().setAttribute("opcionesColaborador", db.buscar_Colaborador_id());
                request.getSession().setAttribute("tablaColaboradores",db.buscar_Colaborador());
                request.getRequestDispatcher("/AdministrarColaborador.jsp").forward(request, response);
            }
            if (valor.equals("3")) {
                String tipo = request.getParameter("tipoColaborador");
                String sucursal = request.getParameter("sucursal");
                String name = request.getParameter("nombreColaborador");
                String lastname1 = request.getParameter("primerApellidoColaborador");
                String lastname2 = request.getParameter("segundoApellidoColaborador");
                String direction = request.getParameter("Direccion");
                String birthDate = request.getParameter("fechaNacimientoColaborador");
                String email = request.getParameter("correoColaborador");
                String password = request.getParameter("passwordColaborador");
                String phoneColaborador = request.getParameter("phoneColaborador");
                String colaborador_id =request.getParameter("colaborador_id");
                conection db = new conection();
                db.actualizar_Colaborador(Integer.valueOf(colaborador_id),Integer.valueOf(tipo), Integer.valueOf(sucursal), name, lastname1, lastname2, direction, Date.valueOf(birthDate), Integer.valueOf(phoneColaborador), email, password);
                request.getRequestDispatcher("/AdministrarColaborador.jsp").forward(request, response);
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
