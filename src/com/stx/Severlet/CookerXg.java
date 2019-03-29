package com.stx.Severlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stx.Manager.Cooker;

/**
 * Servlet implementation class CookerXg
 */
@WebServlet("/CookerXg")
public class CookerXg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookerXg() {
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
//		System.out.println(request.getParameter("ycl_id"));
//		System.out.println(request.getParameter("name"));
//		System.out.println(request.getParameter("quantity"));
//		System.out.println(request.getParameter("people"));
//		System.out.println(request.getParameter("zhuangtai"));
		int id=Integer.parseInt(request.getParameter("ycl_id"));
		String name=request.getParameter("name");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		String people=request.getParameter("people");
		//String zhuangtai=request.getParameter("zhuangtai");
		Cooker ck=new Cooker();
		int x=ck.updatepickup(id, name, quantity, people);
		if(x>0){
			
			response.sendRedirect("/RestaurantSystem/PickUpCg-xgcg.jsp");
		}else{
			
			response.sendRedirect("/RestaurantSystem/PickUpCg_xgsb.jsp");
		}
	}
}
