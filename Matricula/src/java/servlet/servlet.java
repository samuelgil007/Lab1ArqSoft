/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import admin.Admin;
import admin.AdminFacadeLocal;
import estudiante.Estudiante;
import estudiante.EstudianteFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import materia.Materia;
import materia.MateriaFacadeLocal;
import materiaxestudiante.Materiaxestudiante;
import materiaxestudiante.MateriaxestudianteFacadeLocal;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;

/**
 *
 * @author Samuel
 */
public class servlet extends HttpServlet {

    @EJB
    private MateriaxestudianteFacadeLocal materiaxestudianteFacade;

    @EJB
    private MateriaFacadeLocal materiaFacade;

    @EJB
    private AdminFacadeLocal adminFacade;

    @EJB
    private EstudianteFacadeLocal estudianteFacade;

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
            throws ServletException, IOException, FileUploadException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        final FileItemFactory factory = new DiskFileItemFactory();
        final ServletFileUpload upload = new ServletFileUpload(factory);

        try {
            String action = request.getParameter("action");
            String url = "/Matricula/index.jsp";
            if ("buscarEst".equals(action)) {
                String u = request.getParameter("cedulaEst");
                Estudiante a = estudianteFacade.find(u);
                request.getSession().setAttribute("busqueda", a);
                List<Materiaxestudiante> lista = materiaxestudianteFacade.findAll();
                List<Materia> materias = materiaFacade.findAll();
                request.getSession().setAttribute("busquedaMateriax", lista);
                request.getSession().setAttribute("busquedaMateria", materias);
                url = "/Matricula/admin/managerAdmin.jsp";
            } else if ("list".equals(action)) {
                List<Admin> findAll = adminFacade.findAll();
                List<Estudiante> findAll2 = estudianteFacade.findAll();
                request.getSession().setAttribute("admins", findAll);
                request.getSession().setAttribute("estudiantes", findAll2);
                url = "/Matricula/admin/listAccounts.jsp";
            } else if ("login".equals(action)) {
                String u = request.getParameter("username");
                String p = request.getParameter("password");
                boolean checkLogin = adminFacade.checkLogin(u, p);
                boolean checkLogin2 = estudianteFacade.checkLogin(u, p);
                if (checkLogin) {
                    request.getSession().setAttribute("admin", u);
                    url = "/Matricula/admin/managerAdmin.jsp";
                } else if (checkLogin2) {
                    request.getSession().setAttribute("estudiante", u);
                    List<Estudiante> a = estudianteFacade.findAll();
                    List<Materiaxestudiante> c = materiaxestudianteFacade.findAll();
                    String cedula = "";
                    for (int i = 0; i < a.size(); i++) {

                        if (a.get(i).getUsername().equals(request.getSession().getAttribute("estudiante"))) {
                            cedula = a.get(i).getCedula();
                        }
                    }
                    Estudiante tr = estudianteFacade.find(cedula);
                    System.out.println("noImagen".equals(tr.getImagen()));
                    request.getSession().setAttribute("img", "noImagen".equals(tr.getImagen()));
                    request.getSession().setAttribute("cedulaGlobal", cedula);
                    url = "/Matricula/estudiante/managerEstudiante.jsp";
                } else {
                    url = "/Matricula/login.jsp?error=1";
                }
            } else if ("insert".equals(action)) {
                String tipo = request.getParameter("tipo");
                url = "login.jsp";
                if (adminFacade.find(request.getParameter("cedula")) == null && estudianteFacade.find(request.getParameter("cedula")) == null) {
                    if ("admin".equals(tipo)) {
                        Admin a = new Admin();
                        a.setUsername(request.getParameter("username"));
                        a.setPassword(request.getParameter("password"));
                        a.setNombre(request.getParameter("nombre"));
                        a.setCedula(request.getParameter("cedula"));
                        adminFacade.create(a);
                    } else if ("estudiante".equals(tipo)) {
                        Estudiante a = new Estudiante();
                        a.setUsername(request.getParameter("username"));
                        a.setPassword(request.getParameter("password"));
                        a.setNombre(request.getParameter("nombre"));
                        a.setCedula(request.getParameter("cedula"));
                        a.setImagen("noImagen");
                        estudianteFacade.create(a);
                    }
                } else {
                    url = "newAccount.jsp?error=1";
                }
            } else if ("deleteEstudiante".equals(action)) {
                String ced = request.getParameter("cedula");
                Estudiante a = estudianteFacade.find(ced);
                estudianteFacade.remove(a);
                url = "servlet?action=list";
            } else if ("deleteAdmin".equals(action)) {
                String ced = request.getParameter("cedula");
                Admin a = adminFacade.find(ced);
                adminFacade.remove(a);
                url = "servlet?action=list";
            } else if ("materias".equals(action)) {
                List<Materia> materias = materiaFacade.findAll();
                request.getSession().setAttribute("busquedaMateria", materias);   
                url = "/Matricula/estudiante/matricula.jsp";
            } else if ("matricular".equals(action)) {
                List<Estudiante> a = estudianteFacade.findAll();
                List<Materiaxestudiante> c = materiaxestudianteFacade.findAll();
                String cedula = "";
                for (int i = 0; i < a.size(); i++) {
                    
                    if (a.get(i).getUsername().equals(request.getSession().getAttribute("estudiante"))){
                        cedula = a.get(i).getCedula();
                    }
                }
                Boolean bol = false;
                String f = request.getParameter("codigo");
                for (int i = 0; i < c.size(); i++) {
                    if(c.get(i).getCodigo().equals(f)  && c.get(i).getCedula().equals(cedula)){
                        bol = true;
                    }
                }
                if(bol){
                    url = "/Matricula/estudiante/matricula.jsp?error=1";
                } else {
                    Materiaxestudiante rt = new Materiaxestudiante();
                    rt.setCedula(cedula);
                    rt.setCodigo(f);
                    materiaxestudianteFacade.create(rt);
                    url = "/Matricula/estudiante/matricula.jsp?error=2";
                }  
           
            } else if ("cancelar".equals(action)) {
                List<Estudiante> a = estudianteFacade.findAll();
                List<Materiaxestudiante> c = materiaxestudianteFacade.findAll();
                String cedula = "";
                for (int i = 0; i < a.size(); i++) {

                    if (a.get(i).getUsername().equals(request.getSession().getAttribute("estudiante"))) {
                        cedula = a.get(i).getCedula();
                    }
                }
                Boolean bol = false;
                String f = request.getParameter("codigo");
                int index = 999;
                for (int i = 0; i < c.size(); i++) {
                    if (c.get(i).getCodigo().equals(f) && c.get(i).getCedula().equals(cedula)) {
                        bol = true;
                        index = c.get(i).getId();
                    }
                }
                if (bol) {
                    Materiaxestudiante rt = materiaxestudianteFacade.find(index);
                    materiaxestudianteFacade.remove(rt);
                    url = "/Matricula/estudiante/matricula.jsp?error=3";
                } else {
                    url = "/Matricula/estudiante/matricula.jsp?error=4";
                }
            } else if ("logout".equals(action)) {
                request.getSession().removeAttribute("admin");
                request.getSession().removeAttribute("estudiante");
                request.getSession().removeAttribute("img");
                url = "/Matricula/login.jsp";
            }
            response.sendRedirect(url);
        } finally {
            out.close();
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
