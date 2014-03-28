<%@ page  contentType="text/html; charset=UTF-8"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>매장 정보 입력 페이지</title>
</head>


<body>
<center>
<form method="post" action="ms_InsertProAction.action"  enctype="multipart/form-data">
<table border="1">
<tr><td colspan="2" ><font size="7"  align="center"><b>매장 정보 등록</b></font></td></tr>
   <tr>
   <td>매장명</td><td><input type="text" size="15" maxlength="40" name="store" /></td> 
   </tr>
   
   <tr>
   <td>매장주소</td><td><input type="text" size="55" maxlength="100" name="s_addr" /></td> 
   </tr>
   
   <tr>
   <td>매장이미지 업로드</td><td><input type="file" name="sfile_orgname" /></td> 
   </tr>
   
   <tr>
   <td>위도&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="s_lat" size="10" maxlength="30"/></td> 
   <td>경도&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="s_lng" size="10" maxlength="30"/></td> 
   </tr>
   
   <tr>
   <td>상세페이지 연결주소(Action네임사용)</td><td><input type="text" name="sfile_orgname" /></td> 
   </tr>



</table>
</form>
</center>
</body>
</html>