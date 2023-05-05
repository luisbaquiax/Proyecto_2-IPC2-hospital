/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospitalapi.servletController.laboratorio;

import com.hospitalapi.objects.JsonConverter;
import com.hospitalapi.service.laboratorio.ServiceReportLaboratorio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis
 */
@WebServlet(name = "ServletControllerReportLab", urlPatterns = {"/ServletControllerReportLab"})
public class ServletControllerReportLab extends HttpServlet {

    private ServiceReportLaboratorio serviceReport;
    private JsonConverter converter;

    public ServletControllerReportLab() {
        this.serviceReport = new ServiceReportLaboratorio();
        this.converter = new JsonConverter();
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
        String tarea = request.getParameter("tarea");
        switch (tarea) {
            case "topExamenes":
                sendListTopExamenes(request, response);
                break;
            case "topPacientes":
                sendListTopPacientes(request, response);
                break;
            default:
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
    }

    private void sendListTopExamenes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(this.converter.toJson(this.serviceReport.getListTopExamenes(Integer.parseInt(request.getParameter("id")))));
    }

    private void sendListTopPacientes(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(this.converter.toJson(this.serviceReport.getListTopPaciente(Integer.parseInt(request.getParameter("id")))));
    }

}
