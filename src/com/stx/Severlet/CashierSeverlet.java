package com.stx.Severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.Manager.Cashier;

/**
 * Servlet implementation class CashierSeverlet
 */
@WebServlet("/CashierSeverlet")
public class CashierSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CashierSeverlet() {
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
		String cai=request.getParameter("diancai");
		String table=request.getParameter("tableid");
		//System.out.println(cai);
	//	System.out.println(table);
		String[] a=cai.split(",");
//		for(int i=0;i<a.length-1;i++){
//			
//			System.out.println(a[i]);
//		}
		for(int i=0;i<a.length;i++){
			
			cs.DianCai(Integer.parseInt(a[i]),Integer.parseInt(table));
		}
		response.sendRedirect("/RestaurantSystem/ckcd.jsp");
	}
}
