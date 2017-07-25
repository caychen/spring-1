<%@page import="org.com.cay.entity.Person"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//1、从application域对象中获取IOC容器的实例
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
		
		//2、从IOC容器中得到Bean对象
		Person person = (Person)ctx.getBean("person");
		
		//3、使用Bean
		person.hello();
	%>
	
	<a href="person-save">Person save!</a>
</body>
</html>