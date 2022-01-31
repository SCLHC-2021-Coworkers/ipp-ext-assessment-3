<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>ȸ�� ���</title>
<link rel="stylesheet" href="stylesheet/main.css">
<style>
	form {
		display: block;
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
	<div class="container">
		<div class="vertical-align">
			<form action="<%= request.getContextPath() %>/register.do" method="POST">
				<h1>ȸ�� ���</h1>
				<table>
					<tbody>
						<tr>
							<th>���̵�</th>
							<td>
								<input type="text" name="pId">
							</td>
						</tr>
						<tr>
							<th>��й�ȣ</th>
							<td>
								<input type="text" name="pPw">
							</td>
						</tr>
						<tr>
							<th>����</th>
							<td>
								<input type="text" name="cName">
							</td>
						</tr>
						<tr>
							<th>�̸���</th>
							<td>
								<input type="email" name="cEmail">
							</td>
						</tr>
						<tr>
							<th>����ó</th>
							<td>
								<input type="tel" name="cTel">
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<button type="submit">�� ��</button>
								<button type="button" id="toMemberListBtn">�� ȸ</button>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
	<%
		String msg = null;
		if (request.getMethod().equals("POST")) {
			if (response.getStatus() < 300) {
				msg = "ȸ�� ������ ��ϵǾ����ϴ�.";
			} else {
				msg = (String) request.getAttribute("errorMsg");
			}
		}
	%>
	<script>
		document.getElementById('toMemberListBtn').onclick = function () {
			window.location.href = 'memberList.do';
		};
	</script>
	<% if (msg != null) { %>
		<script>
			alert('<%= msg %>');
			window.history.back();
		</script>
	<% } %>
</body>
</html>