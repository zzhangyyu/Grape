<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<body>
	<aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
         <section class="sidebar">
          <!-- sidebar menu: : style can be found in sidebar.less -->
           <ul class="treeview-menu">
<!--             <li class="header">MAIN NAVIGATION</li> -->
            <li class="treeview">
          
          		<c:forEach items="${sessionScope.resoList}" var="reso" >
					<c:if test="${reso.fatherId==null}">
					 <ul class="treeview-menu">
					 		<li>
				              <a href="#"><i class="fa fa-circle-o hidden"></i><i class="fa fa-angle-left pull-right"></i></a>
				            </li>
				            <li>
				              <a href="${reso.menuUrl}"><i class="fa fa-circle-o"></i> ${reso.resouName} <i class="fa fa-angle-left pull-right"></i></a>
				              	<c:forEach items="${resoList}" var="reso1" >
									<c:if test="${reso1.fatherId==reso.id}">
										<ul class="treeview-menu">
				          				 	 <li>
				              					<a href="${reso1.menuUrl}"><i class="fa fa-circle-o"></i> ${reso1.resouName} <i class="fa fa-angle-left pull-right"></i></a>
				              				</li>
		          						</ul>
									</c:if>
			   					 </c:forEach>
				            </li>
		          	</ul>
				   </c:if>
			    </c:forEach>
     		</li>
          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>
	
     
</body>
</html>      