//设置导航中的样式随链接更新
function navStyle(){
	var url = window.location.href;
	var strs = url.split("/");
	var firstID = strs[4];
	var subID = strs[5].substring(0, strs[5].indexOf("."));
	document.getElementById(firstID).className = "active";
	document.getElementById(subID).className = "active";
}

//创建请求对象
function createRequest(){
	try{
		request = new XMLHttpRequest();
	}catch (tryMS){
		try{
			requesr = new ActiveXObject("Msxml2.XMLHTTP");		
		}catch(otherMS){
			try{
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(failed){
				request = null;
			}
		}
	}
	return request;
}


function updateStyle(role){
	var stu = document.getElementById("stu");
	var col = document.getElementById("col");
	stu.className = "";
	col.className = "";
	
	if(role==2){
		stu.className = "active";
	}else{
		col.className = "active";
	}
}

//请求用户信息列表
function getUserList(partId,role,pageSize,page){
	var request = createRequest();
	if(request == null){
		alert("Unable to create request");
	}else{
		if(page == null) var page = 1;
		if(pageSize == null) var pageSize = 20;
		if(role == null) var role = 2;
		var url = "admin/getUserList.action?page="+page+"&pageSize="+pageSize+"&role="+role;
		
		if(partId!=null){
			url=url+"&partId="+partId ;	
		}
		
		updateStyle(role);
		
		request.open("GET", url + "&" + Math.random(), true);
		request.onreadystatechange=function(){
			if(request.readyState == 4){
				if(request.status == 200){
					var userList = document.getElementById("table");
					userList.innerHTML= "";
					var pageDiv = document.getElementById("pageDiv");
					pageDiv.innerHTML = "";
					
					var page = eval("(" + request.responseText + ")");
					var data = page.list;
					var i;
					var len = data.length;
					

					//填充数据
					for(i=0; i<len; i++){
						var item = data[i];
						var line = document.createElement("tr");
						var box1 = document.createElement("td");
						var box2 = document.createElement("td");
						var box3 = document.createElement("td");

						var id = item.username;
						box1.innerHTML = id;
						line.appendChild(box1);
						if(item.role==1){
							box2.innerHTML = "院系";
						}else if(item.role==2){
							box2.innerHTML = "学生";
						}
						line.appendChild(box2);
						box3.innerHTML = "<a href='javascript:resetPwd("+id+");' >重置密码</a>";
						line.appendChild(box3);
						
						userList.appendChild(line);
					}
					//更改页码
					var li_omit = document.createElement("li");
					li_omit.innerHTML = "<a>...</a>";
					var li_first =  document.createElement("li");
					li_first.innerHTML = "<a href='javascript:;' onclick='getUserList("+partId+","+role+","+pageSize+","+"1)'>首页</a>";
					var li_tail =  document.createElement("li");
					li_tail.innerHTML = "<a href='javascript:;' onclick='getUserList("+partId+","+role+","+pageSize+","+page.totalPage+")'>尾页</a>";
					pageDiv.appendChild(li_first);
					//向前翻页
					if(page.currentPage!=1){
						var li_last =  document.createElement("li");
						li_last.innerHTML = "<a href='javascript:;' onclick='getUserList("+partId+","+role+","+pageSize+","+(page.currentPage-1)+")'>&laquo;</a>";
					}
					//中间页码
					if(page!=null){
						//页数>6的输出
						if(page.totalPage>6){
							if(page.currentPage<6){
								for(i = 1; i < 7; i++){
									var li_page = document.createElement("li");
									if(i == page.currentPage){
										li_page.className="active";
									}
									li_page.innerHTML = "<a href='javascript:;' onclick='getUserList("+partId+","+role+","+pageSize+","+i+")'>"+ i +"</a>";
									pageDiv.appendChild(li_page);
								}
								pageDiv.appendChild(li_omit);
							}else if(page.currentPage >(page.totalPage-6)){
								pageDiv.appendChild(li_omit);
								for(i = page.totalPage-6; i <= page.totalPage; i++){
									var li_page = document.createElement("li");
									if(i == page.currentPage){
										li_page.className="active";
									}
									li_page.innerHTML = "<a href='javascript:;' onclick='getUserList("+partId+","+role+","+pageSize+","+i+")'>"+ i +"</a>";
									pageDiv.appendChild(li_page);
								}
							}else{
								pageDiv.appendChild(li_omit);
								for(i = page.currentPage-2; i < page.currentPage+4; i++){
									var li_page = document.createElement("li");
									if(i == page.currentPage){
										li_page.className="active";
									}
									li_page.innerHTML = "<a href='javascript:;' onclick='getUserList("+partId+","+role+","+pageSize+","+i+")'>"+ i +"</a>";
									pageDiv.appendChild(li_page);
								}
								pageDiv.appendChild(li_omit);
							}
						}else{
							for(i = 1; i <= page.totalPage; i++){
								var li_page = document.createElement("li");
								if(i == page.currentPage){
									li_page.className="active";
								}
								li_page.innerHTML = "<a href='javascript:;' onclick='getUserList("+partId+","+role+","+pageSize+","+i+")'>"+ i +"</a>";
								pageDiv.appendChild(li_page);
							}
						}
					}else{
						var li_page = document.createElement("li");
						li_page.className="active";
						li_page.innerHTML = "<a href='javascript:;' onclick='getUserList("+partId+","+role+","+pageSize+","+"1)'>1</a>";
						pageDiv.appendChild(li_page);
					}
					//向后翻页
					if(page.currentPage!=1){
						var li_last =  document.createElement("li");
						li_last.innerHTML = "<a href='javascript:;' onclick='getUserList("+partId+","+role+","+pageSize+","+(page.currentPage+1)+")'>&raquo;</a>";
					}
					pageDiv.appendChild(li_tail);
				}
			}
		};
		request.setRequestHeader("Cache-Control","no-cache")
		request.send(null);
	}
}

//重置用户密码
function resetPwd(id){
	var flag = confirm("是否确认重置该账户密码？");
	if(flag){
		var request = createRequest();
		if(request == null){
			alert("Unable to create request");
		}else{
			var url = "admin/resetUser.action?id="+id;
		};
		request.open("GET", url + "&" + Math.random(), true);
		request.onreadystatechange=function(){
			if(request.readyState == 4){
				if(request.status == 200){
					var result = eval("(" + request.responseText + ")");
					if(result.result = "success"){
						alert("重置成功！");
						window.location.reload();
					}else{
						alert("重置失败！");
					}
				}
			}
		};
		request.setRequestHeader("Cache-Control","no-cache")
		request.send(null);
	}
	
}
