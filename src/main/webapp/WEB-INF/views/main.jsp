<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약서비스</title>
</head>
<body>
                 <c:forEach var="cateList" items="${categoryList}">
	                    <strong>${cateList.name}</strong><br>
                </c:forEach> 
                바로 예매 가능한 전시, 공연, 행사가 ${allCount }개 있습니다 <br>
     	  카테고리1: 바로 예매 가능한 전시, 공연, 행사가 ${count }개 있습니다 <br>
                <c:forEach var="cateList" items="${list}">
                		 <%-- <li>cateList: ${cateList}</li> --%>
	                   descript: ${cateList.description}<br>
	                   content:  ${cateList.content}<br>
	                   ----------------------------<br>
                </c:forEach>
<%--                 <c:forEach var="dispList" items="${displayList}">
	                   place name: ${dispList.place_name}<br>
	                   ----------------------------<br>
                </c:forEach> --%>
                
<%--                                  <c:forEach var="prodList" items="${productList}">
	                <li>
	                    <strong>${prodList.name}</strong>
		            </li>
                </c:forEach> 
                                 <c:forEach var="promList" items="${promotionList}">
	                <li>
	                    <strong>${promList.name}</strong>
		            </li>
                </c:forEach>  --%>
</body>
</html>