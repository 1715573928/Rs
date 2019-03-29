package com.stx.Severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.Manager.*;





/**
 * Servlet implementation class GiveAllPriceSeverlet
 */
@WebServlet("/GiveAllPriceSeverlet")
public class GiveAllPriceSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveAllPriceSeverlet() {
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
		int tableid=Integer.parseInt(request.getParameter("tableid"));
//		int allprice=Integer.parseInt(request.getParameter("allprice"));
		Cashier cs=new Cashier();
		int y=cs.Jiezhang(tableid);
		if(y>0){
			
			response.sendRedirect("jiezhangcg.jsp");
		}
		
	}

}
