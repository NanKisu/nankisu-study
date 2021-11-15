document.addEventListener("DOMContentLoaded", () => {
	var request = new XMLHttpRequest();
	request.addEventListener("load", () => {
		var response = JSON.parse(request.responseText);
		document.querySelector("#tabUi-list").innerHTML = "";
		response.lists.forEach((list)=>{
			document.querySelector("#tabUi-list").innerHTML += TabUiListLi(list);
		});
		document.querySelector("#tabUi-list li").id = "selected";
		
		var request2 = new XMLHttpRequest();
		request2.addEventListener("load", () => {
			var response2 = JSON.parse(request2.responseText);
			document.querySelector("#tabUi-content").innerHTML = "";
			response2.men.forEach((man)=>{
				document.querySelector("#tabUi-content").innerHTML += TabUiContentSpan(man)
			});
		});
		request2.open("GET", "./data/SDS.data");
		request2.send();
	});
	request.open("GET", "./data/tabUi-lists.data");
	request.send();
	
	document.querySelector("#tabUi-list").addEventListener("click", function(e) {
		if(e.target.tagName == "LI"){
			document.querySelector("#selected").id = "";
			e.target.id = "selected";
			var request = new XMLHttpRequest();
			request.addEventListener("load", () => {
				var response = JSON.parse(request.responseText);
				document.querySelector("#tabUi-content").innerHTML = "";
				response.men.forEach((man)=>{
					document.querySelector("#tabUi-content").innerHTML += TabUiContentSpan(man)
				});
			});
			request.open("GET", "./data/"+e.target.getAttribute("name")+".data");
			request.send();
		}
	});
});

