<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>多道程序设计缓冲区协调操作</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/layui.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>fonts/font-awesome-4.3.0/css/font-awesome.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/default.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/component.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/custom-bars.css" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/button.css" />
	
	<style>
	body{
		background: url(img/bg2.jpg) no-repeat;
    	background-size: 100% 100%;
	}
	::-webkit-scrollbar  
	{  
	    width: 10px;
	    height: 4px;  
	    background-color: #F5F5F5; 
	     
	}  
  	
  	
	/*定义滚动条轨道 内阴影+圆角*/  
	::-webkit-scrollbar-track  
	{  
	     -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
        /*border-radius: 10px;*/
        background: #EDEDED;
	}  
  
	/*定义滑块 内阴影+圆角*/  
	::-webkit-scrollbar-thumb  
	{  
	    border-radius: 10px;
		background-color: #F90;
		background-image: -webkit-linear-gradient(45deg, rgba(255, 255, 255, .2) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, .2) 50%, rgba(255, 255, 255, .2) 75%, transparent 75%, transparent);
	} 
		h3{
			color: #fff;
    		text-shadow: 5px 5px 5px #000;
			margin: 20px;
			font-size: 20px;
		}
		.container{
			
		}
		.content{
		    height: 800px;
			float: left;
			width: 500px;
			
		}
		.progress-factor {
   	
    		padding: 0.5em.2em 0;
		}
		.flexy-grid {
			height: 80%;
		    padding: 0;
		}

		.value-label {
    
    		margin: 0 0 2.5em 0;
    
		}
		#endSystem{
			position: absolute;
		    right: 80px;
		    top: 157px;
		}
		.layui-icon-close{
			font-size:30px;
		}
		#setParam{
			position: absolute;
		    right: 80px;
		    top: 5px;
		}
		.layui-form-pane .layui-input {
    		font-size: 16px;
    
		}
		.layui-input, .layui-textarea {
		    display: block;
		    width: 84%;
		    padding-left: 10px;
		    float: right;
		}	
			
		.layui-table {
	    	margin-left: 79px;
		    float: left;
		    width: 50%;
		    background-color: #fff;
		    color: #666;
		    display: block;		
    	}
		.layui-table td, .layui-table th {
		   
		    padding: 9px 34px;
		  
		}
		.layui-form-pane .layui-form-label {
		    width: 190px;
		}
		
		
		
		
		#buffer1{
		cursor:pointer;
		font-size: 27px;
	    border-radius: 10px;
	    color: #fff;
	    position: absolute;
	    top: 250px;
	    right: 80px;
	    clear: both;
	    width: 258px;
	    height: 386px;
	    background: url(img/buffer5.png) no-repeat;
	    background-size: 100% 100%;
	   
	    outline: none;
		}
		
		#buffer2{
		cursor:pointer;
		font-size: 27px;
	    border-radius: 10px;
	    color: #fff;
	    position: absolute;
	    top: 250px;
	    right: 390px;
	    clear: both;
	    width: 258px;
	    height: 386px;
	    background: url(img/buffer1.png) no-repeat;
	    background-size: 100% 100%;
	   
	    outline: none;
		}
		
		#buffer3 {
			cursor:pointer;
		    font-size: 27px;
		    border-radius: 10px;
		    color: #fff;
		    position: absolute;
		    top: 250px;
		    right: 690px;
		    clear: both;
		    width: 258px;
		    height: 386px;
		    background: url(img/buffer3.png) no-repeat;
		    background-size: 100% 100%;
		    outline: none;
		}
		
		#play{
			position: absolute;
    		top: 80px;
   			right: 80px;
		}
		.buffer1Span{
			color: #fff;
		    text-shadow: 5px 5px 5px #000;
	
		    font-size: 29px;
		    position: absolute;
		    float: right;
		    display: block;
		    top: 200px;
		    right: 158px;
    	}
    	.buffer2Span{
			color: #fff;
		    text-shadow: 5px 5px 5px #000;
	
		    font-size: 29px;
		    position: absolute;
		    float: right;
		    display: block;
		    top: 200px;
		    right: 470px;
    	}
    	.buffer3Span{
			color: #fff;
		    text-shadow: 5px 5px 5px #000;
	
		    font-size: 29px;
		    position: absolute;
		    float: right;
		    display: block;
		    top: 200px;
		    right: 776px;
    	}
	</style>
  </head>
  
  <body>
	<div class="container">
	
		<section class="content">
			<!-- <h2>h2</h2> -->
			
			<article class="flexy-grid">
				<h3>Put 线程</h3>
				<input type="checkbox" id="bar-2">
				<div class="flexy-column">
					<div class="progress-factor flexy-item">
						<div class="progress-bar">
							<div class="bar has-rotation has-colors red heat-gradient" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100">
								<div class="tooltip heat-gradient-tooltip"></div>
								<div class="bar-face face-position roof percentage"></div>
								<div class="bar-face face-position back percentage"></div>
								<div class="bar-face face-position floor percentage volume-lights"></div>
								<div class="bar-face face-position left"></div>
								<div class="bar-face face-position right"></div>
								<div class="bar-face face-position front percentage volume-lights shine"></div>
							</div>
						</div>
					</div>
				</div>
				<h3>Move 线程</h3>
				<div class="flexy-column">
					<div class="progress-factor flexy-item">
						<div class="progress-bar">
							<div class="bar has-rotation has-colors red heat-gradient" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100">
								<div class="tooltip heat-gradient-tooltip"></div>
								<div class="bar-face face-position roof percentage"></div>
								<div class="bar-face face-position back percentage"></div>
								<div class="bar-face face-position floor percentage volume-lights"></div>
								<div class="bar-face face-position left"></div>
								<div class="bar-face face-position right"></div>
								<div class="bar-face face-position front percentage volume-lights shine"></div>
							</div>
						</div>
					</div>
				</div>
				<h3>Get 线程</h3>
				<div class="flexy-column">
					<div class="progress-factor flexy-item">
						<div class="progress-bar">
							<div class="bar has-rotation has-colors red heat-gradient" role="progressbar" aria-valuenow="10" aria-valuemin="0" aria-valuemax="100">
								<div class="tooltip heat-gradient-tooltip"></div>
								<div class="bar-face face-position roof percentage"></div>
								<div class="bar-face face-position back percentage"></div>
								<div class="bar-face face-position floor percentage volume-lights"></div>
								<div class="bar-face face-position left"></div>
								<div class="bar-face face-position right"></div>
								<div class="bar-face face-position front percentage volume-lights shine"></div>
							</div>
						</div>
					</div>
				</div>
				<label id="switchBtn" class="value-label" for="bar-2">暂停 / 继续</label>
			</article>
			
		
		</section>
		<!-- Related demos -->
			<button class="button button-3d button-box button-jumbo" id="setParam"><i class="fa fa-gear"></i></button>
			<button class="button button-3d button-box button-jumbo" id="play"><i class="layui-icon layui-icon-play" style="font-size: 35px;"></i></button>
			<button class="button button-3d button-box button-jumbo" id="endSystem"><i class="layui-icon layui-icon-close"></i></button>

		  	<!-- <button class="button button-primary button-circle button-giant button-longshadow" id="setParam">
    			<i class="fa fa-gear"></i>
  			</button> -->
		<table class="layui-table">
			  <colgroup>
			    <col width="150">
			    <col width="200">
			    <col>
			  </colgroup>
			  <thead>
			    <tr>
			      <!--  <th>${sessionScope.param}</th>-->
			      <th>缓冲区</th>
			      <th>数据个数</th>
			      <th>数据内容</th>
			      <th>空闲空间个数</th>
			      <th>阻塞线程数</th>
			    </tr> 
			  </thead>
			  <tbody>
			    <tr>
			      <td>Buffer1</td>
			      <td id="buffer1DataNum"></td>
			      <td id="buffer1Data"></td>
			      <th id="buffer1FreeSpaceNum"></th>
			      <th id="blockedNum"></th>
			    </tr>
			    <tr>
			      <td>Buffer2</td>
			      <td id="buffer2DataNum"></td>
			      <td id="buffer2Data"></td>
			       <th id="buffer2FreeSpaceNum"></th>
			    </tr>
			    <tr>
			      <td>Buffer3</td>
			      <td id="buffer3DataNum"></td>
			      <td id="buffer3Data"></td>
			       <th id="buffer3FreeSpaceNum"></th>
			    </tr>
			  </tbody>
		</table>
			<span class="buffer1Span">Buffer1</span>
			<div id="buffer1" contenteditable="true"; style="overflow:auto;text-shadow: 5px 5px 5px #000;" spellcheck="false" >
				<!-- <c:forEach var="u" items="${sessionScope.buffer1List}">
					${u.message}<br>
				</c:forEach>-->
			
			</div>
			<span class="buffer2Span">Buffer2</span>
			<div id="buffer2" contenteditable="true"; style="overflow:auto;text-shadow: 5px 5px 5px #000;" spellcheck="false" >
				
			
			</div>
			<span class="buffer3Span">Buffer3</span>
			<div id="buffer3" contenteditable="true"; style="overflow:auto;text-shadow: 5px 5px 5px #000;" spellcheck="false" >
				
			
			</div>
	</div>
	
	<script src="js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/layer.js"></script>
	<script type="text/javascript" src="js/layui.js"></script>
	<script type="text/javascript" charset="utf-8">
		$("#buffer1").hover(function(){
		    $("#buffer1").css("overflow","auto");
		},function(){
		    $("#buffer1").css("overflow","hidden");
		})
		$("#buffer2").hover(function(){
		    $("#buffer2").css("overflow","auto");
		},function(){
		    $("#buffer2").css("overflow","hidden");
		})
		$("#buffer3").hover(function(){
		    $("#buffer3").css("overflow","auto");
		},function(){
		    $("#buffer3").css("overflow","hidden");
		})
		setInterval(function () {
			$.ajax({
			
			             type: "post",
			
			             url: "/MyOsProject/GetBlockedNumAction?",
			
			             dataType: "json",
			
			             success: function(data){
			             	$("#blockedNum").html(data);		
							console.log(data);
			             }
			 });
		
		},1000)
		
		var table = "";	 
		$("#endSystem").click(function(){
			
			$.ajax({
			
			             type: "post",
			
			             url: "/MyOsProject/PauseAction?pause=end",
			
			             data: {pause:"end"},
			
			             dataType: "json",
			
			             success: function(data){
			             	table = '<form id="setMyParam" class="layui-form layui-form-pane" action="/MyOsProject/OsMainView" method="post">'+
			 				'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009f95;color: #fff;">总运行时间</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="buffer1Size" value="'+data[0].runtime+' 毫秒" required lay-verify="required" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009f95;color: #fff;">buffer中数据个数</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="buffer1Size" value="'+data[0].bufferDataNum+'" required lay-verify="required" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009f95;color: #fff;">已放入的个数</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="buffer1Size" value="'+data[0].putInBufferNum+'" required lay-verify="required" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009f95;color: #fff;">已取出的数据个数</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="buffer1Size" value="'+data[0].getOutBufferNum+'" required lay-verify="required" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009f95;color: #fff;">平均每个Buffer中的个数</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="buffer1Size" value="'+data[0].avgBufferNum+'" required lay-verify="required" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'</form>';
					 	
							 layer.open({
							  type: 1 //Page层类型
							  ,area: ['620px', '420px']
							  ,title: '运行结果'
							  ,shade: 0.6 //遮罩透明度
							  , skin: 'layui-layer-molv'
							  ,anim:2
							  ,maxmin: true //允许全屏最小化
							  ,anim: 1 //0-6的动画形式，-1不开启
							  ,content:table
							}); 
			             }
			 });
		
			 
		
		})
		
		
		var pauseFlag = true;
		$("#switchBtn").click(function(){
				if(pauseFlag==true) {
					$.ajax({
			
			             type: "post",
			
			             url: "/MyOsProject/PauseAction?pause=true",
			
			             data: {pause:"true"},
			
			             dataType: "json",
			
			             success: function(data){
			             			
							
			             }
			
			         });
				}else {
					$.ajax({
			
			             type: "post",
			
			             url: "/MyOsProject/PauseAction?pause=false",
			
			             data: {pause:"false"},
			
			             dataType: "json",
			
			             success: function(data){
			             			
							
			             }
			
			         });
				}
				pauseFlag = !pauseFlag;
		
		})
		
		
		$("#play").click(function(){
				$.ajax({
			
			             type: "post",
			
			             url: "/MyOsProject/GetBufferDataAction?start=true",
			
			             data: {start:"end"},
			
			             dataType: "json",
			
			             success: function(data){
			             			
							
			             }
			
			         });
				setInterval(function () {
			           $.ajax({
			
			             type: "post",
			
			             url: "/MyOsProject/GetBufferDataAction?type=1",
			
			             data: {type:"1"},
			
			             dataType: "json",
			
			             success: function(data){
			             			
									var html="";
									$.each(data, function(n, value){
										$("#buffer1").html(" ");
										$("#buffer1DataNum").html(value.bufferContentNum);
										$("#buffer1Data").html(value.bufferContent);
										$("#buffer1FreeSpaceNum").html(value.freeSpaceNum);
										html += value.message+"<br>";
										
									});
									$("#buffer1").html(html);
			
			                      }
			
			         });
				
			        },1000);
			        
			        setInterval(function () {
			           $.ajax({
			
			             type: "post",
			
			             url: "/MyOsProject/GetBufferDataAction?type=2",
			
			             data: {type:"2"},
			
			             dataType: "json",
			
			             success: function(data){
			             			
									var html="";
									$.each(data, function(n, value){
										$("#buffer2").html(" ");
										$("#buffer2DataNum").html(value.bufferContentNum);
										$("#buffer2Data").html(value.bufferContent);
										$("#buffer2FreeSpaceNum").html(value.freeSpaceNum);
										html += value.message+"<br>";
										
									});
									$("#buffer2").html(html);
			
			                      }
			
			         });
				
			        },1000);
			        
			        setInterval(function () {
			           $.ajax({
			
			             type: "post",
			
			             url: "/MyOsProject/GetBufferDataAction?type=3",
			
			             data: {type:"3"},
			
			             dataType: "json",
			
			             success: function(data){
			             			
									var html="";
									$.each(data, function(n, value){
										$("#buffer3").html(" ");
										$("#buffer3DataNum").html(value.bufferContentNum);
										
										$("#buffer3Data").html(value.bufferContent);
										$("#buffer3FreeSpaceNum").html(value.freeSpaceNum);
										html += value.message+"<br>";
										
									});
									$("#buffer3").html(html);
			
			                      }
			
			         });
				
			        },1000);
				
				
		
		})
		

		
	
	
		$("#change-color .bar").hover(function(){
			// $(this).toggleClass('active');
			$(this).find('.front').toggleClass('shine');
		});
		var form = 		'<form id="setMyParam" class="layui-form layui-form-pane" action="/MyOsProject/OsMainView" method="post">'+

  						'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009f95;color: #fff;">Buffer1容量</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="buffer1Size" required lay-verify="required" placeholder="请输入容量" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009f95;color: #fff;">Buffer2容量</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="buffer2Size" required lay-verify="required" placeholder="请输入容量" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009f95;color: #fff;">Buffer3容量</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="buffer3Size" required lay-verify="required" placeholder="请输入容量" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #F90;color: #fff;">Put操作个数</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="PutNum" required lay-verify="required" placeholder="请输入个数" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: purple;color: #fff;">MoveBuffer2操作个数</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="Move2Num" required lay-verify="required" placeholder="请输入个数" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: purple;color: #fff;">MoveBuffer3操作个数</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="Move3Num" required lay-verify="required" placeholder="请输入个数" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: limegreen;color: #fff;">GetBuffer2操作个数</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="Get2Num" required lay-verify="required" placeholder="请输入个数" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: limegreen;color: #fff;">GetBuffer3操作个数</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="Get3Num" required lay-verify="required" placeholder="请输入个数" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009FDB;color: #fff;">putSpeed</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="putSpeed" required lay-verify="required" placeholder="请输入put线程的速度" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
						'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009FDB;color: #fff;">moveSpeed</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="moveSpeed" required lay-verify="required" placeholder="请输入move线程的速度" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
					 	'<div class="layui-form-item" pane>'+
  							' <label class="layui-form-label" style="background: #009FDB;color: #fff;">GetSpeed</label>'+
  							'<div class="layui-input-block">'+
					    	'<input type="text" name="getSpeed" required lay-verify="required" placeholder="请输入get线程的速度" '+'autocomplete="off" class="layui-input">'+   
					  		'</div>'+
					 	'</div>'+
						' <button style="width: 115px;margin: 0 auto;height: 40px;display: block;"class="button button-glow button-rounded button-highlight">设置</button>'
						'</form>';
						    
		$("#setParam").click(function(){
			layer.open({
			  type: 1 //Page层类型
			  ,area: ['620px', '420px']
			  ,title: '参数设置'
			  ,shade: 0.6 //遮罩透明度
			  , skin: 'layui-layer-molv'
			  ,anim:2
			  ,maxmin: true //允许全屏最小化
			  ,anim: 1 //0-6的动画形式，-1不开启
			  ,content:form
			});    

		})
		layui.use('form', function(){
  			var form = layui.form;
  		});
	</script>
</body>
</html>
