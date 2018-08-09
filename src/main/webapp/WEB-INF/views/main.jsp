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
                <p class="event_lst_txt">바로 예매 가능한 행사가 <span class="pink">${allCnt}개</span> 있습니다</p>
                <div class="wrap_event_box">
                    <!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
                    <ul class="lst_event_box" id="leftUl">
                       <c:forEach var="allList" items="${allProdList}" begin="0" end="1" step="1">
		                   <li class="item">
                            	<a href="detail.html" class="item_book">
                                <div class="item_preview"> 
                                	<img alt="${allList.description}" class="img_thumb" src="${allList.saveFileName}">
                                	<span class="img_border"></span> 
                                </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span>${allList.description}</span><small class="sm">${allList.placeName}</small></h4>
                                    <p class="event_txt_dsc">${allList.content}</p>
                                </div>
                            	</a>
                          </li>
	                	</c:forEach>
                    </ul>
                    <ul class="lst_event_box" id="rightUl">
                    	<c:forEach var="allList" items="${allProdList}" begin="2" end="3" step="1">
		                   <li class="item">
                            	<a href="detail.html" class="item_book">
                                <div class="item_preview"> 
                                	<img alt="${allList.description}" class="img_thumb" src="${allList.saveFileName}">
                                	<span class="img_border"></span> 
                                </div>
                                <div class="event_txt">
                                    <h4 class="event_txt_tit"> <span>${allList.description}</span><small class="sm">${allList.placeName}</small></h4>
                                    <p class="event_txt_dsc">${allList.content}</p>
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
        <c:forEach var="all" items="${allProdList}">
        <li class="item">
                <div class="event_txt">
                    <h4 class="event_txt_tit"> <span>${all.description}</span> <small class="sm">${all.placeName}</small> </h4>
                    <p class="event_txt_dsc">${all.content}</p>
                </div>
        </li>
		</c:forEach>
    </script>
        <script type="rv-template" id="itemList2">
        <li class="item">
                <div class="event_txt">
                    <h4 class="event_txt_tit"> <span>${description}</span> <small class="sm">${placeName}</small> </h4>
                    <p class="event_txt_dsc">${content}</p>
                </div>
        </li>
    </script>

    <script>
    	var promItem=document.querySelector("#promotionItem");
    	var promUl=document.querySelector(".visual_img");
    	
    	
    	var preBtn=document.querySelector(".btn_pre_e");
    	var nxtBtn=document.querySelector(".btn_nxt_e");
    	
		preBtn.addEventListener("click",function(){
    		
    	});
    	nxtBtn.addEventListener("click",function(){
    		
    	});
    </script>
<script>
	var itemList="";
 	function mainAjax2(url){
		var oReq=new XMLHttpRequest();
		oReq.addEventListener("load",function(){
 			 itemList = document.querySelector("#itemList").innerText;			
			//console.log(itemList);
 			
/* 				var leftUl=document.querySelector("#leftUl");
				leftUl.insertAdjacentHTML('beforeend',itemList);
				console.log("추가"); */
			
				var leftUl=document.querySelector("#leftUl");
				leftUl.insertAdjacentHTML('beforeend',itemList);
				
	     	
/*			for(var i=1; i<=2; i++){
				var rightUl=document.querySelector("#rightUl");
				rightUl.insertAdjacentHTML('beforeend',itemList);
				console.log("추가");
			}   */
			
			/* var resultHTML="";
			var itemList=document.querySelector("#itemList").innerHTML;
			for(var i=1; i<=2; i++){
				resultHTML+=itemList.replace("${description}",data[i].name)
			} */
			
/*  			var data=JSON.parse(this.responseText);
			console.log(data);  */
			
			//다시
			console.log(this.responseText);
			//console.log(JSON.parse());
			
		});
		oReq.open("POST", url, true);
		oReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		oReq.send("start=4");
 	}
	var btn=document.querySelector(".btn");
   	btn.addEventListener("click", function(){
   			var url="/reservation/main";
			mainAjax2(url);
			console.log("더보기버튼 누름");

   	});
</script>

<script>

	function cateAjax(url){
		var oReq=new XMLHttpRequest();
		oReq.addEventListener("load",function(){
			console.log("카테고리아이디를 가져와야함");
			console.log("url: "+url);
		});
		oReq.open("POST", url,true);
		oReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		oReq.send("categoryId=2");
	}
	var cateTab=document.querySelector(".cateTab");
	cateTab.addEventListener("click", function(e){
        if (e.target.tagName === "A") {
        	console.log(e.target.innerText);
    		
        	removeActive();
        	e.target.classList.add("active");

        	cateAjax("/reservation/main");
         }		
	});
	function removeActive(){
		var anchor=document.querySelectorAll(".anchor");
		for(var i=0, len=anchor.length; i<len; i++ ){
			anchor[i].classList.remove("active");
		}
		//e.target.classList.add("active");
	}
</script>
<script>
	/* var size=${prodImgList}.size();
	console.log(size); */
</script>
</body>
</html>