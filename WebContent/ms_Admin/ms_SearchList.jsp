<%@ page contentType="text/html; charset=UTF-8"  %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>

<html>
<head>
<title>매장 관리</title>
</head>
searchStore=${searchStore}

<body bgcolor="#FFFF7E">
<center><font size="7" ><b>매장 관리</b></font>
    <table width="800">
       <tr><td align="left" width="400">
           <a href="ms_InsertForm.action?currentPage=${currentPage}">매장 등록</a></td>
           <td align="right" width="400">
           <a href="ms_ListAction.action?currentPage=${currentPage}">전체목록</a></td></tr>
    </table>
    
    <table width="800"  border="1">
       <tr height="30" bgcolor="">
         <td align="center" width="50" >번 호</td>
         <td align="center" width="600" >매 장 명</td>
         <td align="center" width="150" >작 성 일</td>
       </tr>
       
    <c:forEach var="list"  items="${list}"> <%--매장 목록 뽑아내는 forEach문 --%>
      <tr height="30" bgcolor="">
       <td align="center" width="50">
         <c:out value="${list.no}" /> <%--리스트 번호 세팅하는 곳 --%>
          <c:set var="number" value="${list.no -1}" /> 
       </td>
       <td align="center" width="600">
          <a href="ms_ViewAction.action?num=${list.no}&currentPage="${currentPage}">${list.store}</a>
       </td>
       <td align="center" width="150" >${list.sreg_Date}<%--<img src="/ProjectStore/ms_UploadFile/store/${list.sfile_Savname}" /> --%></td>
      </tr>
     </c:forEach>
     </table>
     <table>
     <tr align="center">
        <td><s:property value="SearchPagingHtml" escape="false" />
        </td>
     </tr>
     
  <form method="post" action="ms_SearchListAction.action" name="serchForm"><%--검색폼 검색 누르면 검색한 리스트 액션으로 이동 --%>
  <table>
      <tr><td>
          매장 이름 &nbsp;&nbsp;&nbsp;&nbsp;
         <input type="text" name="searchStore" size="30" maxlengh="50"/>&nbsp;&nbsp;&nbsp;&nbsp;
         <input type="hidden" name="currentPage" value="${currentPage}" />
         <input type="submit" value="검색" />
      </td></tr>
  </table>
  </form>
  
  
</center>
</body>
</html>