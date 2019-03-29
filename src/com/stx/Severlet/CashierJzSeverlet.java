package com.stx.Severlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stx.Manager.Cashier;
import com.stx.Model.CashierModel;

/**
 * Servlet implementation class CashierJzSeverlet
 */
@WebServlet("/CashierJzSeverlet")
public class CashierJzSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashierJzSeverlet() {
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
		Cashier cs=new Cashier();
		int tableid=Integer.parseInt(request.getParameter("table"));
		ArrayList<CashierModel> cm=cs.SeeJeZhang(tableid);
		HttpSession hs=request.getSession();
		HttpSession hss=request.getSession();
		hss.setAttribute("tableid", tableid);
	 	hs.setAttribute("CaiPrice", cm);
		response.sendRedirect("/RestaurantSystem/AllPrice.jsp");
	}
}
