<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Styles/header.css" rel="stylesheet" type="text/css" />
<link href='http://fonts.googleapis.com/css?family=Cookie' rel='stylesheet' type='text/css'>

<title>Header</title>
</head>
<body>
	<div id = "header">
		<a href="./BookList"><img src="picture/books6.jpg" /></a>
		<script type="text/javascript">
			tday=new Array("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday");
			tmonth=new Array("January","February","March","April","May","June","July","August","September","October","November","December");
			
			function GetClock(){
			var d=new Date();
			var nday=d.getDay(),nmonth=d.getMonth(),ndate=d.getDate(),nyear=d.getYear(),nhour=d.getHours(),nmin=d.getMinutes(),nsec=d.getSeconds();
			if(nsec<10){
				nsec = "0"+nsec;
			}
			if(nmin<10){
				nmin = "0"+nmin;
			}
			if(nhour<10){
				nhour="0"+nhour;
			}
			document.getElementById('clockbox').innerHTML=""+tday[nday]+", "+tmonth[nmonth]+" "+ndate+", "+nhour+":"+nmin+":"+nsec;
			}
			
			window.onload=function(){
			GetClock();
			setInterval(GetClock,1000);
			}
			</script>
			<div id="clockbox"></div>
	</div>
	<!-- header -->
	<div id="title">
		<p>Book Store</p>
		
	</div>
	<!-- title -->
</body>
</html>