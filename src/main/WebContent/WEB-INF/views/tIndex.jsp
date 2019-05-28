<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<table>

		<tr>
			<td>课程id</td>
			<td>课程名称</td>
			<td>授课老师</td>
			<td>班级容量</td>
			<td>已选人数</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${datas.list}" var="cls">

			<tr>
				<td>${cls.id}</td>
				<td>${cls.name}</td>
				<td>${cls.username}</td>
				<td>${cls.size}</td>
				<td>${cls.count}</td>
				<td>。。。。。</td>
			</tr>



		</c:forEach>

		<c:forEach begin="1" end="${datas.pages }" varStatus="vs">
			<a href="teacherIndex?pageNum=${vs.count}&pageSize=${datas.pageSize}">第${vs.count}页</a>
		</c:forEach>


	</table>

</body>
</html>