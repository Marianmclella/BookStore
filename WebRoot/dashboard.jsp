<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="head.jsp"></jsp:include>
<body>
	<jsp:include page="aside.jsp"></jsp:include>
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<form method="post" action="test">
				<table width="698" border="0" cellpadding="0" cellspacing="0" id="tab">
			        <caption>点击自动隐藏／显示</caption>
			        <tr>
			            <td width="32" style="display: none" align="center" bgcolor="#EFEFEF" Name="Num"><input type="checkbox" name="checkbox" value="checkbox" /></td>
			            <td width="186" bgcolor="#EFEFEF" Name="Num" EditType="TextBox">序号</td>
			            <td width="152" bgcolor="#EFEFEF" Name="ProductName" EditType="DropDownList" DataItems="{text:'A',value:'a'},{text:'B',value:'b'},{text:'C',value:'c'},{text:'D',value:'d'}">商品名称</td>
			            <td width="103" bgcolor="#EFEFEF" Name="Amount" EditType="TextBox">数量</td>
			            <td width="103" bgcolor="#EFEFEF" Name="Price" EditType="TextBox">单价</td>
			            <td width="120" bgcolor="#EFEFEF" Name="SumMoney" Expression="Amount*Price" Format="#,###.00">合计</td>
			        </tr>
			        <tr>
			            <td align="center" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" value="checkbox" /></td>
			            <td bgcolor="#FFFFFF">1</td>
			            <td bgcolor="#FFFFFF" Value="c">C</td>
			            <td bgcolor="#FFFFFF">0</td>
			            <td bgcolor="#FFFFFF">0</td>
			            <td bgcolor="#FFFFFF">0</td>
			        </tr>
			        <tr>
			            <td align="center" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox3" value="checkbox" /></td>
			            <td bgcolor="#FFFFFF">2</td>
			            <td bgcolor="#FFFFFF" Value="d">D</td>
			            <td bgcolor="#FFFFFF">0</td>
			            <td bgcolor="#FFFFFF">0</td>
			            <td bgcolor="#FFFFFF">0</td>
			        </tr>
			       </table>
			       <input type="submit" value="submit" />
			</form>
		</div>
	</section>
</body>
</html>