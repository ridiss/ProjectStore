<!-- 테스트용입니다. -->
<%@ page  contentType="text/html; charset=UTF-8"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>매장 정보 입력 페이지</title>
</head>


<body>
<center>
<font size="7"  align="center"><b>매장 정보 등록</b></font>
<form method="post" action="ms_InsertProAction.action"  enctype="multipart/form-data">
<table border="0">
   <tr bgcolor="#DBFFD5">
   <td align="center">매장명</td><td><input type="text" size="15" maxlength="40" name="store" /></td> 
   </tr>
   
   <tr>
   <td align="center">매장주소</td><td><input type="text" size="55" maxlength="100" name="s_addr" /></td> 
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">매장이미지 업로드</td><td><input type="file" name="sfile_orgname" /></td> 
   </tr>
   
   <tr>
   <td align="center">위도</td><td><input type="text" name="s_lat" size="10" maxlength="30"/><font size="1" color="red">소수점까지 입력해주세요.</font></td>
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">경도</td><td><input type="text" name="s_lng" size="10" maxlength="30"/><font size="1" color="red">소수점까지 입력해주세요.</font></td>
   </tr>
   
   <tr>
   <td>상세페이지 연결주소(Action네임사용)</td><td><input type="text" name="s_action" size="55" maxlength="100" /></td> 
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">메뉴A 이름</td><td><input type="text" name="m_a" size="30" maxlength="50"/></td> 
   </tr>
   
   <tr>
   <td align="center">메뉴A 가격</td><td><input type="text" name="m_ap" size="10" maxlength="10"/></td>
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">메뉴A이미지 업로드</td><td><input type="file" name="m_afile_orgname" /></td> 
   </tr>
   
   <tr>
   <td align="center">메뉴B 이름</td><td><input type="text" name="m_b" size="30" maxlength="50"/></td> 
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">메뉴B 가격</td><td><input type="text" name="m_bp" size="10" maxlength="10"/></td>
   </tr>
   
   <tr>
   <td align="center">메뉴B이미지 업로드</td><td><input type="file" name="m_bfile_orgname" /></td> 
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">메뉴C 이름</td><td><input type="text" name="m_c" size="30" maxlength="50"/></td> 
   </tr>
   
   <tr>
   <td align="center">메뉴C 가격</td><td><input type="text" name="m_cp" size="10" maxlength="10"/></td>
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">메뉴C이미지 업로드</td><td><input type="file" name="m_cfile_orgname" /></td> 
   </tr>



</table>
</form>
</center>
</body>
</html>