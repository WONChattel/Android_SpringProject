<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>레시피 나오는지 확인</title>
</head>
<body>
		
		<c:if test="${not empty list }">
			<c:forEach var="vo" items ="${list }">
				${vo.RCP_NM }. ${vo.RCP_PARTS_DTLS } :
			</c:forEach>
		</c:if>
		<c:if test="${empty list }">
			~데이터 없다
		</c:if>

</body>
</html>