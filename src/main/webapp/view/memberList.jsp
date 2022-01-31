<%@page import="com.ipp.ext3.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ȸ����� ��ȸ</title>
<link rel="stylesheet" href="stylesheet/main.css">
<style>
	.wrapper {
		width: 80vw;
	}
	table {
		width: 100%;
	}
	h1 {
		text-align: center;
	}
</style>
</head>
<body>
	<%
		List<MemberDto> memberList = (List<MemberDto>) request.getAttribute("memberList");
	%>
	<div class="container">
		<div class="vertical-align">
			<div class="wrapper">
				<h1>ȸ�������ȸ</h1>
				<table>
					<thead>
						<tr>
							<th>ȸ�����̵�</th>
							<th>ȸ���̸�</th>
							<th>�̸���</th>
							<th>����ó</th>
						</tr>
					</thead>
					<tbody>
						<% for (MemberDto mem : memberList) { %>
							<tr>
								<td><%= mem.getpId() %></td>
								<td><%= mem.getcName() %></td>
								<td><%= mem.getcEmail() %></td>
								<td><%= mem.getcTel() %></td>
							</tr>
						<% } %>
					</tbody>
				</table>
				<button type="button" id="toBackBtn">�ڷΰ���</button>
			</div>
		</div>
	</div>
	<script>
		document.getElementById('toBackBtn').onclick = function () {
			window.location.href = 'register.do';
		}
	</script>
</body>
</html>