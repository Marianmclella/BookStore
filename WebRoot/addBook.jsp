<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <%@ page contentType="text/html;charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="head.jsp"></jsp:include>
<body>
	<jsp:include page="aside.jsp"></jsp:include>
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
			<section>
				<h2>
					<strong style="color:grey;">请输入具体信息</strong>
				</h2>
				<form action="addBookServlet" method="post">
				<ul class="ulColumn2">
					<li><span class="item_name" style="width:120px;">图书编号：</span>
						<input type="tel" class="textbox textbox_295"
						placeholder="请输入6位数的编号" name="no" /> <span style="display: none"
						class="errorTips">错误提示信息...</span></li>
					<li><span class="item_name" style="width:120px;">书名：</span> <input
						type="text" class="textbox textbox_295" placeholder="请输入图书的名字" name="name" />
						<span style="display: none" class="errorTips">错误提示信息...</span></li>
					<li><span class="item_name" style="width:120px;">作者：</span> <input
						type="text" class="textbox textbox_295" placeholder="请输入作者的名字" name="author" />
						<span style="display: none" class="errorTips">错误提示信息...</span></li>
					<li><span class="item_name" style="width:120px;">价格：</span> <input
						type="tel" class="textbox textbox_295" placeholder="请输入价格" name="price" /> <span
						style="display: none" class="errorTips">错误提示信息...</span></li>
					<li><span class="item_name" style="width:120px;">添加数量：</span>
						<input type="text" class="textbox textbox_295" name="amount"
						placeholder="请输入添加的数量" /> <span style="display: none"
						class="errorTips">错误提示信息...</span></li>
					<li><span class="item_name" style="width:120px;">目录：</span> <select
						class="select" name="category">
							<option>文学</option>
							<option>小说</option>
							<option>传记</option>
							<option>历史</option>
							<option>国学</option>
							<option>社会科学</option>
							<option>法律</option>
					</select> <span style="display: none" class="errorTips">错误提示信息...</span></li>
					<li><span class="item_name" style="width:120px;">是否热销：</span>
						<label class="single_selection"><input type="radio"
							name="name" />推荐</label> <label class="single_selection"><input
							type="radio" name="name" />不推荐</label></li>
					<li><span class="item_name" style="width:120px;">摘要：</span> <textarea
							placeholder="摘要信息" class="textarea" name="introduce"
							style="width:500px;height:100px;"></textarea></li>
					<li><span class="item_name" style="width:120px;">上传图片：</span>
						<label class="uploadImg"> <input type="file" /> <span>上传图片</span>
					</label></li>
					<li><span class="item_name" style="width:120px;"></span> <input
						type="submit" class="link_btn" /></li>
				</ul>
				</form>
			</section>
		</div>
	</section>
</body>
<<script type="text/javascript">
	var status = <%=request.getAttribute("status")  %>
	if(status==1){
		alert("添加成功");
	}
</script>
</html>