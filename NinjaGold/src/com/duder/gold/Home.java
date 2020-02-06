package com.duder.gold;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static String sessionGold = "gold";
	
	private Building[] buildings;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
	   this.buildings = new Building[]{
	       new Building(1,30,true,"corner"),
	       new Building(3,6,false,"house"),
	       new Building(4,8,false,"dojo"),
	       new Building(50,100,true,"casino")
	   };
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		Integer sessionGold = (Integer)session.getAttribute("gold");
		
		// if first-time-user, sessionGold will be NULL
		if(sessionGold == null) {
			// we set session gold to 0
			session.setAttribute("gold", 0);
		}
		
		// we now have to send session value over to view!
		request.setAttribute("gold", sessionGold);
		request.setAttribute("buildings", this.buildings);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String buildingName = (String)request.getParameter("building");
		
		// initialize Random object
		Random rand = new Random();
		
		
		// get current gold
		HttpSession session = request.getSession();
		Integer currentGold = (Integer)session.getAttribute("gold");
		Integer goldThisTurn = 0;
		
		switch(buildingName) {
		case "farm": // 0
			// 1-30
			goldThisTurn = this.buildings[0].min + rand.nextInt(this.buildings[0].max);
			// do farm stuff
			break;
		case "house": // 1
			// 3-6
			goldThisTurn = this.buildings[1].min + rand.nextInt(this.buildings[1].max);
			// do house stuff
			break;
		case "dojo": // 2
			// 4-6
			goldThisTurn = this.buildings[2].min + rand.nextInt(this.buildings[2].max);
			// do dojo stuff
			break;
		default: // 3
			// flip a coin
			// +/- 50-100
			goldThisTurn = this.buildings[3].min + rand.nextInt(this.buildings[3].max);
			if(rand.nextBoolean()) {
				// 50% chance of LOSING money
				goldThisTurn = goldThisTurn * -1;
			}
			// do casino stuff
		}
		session.setAttribute("gold", currentGold + goldThisTurn);
		
		
		response.sendRedirect("/NinjaGold/Home");
	}

}
