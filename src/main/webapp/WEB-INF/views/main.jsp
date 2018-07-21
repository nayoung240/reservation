<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
    <title>예약서비스</title>
    <meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
     <div id="container">
        <div class="header">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="https://m.naver.com/" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="./myreservation.html" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a href="./bookinglogin.html" class="btn_my"> <span class="viewReservation" title="예약확인">예약확인</span> </a>
            </header>
        </div>
        <hr>
        <div class="event">
            <div class="section_visual">
                <div class="group_visual">
                    <div class="container_visual">
                        <div class="prev_e" style="display:none;">
                            <div class="prev_inn">
                                <a href="#" class="btn_pre_e" title="이전"> <i class="spr_book_event spr_event_pre">이전</i> </a>
                            </div>
                        </div>
                        <div class="nxt_e" style="display:none;">
                            <div class="nxt_inn">
                                <a href="#" class="btn_nxt_e" title="다음"> <i class="spr_book_event spr_event_nxt">다음</i> </a>
                            </div>
                        </div>
                        <div>
                            <div class="container_visual">
                                <!-- [D] 이전,다음 버튼을 클릭할때마다 캐러셀 형태로 순환 됨 -->
                                <ul class="visual_img">
                                </ul>
                            </div>
                            <span class="nxt_fix" style="display:none;"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="section_event_tab">
                <ul class="cateTab event_tab_lst tab_lst_min">
                    <li class="item" data-category="0">
                        <a class="anchor active">전체리스트</a>
                    </li>
                    <c:forEach var="cateList" items="${categoryList}">
	                	<li class="item" data-category="${cateList.id}">
                        	<a class="anchor">${cateList.name}</a>
                    	</li>    
                	</c:forEach> 
                </ul>
            </div>
            <div class="section_event_lst">
                <p class="event_lst_txt">바로 예매 가능한 행사가 <span class="pink">${allCount} ${fn:length(pagingList)} 개</span> 있습니다</p>
                <div class="wrap_event_box">
                    <!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
                    <ul class="lst_event_box" id="leftUl">
                       <c:forEach var="prodAllList" items="${prodAllList}" begin="0" end="1" step="1">
		                   <li class="item">
                            	<a href="detail.html" class="item_book">
                                <div class="item_preview"> 
                                	<img alt="${prodAllList.description}" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945">
                                	<span class="img_border"></span> 
                                </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span>${prodAllList.description}</span>
                                    <c:forEach var="dispList" items="${displayList}">
                                    <c:if test="${prodAllList.id==dispList.productId}"> 
                                    <small class="sm">${dispList.placeName}</small> 
                                    </c:if>
                                    </c:forEach>
                                    </h4>
                                    <p class="event_txt_dsc">${prodAllList.content}</p>
                                </div>
                            	</a>
                          </li>
	                </c:forEach>
                    </ul>
                    <ul class="lst_event_box" id="rightUl">
                       <c:forEach var="prodAllList" items="${prodAllList}" begin="2" end="3" step="1">
		                   <li class="item">
                            	<a href="detail.html" class="item_book">
                                <div class="item_preview"> 
                                	<img alt="${prodAllList.description}" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170303_271/1488514705030TuUK4_JPEG/17%B5%E5%B8%B2%B0%C9%C1%EE_%B8%DE%C0%CE%C6%F7%BD%BA%C5%CD_%C3%D6%C1%BE.jpg?type=l591_945">
                                	<span class="img_border"></span> 
                                </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span>${prodAllList.description}</span>
                                    <c:forEach var="dispList" items="${displayList}">
                                    <c:if test="${prodAllList.id==dispList.productId}"> 
                                    <small class="sm">${dispList.placeName}</small> 
                                    </c:if>
                                    </c:forEach>
                                    </h4>
                                    <p class="event_txt_dsc">${prodAllList.content}</p>
                                </div>
                            	</a>
                          </li>
	                </c:forEach>
                    </ul>
                    <!-- 더보기 -->
                    <div class="more">
                        <button class="btn"><span>더보기</span></button>
                    </div>
                </div>
            </div>
        </div>
    </div>
                <c:forEach var="cateList" items="${categoryList}">
	                    <strong>${cateList.name}</strong><br>
                </c:forEach> 
                바로 예매 가능한 전시, 공연, 행사가 ${allCount }개 있습니다 <br>
     	  카테고리1: 바로 예매 가능한 전시, 공연, 행사가 ${count }개 있습니다 <br>
     	  
                <c:forEach var="pagingList" items="${pagingList}">
	                   description: ${pagingList.description}<br>
	                   content:  ${pagingList.content}<br>
	                   <c:forEach var="dispList" items="${displayList}">
			                <c:if test="${pagingList.id==dispList.productId}">
					           placeName: ${dispList.placeName}<br>
			                </c:if>
	                	</c:forEach> 
	                ---------------------------------------<br>
                </c:forEach>
	                ======================================================<br>
	                <c:forEach var="prodAllList" items="${prodAllList}">
	                   description: ${prodAllList.description}<br>
	                   content:  ${prodAllList.content}<br>
	                   <c:forEach var="dispList" items="${displayList}">
			                <c:if test="${prodAllList.id==dispList.productId}">
					           placeName: ${dispList.placeName}<br>
			                </c:if>
	                </c:forEach> 
	                ---------------------------------------<br>
                </c:forEach>
                

    <footer>
        <div class="gototop">
            <a href="#" class="lnk_top"> <span class="lnk_top_text">TOP</span> </a>
        </div>
        <div class="footer">
            <p class="dsc_footer">네이버(주)는 통신판매의 당사자가 아니며, 상품의정보, 거래조건, 이용 및 환불 등과 관련한 의무와 책임은 각 회원에게 있습니다.</p>
            <span class="copyright">© NAVER Corp.</span>
        </div>
    </footer>

    <script type="rv-template" id="promotionItem">
    <li class="item" style="background-image: url(http://211.249.62.123/productImages/${productId}/${productImageId});">
        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
            <div class="event_txt">
                <h4 class="event_txt_tit"></h4>
                <p class="event_txt_adr"></p>
                <p class="event_txt_dsc"></p>
            </div>
        </a>
    </li>
    </script>

    <script type="rv-template" id="itemList">
        <li class="item">

                <div class="event_txt">
                    <h4 class="event_txt_tit"> <span>${description}</span> <small class="sm">${placeName}</small> </h4>
                    <p class="event_txt_dsc">${content}</p>
                </div>

        </li>
    </script>
