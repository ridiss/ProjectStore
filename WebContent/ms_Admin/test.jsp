<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<body>
<center>
<table border="1">
   <tr align="center">
     <c:forEach var="list"  items="${list}" varStatus="status">
       <td>
       <a href="${list.s_Action}.action"/>
       <img src="/ProjectStore/ms_UploadFile/store/${list.sfile_Savname}"  width="100" height="115"/></td>
       <c:if test ="${status.count%4 eq 0 }"></tr></c:if>
    </c:forEach>
  </table>
  </center>
</body>
