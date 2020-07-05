<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html lang="en">

<head>
<title>Wines &mdash; Website Template by Colorlib</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link
	href="https://fonts.googleapis.com/css?family=Cinzel:400,700|Montserrat:400,700|Roboto&display=swap"
	rel="stylesheet">

<link rel="stylesheet" href="../fonts/icomoon/style.css">

<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/jquery-ui.css">
<link rel="stylesheet" href="../css/owl.carousel.min.css">
<link rel="stylesheet" href="../css/owl.theme.default.min.css">
<link rel="stylesheet" href="../css/owl.theme.default.min.css">

<link rel="stylesheet" href="../css/jquery.fancybox.min.css">

<link rel="stylesheet" href="../css/bootstrap-datepicker.css">

<link rel="stylesheet" href="../fonts/flaticon/font/flaticon.css">

<link rel="stylesheet" href="../css/aos.css">
<link href="../css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet"
	type="text/css">

<link rel="stylesheet" href="../css/style.css">



</head>

<body data-spy="scroll" data-target=".site-navbar-target"
	data-offset="300">

	<div class="site-wrap">

		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>



		<div class="row align-items-center">
			<div class="col-12 text-center">
				<a href="index.html" class="site-logo"> <img
					src="images/bintealogo.png" alt="Image" class="img-fluid">
				</a>
			</div>
		</div>




		<div
			class="site-navbar py-2 js-sticky-header site-navbar-target d-none pl-0 d-lg-block"
			role="banner">

			<div class="container">
				<div class="d-flex align-items-center">

					<div class="mx-auto">
						<nav class="site-navigation position-relative text-left"
							role="navigation">
							<ul
								class="site-menu main-menu js-clone-nav mx-auto d-none pl-0 d-lg-block border-none">
								<li><a href="board/board.do" class="nav-link text-left">NOTICE</a></li>
								<li class="active"><a href="about.html"
									class="nav-link text-left">TEA</a></li>
								<li><a href="shop.html" class="nav-link text-left">TEAWARE</a></li>
								<li><a href="shop.html" class="nav-link text-left">GIFTSET</a></li>
								<li><a href="contact.html" class="nav-link text-left">Q&A</a></li>
							</ul>
						</nav>

					</div>

				</div>
			</div>

		</div>

	</div>


	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
		integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
		crossorigin="anonymous">

	<title>board</title>
	<style>
body {
	padding-top: 70px;
	padding-bottom: 30px;
}
</style>
</head>

<body>
	<article>
		<div class="공지사항">

			<div class="table-responsive">

				<table class="table table-striped table-sm">

					<colgroup>

						<col style="width: 5%;" />

						<col style="width: auto;" />

						<col style="width: 15%;" />

						<col style="width: 10%;" />

						<col style="width: 10%;" />

					</colgroup>
					

					<thead>

						<tr align='center'>

							<th>NO</th>

							<th>글제목</th>


							<th>작성자</th>

							<th>작성일</th>

							<th>조회수</th>

						</tr>

					</thead>

					<tbody>

						<c:if test="${empty listResult.list}">
							<tr align='center'>
								<td  colspan="5">데이터가 없음</td>
							</tr>
						</c:if>

						<c:forEach items="${listResult.list}" var="board">
							<tr align='center'>
								<td >${board.b_seq}</td>
								<td >
								<a href="board.do?m=content&seq=${board.b_seq}">
										${board.b_subject} </a></td>
								
										<td>관리자</td>
									<td>${board.b_date}</td>
									<td>${board.b_count}</td>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	
	
		<hr width='600' size='2' color='gray' noshade>
		<font color='gray' size='3' face='나눔고딕'> (총페이지수 :
			${listResult.totalPageCount}) &nbsp;&nbsp;&nbsp; 
		
			<c:forEach begin="1" end="${listResult.totalPageCount}" var="i">
				<a href='board.do?cp=${i}'> 
				<c:choose>
					<c:when test="${i==listResult.currentPage}">
						<strong>${i}</strong>
					</c:when>
					<c:otherwise>
		         	   ${i}
		            </c:otherwise>
				</c:choose>
				</a>&nbsp;
	
  </c:forEach> ( TOTAL : ${listResult.totalCount})
	
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 페이지 싸이즈 : <select id="psId"
			name="ps" onchange="f(this)">
				<c:choose>
					<c:when test="${listResult.pageSize == 3}">
						<option value="3" selected>3</option>
						<option value="5">5</option>
						<option value="10">10</option>
					</c:when>
					<c:when test="${listResult.pageSize == 5}">
						<option value="3">3</option>
						<option value="5" selected>5</option>
						<option value="10">10</option>
					</c:when>
					<c:otherwise>
						<option value="3">3</option>
						<option value="5">5</option>
						<option value="10" selected>10</option>
					</c:otherwise>
				</c:choose>
	</div>	
		</select> <script language="javascript">
       function f(select){
           //var el = document.getElementById("psId");
           var ps = select.value;
           //alert("ps : " + ps);
           location.href='board.do?m=list&ps='+ps;
       }
    
    </script>

		</font>
		<hr width='600' size='2' color='gray' noshade>
	</article>


</body>

</html>


<%--  
    <div class="hero-2" style="background-image: url('images/hero_2.jpg');">
     <div class="container">
        <div class="row justify-content-center text-center align-items-center">
          <div class="col-md-8">
            <span class="sub-title">Welcome</span>
            <h2>About Us</h2>
          </div>
        </div>
      </div>
    </div>
	

    <div class="site-section py-5 custom-border-bottom" data-aos="fade">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-6">
            <div class="block-16">
              <figure>
                <img src="images/hero_1.jpg" alt="Image placeholder" class="img-fluid">
    
              </figure>
            </div>
          </div>
          <div class="col-md-1"></div>
          <div class="col-md-5">
    --%>
