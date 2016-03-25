<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.test.domain.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" type="text/css" href="css/bookinfo.css" />
<jsp:include page="head.jsp"></jsp:include>
<body>
			<% 
				Book book = (Book) request.getAttribute("book"); 
			%>
	<jsp:include page="aside.jsp"></jsp:include>
	<div id="bg"></div>
	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">


			<div id="show"
				style="position: fixed; background: white; z-index: 1222;top: 3%;  left: 32%; width:500px; height:720px;border:5px solid #DDDDDD; display: none; ">
				<div style="margin: auto auto;  width: 450px;padding-left: 0px;">
					<h2>
						<strong style="color:grey;">请输入具体信息</strong>
					</h2>
					<form method="post" action="bookInfo">
					<ul class="ulColumn2" style="margin-left: -30px;">
						<li><span class="item_name" style="width:120px;">图书编号：</span>
							<input type="tel" class="textbox textbox_295" name="no"
							value="<%=book.getId() %>" display="true" /> <span style="display: none"
							class="errorTips">错误提示信息...</span></li>
						<li><span class="item_name" style="width:120px;">书名：</span> <input
							type="text" class="textbox textbox_295" value="<%=book.getName() %>" name="name" />
							<span style="display: none" class="errorTips">错误提示信息...</span></li>
						<li><span class="item_name" style="width:120px;">作者：</span> <input
							type="text" class="textbox textbox_295" value="<%=book.getAuthor() %>" name= "author" />
							<span style="display: none" class="errorTips">错误提示信息...</span></li>
						<li><span class="item_name" style="width:120px;">价格：</span> <input
							type="tel" class="textbox textbox_295" value="<%=book.getPrice() %>" name="price" />
							<span style="display: none" class="errorTips">错误提示信息...</span></li>
						<li><span class="item_name" style="width:120px;">添加数量：</span>
							<input type="text" class="textbox textbox_295"
							value="<%=book.getStock() %>" name="stock" /> <span style="display: none"
							class="errorTips">错误提示信息...</span></li>
						<li><span class="item_name" style="width:120px;">目录：</span> <select
							class="select">
								<option>文学</option>
								<option>小说</option>
								<option>传记</option>
								<option>历史</option>
								<option>国学</option>
								<option>社会科学</option>
								<option>法律</option>
						</select> <span style="display: none" class="errorTips">错误提示信息...</span></li>
						<li><span class="item_name" style="width:120px;">摘要：</span> <textarea
								placeholder="摘要信息" class="textarea"
								style="width:400px;height:100px;margin-left: 50px;" name="introduce">value="<%=book.getIntroduce() %>"</textarea>
						</li>
						<li><span class="item_name" style="width:120px;">上传图片：</span>
							<label class="uploadImg"> <input type="file" /> <span>上传图片</span>
						</label></li>
						<li style="margin-top: 30px;"><span class="item_name"
							style="width:120px;"></span> <input type="submit"
							class="link_btn" /> <input type="button" value="取消"
							onclick="esc()" style="margin-left: 130px;" class="link_btn" /></li>
					</ul>
					</form>
				</div>
			</div>




			<section>
				<div class="head_index">
					<span><%=book.getCategrory()%> > <%=book.getName()%></span>
				</div>
				<div class="contain">
					<form name="bookinfo" method="post" action="bookInfo">
						<div class="contain_1">
							<div class="contain_left">
								<img src="<%=book.getPicUrl() %>" width="300">
							</div>
							<div class="contain_right">
								<div class="right_head">
									<p>
										书名：<%=book.getName()%></p>
									<strong style="margin-left: 20px; font-size: 20px;">分类</strong>：
									<p>
										<%=book.getCategrory()%></p>
									<input onclick="show()" type="button" value="编辑" id="edit"
										class="link_btn edit_input" />
								</div>
								<div class="right_info">
									<p>图书出版时间 : 2015-12-3</p>
									<ul style="">
										<li style="color: crimson;margin-left:0px;"><strong>库存</strong>：<%=book.getStock()%></li>
										<li>收藏：200</li>
										<li>阅读量：2000</li>
										<li>人气：12902</li>
									</ul>
									<ul style="height: 40px;margin-top: 45px;">
										<li style="margin-left: 0px;">评论：232</li>
										<li>访问量：324</li>
									</ul>
								</div>
								<div class="right_price">
									<p style="">
										<strong>售价：</strong>
										<%=book.getPrice()%>
									</p>
								</div>
								<div class="right_intro">
									<p style="font-size: 20px;">
										<strong>作品简介：</strong>
									</p>
									<textarea name="introduce" id="intro" disabled="true">&nbsp;&nbsp;&nbsp;&nbsp;<%=book.getIntroduce()%>
                            </textarea>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="contain2">
					<div class="tab">
						<ul>
							<li><a id="a1" class="active"><button onclick="dd(1)">交易记录</button>
							</a></li>
							<li><a id="a2"><button onclick="dd(2)">评论管理</button> </a></li>
						</ul>
					</div>
					<div id="tab1" class="tab_contain" style="display: block">
						<table class="table">
							<tr>
								<th>图书编号</th>
								<th>书名</th>
								<th>作者</th>
								<th>价格</th>
								<th>类别</th>
								<th>库存量</th>
								<th>简介</th>
							</tr>
							<tr>
								<td style="width:265px;"><div class="cut_title ellipsis">265px宽·长标题字符串截取，仅适合单行截取，多行截取程序定义一下。</div>
								</td>
								<td>内容二</td>
								<td>内容三</td>
								<td>内容四</td>
								<td>内容五</td>
								<td>内容六</td>
								<td><a href="#">表内链接</a> <a href="#" class="inner_btn">表内按钮</a>
								</td>
							</tr>
							<tr>
								<td style="width:265px;"><div class="cut_title ellipsis">265px宽·长标题字符串截取，仅适合单行截取，多行截取程序定义一下。</div>
								</td>
								<td>内容二</td>
								<td>内容三</td>
								<td>内容四</td>
								<td>内容五</td>
								<td>内容六</td>
								<td><a href="#">表内链接</a> <a href="#" class="inner_btn">表内按钮</a>
								</td>
							</tr>
							<tr>
								<td style="width:265px;"><div class="cut_title ellipsis">265px宽·长标题字符串截取，仅适合单行截取，多行截取程序定义一下。</div>
								</td>
								<td>内容二</td>
								<td>内容三</td>
								<td>内容四</td>
								<td>内容五</td>
								<td>内容六</td>
								<td><a href="#">表内链接</a> <a href="#" class="inner_btn">表内按钮</a>
								</td>
							</tr>
						</table>
					</div>
					<div id="tab2" class="tab_contain">tab2</div>
				</div>
			</section>
		</div>
	</section>
</body>
<script type="text/javascript">
	function show() {
		document.getElementById("show").style.display = "block";
		document.getElementById("bg").style.display = "block";
	}
	function esc() {
		document.getElementById("show").style.display = "none";
		document.getElementById("bg").style.display = "none";
	}

	function dd(v) {
		if (v == 1) {
			document.getElementById('tab1').style.display = "block";
			document.getElementById('tab2').style.display = 'none';
			document.getElementById('a1').setAttribute('class', 'active');
			document.getElementById('a2').removeAttribute('class');
		} else {
			document.getElementById('tab2').style.display = "block";
			document.getElementById('tab1').style.display = 'none';
			document.getElementById('a2').setAttribute('class', 'active');
			document.getElementById('a1').removeAttribute('class');
		}
	}
	
	var status= <%=request.getParameter("status") %>
	if(status==200){
		alert('修改成功！！！');
	}
</script>
</html>