<script>
 	function mainAjax2(){
		var oReq=new XMLHttpRequest();
		oReq.addEventListener("load",function(){
			//var itemList = document.querySelector("#itemList").innerText;
			
//			console.log(itemList);
			console.log("maindata2");
/*  			for(var i=1; i<=2; i++){
				var leftUl=document.querySelector("#leftUl");
				leftUl.insertAdjacentHTML('beforeend',itemList);
				console.log("추가");
			}
			for(var i=1; i<=2; i++){
				var rightUl=document.querySelector("#rightUl");
				rightUl.insertAdjacentHTML('beforeend',itemList);
				console.log("추가");
			}   */
			
			var resultHTML="";
			var itemList=document.querySelector("#itemList").innerHTML;
			for(var i=1; i<=2; i++){
				resultHTML+=itemList.replace("${description}",data[i].name)
			}
			
/*  			var data=JSON.parse(this.responseText);
			console.log(data);  */
		});
		oReq.open("GET", "/reservation/main", true);
		oReq.send();
 	}
	var btn=document.querySelector(".btn");
   	btn.addEventListener("click", function(){
			mainAjax2();
			console.log("log");	
   	});
</script>

<script>

	function cateAjax(url){
		var oReq=new XMLHttpRequest();
		oReq.addEventListener("load",function(){
			console.log("카테고리아이디를 가져와야함");
		});
		oReq.open("GET", url);
		oReq.send();
	}
	var cateTab=document.querySelector(".cateTab");
	cateTab.addEventListener("click", function(e){
		console.log(e.target.innerText);
		
		cateAjax("/reservation/main");
		
		changeActive();
		
	});
	function changeActive(){
		var anchor=document.querySelectorAll(".anchor");
		for(var i=0, len=anchor.length; i<len; i++ ){
			anchor[i].classList.remove("active");
		}
		e.target.classList.add("active");
	}
</script>
</body>
</html>