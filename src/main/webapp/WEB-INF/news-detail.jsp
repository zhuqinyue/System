<%@ page language="java" pageEncoding="utf-8"%>
<%@page import="java.util.UUID"%>
<%@page import="java.net.URLDecoder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<meta name="description" content="${description}"/>
	<meta name="keywords" content="${keywords}" />
	<meta itemprop="name" content="${title}"/>
	<title>云鼎空间</title>
	<link href="/css/reset.css" rel="stylesheet"/>
	<link href="/css/iconfont.css" rel="stylesheet"/>
	<link href="/css/style.css" rel="stylesheet"/>
	<script src="/js/jquery.min.js"></script>
	<link rel="stylesheet" href="/view/desk/main.css">
	<style>
		.newsbody{
			padding: 24px;
			background-color: #fff;
			border-radius: 4px;
			margin-bottom: 10px;
		}
		#pagebody {
			width: 80%;
			margin: auto;
			transition: width .3s ease-in;
		}

	</style>
	<script>

		function changeFrameHeight(){
			setTimeout(function(){
				var ifm= document.getElementById("iframepage");
				var iframeDoc = getIframeDocument(ifm);
				//  console.log($('#iframepage').contents()[0].getElementById("app").getAttribute("title"))
				ifm.height=iframeDoc.body.scrollHeight;
				//  $(".box").hide();
			},1000);

		}


	</script>
</head>
<body>

<header id="header" class="clearfix">
	<div id="logo">
		<a href="./index.html">
			<img src="/img/logo.png"/>
			<img src="/img/logo_text.png"/>
		</a>
	</div>
	<nav>
		<a href="/desk/getpageindex.html"  id="index" style="font-family: 'Arial Normal', 'Arial';" class="daoh">首页</a>
		<!--            <a href="/#/case"  @click="loading('example')" v-show="false" id="example" style="font-family: 'Arial Normal', 'Arial';" class="daoh">成功案例</a>-->
		<a  href="/desk/getpagenews.html" id="newss" style="font-family: 'Arial Normal', 'Arial';" class="active daoh">
			新闻中心</a>
		<span>客服热线：18500679093</span>
	</nav>
</header>
<!--  <div id="banner">-->
<!--    <img src="/img/u0.png"/>-->
<!--  </div>-->
<div id="wrapper" class="huise">
	<script src="/js/vue-2.4.0.js"></script>
	<div id="pagebody">
		<article id="news" class="clearfix">
			<div id="bian">
				<div class="news-bar" style="width: 23%;padding: 0px 0px 0px 7px;" >
					<section class="news-bar__section" style="border-radius: 4px;">
						<h3 class="news-bar__header" >最新文章</h3>
						<ul>
							<li v-for="item in zuixinglist" :key="item.newsid" @click.prevent="gotonewsdetail(item.newsid)">
								<a   v-text="item.newstitle" style="cursor: pointer;font-size: smaller;"></a>
								<span class="news-bar__info">{{item.updatetime|substr}}</span>
							</li>
						</ul>
					</section>
					<section class="news-bar__section banner">
						<img src="/img/u108.png"/>
					</section>
					<section class="news-bar__section">
						<h3 class="news-bar__header">推荐文章</h3>
						<ul>
							<li v-for="item in tuijianlist" @click.prevent="gotonewsdetail(item.newsid)">
								<a v-text="item.newstitle" style="cursor: pointer;font-size: smaller;" ></a>
								<span class="news-bar__info">{{item.updatetime|substr}}</span>
							</li>
						</ul>
					</section>
				</div>
			</div>
			<div class="news-detail" style="width: 76%;">
				<div class="news-detail__nav"><a @click="loading('index')" style="cursor: pointer;">首页</a> / <a id="typexw" @click="loading('news')" style="cursor: pointer;">新闻中心</a></div>
				<div class="newsbody">
					<h1 class="news-detail__title" style="font-family: -webkit-body;">{{newsdata.newstitle}}</h1>
					<div class="news-detail__info">
						<span class="author">云鼎空间</span> .
						<span class="time">{{newsdata.updatetime|substr}}</span> .
						<span class="source">新闻中心.产品运营</span> .
						<span class="viewer">阅读{{newsdata.liulanliang}}</span>
					</div>
				</div>

				<iframe class="news-detail__content newsbody" id="iframepage"  :src="src" frameborder="1" scrolling="no" width="100%" onload="changeFrameHeight()"> <!--onload="changeFrameHeight()"-->
				</iframe>

			</div>
		</article>
	</div>
	<div id="page-tool">
		<section class="contact">
			<i class="iconfont icon-dianhua"></i>
			<div class="pop">
				<h4>联系我们</h4>
				<p>电话：18500679093</p>
				<p>邮箱：401187784@qq.com</p>
			</div>
		</section>
		<section class="wechat">
			<i class="iconfont icon-weixin"></i>
			<div class="pop">
				<img src="/img/code.png"/>
			</div>
		</section>
		<section class="up" onclick="document.body.scrollTop = 0;document.documentElement.scrollTop = 0;">
			<i class="iconfont icon-up"></i>
			<div class="pop">
				返回顶部
			</div>
		</section>
	</div>
	<footer id="footer">
		<p>公司地址：北京市大兴区亦庄经济开发区地盛中路5号联邦国际云鼎科技有限公司  联系电话：18500679093</p>
		<p>Copyright © 2019-2026 www.bjydkj.cn 北京云鼎空间网络科技有限公司 版权所有</p>
		<a href="https://beian.miit.gov.cn"><p>京ICP备19012932号-1</p></a>
	</footer>
