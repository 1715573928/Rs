package com.stx.Severlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stx.Manager.CKCD_dao;
import com.stx.Model.Sccp;

/**
 * Servlet implementation class CKCD_Severlet
 */
@WebServlet("/CKCD_Severlet")
public class CKCD_Severlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CKCD_Severlet() {
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
		CKCD_dao cd = new CKCD_dao();
		ArrayList<Sccp> arr = cd.method();
		
		HttpSession hs =request.getSession();
		hs.setAttribute("DianCan", arr);
		
		response.sendRedirect("/RestaurantSystem/ckcd.jsp");
	}

}
