<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" 
pageEncoding="UTF-8"%>
<script type="text/javascript">
    $(function(){
    	$("#gotoPage").click(function(){
    		//alert("hello");
    		//用户输入我要去第几页
    		//1.获取到用户输入的值
    		  var pn= $("#pn_input").val();
    		//2.发送新的分页请求
    		//这里应该是出现了浏览器的兼容问题   IDE自带的浏览器    这个请求路径会出现问题
    		//但是在谷歌浏览器中没有问题
    		window.location.href = "${page.url }&pn="+pn;
    	});
    });
</script>
<div id="page_nav">
		<a href="${page.url }&pn=1">首页</a>
		<!-- 判断是否有上一页 -->
		<c:if test="${page.hasPrev }">
		<a href="${page.url }&pn=${page.pageNo-1}">上一页</a>
		</c:if>
		<!-- 当前页码 -->
		<!--  总页码在五页以内  -->
		<c:if test="${page.totalPage<=5 }">
		<!-- 给begin和end赋值 -->
		<c:set var="begin" value="1" scope="page"></c:set>
		<c:set var="end" value="${page.totalPage }" scope="page"></c:set>
		</c:if>
		<!-- 总页码在五页以上  才使用连续显示五页的逻辑-->
        <c:if test="${page.totalPage>5 }">
        <!--当前页码小于3  -->
             <c:if test="${page.pageNo<=3 }">
              <c:set var="begin" value="1" scope="page"></c:set>
		      <c:set var="end" value="5" scope="page"></c:set>
             </c:if>
             <!--当前页码大于3  -->
              <c:if test="${page.pageNo>3 }">
              <c:set var="begin" value="${page.pageNo-2 }" scope="page"></c:set>
		      <c:set var="end" value="${page.pageNo+2 }" scope="page"></c:set>
             </c:if>
             <!--当前页码+2大于等于总页码   end就到总页码结束   begin:总页码-4  -->
             <c:if test="${page.pageNo+2>=page.totalPage }">
              <c:set var="begin" value="${page.totalPage-4 }" scope="page"></c:set>
		      <c:set var="end" value="${page.totalPage }" scope="page"></c:set>
             </c:if>
        </c:if>
        <!-- 当begin根据各种情况设置好值后 使用下面的c：forEach进行遍历 -->
		<c:forEach begin="${begin }" end="${end }" var="pnum">
		 <!--判断当前遍历页码是否为当前页码。若是,则不加标签 否则加标签  -->
		 <c:if test="${pnum==page.pageNo }">
		       <span style="color:blue">【${page.pageNo}】</span>
		 </c:if>
		 <c:if test="${pnum!=page.pageNo }">
		    <a href="${page.url }&pn=${pnum}">${pnum}</a>
		</c:if>
		</c:forEach>
		<!--判断是否有下一页  -->
		<c:if test="${page.hasNext }">
		<a href="${page.url }&pn=${page.pageNo+1}">下一页</a>
		</c:if>
		<a href="${page.url }&pn=${page.totalPage}">末页</a>
		共${page.totalPage}页，${page.totalCount}条记录 到第<input value="${page.pageNo}" name="pn" id="pn_input"/>页
		<input type="button" value="确定" id="gotoPage">
		</div>