</div>
</body>
</html>

<script>

	function getText(){
		var iframe = document.getElementById('iframepage');
		var iframeDoc = getIframeDocument(iframe);



	}

	function getIframeDocument(iframe) {
		return iframe.contentDocument || iframe.contentWindow.document;
	}





	$(function () {



		/* setInterval(function (){
           document.querySelector('iframe').height = window.frames[0].document.documentElement.scrollHeight;
       }, 200);*/
		// $("html,body").animate({scrollTop: $("#bian").offset().top}, 800);
		/*console.log((parseInt($("#bian").height()/100)+1)*100 )
      var a = (parseInt($("#bian").height()/100)+1)*100
      $(window).on('scroll', function() {
        console.log($(window).scrollTop())
        if($(window).scrollTop()>=a+500){
          console.log("进来")
          if(!$("#bian").attr("class")){
            console.log("xixi")
            $("#bian").addClass("jued")
          }
        }else{
          $("#bian").removeClass()
        }
      });*/

	})
	Vue.filter('substr', function (val) {
		if(val!=null){
			return val.substring(0,10);
		}
		return val
	})

	var vm1 = new Vue({
		el: "#news",
		data:{
			newsdata : {},
			zuixinglist:[],
			tuijianlist:[],
			src:""
		},
		methods:{
			getUrlKey: function (name) {
				return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.href) || [, ""])[1].replace(/\+/g, '%20')) || null
			},
			gotonewsdetail:function(newsid){
				window.location.href="/desk/getpagenewsdetail.html?newsid="+newsid+"";
				$.post("/desk/addPV",{"id":newsid,"type":"news"})
			},
			loading:function(page){
				$(".daoh").removeClass("active")
				if(page=="news"){
					$("#"+page+"s").addClass("active")
				}else {
					$("#"+page).addClass("active")
				}

				window.location.href="/desk/getpage"+page+".html";
			},

		},
		mounted:function () {
			var _this = this
			$.post("/desk/getnews",{
				"type":"news"
			},function (obj){
				if(obj.ok){
					_this.zuixinglist = obj.data
				}
			})
			$.post("/desk/getnews",{
				"type":"tuijian"
			},function (obj){
				if(obj.ok){
					_this.tuijianlist = obj.data
				}
			})

			var newsid = this.getUrlKey("newsid")
			$.post("/desk/findOneNewsBodyById",{"newsid":newsid,"type":"news"},function (obj) {
				if(obj.ok){
					_this.newsdata = obj.data
					_this.src = "/desk/getbodypage?type=news&id="+obj.data.newsid
					$(document).attr("title",_this.newsdata.newstitle);
				}
			})

			$.post("/desk/addPV",{"id":newsid,"type":"news"})





		}

	})

</script>