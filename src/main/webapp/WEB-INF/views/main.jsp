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
                                	<c:forEach var="promList" items="${allPromList}">
									<li class="item" style="background-image: url('${promList.saveFileName}');">
								        <a href="#"> <span class="img_btm_border"></span> <span class="img_right_border"></span> <span class="img_bg_gra"></span>
								            <div class="event_txt">
								                <h4 class="event_txt_tit"></h4>
								                <p class="event_txt_adr"></p>
								                <p class="event_txt_dsc"></p>
								            </div>
								        </a>
								    </li>
								    </c:forEach>
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
                <p class="event_lst_txt">바로 예매 가능한 행사가 <span class="pink">${allCnt}</span>개 있습니다</p>
                <div class="wrap_event_box">
                    <!-- [D] lst_event_box 가 2컬럼으로 좌우로 나뉨, 더보기를 클릭할때마다 좌우 ul에 li가 추가됨 -->
                    <ul class="lst_event_box" id="leftUl">
                         <c:forEach var="allList" items="${allProdList}" begin="0" end="1" step="1">
		                   <li class="item">
                            	<a href="detail?id=${allList.id}" class="item_book">
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
                            	<a href="detail?id=${allList.id}" class="item_book">
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
    <script>
    	var promItem=document.querySelector("#promotionItem");
    	var promUl=document.querySelector(".visual_img");
    
    	var n=0;
    	function slide(){
      	  if(n==1000){
      	    n=0;
      	  	promUl.style.transitionDuration="0s";
      	    promUl.style.transform ="translateX(-"+n+"%)";
      	  }
      	  else{
      	    n+=100;  
      	  	promUl.style.transitionDuration="1s";
      	    promUl.style.transform ="translateX(-"+n+"%)";
      	  }
      	  setTimeout(slide,5000);
      	}slide();
    </script>
    <script type="rv-template" id="itemList">
        <li class="item">
            <a href="" class="item_book">
                <div class="item_preview">
                    <img alt="{description}" class="img_thumb" src="{saveFileName}">
                    <span class="img_border"></span>
                </div>
                <div class="event_txt">
                    <h4 class="event_txt_tit"> <span>{description}</span> <small class="sm">{placeName}</small> </h4>
                    <p class="event_txt_dsc">{content}</p>
                </div>
            </a>
        </li>
    </script>
	<script>
	function addProdList(json, type){
		var template = document.querySelector("#itemList").innerText;
		
		var leftUl=document.querySelector("#leftUl");
		var rightUl=document.querySelector("#rightUl");
		var left="";
		var right=""; 
		
		if(type=="all"){
			for(var i=0; i<2; i++){
				left+=template.replace("{description}",json.allProdList[i].description)
					.replace("{saveFileName}",json.allProdList[i].saveFileName)
					.replace("{description}",json.allProdList[i].description)
					.replace("{placeName}",json.allProdList[i].placeName)
					.replace("{content}",json.allProdList[i].content);
			} 
			for(var i=2; i<4; i++){
				right+=template.replace("{description}",json.allProdList[i].description)
				.replace("{saveFileName}",json.allProdList[i].saveFileName)
				.replace("{description}",json.allProdList[i].description)
				.replace("{placeName}",json.allProdList[i].placeName)
				.replace("{content}",json.allProdList[i].content);
			}
			leftUl.innerHTML = left;
			rightUl.innerHTML = right;
		}
		else if(type=="category"){
			for(var i=0; i<2; i++){
				left+=template.replace("{description}",json.cateProdList[i].description)
					.replace("{saveFileName}",json.cateProdList[i].saveFileName)
					.replace("{description}",json.cateProdList[i].description)
					.replace("{placeName}",json.cateProdList[i].placeName)
					.replace("{content}",json.cateProdList[i].content);
			} 
			for(var i=2; i<4; i++){
				right+=template.replace("{description}",json.cateProdList[i].description)
				.replace("{saveFileName}",json.cateProdList[i].saveFileName)
				.replace("{description}",json.cateProdList[i].description)
				.replace("{placeName}",json.cateProdList[i].placeName)
				.replace("{content}",json.cateProdList[i].content);
			}
			leftUl.innerHTML = left;
			rightUl.innerHTML = right;
		}
	}
	
   	function cateAjax(type, sendType, url){
		var oReq=new XMLHttpRequest();
		oReq.addEventListener("load",function(){
			var json=JSON.parse(this.responseText);
			addProdList(json, type);
		});
		oReq.open(sendType, url,true);
		oReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		oReq.send(sendContent);
	}
   	
	function moreProduct(json, type){
		var template = document.querySelector("#itemList").innerText;
		
		var leftUl=document.querySelector("#leftUl");
		var rightUl=document.querySelector("#rightUl");
		var left="";
		var right=""; 
		var length=0;
		
		if(type=="all"){
			length=json.allProdList.length
			console.log("길이: "+length);
			if(length!=0){ //2 1 1 / 3 2 1 / 4 2 2
				if(length<=2){
					left+=template.replace("{description}",json.allProdList[0].description)
					.replace("{saveFileName}",json.allProdList[0].saveFileName)
					.replace("{description}",json.allProdList[0].description)
					.replace("{placeName}",json.allProdList[0].placeName)
					.replace("{content}",json.allProdList[0].content);
					
					if(length==2){
						right+=template.replace("{description}",json.allProdList[1].description)
						.replace("{saveFileName}",json.allProdList[1].saveFileName)
						.replace("{description}",json.allProdList[1].description)
						.replace("{placeName}",json.allProdList[1].placeName)
						.replace("{content}",json.allProdList[1].content);
					}
				}
				else{
					for(var i=0; i<length-2; i++){
						left+=template.replace("{description}",json.allProdList[i].description)
						.replace("{saveFileName}",json.allProdList[i].saveFileName)
						.replace("{description}",json.allProdList[i].description)
						.replace("{placeName}",json.allProdList[i].placeName)
						.replace("{content}",json.allProdList[i].content);
					} 
					for(var i=2; i<length; i++){
						right+=template.replace("{description}",json.allProdList[i].description)
						.replace("{saveFileName}",json.allProdList[i].saveFileName)
						.replace("{description}",json.allProdList[i].description)
						.replace("{placeName}",json.allProdList[i].placeName)
						.replace("{content}",json.allProdList[i].content);
					}
				}
				leftUl.insertAdjacentHTML('beforeend',left);
				rightUl.insertAdjacentHTML('beforeend',right); 
			}
		}
		else if(type=="category"){
			length=json.cateProdList.length
			console.log("길이: "+length);
			if(length!=0){ 
				if(length<=2){
					left+=template.replace("{description}",json.cateProdList[0].description)
					.replace("{saveFileName}",json.cateProdList[0].saveFileName)
					.replace("{description}",json.cateProdList[0].description)
					.replace("{placeName}",json.cateProdList[0].placeName)
					.replace("{content}",json.cateProdList[0].content);
					
					if(length==2){
						right+=template.replace("{description}",json.cateProdList[1].description)
						.replace("{saveFileName}",json.cateProdList[1].saveFileName)
						.replace("{description}",json.cateProdList[1].description)
						.replace("{placeName}",json.cateProdList[1].placeName)
						.replace("{content}",json.cateProdList[1].content);
					}
				}
				else{
					for(var i=0; i<length-2; i++){
						left+=template.replace("{description}",json.cateProdList[i].description)
							.replace("{saveFileName}",json.cateProdList[i].saveFileName)
							.replace("{description}",json.cateProdList[i].description)
							.replace("{placeName}",json.cateProdList[i].placeName)
							.replace("{content}",json.cateProdList[i].content);
					} 
					for(var i=2; i<length; i++){
						right+=template.replace("{description}",json.cateProdList[i].description)
						.replace("{saveFileName}",json.cateProdList[i].saveFileName)
						.replace("{description}",json.cateProdList[i].description)
						.replace("{placeName}",json.cateProdList[i].placeName)
						.replace("{content}",json.cateProdList[i].content);
					}
				}
				leftUl.insertAdjacentHTML('beforeend',left);
				rightUl.insertAdjacentHTML('beforeend',right); 
			}
		}
	}
	
	var type="all";
 	function moreProductAjax(url, startNum){
		var oReq=new XMLHttpRequest();
		oReq.addEventListener("load",function(){
			var json=JSON.parse(this.responseText);
			moreProduct(json, type);
			console.log("sn: "+startNum);
		});
		oReq.open("POST", url, true);
		oReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		oReq.send(sendContent+"&start="+startNum);
 	}
 	var startNum=0;
 	var btn=document.querySelector(".btn");
   	btn.addEventListener("click", function(){
		startNum+=4;
   	   	moreProductAjax("/reservation/products", startNum);
   	}); 
   	
   	function countProduct(json, cateName){
   		var pink=document.querySelector(".pink");

    		if(cateName=="전체리스트"){
   			pink.innerText=${allCnt};
   		}
   		else if(cateName=="전시"){
   			pink.innerText=json.cateList[0].count;
   		}
   		else if(cateName=="뮤지컬"){
   			pink.innerText=json.cateList[1].count;
   		}
   		else if(cateName=="콘서트"){
   			pink.innerText=json.cateList[2].count;
   		}
   		else if(cateName=="클래식"){
   			pink.innerText=json.cateList[3].count;
   		}
   		else if(cateName=="연극"){
   			pink.innerText=json.cateList[4].count;
   		} 
   	}
   	
   	function cateCntAjax(url, cateName){
		var oReq=new XMLHttpRequest();
		oReq.addEventListener("load",function(){
			var json=JSON.parse(this.responseText);
			countProduct(json, cateName);
		});
		oReq.open("GET", url, true);
		oReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		oReq.send(null);
	}
   	
   	var sendContent="";
	var cateTab=document.querySelector(".cateTab");
	cateTab.addEventListener("click", function(e){
		//startNum 초기화
		startNum=0;
		
        if (e.target.tagName === "A") {
        	console.log(e.target.innerText);
    		
        	//카테고리 active
    		var anchor=document.querySelectorAll(".anchor");
    		for(var i=0, len=anchor.length; i<len; i++ ){
    			anchor[i].classList.remove("active");
    		}
        	e.target.classList.add("active");
        	
        	//카테고리 ajax
        	var btn=document.querySelector(".btn");
            
            if(e.target.innerText=="전체리스트"){
            	type="all";
 				sendContent="";
 				cateAjax("all", "GET", "/reservation/products", e.target.innerText);
 				cateCntAjax("/reservation/api/categories", e.target.innerText);
        	}
            else if(e.target.innerText=="전시"){
            	type="category";
 				sendContent="categoryId=1";
 				cateAjax("category", "POST", "/reservation/products");
 				cateCntAjax("/reservation/api/categories", e.target.innerText);
        	}
        	else if(e.target.innerText=="뮤지컬"){
            	type="category";
            	sendContent="categoryId=2";
            	cateAjax("category", "POST", "/reservation/products");
            	cateCntAjax("/reservation/api/categories", e.target.innerText);
        	}
        	else if(e.target.innerText=="콘서트"){
            	type="category";
            	sendContent="categoryId=3";
            	cateAjax("category", "POST", "/reservation/products");
            	cateCntAjax("/reservation/api/categories", e.target.innerText);
        	}
			else if(e.target.innerText=="클래식"){
            	type="category";
            	sendContent="categoryId=4";
            	cateAjax("category", "POST", "/reservation/products");
            	cateCntAjax("/reservation/api/categories", e.target.innerText);
        	}
			else if(e.target.innerText=="연극"){
            	type="category";
            	sendContent="categoryId=5";
            	cateAjax("category", "POST", "/reservation/products");
            	cateCntAjax("/reservation/api/categories", e.target.innerText);
        	}
         }	 
	});
	
</script>
</body>
</html>