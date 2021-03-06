<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="네이버 예약, 네이버 예약이 연동된 곳 어디서나 바로 예약하고, 네이버 예약 홈(나의예약)에서 모두 관리할 수 있습니다.">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no">
<title>네이버 예약</title>
<link href="css/style.css" rel="stylesheet">
    <style>
        .container_visual {
            height: 414px;
        }
    </style>
</head>
<body>
<div id="container">
        <div class="header fade">
            <header class="header_tit">
                <h1 class="logo">
                    <a href="./mainpage.html" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                    <a href="./mainpage.html" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                </h1>
                <a href="#" class="btn_my"> <span title="예약확인">예약확인</span> </a>
            </header>
        </div>
        <div class="ct main">
            <div>
                <div class="section_visual">
                    <header>
                        <h1 class="logo">
                            <a href="main" class="lnk_logo" title="네이버"> <span class="spr_bi ico_n_logo">네이버</span> </a>
                            <a href="main" class="lnk_logo" title="예약"> <span class="spr_bi ico_bk_logo">예약</span> </a>
                        </h1>
                        <a href="./myreservation.html" class="btn_my"> <span class="viewReservation" title="예약확인">예약확인</span> </a>
                    </header>
                    <p id="detailId" style="display:none">${detailId}</p>
                    <div class="pagination">
                        <div class="bg_pagination"></div>
                        <div class="figure_pagination">
                            <span class="num">1</span>
                            <c:choose>
						        <c:when test="${etCount>=1}">
						            <span class="num off">/ <span>2</span></span>
						        </c:when>
						        <c:otherwise>
						            <span class="num off">/ <span>1</span></span>
						        </c:otherwise>
						    </c:choose>
                        </div>
                    </div>
                    <div class="group_visual">
                        <div>
                            <div class="container_visual" style="width: 414px;">
                                <ul class="visual_img detail_swipe" style="transition-duration: 1s;">
                                </ul>
                            </div>
                            <c:if test="${etCount>=1}">
                            <div class="prev">
                                <div class="prev_inn">
                                    <a href="#" class="btn_prev" title="이전">
                                        <!-- [D] 첫 이미지 이면 off 클래스 추가 -->
                                        <i class="spr_book2 ico_arr6_lt off"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="nxt">
                                <div class="nxt_inn">
                                    <a class="btn_nxt" title="다음">
                                        <i class="spr_book2 ico_arr6_rt"></i>
                                    </a>
                                </div>
                            </div>
                            </c:if>
                        </div>
                    </div>
                    <div class="group_btn_goto"  style="display: none;">
                        <a class="btn_goto_home" title="홈페이지" href="#" target="siteUrl"> <i class="fn fn-home1"></i> </a>
                        <a class="btn_goto_tel" title="전화" href="#"> <i class="fn fn-call1"></i> </a>
						<a class="btn_goto_mail" title="이메일" href="#"> <i class="fn fn-mail1"></i> </a>
                        <a href="#" class="btn_goto_path" title="길찾기"> <i class="fn fn-path-find1"></i> </a>
                        <a href="#" class="fn fn-share1 naver-splugin btn_goto_share" title="공유하기"></a>
                    </div>
                </div>
                <div class="section_store_details">
                    <!-- [D] 펼쳐보기 클릭 시 store_details에 close3 제거 -->
                    <div class="store_details close3">
                        <p class="dsc">
	                        <c:forEach var="prod" items="${product}">
								${prod.content}		
							</c:forEach>
                        </p>
                    </div>
                    <!-- [D] 토글 상황에 따라 bk_more에 display:none 추가 -->
                    <a class="bk_more _open"> <span class="bk_more_txt">펼쳐보기</span> <i class="fn fn-down2"></i> </a>
                    <a class="bk_more _close" style="display: none;"> <span class="bk_more_txt">접기</span> <i class="fn fn-up2"></i> </a>
                </div>
                <div class="section_event">
                    <div class="event_info_box">
                        <div class="event_info_tit">
                            <h4 class="in_tit"> <i class="spr_book ico_evt"></i> <span>이벤트 정보</span> </h4>
                        </div>
                        <div class="event_info">
                      		<c:forEach var="prod" items="${product}">
                            	<div class="in_dsc">${prod.event}</div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
                <div class="section_btn"> <button type="button" class="bk_btn" onclick="location.href='reserve?id=${detailId}'"> <i class="fn fn-nbooking-calender2"></i> <span>예매하기</span> </button> </div>
                <div class="section_review_list">
                    <div class="review_box">
                        <h3 class="title_h3">예매자 한줄평</h3>
                        <div class="short_review_area">
                            <div class="grade_area">
                                <!-- [D] 별점 graph_value는 퍼센트 환산하여 width 값을 넣어줌 -->
                                <span class="graph_mask"> <em class="graph_value" style="width: ${scoreWidth}%; vertical-align: text-top;"></em> </span>
                                <strong class="text_value"> <span>${avgScore}</span> <em class="total">5.0</em> </strong>
                                <span class="join_count"><em class="green">${commentCnt}건</em> 등록</span>
                            </div>
                            <ul class="list_short_review">
                 	            <c:forEach var="comm" items="${comment}" begin="0" end="2" step="1">
                            	<li class="list_item">
                                    <div>
                                        <div class="review_area">
                                        	<c:forEach var="commImg" items="${commentImages}">
                                        	<c:if test="${commImg.reservationUserCommentId==comm.id}">
                                            <div class="thumb_area">
                                                <a href="javascript:void(0)" class="thumb" title="이미지 크게 보기"> <img width="90" height="90" class="img_vertical_top" src="${commImg.saveFileName}" alt="리뷰이미지"> </a> <span class="img_count">1</span>
                                             </div>
                                              </c:if>
                                             </c:forEach>
                                            <h4 class="resoc_name"></h4>
                                            <p class="review">${comm.comment}</p>
                                        </div>
                                        <div class="info_area">
                                            <div class="review_info"> 
                                            <span class="grade">${comm.score}</span> 
                                            <span class="name"> ${fn:substring(comm.reservationEmail,0,3)}***</span>
                                            <span class="date">${comm.createDate} 방문</span> </div>
                                        </div>
                                    </div>
                                </li>
                                </c:forEach>
                            </ul>
                        </div>
                        <p class="guide"> <i class="spr_book2 ico_bell"></i> <span>네이버 예약을 통해 실제 방문한 이용자가 남긴 평가입니다.</span> </p>
                    </div>
                    <a class="btn_review_more" href="review?id=${detailId}"> <span>예매자 한줄평 더보기</span> <i class="fn fn-forward1"></i> </a>
                </div>
                <div class="section_info_tab">
                    <!-- [D] tab 선택 시 anchor에 active 추가 -->
                    <ul class="info_tab_lst">
                        <li class="item active _detail">
                            <a class="anchor active">상세정보</a>
                        </li>
                        <li class="item _path">
                            <a class="anchor">오시는길</a>
                        </li>
                    </ul>
                    <!-- [D] 상세정보 외 다른 탭 선택 시 detail_area_wrap에 hide 추가 -->
                    <div class="detail_area_wrap">
                        <div class="detail_area">
                        <div class="detail_info">
                                <h3 class="blind">상세정보</h3>
                                <ul class="detail_info_group">
                                    <li class="detail_info_lst">
                                        <strong class="in_tit">[소개]</strong>
                                        <p class="in_dsc">
                                        <c:forEach var="prod" items="${product}">
										${prod.content}
										</c:forEach>		
                                        </p>
                                    </li>
                                    <li class="detail_info_lst"> <strong class="in_tit">[공지사항]</strong>
                                        <ul class="in_img_group">
                                            <li class="in_img_lst"> <img class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170131_238/14858250829398Pnx6_JPEG/%B0%F8%C1%F6%BB%E7%C7%D7.jpg?type=a1000"> </li>
                                        </ul>
                                    </li>
                                    <!-- <li class="detail_info_lst"> <strong class="in_tit">[공연정보]</strong>
                                        <ul class="in_img_group">
                                            <li class="in_img_lst"> <img alt="" class="img_thumb" src="https://ssl.phinf.net/naverbooking/20170131_255/1485825099482NmYMe_JPEG/%B0%F8%BF%AC%C1%A4%BA%B8.jpg?type=a1000"> </li>
                                        </ul>
                                    </li> -->
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- [D] 오시는길 외 다른 탭 선택 시 detail_location에 hide 추가 -->
                    <div class="detail_location hide">
                        <div class="box_store_info no_topline">
                        	<c:forEach var="dispImg" items="${displayImages}">
                            <a href="javascript:void(0)" class="store_location" title="지도웹으로 연결">
                                <img class="store_map img_thumb" alt="map" src="${dispImg.saveFileName}">
                                <span class="img_border"></span>
                                <span class="btn_map"><i class="spr_book2 ico_mapview"></i></span>
                            </a>
                            </c:forEach>
                            <c:forEach var="prod" items="${product}">
                            <h3 class="store_name">${prod.description}</h3>
                            <div class="store_info">
                                <div class="store_addr_wrap">
                                    <span class="fn fn-pin2"></span>
                                    <p class="store_addr store_addr_bold">${prod.placeLot}</p>
                                    <p class="store_addr">
                                        <span class="addr_old">지번</span>
                                        <span class="addr_old_detail">${prod.placeStreet}</span>
                                    </p>
                                    <p class="store_addr addr_detail">${prod.placeName}</p>
                                </div>
                                <div class="lst_store_info_wrap">
                                    <ul class="lst_store_info">
                                        <li class="item"> <span class="item_lt"> <i class="fn fn-call2"></i> <span class="sr_only">전화번호</span> </span> <span class="item_rt"> <a href="tel:02-548-0597" class="store_tel">${prod.tel}</a></span> </li>
                                    </ul>
                                </div>
                            </div>
                            </c:forEach>
							<!-- [D] 모바일 브라우저에서 접근 시 column2 추가와 btn_navigation 요소 추가 -->
                            <div class="bottom_common_path column2">
                                <a href="javascript:void(0)" class="btn_path"> <i class="fn fn-path-find2"></i> <span>길찾기</span> </a>
								<a href="javascript:void(0)" class="btn_navigation before"> <i class="fn fn-navigation2"></i> <span>내비게이션</span> </a>
                            </div>
                        </div>
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
    <div id="photoviwer"></div>
    
    <script type="rv-template" id="etImageList">
    <li class="item" style="width: 414px; height: -webkit-fill-available;"> <img style="height: -webkit-fill-available;" class="img_thumb" src="{{saveFileName}}"> <span class="img_bg"></span>
    <div class="visual_txt">
	</script>
	<script type="rv-template" id="etImageList2">
        <div class="visual_txt_inn">
            <h2 class="visual_txt_tit"> <span>{{description}}</span> </h2>
            <p class="visual_txt_dsc"></p>
        </div>
    </div>
	</li>
	</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>
    <script>
   var detailUl=document.querySelector(".visual_img");	
   function addEtTemplate(json){		
   		var etTempl=document.querySelector("#etImageList").innerText;
   		var etTempl2=document.querySelector("#etImageList2").innerText;
   		var etBindTempl=Handlebars.compile(etTempl);
   		var etBindTempl2=Handlebars.compile(etTempl2);
   		
		var prodHTML=etBindTempl(json.productImage[0]);
		prodHTML+=etBindTempl2(json.product[0]);
		
        var etHTML=json.etImages.reduce(function(prev,next){ 
           return prev+etBindTempl(next)+etBindTempl2(json.product[0]);
       },"");
       
		detailUl.insertAdjacentHTML('beforeend',prodHTML);
		detailUl.insertAdjacentHTML('beforeend',etHTML);
   }
	
	var detailId=parseInt(document.querySelector("#detailId").innerText);
	
    window.onload=function(){
 		var oReq=new XMLHttpRequest();
		oReq.addEventListener("load",function(){
			var json=JSON.parse(this.responseText);
			addEtTemplate(json);
		});
		oReq.open("POST", "/reservation/img/et", true);
		oReq.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		oReq.send("displayInfoId="+detailId);
	}
   </script>
   <script>
 	var etcnt=1;
 	var etMargin=0;
 	var promNum=document.querySelector(".num");
 	var leftBtn=document.querySelector(".btn_prev");
 	var lefticon=document.querySelector(".btn_prev i");
 	var rightBtn=document.querySelector(".btn_nxt");
 	var righticon=document.querySelector(".btn_nxt i");
 	
	leftBtn.addEventListener("click",function(){
		if(etcnt==2){
 			lefticon.classList.add("off"); 
 			righticon.classList.remove("off"); 
 			
			etcnt--;
			etMargin-=100;
	
			promNum.innerText=etcnt;
			detailUl.style.marginLeft ="-"+etMargin+"%";
		}
	});	
 	
 	rightBtn.addEventListener("click", function(){
 		if(etcnt==1){
 			lefticon.classList.remove("off"); 
 			righticon.classList.add("off"); 
 			
 	 		etcnt++;
 	 		etMargin+=100;  
 	 		
 	 		promNum.innerText=etcnt;
 			detailUl.style.marginLeft ="-"+etMargin+"%";
 		}
 		
   	}); 
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
    //접기 펼치기
    $(document).ready(function(){
        $(".bk_more").click(function(){
            $(".store_details").toggleClass("close3");
             if($("._close").css("display") == "none"){   
    		    $('._close').css("display", "block");   
		    } 
            else{
            $('._close').css("display", "none");
            }
            if($("._open").css("display") == "block"){   
    		    $('._open').css("display", "none");   
		    } 
            else{
            $('._open').css("display", "block");
            } 
        });
    });
    </script>
    <script>    
    /*
     * 리뷰 사진 없을 때
     */
    	var reviewArea=document.querySelectorAll(".review_area");
    	for(var i=0, len=reviewArea.length; i<len; i++ ){
    		if(!reviewArea[i].querySelector(".thumb_area")){
    			reviewArea[i].classList.add("no_img");
			}
    	}
    </script>
    <script>
    //탭전환
	var infoTab=document.querySelector(".info_tab_lst");
	infoTab.addEventListener("click", function(e){
         if (e.target.tagName === "A") {
        	console.log(e.target.innerText);
    		
         	//카테고리 active
    		var anchor=document.querySelectorAll(".anchor");
    		for(var i=0, len=anchor.length; i<len; i++ ){
    			anchor[i].classList.remove("active");
    		}
        	e.target.classList.add("active"); 
        	
        	//상세정보, 오시는길 내용
        	var detArea=document.querySelector(".detail_area_wrap");
        	var detLoca=document.querySelector(".detail_location");
            if(e.target.innerText=="오시는길"){
            	//상세정보 외 다른 탭 선택 시 detail_area_wrap에 hide 추가
            	detLoca.classList.remove("hide");
            	detArea.classList.add("hide");
        	}
            else{
            	//오시는길 외 다른 탭 선택 시 detail_location에 hide 추가
            	detArea.classList.remove("hide");
            	detLoca.classList.add("hide");
            }
        } 
	});
    </script>
</body>
</html>
