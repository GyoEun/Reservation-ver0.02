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

import Persistance.*;

@WebServlet("/inquiry")
public class InquiryCancelController extends HttpServlet {
	
	private CancelDAO canceldao= new CancelDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<CancelDTO> reserveArr;		
		reserveArr = canceldao.inquiry();
		
		req.setAttribute("reserve",reserveArr);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/InquiryCancelView.jsp");
		dispatcher.forward(req,resp);

	}

}
