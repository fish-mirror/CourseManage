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


function updateStyle(graduate,classname,num){
	var all_stu = document.getElementById("all_stu");
	var graduated = document.getElementById("graduated");
	var non_graduated = document.getElementById("non_graduated");
	var class_item = document.getElementById("class_item");
	all_stu.className = "";
	graduated.className = "";
	non_graduated.className = "";
	class_item.innerHTML = "";
	if(graduate==1){
		graduated.className = "active";
	}else if(graduate == 0){
		non_graduated.className = "active";
	}else if(classname!=null){
		class_item.innerHTML = classname;
	}else if(num!=null){
		class_item.innerHTML = num;
	}else{
		all_stu.className = "active";
	}
}

