<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head><!-- 
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR"> -->

<title>예약 정보 등록</title>
</head>
<body>
<form action = "register">
	<fieldset>
		<div>
			<label for = "reserveName">예약인 성함</label><input name = "rName" type = "text" id = "reserveName" required>
		</div>
		<div>
			<label for = "reservePnum">예약인 연락처</label><input name = "pnum" type = "text" id = "reservePnum" required>
		</div>
		<div>
			<label for = "facilitiesName">시설 명</label><input name = "fName" type = "text" id = "facilitiesName" required>
			<label for = "reserveCnt">예약 인원</label><input name = "cnt" type = "text" id = "reserveCnt" required>
		</div>
		<div>
			<label>예약기간 
			<input type = "date" name = "start" > 
			~ <input type = "date" name = "end" ></label>
		</div>
		<div>
			<label>차량
			<input type="text" name="cNum" id="carNum">
       		<input type="text" name="cName" id="carName"></label>
		</div>
	</fieldset>
	
	  <input type="submit" value="등록" class="register">
      <input type="reset" value="취소" class="reset">

</form>

</body>
</html>