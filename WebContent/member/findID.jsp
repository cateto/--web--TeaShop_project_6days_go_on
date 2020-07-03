<%@page contentType="text/html;charset=utf-8"%>
<jsp:include page="../etc/frame-ver2.jsp"/>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>BinTea &mdash; BinTea is New Wave</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  
  <link href="https://fonts.googleapis.com/css?family=Cinzel:400,700|Montserrat:400,700|Roboto&display=swap" rel="stylesheet">

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
  <link href="../css/jquery.mb.YTPlayer.min.css" media="all" rel="stylesheet" type="text/css">

  <link rel="stylesheet" href="../css/style.css">

	<!-- 위에까지는 템플릿 -->

	<!-- 추가한 부분 (로그인 확인 js)-->

</head>

<body data-spy="scroll" data-target=".site-navbar-target" data-offset="300" onload="document.f.id.focus()">

  <div class="site-wrap">


    <div class="site-section bg-light">
      <div class="container">
        <div class="row" >
			
          <div class="col-lg-12">
            <div class="section-title mb-5">
              <h2>ID 찾기</h2>
            </div>
  
          </div>
          <div class="search-div">

		<form action="member.do?m=foundID" method="post">

			  <div class="row">
                <div class="col-md-12 form-group">
                   <label for="name">이름</label>
                         
                     <input class="form-control form-control-lg" name="name" size="20" align="center">
               </div>
             </div>
              <div class="row">
                <div class="col-md-12 form-group">
                   <label for="birth">생년월일</label>
                     <input class="form-control form-control-lg" type="text" class="form-control" id="birth" align="center" size="20" name="birth" placeholder="ex) 1990-03-13" data-provide="datepicker" data-date-format="yyyy-mm-dd">
                </div>
             </div>
			
                <br/> <br/>
                      <div class="col-12">
                          <input type="submit" value="find" class="btn btn-primary py-3 px-5">
                      </div>
                  
		</form>
		</div>


</div>
          
        </div>

        
      </div>
    </div>

  

<jsp:include page="../etc/footer.jsp"/>
    

  </div>
  <!-- .site-wrap -->


  <!-- loader -->
  <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#ff5e15"/></svg></div>

  <script src="../js/jquery-3.3.1.min.js"></script>
  <script src="../js/jquery-migrate-3.0.1.min.js"></script>
  <script src="../js/jquery-ui.js"></script>
  <script src="../js/popper.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/owl.carousel.min.js"></script>
  <script src="../js/jquery.stellar.min.js"></script>
  <script src="../js/jquery.countdown.min.js"></script>
  <script src="../js/bootstrap-datepicker.min.js"></script>
  <script src="../js/jquery.easing.1.3.js"></script>
  <script src="../js/aos.js"></script>
  <script src="../js/jquery.fancybox.min.js"></script>
  <script src="../js/jquery.sticky.js"></script>
  <script src="../js/jquery.mb.YTPlayer.min.js"></script>




  <script src="../js/main.js"></script>

</body>

</html>