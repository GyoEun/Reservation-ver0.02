<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="Persistance.*" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>예약 정보 관리</title>
	<style>
	
body{
	
    margin: 0;
    padding: 0;
}



.content{
    width: 100%;
    height: 30rem;
}

table {
    position: relative;
    left: 50%;
    transform: translateX(-50%);
    margin: 10px 5px;
    border-collapse: collapse;
    width: 70%;
    display:block;
    height:450px;
    overflow:auto;
}

th, td {
    padding: 8px;
    text-align: center;
    border-bottom: 1px solid #ddd;
    border: 1px solid #ddd;
}

thead th{
    background-color: #B7C6EE;
}

tbody tr:hover {background-color:#DEE6F8;}

.bt{
    position: relative;
    left: 15%;
   	width : 100px;
    height : 40px;
    background-color: #0F1D42;
    border: none;
    color: white;
    padding: 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
</head>
<body>
        <div class="content">
          	<button class="bt register">등록</button>
           	<button class="bt delete">삭제</button>
			<button class="bt update">수정</button>

        
            <table>
                <thead>
                    <tr>
                       <th class="a">All</th>
						<th class="b">No</th>
						<th class="c">예약시작</th>
						<th class="d">예약종료</th>
						<th class="e">시설명</th>
						<th class="f">인원</th>
						<th class="g">성함</th>
						<th class="h">연락처</th>
						<th class="i">예약시간</th>
                    </tr>
                </thead>
                <tbody>
					<%
						ArrayList<ReservationDTO> list = (ArrayList<ReservationDTO>) request.getAttribute("reserve");
								if(list != null) {				
									for (ReservationDTO dto : list) {
										pageContext.setAttribute("reserve", dto);
					%>
					 <tr>
                       	<td><input class="ch" type="checkbox"></td>
                       	<td class="id"><%= dto.getReservation_ID() %></td>
                       	<td><%= dto.getReservation_Start()%></td>
						<td><%= dto.getReservation_End()%></td>
						<td><%= dto.getFacilities_Name()%></td>
						<td><%= dto.getHeadCount()%></td>
						<td><%= dto.getReservation_Name() %></td>
						<td><%= dto.getReservation_Phone_Number() %></td>
						<td><%= dto.getReservation_Date() %></td>
                    </tr>
					<%}}%>
                </tbody>
            </table>
          
        </div>



	<script>
	window.addEventListener("load",function(){
		
		const registerbtn = document.querySelector(".register");
		const deletebtn = document.querySelector(".delete");
		const updatebtn = document.querySelector(".update");
		const chbox = document.querySelectorAll(".ch");
		const id = document.querySelectorAll(".id");
		
		registerbtn.addEventListener("click",()=>{
			//새로운 창 뜨도록 하기
			window.open("RegisterReserveView.jsp","예약 정보 등록","width=500, height=400, left=300, top=300");
		})
		
		deletebtn.addEventListener("click",()=>{
			//체크박스에 체크한 id가져오기
			var ids = new Array();
			for(var i=0; i<chbox.length; i++){
				if(chbox[i].checked==true){
					ids.push(id[i].innerText);
				}
			}
			if(ids.length==0){
				alert('삭제할 정보를 선택하세요');
			}else{
				
				//삭제컨트롤러에 전송~!
				var ox = confirm("예약 정보를 삭제하시겠습니까?");
				if(ox){
					var url = "delete?";
					url += "cnt="+ids.length+"&";
					for(var i=0;i<ids.length;i++){
						url += "id"+i+"="+ids[i]+"&"
					}
					window.location.href = url;
				}
			}
		})
		
		updatebtn.addEventListener("click",()=>{
			// 새로운 창 뜨도록 하기
			var cnt = 0;
			var up;
			for(var i=0; i<chbox.length; i++){
				if(chbox[i].checked==true){
					cnt++;
					up = id[i].innerText;
				}
			}
			if(cnt==0){
				alert('수정할 정보를 선택하세요');
			}
			else if(cnt==1){
				window.open("updateview?id="+up,"예약 정보 수정","width=500, height=400, left=300, top=300");
			}else{
				alert('하나만 선택');
			}
		})
		
	})
	</script>
</body>
</html>