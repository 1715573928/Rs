package com.stx.Severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.Manager.Delete_Cai_Dao;

/**
 * Servlet implementation class Delete_Cai
 */
@WebServlet("/Delete_Cai")
public class Delete_Cai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Cai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("dname");
		//System.out.println(name+"--------dname-----");
		Delete_Cai_Dao dcd = new Delete_Cai_Dao();
		int i = dcd.method(name);
		if(i>0)
		{
			response.sendRedirect("/RestaurantSystem/ckcdkxg.jsp");
		}else
		{
			 
		}
	}

}
