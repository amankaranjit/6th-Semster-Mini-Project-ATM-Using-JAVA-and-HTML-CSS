/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.aadimcollege.servlet;

import com.aadimcollege.bean.UserBean;
import com.aadimcollege.db.JDBCConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yubaraj
 */
public class UserListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Connection cn = JDBCConnection.getConnection();
            String sql = "select * from user";
            Statement stat = cn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            List<UserBean> userList = new ArrayList<UserBean>();
            
            while(rs.next()){
                UserBean userBean = new UserBean();
                userBean.setAddress(rs.getString("address"));
                userBean.setFirstName(rs.getString("first_name"));
                userBean.setId(rs.getInt("id"));
                userBean.setLastName(rs.getString("last_name"));
                               
                userList.add(userBean);
            }
            System.out.println("Total Users"+ userList.size());
            
            request.setAttribute("userList", userList);
            
            RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
            rd.forward(request, response);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}