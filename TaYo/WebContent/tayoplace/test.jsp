<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/temp/header.jsp" %>

<style>
	#daylist {
		overflow-x: hidden;
		overflow-y: auto;
		height: 30rem;
	}
	
	#placelist {
		overflow-x: hidden;
		overflow-y: auto;
		height: 26rem;
		
	}
	
	#location {
		text-align: center;
		width: 100%;
		height: 100%;
	}
	
	.list-group {
		margin-bottom: 0.5rem;
	}
	
	button[name="placebtn"], button[name="planbtn"], button[name="addplacebtn"] {
		float: right;
		width: 2rem;
		height : 2rem;
		text-align: center;
	}
</style>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/httpRequest.js"></script>
<script type="text/javascript">

$(function() {
	// Search tour result variables
	var titles;
	var addr2;
	var readcount;
	
	
	$("#place").keydown(function(key) {
		if (key.keyCode == 13) {
			titles = new Array();
	
			$.ajax({
				url: '${pageContext.request.contextPath}/place',
				data: 'act=searchTour&location=' + $("#location").val() + '&place=' + $("#place").val(),
				method: 'post',
				success: function(xml) {
					parser = new DOMParser();
					xmlDoc = parser.parseFromString(xml.trim(), "text/xml");


					var html;
					var prevTitle = "";
					
					$("#tablebody").empty();
					
					$(xml).find("item").each(function() {
						var title = $(this).find("title").text();
						var addr2 = $(this).find("addr2").text();
						var readcount = $(this).find("readcount").text();
					
						
						if (prevTitle != title) {
							prevTitle = title;
							var image = $(this).find("firstimage2").text();
							
							/* html += "<tr><td width='100'><img src='" + image + "' onError=\"this.src='${pageContext.request.contextPath}/images/noImage.png'\" width='80' height='40'/></td><td><ul class='placeclass'><li class='list-group-item' style='padding: 0.3rem;' value='" + title + "'>" + title + addr2 + readcount+ "<button class='btn btn-primary' name='placebtn'>+</button></li></ul></td></tr>"; */
						 	
							html += "<tr><td><div class='card' style='width: 70rem; display: flex;'> "
							html += "<img src='" + image + "' onError=\"this.src='${pageContext.request.contextPath}/images/noImage.png' style='width: 400px;height: 200px;'>"
							html += "<div class='card-body' style='display: inline;'>"
							html += "	<h5 class='card-title'>" + title + "</h5>"
							html += "	<p class='card-text'>"+ addr2 +"</p>"
								html += "	<p class='card-text'>" + readcount +"</p>"
									html += "	<a href=''#' class='btn btn-primary'>상세보기</a>"
									html += "</div>"
										html += "</div></td></tr>";
						}
					});
					
					$("#tablebody").html(html);
				},
				error: function(error) {
					console.log(error);
				}
			});
			return false;
		}
	});
});
</script>


	<ul class="list-group">
		<li class="list-group-item-1" style="background-color:steelblue; color: white; padding: 0.3rem;">1일차</li>
	</ul>
</div>




<div class="col-sm-5">
	<div>
		<div>
			<table class="table table-sm" style="align: center;">
						<tbody align="center">
							<tr>
								<td width="100">
									<select id="location" size="1" name="location">
										<option value="1">서울
										<option value="2">인천
										<option value="3">대전
										<option value="4">대구
										<option value="5">광주
										<option value="6">부산
										<option value="7">울산
										<option value="8">세종
										<option value="31">경기
										<option value="32">강원
										<option value="33">충북
										<option value="34">충남
										<option value="35">경북
										<option value="36">경남
										<option value="37">전북
										<option value="38">전남
										<option value="39">제주
									</select>
								</td>
								<td><input type="text" class="form-control" id="place" name="place" value="" placeholder=""></input></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="placelist">
				
					<table class="table table-bordered table-sm">
						<tbody id="tablebody" align="center">
							
							
							
							

						</tbody>
					</table>
				</div>
				
				
	
				
			</div>
		</div>
</div>

