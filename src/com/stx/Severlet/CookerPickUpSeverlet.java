package com.stx.Severlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.Manager.Cooker;
import com.stx.Model.CookerPickUp;

/**
 * Servlet implementation class CookerPickUpSeverlet
 */
@WebServlet("/CookerPickUpSeverlet")
public class CookerPickUpSeverlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookerPickUpSeverlet() {
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
		request.setCharacterEncoding("utf-8");
		Cooker c=new Cooker();
		String s=request.getParameter("username");
		//System.out.println(s);
		String[] str=request.getParameterValues("name");
		String[] str1=request.getParameterValues("qname");
		//System.out.println(str.length);
		//System.out.println(str1.length);
		for(int i=0;i<str.length;i++){
			if(str[i]!=""){
				
//				System.out.println(str[i]);
//				System.out.println(Integer.parseInt(str1[i]));
				c.pickup(str[i], Integer.parseInt(str1[i]), s);
		}
		}
		response.sendRedirect("/RestaurantSystem/PickUpCg.jsp");
		
	}
}
