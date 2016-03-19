<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<aside class="lt_aside_nav content mCustomScrollbar">
 <h2><a href="index.php">起始页</a></h2>
 <ul>
  <li>
   <dl>
    <dt>商品信息</dt>
    <!--当前链接则添加class:active-->
    <dd><a href="listAll?method=all">商品列表</a></dd>
    <dd><a href="addBook.jsp">添加图书</a></dd>
    <dd><a href="#">图书分类</a></dd>
    <dd><a href="#">品牌管理</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>订单信息</dt>
    <dd><a href="#">订单列表</a></dd>
    <dd><a href="#">添加订单</a></dd>
    <dd><a href="#">缺货登记</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>会员管理</dt>
    <dd><a href="#">会员列表</a></dd>
    <dd><a href="#">添加会员</a></dd>
    <dd><a href="#">会员等级</a></dd>
    <dd><a href="#">资金管理</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>基础设置</dt>
    <dd><a href="#">站点基础设置</a></dd>
    <dd><a href="#">SEO设置</a></dd>
    <dd><a href="#">SQL语句查询</a></dd>
    <dd><a href="#">模板管理</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>营销管理</dt>
    <dd><a href="#">订阅列表</a></dd>
    <dd><a href="#">邮件群发</a></dd>
    <dd><a href="#">优惠打折</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>配送与支付设置</dt>
    <dd><a href="#">配送方式</a></dd>
    <dd><a href="#">支付方式</a></dd>
   </dl>
  </li>
  <li>
   <dl>
    <dt>在线统计</dt>
    <dd><a href="#">流量统计</a></dd>
    <dd><a href="#">销售额统计</a></dd>
   </dl>
  </li>
  <li>
   <p class="btm_infor">© 望唐集团 版权所有</p>
  </li>
 </ul>
</aside>