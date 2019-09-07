/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.control;

import com.sun.javafx.css.CalculatedValue;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.model.maytinh;

/**
 *
 * @author Admin
 */
public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String a = request.getParameter("txtso1");
            String b = request.getParameter("txtso2");
//chuyển kiểu dữ liệu
            int so1 = Integer.parseInt(a);
            int so2 = Integer.parseInt(b);
            //kiểm tra action
            if (action.equals("+")) {
                maytinh tinh = new maytinh();
                out.write(so1 + " + " + so2 + " = " + tinh.cong(so1, so2));
            } else if (action.equals("-")) {
                maytinh tinh = new maytinh();
                out.write(so1 + " - " + so2 + " = " + tinh.tru(so1, so2));
            } else if (action.equals("*")) {
                maytinh tinh = new maytinh();
                out.write(so1 + " * " + so2 + " = " + tinh.nhan(so1, so2));
            } else if (action.equals("/")) {
                maytinh tinh = new maytinh();
                out.write(so1 + " / " + so2 + " = " + tinh.chia(so1, so2));
            }
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
