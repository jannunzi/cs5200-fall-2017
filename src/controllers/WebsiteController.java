package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.jdbc.dao.WebsiteDao;
import lecture.jdbc.model.Website;

/**
 * Servlet implementation class WebsiteController
 */
@WebServlet("/WebsiteController")
public class WebsiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebsiteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		WebsiteDao wdao = WebsiteDao.getInstance();
		
		String action = request.getParameter("action");
		String id = request.getParameter("websiteId");
		Website website = null;
		
		if("delete".equals(action)) {
			if(id != null) {
				int websiteId = Integer.parseInt(id);
				wdao.deleteWebsite(websiteId);
			}
		} else if ("select".equals(action)) {
			if(id != null) {
				int websiteId = Integer.parseInt(id);
				website = wdao.findWebsiteById(websiteId);
				request.setAttribute("website", website);
			}
		}
		
		ArrayList<Website> websites = wdao.findAllWebsites();
		request.setAttribute("websites", websites);
		String nextJSP = "/simpleDaoExample.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		WebsiteDao wdao = WebsiteDao.getInstance();
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Website website = new Website(111, name, description);
		
		if("update".equals(action)) {
			if(id != null) {
				int websiteId = Integer.parseInt(id);
				wdao.updateWebsite(websiteId, website);
			}
		} else {
			wdao.createWebsite(website);
		}
		
		doGet(request, response);
	}

}
