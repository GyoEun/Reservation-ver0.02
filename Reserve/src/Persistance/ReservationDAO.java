package Persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ReservationDAO {
	private DataSource ds;
	
	public ReservationDAO(){
		try{
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	//조회
	public ArrayList<ReservationDTO> inquiry(){
		Connection conn = null;
		Statement st= null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sogongdo.reservation WHERE isCancel = '0'";
		ArrayList<ReservationDTO> reservationArr = new ArrayList<ReservationDTO>();
		
	
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String reserveID = rs.getString("Reservation_ID");
				String Facilities_Name = rs.getString("Facilities_Name");
				String memberID = rs.getString("Member_ID");
				String reserveName = rs.getString("Reservation_Name");
				String reservePnum = rs.getString("Reservation_Phone_Number");
				String HeadCount = rs.getString("HeadCount");
				String reserveDate = rs.getString("Reservation_Date");
				String reserveStart = rs.getString("Reservation_Start");
				String reserveEnd = rs.getString("Reservation_End");
				String isCancel = rs.getString("isCancel");
				String carNum = rs.getString("Car_Num");
				String carName = rs.getString("Car_Name");

				ReservationDTO dto = new ReservationDTO(reserveID,Facilities_Name,memberID, reserveName, reservePnum,
						HeadCount, reserveDate, reserveStart, reserveEnd,carNum,carName,isCancel);
				
				reservationArr.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservationArr;
	}
	
	//수정 -> 조회
	public ReservationDTO inquiry(String rID){
		Connection conn = null;
		Statement st= null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM sogongdo.reservation WHERE Reservation_ID = '"+rID+"'";
		
		ReservationDTO reservationArr= null;
		try {
			conn = ds.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if (rs.next()) {
				String reserveID = rs.getString("Reservation_ID");
				String Facilities_Name = rs.getString("Facilities_Name");
				String memberID = rs.getString("Member_ID");
				String reserveName = rs.getString("Reservation_Name");
				String reservePnum = rs.getString("Reservation_Phone_Number");
				String HeadCount = rs.getString("HeadCount");
				String reserveDate = rs.getString("Reservation_Date");
				String reserveStart = rs.getString("Reservation_Start");
				String reserveEnd = rs.getString("Reservation_End");
				String isCancel = rs.getString("isCancel");
				String carNum = rs.getString("Car_Num");
				String carName = rs.getString("Car_Name");

				ReservationDTO dto = new ReservationDTO(reserveID,Facilities_Name,memberID, reserveName, reservePnum,
						HeadCount, reserveDate, reserveStart, reserveEnd,carNum,carName,isCancel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservationArr;
	}
	
	
	// 등록
	public int register(ReservationDTO reservation) {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		
		String sql1 = "INSERT INTO sogongdo.reservation (Facilities_Name, Member_ID, Reservation_Name,Reservation_Phone_Number,"
				+ "HeadCount, Reservation_Date, Reservation_Start, Reservation_End, isCancel,Car_Num, Car_Name) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		String sql2 =  "INSERT INTO sogongdo.reservation (Facilities_Name, Member_ID, Reservation_Name,Reservation_Phone_Number,"
				+ "HeadCount, Reservation_Date, Reservation_Start, Reservation_End, isCancel) VALUES(?,?,?,?,?,?,?,?,?)";
		
		
		try {
			conn = ds.getConnection();
			
			if(reservation.getCar_Name() != null) {
				st = conn.prepareStatement(sql1);
			
				st.setString(1,reservation.getFacilities_Name());
				st.setString(2,reservation.getMember_ID());
				st.setString(3,reservation.getReservation_Name());
				st.setString(4,reservation.getReservation_Phone_Number());
				st.setString(5,reservation.getHeadCount());
				st.setString(6,reservation.getReservation_Date());
				st.setString(7,reservation.getReservation_Start());
				st.setString(8,reservation.getReservation_End());
				st.setString(9,reservation.getIsCancel());
				st.setString(10,reservation.getCar_Num());
				st.setString(11,reservation.getCar_Name());
			}
			else {
				st = conn.prepareStatement(sql2);
				
				st.setString(1,reservation.getFacilities_Name());
				st.setString(2,reservation.getMember_ID());
				st.setString(3,reservation.getReservation_Name());
				st.setString(4,reservation.getReservation_Phone_Number());
				st.setString(5,reservation.getHeadCount());
				st.setString(6,reservation.getReservation_Date());
				st.setString(7,reservation.getReservation_Start());
				st.setString(8,reservation.getReservation_End());
				st.setString(9,reservation.getIsCancel());
			}
			
			
			result = st.executeUpdate();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//삭제	
		public int delete(String[] id){
			if(id.length <= 0){
				return 0;
			}else{
				Connection conn = null;
				Statement st= null;
				int result = 0;
				String sql = "DELETE FROM sogongdo.reservation WHERE Reservation_ID IN (";
				try{
					conn = ds.getConnection();
					st = conn.createStatement();
				
					for(int i=0; i<id.length; i++){
						sql +="'"+ id[i]+"',";
					}
					sql = sql.substring(0, sql.length()-1);
					sql += ")";
					result = st.executeUpdate(sql);
				}catch(SQLException e){
					e.printStackTrace();
				}
				return result;
			}
		}
		
		//수정
		public int update(String id,ReservationDTO reserve){
			Connection conn = null;
			PreparedStatement st = null;
			int rs = 0;
			
			String sql = "UPDATE sogongdo.reservation "
					+ "SET Reservation_ID=?, Facilities_Name=?, Member_ID=?,Resevation_Name=?,"
					+ "Reservation_Phone_Number =?, HeadCount = ?,"
					+ "Reservation_Date=?,Reservation_Start=?,Reservation_End=?,isCancel=?,"
					+ "Car_Num = ?, Car_Name = ?"
					+ " WHERE Reservation_ID = ?";
			try{
				conn = ds.getConnection();
				st = conn.prepareStatement(sql);
				
				st.setString(1,reserve.getReservation_ID());
				st.setString(2,reserve.getFacilities_Name());
				st.setString(3,reserve.getMember_ID());
				st.setString(4,reserve.getReservation_Name());
				st.setString(5,reserve.getReservation_Phone_Number());
				st.setString(6,reserve.getHeadCount());
				st.setString(7,reserve.getReservation_Date());
				st.setString(8,reserve.getReservation_Start());
				st.setString(9,reserve.getReservation_End());
				st.setString(10,reserve.getIsCancel());
				st.setString(11,reserve.getCar_Num());
				st.setString(12,reserve.getCar_Name());
				st.setString(13,id);
				rs = st.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return rs;
		}
}