<%--
            <div class="site-section-heading pt-3 mb-4">
              <h2 class="text-black font-heading-serif">How We Started</h2>
            </div>
            <p>Rerum quis soluta, esse, cupiditate voluptate ipsum? Sunt unde eos vitae suscipit harum eligendi reprehenderit, illo eaque sit!</p>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Delectus consequuntur hic quaerat cupiditate tempore temporibus nulla at eum!</p>
    
          </div>
        </div>
      </div>
    </div>

    

    <div class="site-section py-5 bg-light custom-border-bottom" data-aos="fade">
      <div class="container">
        <div class="row">
          <div class="col-md-6 order-md-2">
            <div class="block-16">
              <figure>
                <img src="images/hero_2.jpg" alt="Image placeholder" class="img-fluid ">
                <a href="https://vimeo.com/channels/staffpicks/93951774" class="play-button popup-vimeo" data-fancybox><span
                    class="icon-play"></span></a>
    
              </figure>
            </div>
          </div>
          <div class="col-md-5 mr-auto">
    
    
            <div class="site-section-heading pt-3 mb-4">
              <h2 class="text-black font-heading-serif">Wines For You All</h2>
            </div>
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Delectus consequuntur hic quaerat cupiditate tempore temporibus nulla at eum!</p>
            <p>Magni debitis minima ipsam, itaque nam eligendi iusto? Adipisci blanditiis itaque ipsam cupiditate architecto, dolore saepe placeat culpa.</p>
            
            
    
          </div>
        </div>
      </div>
    </div>
    
    <div class="site-section site-section-sm site-blocks-1 border-0" data-aos="fade">
      <div class="container">
        <div class="row">
          <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="">
            <div class="icon mr-4 align-self-start">
              <span class="icon-truck text-primary"></span>
            </div>
            <div class="text">
              <h2 class="font-heading-serif">Free Shipping</h2>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus at iaculis quam. Integer accumsan
                tincidunt fringilla.</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="100">
            <div class="icon mr-4 align-self-start">
              <span class="icon-refresh2 text-primary"></span>
            </div>
            <div class="text">
              <h2 class="font-heading-serif">Free Returns</h2>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus at iaculis quam. Integer accumsan
                tincidunt fringilla.</p>
            </div>
          </div>
          <div class="col-md-6 col-lg-4 d-lg-flex mb-4 mb-lg-0 pl-4" data-aos="fade-up" data-aos-delay="200">
            <div class="icon mr-4 align-self-start">
              <span class="icon-help text-primary"></span>
            </div>
            <div class="text">
              <h2 class="font-heading-serif">Customer Support</h2>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus at iaculis quam. Integer accumsan
                tincidunt fringilla.</p>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="site-section bg-light">
      <div class="container">
        <div class="owl-carousel owl-slide-3 owl-slide">
        
          <blockquote class="testimony">
            <img src="images/person_1.jpg" alt="Image">
            <p>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero sapiente beatae, nemo quasi quo neque consequatur rem porro reprehenderit, a dignissimos unde ut enim fugiat deleniti quae placeat in cumque?&rdquo;</p>
            <p class="small text-primary">&mdash; Collin Miller</p>
          </blockquote>
          <blockquote class="testimony">
            <img src="images/person_2.jpg" alt="Image">
            <p>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero sapiente beatae, nemo quasi quo neque consequatur rem porro reprehenderit, a dignissimos unde ut enim fugiat deleniti quae placeat in cumque?&rdquo;</p>
            <p class="small text-primary">&mdash; Harley Perkins</p>
          </blockquote>
          <blockquote class="testimony">
            <img src="images/person_3.jpg" alt="Image">
            <p>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero sapiente beatae, nemo quasi quo neque consequatur rem porro reprehenderit, a dignissimos unde ut enim fugiat deleniti quae placeat in cumque?&rdquo;</p>
            <p class="small text-primary">&mdash; Levi Morris</p>
          </blockquote>
          <blockquote class="testimony">
            <img src="images/person_1.jpg" alt="Image">
            <p>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Libero sapiente beatae, nemo quasi quo neque consequatur rem porro reprehenderit, a dignissimos unde ut enim fugiat deleniti quae placeat in cumque?&rdquo;</p>
            <p class="small text-primary">&mdash; Allie Smith</p>
          </blockquote>
        
        </div>
      </div>
    </div>
  
	
    
    
    <div class="footer">
      <div class="container">
        
        <div class="row">
          <div class="col-12 text-center">
            <div class="social-icons">
              <a href="#"><span class="icon-facebook"></span></a>
              <a href="#"><span class="icon-twitter"></span></a>
              <a href="#"><span class="icon-youtube"></span></a>
              <a href="#"><span class="icon-instagram"></span></a>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <div class="copyright">
                <p>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart text-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
                    <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>



            </div>
          </div>
        </div>
      </div>
    </div>
    

  </div>
  	
  <!-- .site-wrap -->


  <!-- loader -->
  <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#ff5e15"/></svg></div>

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/bootstrap-datepicker.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.fancybox.min.js"></script>
  <script src="js/jquery.sticky.js"></script>
  <script src="js/jquery.mb.YTPlayer.min.js"></script>




  <script src="js/main.js"></script>
	--%>
</body>

</html>