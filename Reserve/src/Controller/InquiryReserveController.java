package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Persistance.ReservationDAO;
import Persistance.ReservationDTO;

@WebServlet("/inquiry")
public class InquiryReserveController extends HttpServlet {
	
	private ReservationDAO reserveDAO = new ReservationDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<ReservationDTO> reserveArr;		
		reserveArr = reserveDAO.inquiry();
		
		req.setAttribute("reserve",reserveArr);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/InquiryReserveView.jsp");
		dispatcher.forward(req,resp);

	}

}
