package com.stx.Severlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stx.Manager.DianCan;
import com.stx.Model.Sccp;

/**
 * Servlet implementation class DianCan_Severlet
 */
@WebServlet("/DianCan_Severlet")
public class DianCan_Severlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DianCan_Severlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DianCan dc = new DianCan();
		ArrayList<Sccp> arr = dc.method();
		
		HttpSession hs =request.getSession();
		hs.setAttribute("DianCan", arr);
		
		response.sendRedirect("/RestaurantSystem/diancan.jsp");

		
	}

}
