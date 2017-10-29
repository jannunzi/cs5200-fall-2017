package lectures.jdbc.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.jdbc.dao.*;

@WebServlet("/Website")
public class Website extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Website() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WebsiteDao wdao = WebsiteDao.getInstance();
		ArrayList<lecture.jdbc.model.Website> websites = wdao.findAllWebsites();
		System.out.println(websites);
		response.setContentType("text/html");
		response.getWriter().append("<h1>Hello from website servlet</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
