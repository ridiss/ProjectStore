
<%@ page  contentType="text/html; charset=UTF-8"  %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>매장 정보 입력 페이지</title>
</head>

	<SCRIPT type="text/javascript">
		function validation() {
		
			var frm = document.getElementById("storeForm");
			
			if(frm.store.value == "") {
				alert("매장명을 입력해주세요.");
				return false;
			} 
			
			else if(frm.s_addr.value == "") {
				alert("매장주소를 입력해주세요.");
				return false;
			}
			
			else if(frm.sfile_orgname.value == "") {
				alert("매장이미지를 업로드해주세요.");
				return false;
			}
			
			else if(frm.s_lat.value == "") {
				alert("위도를 입력해주세요.");
				return false;			
			} 
			else if(frm.s_lng.value == "") {
				alert("경도를 입력해주세요.");
				return false;			
			}
			else if(frm.s_action.value == "") {
				alert("연결주소를 입력해주세요.");
				return false;			
			}
			
			return true;
		}
	</SCRIPT>


<body>
<center>
<font size="7"  align="center"><b>매장 정보 등록</b></font><font size="2" color="red" >( * 부분은 반드시 입력해주세요. )</font>
<form method="post" action="ms_InsertAction.action"  id="storeForm" enctype="multipart/form-data" onsubmit="return validation();">
<table border="0">
   <tr bgcolor="#DBFFD5">
   <td align="center"><font size="4" color="red">*</font> 매장명</td><td><input type="text" size="15" maxlength="40" name="store" /></td> 
   </tr>
   
   <tr>
   <td align="center"><font size="4" color="red">*</font>매장주소</td><td><input type="text" size="55" maxlength="100" name="s_Addr" /></td> 
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center"><font size="4" color="red">*</font>매장이미지 업로드(jpg파일만업로드가능합니다.)</td><td><input type="file" name="s_Upload" /></td> 
   </tr>
   
   <tr>
   <td align="center"><font size="4" color="red">*</font>위도&lt;Lat&gt;</td><td><input type="text" name="s_Lat" size="10" maxlength="30"/><font size="1" color="red">소수점까지 입력해주세요.</font></td>
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center"><font size="4" color="red">*</font>경도&lt;Lng&gt;</td><td><input type="text" name="s_Lng" size="10" maxlength="30"/><font size="1" color="red">소수점까지 입력해주세요.</font></td>
   </tr>
   
   <tr>
   <td><font size="4" color="red">*</font>상세페이지 연결주소(Action네임사용)</td><td><input type="text" name="s_Action" size="55" maxlength="100" /></td> 
   </tr>
   
   <tr>
   <td align="center"><font size="4" color="red">*</font>메뉴카테고리</td>
   <td><input type="radio" name="m_Category"  value="kr"/>한식&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="radio" name="m_Category"  value="ch"/>중식 &nbsp;&nbsp;&nbsp;&nbsp;
   <input type="radio" name="m_Category" value="jp" />일식&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="radio" name="m_Category"  value="us"/>양식&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="radio" name="m_Category"  value="etc"/>ETC</td> 
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">메뉴A 이름</td><td><input type="text" name="m_A" size="30" maxlength="50"/></td> 
   </tr>
   
   <tr>
   <td align="center">메뉴A 가격</td><td><input type="text" name="m_Ap" size="10" maxlength="10"/>원</td>
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">메뉴A이미지 업로드(jpg파일만업로드가능합니다.)</td><td><input type="file" name="ma_Upload" /></td> 
   </tr>
   
   <tr>
   <td align="center">메뉴B 이름</td><td><input type="text" name="m_B" size="30" maxlength="50"/></td> 
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">메뉴B 가격</td><td><input type="text" name="m_Bp" size="10" maxlength="10"/>원</td>
   </tr>
   
   <tr>
   <td align="center">메뉴B이미지 업로드(jpg파일만업로드가능합니다.)</td><td><input type="file" name="mb_Upload" /></td> 
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">메뉴C 이름</td><td><input type="text" name="m_C" size="30" maxlength="50"/></td> 
   </tr>
   
   <tr>
   <td align="center">메뉴C 가격</td><td><input type="text" name="m_Cp" size="10" maxlength="10"/>원</td>
   </tr>
   
   <tr bgcolor="#DBFFD5">
   <td align="center">메뉴C이미지 업로드(jpg파일만업로드가능합니다.)</td><td><input type="file" name="mc_Upload" /></td> 
   </tr>
   
   <tr>
   <td align="center" colspan="2"><input type="reset" value="다시작성" /><input type="submit" value="확인" /></td> 
   </tr>



</table>
</form>
</center>
</body>
</html>