package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Persistance.ReservationDAO;
import Persistance.ReservationDTO;

import java.text.DecimalFormat;

import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterReserveController extends HttpServlet {
	private ReservationDAO reservedao = new ReservationDAO();
	
	DecimalFormat df = new DecimalFormat("00");
	Calendar currentCalendar = Calendar.getInstance(); 
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	String strYear = Integer.toString(currentCalendar.get(Calendar.YEAR));
    	String strMonth = df.format(currentCalendar.get(Calendar.MONTH) + 1);
    	String strDay = df.format(currentCalendar.get(Calendar.DATE));
    	String strDate = strYear + "-" +strMonth +"-"+ strDay; 
    	String Reservation_Date= strDate;
    	
    	String Reservation_Start=req.getParameter("start");
    	String Reservation_End = req.getParameter("end");

    	ReservationDTO dto = new ReservationDTO("0",req.getParameter("fName"), "980127", req.getParameter("rName"),
    			req.getParameter("pnum"),  req.getParameter("cnt"), Reservation_Date,Reservation_Start,Reservation_End,
    			req.getParameter("carNum"), req.getParameter("carName"), "0");
    	
		int rs = reservedao.register(dto);
		PrintWriter out = resp.getWriter();
		
		if(rs==1){
			out.print("<script>alert('성공적으로 등록되었습니다');window.opener.location.reload(); window.close(); </script>");
		}else{
			out.print("<script>alert('등록이 실패하였습니다');window.opener.location.reload(); window.close(); </script>");
		}
	}

}
