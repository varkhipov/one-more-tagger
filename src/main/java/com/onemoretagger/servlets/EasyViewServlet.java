package com.onemoretagger.servlets;



import com.onemoretagger.Program;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;




/**
 * Created by Sus on 27.07.2017.
 */
public class EasyViewServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Program.main();
        req.setAttribute("name", Program.trackInfo);
        req.getRequestDispatcher("mypage.jsp").forward(req, resp);
    }
}