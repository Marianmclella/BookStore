<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" %>
<%@page import="com.test.domain.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="head.jsp"></jsp:include>
<body>
	<jsp:include page="aside.jsp"></jsp:include>
	<section class="rt_wrap content mCustomScrollbar">
		 <div class="rt_content">
		 		<section>
            <h2><strong style="color:grey;">表单样式（组合）</strong></h2>
            <input type="text" class="textbox" placeholder="默认宽度..."/>
            <input type="text" class="textbox textbox_295" placeholder="class=295px..."/>
            <input type="text" class="textbox textbox_225" placeholder="class=225px..."/>
            <select class="select">
                <option>下拉菜单</option>
                <option>菜单1</option>
            </select>
            <input type="button" value="组合按钮" class="group_btn"/>
        </section>
        
        
        
        <section>

            <h2><strong style="color:grey;">页面标题及表格/分页（根据具体情况列入重点，切勿放置可扩展内容不定的数据）</strong></h2>
            <div class="page_title">
                <h2 class="fl">例如产品详情标题</h2>
                <a class="fr top_rt_btn">右侧按钮</a>
                
            </div>
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
                <%
                	
                	List<Book> books =(List<Book>)request.getAttribute("books");
                	for(Book book : books){%>
                <tr>
                    <td style="width:265px;"><div class="cut_title ellipsis"><%=book.getId()%></div></td>
                    <td><%=book.getName() %></td>
                    <td><%=book.getAuthor() %></td>
                    <td><%=book.getPrice() %></td>
                    <td><%=book.getCategrory() %></td>
                    <td><%=book.getStock() %></td>
                    <td><%=book.getIntroduce() %></td>
                </tr>
                <%}%>
            </table>
            <aside class="paging">
                <a>第一页</a>
                <a>1</a>
                <a>2</a>
                <a>3</a>
                <a>…</a>
                <a>1004</a>
                <a>最后一页</a>
            </aside>
        </section>
        
        
		 </div>
	</section>
</body>
</html>