// 브라우저에는 기본적으로 window라는 객체가 있다.
// window는 기본 객체이므로 생략할 수 있다.
window.setTimeout();
setTimeout();

// setTimeout();
// setTimeout()의 매게변수로 함수가 들어가는데, 이 함수와 같이
// 즉시 실행되지 않고, 나중에 필요한 시점에 호출되는 할수를 콜백함수라고 한다.
function func1(msg){
    setTimeout(() => {
        console.log(msg);
    }, 3000);
}
func1("Hello");

// Javascript는 싱글스레드로 동작하는 언어로서
// call Stack, background, task queue로 분리된 event loop로 동작한다.

function main(){
    console.log(1);         // 2. console.log 1 실행, call Stack에 들어갔다 사라짐
    setTimeout(() => {      // 3. console.log 2 background에 들어감
        console.log(2);     //    0초 후, task queue로 이동
    }, 0);                  
    console.log(3);         // 4. console.log 3 실행, call Stack에 들어갔다 사라짐
}                           // 5. main함수 call Stack에서 사라짐

main();                     // 1. main함수 실행, call Stack에 들어감
                            // 6. call Stack이 모두 비었으므로 task queue에 있던 console.log 2 실행
                            
// 브라우저에서는 HTML코드를 DOM(Document Object Model)구조로 저장한다
// 그리고 이러한 DOM에 관련된 다양한 DOM API를 제공한다.
document.getElementById();
document.queryCommandValue(); 

// 브라우져에서 일어나는 다양한 동작, 상황을 이벤트라고 하고, 이에 따른 동작을 등록할 수 있다.
var el = document.querySelector(".outside");
el.addEventListener("click", function(){
    console.log("do something..");
}, false);

// 브라우저는 이벤트 리스너를 호출할 때, 사용자로부터 어떤 이벤트가 발생했는지에 
// 대한 정보를 담은 이벤트 객체를 생성해서 리스너 함수에 전달합니다.
el.addEventListener("click", function(e){
    console.log(e.target);
}, false);

// Ajax란 웹에서 비동기 통신을 위한 기술
// json이란 Javascript에서 표준적으로 쓰이는 데이터 포맷
// CORS - Cross Origin Resource Sharing
// Cross-Site Http Request를 가능하게 하는 표준 규약
var oReq = new XMLHttpRequest();
oReq.addEventListener("load", function() {
    console.log(this.responseText);
});    
oReq.open("GET", "https://api.flickr.com/services/rest/?&method=flickr.people.getPublicPhotos&format=json&api_key=API_KEY&user_id=USER_ID");
oReq.send();
