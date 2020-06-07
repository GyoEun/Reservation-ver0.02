package Persistance;

public class CancelDTO {
	private String Reservation_ID;
	private String Facilities_Name;
	private String Member_ID;
	private String Reservation_Name;
	private String Reservation_Phone_Number;
	private String HeadCount;
	private String Reservation_Date;
	private String Reservation_Start;
	private String Reservation_End;
	private String Car_Num;
	private String Car_Name;
	private String isCancel;
	
	
	public CancelDTO(String Reservation_ID, String Facilities_Name, String Memeber_ID, String Reservation_Name,
			String Reservation_Phone_Number, String HeadCount, String Reservation_Date, String Reservation_Start, String Reservation_End,
			String Car_Num, String Car_Name, String isCancel) {
		super();
		this.Reservation_ID = Reservation_ID;
		this.Facilities_Name = Facilities_Name;
		this.Member_ID = Memeber_ID;
		this.Reservation_Name = Reservation_Name;
		this.Reservation_Phone_Number = Reservation_Phone_Number;
		this.HeadCount = HeadCount;
		this.Reservation_Date = Reservation_Date;
		this.Reservation_Start = Reservation_Start;
		this.Reservation_End = Reservation_End;
		this.Car_Num = Car_Num;
		this.Car_Name = Car_Name;
		this.isCancel = isCancel;	
	}
	
	public String getReservation_ID() {return Reservation_ID;}
	public String getFacilities_Name() {return Facilities_Name;}
	public String getMember_ID() {return Member_ID;}
	public String getReservation_Name() {return Reservation_Name;}
	public String getReservation_Phone_Number() {return Reservation_Phone_Number;}
	public String getHeadCount() {return HeadCount;}
	public String getReservation_Date() {return Reservation_Date;}
	public String getReservation_Start() {return Reservation_Start;}
	public String getReservation_End() {return Reservation_End;}
	public String getCar_Num() {return Car_Num;}
	public String getCar_Name() {return Car_Name;}
	public String getIsCancel() {return isCancel;}
	
	public void setReservationID(String Reservation_ID) {this.Reservation_ID = Reservation_ID;}
	public void setFacilitiesName(String Facilities_Name) {this.Facilities_Name = Facilities_Name;}
	public void setMember_ID(String Member_ID) {this.Member_ID = Member_ID;}
	public void setReservationName(String Reservation_Name) {this.Reservation_Name = Reservation_Name;}
	public void setReservationPhoneNumber(String Reservation_Phone_Number) {this.Reservation_Phone_Number = Reservation_Phone_Number;}
	public void setHeadCount(String HeadCount){this.HeadCount = HeadCount;}
	public void setReservationDate(String Reservation_Date) {this.Reservation_Date = Reservation_Date;}
	public void setReservationStart(String Reservation_Start) {this.Reservation_Start = Reservation_Start;}
	public void setReservationEnd(String Reservation_End) {this.Reservation_End = Reservation_End;}
	public void setCarNum(String Car_Num) {this.Car_Num = Car_Num;}
	public void setCarName(String Car_Name) {this.Car_Name = Car_Name;}
	public void setIsCancel(String isCancel) {this.isCancel = isCancel;}
}
