<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.kitri.dto.TripBasicDTO"%>
<%@ page import="com.kitri.dto.TripDetailDTO"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix ="x" uri ="http://java.sun.com/jsp/jstl/xml" %>

<c:set var="areaCodes" value="${requestScope.areaCodes}"/>
<x:parse var="area" xml="${areaCodes}"/>

<c:set var="list" value="${requestScope.TripBasicDTO}"/>
<c:forEach var="basicDTO" items="${list}">
	<div class="col-lg-3 col-sm-6" name="scheduleinfo" style="cursor:pointer">
		<div class="image-tour position-relative">
			<img src="/TaYo/images/p1.jpg" alt="" class="img-fluid" />
			<p><span>${basicDTO.likeCount} </span> <span class="fa fa-thumbs-up"> | ${basicDTO.viewCount} </span> <span class="fa fa-eye"></p>
		</div>
		<div class="package-info">
			<c:set var="oldLocation_id" value="-1"/>
			<h6 class="mt-1"><span class="fa fa-map-marker mr-2"></span>
				<c:forEach var="detailDTO" items="${basicDTO.detailList}">
					<c:if test="${oldLocation_id != detailDTO.loc_id}">
						<x:forEach varStatus="idx" var="areaCode" select="$area/response/body/items/item">
							<x:set var="codeValue" select="$areaCode/code"/>
							<x:set var="locName" select="$areaCode/name"/>
							<c:set var="loc" value="${detailDTO.loc_id}"/>
							<x:if select="$codeValue = $loc">
								<x:out select="$locName"/>
							</x:if>
						</x:forEach>
						<c:set var="oldLocation_id" value="${detailDTO.loc_id}"/>
					</c:if>
				</c:forEach> 
			</h6>
			<h5 class="my-2">${basicDTO.tripTitle}</h5>
			<p class="">${basicDTO.tripTheme} (${basicDTO.tripNum}인)</p>
			<ul class="listing mt-3">
				<fmt:parseDate var="startPlanDate" value="${basicDTO.startDate}" pattern="yyyy-MM-dd"/>
				<fmt:parseDate var="endPlanDate" value="${basicDTO.endDate}" pattern="yyyy-MM-dd"/>
				<fmt:parseNumber value="${startPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="startDate"/>
				<fmt:parseNumber value="${endPlanDate.time / (1000*60*60*24)}" integerOnly="true" var="endDate"/>
				<li><span class="fa fa-clock-o mr-2"></span><span>${basicDTO.startDate} ~ ${basicDTO.endDate} (${endDate - startDate + 1})</span></li>
			</ul>
			<h6 class="mt-1"><span class="fa fa-user-circle"> ${basicDTO.email}</h6>
		</div>
	</div>
</c:forEach>