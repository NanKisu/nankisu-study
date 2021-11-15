// 변수는 var, let, const로 선언할 수 있다.
// var은 변수의 유효 범위가 함수, let과 const는 괄호이다.
// const는 한번 값을 초기화하면 변경 할 수 없다.
var a = 2;
var a = "aaa";
var a = 'aaa';
var a = true;
var a = [];
var a = {};
var a = undefined;
a + 1;

// 연산자
// or 연산자 활용
var name;
var msg = "welcome " + (name || "geust");
console.log(msg)

// 삼항연사자
var data = 11;
const result = (data > 10) ? "bigger" : "small";
console.log(result)

// 비교연산자 ==(묵시적 타입변환 일어남)와 ===(타입비교) 
0 == false;
"" == false;
null == false;
0 == "0"
null == undefined
null && true

// 자바스크립트의 타입은 실행중에 결정된다.
// 타입을 체크하는 확실한 방법은 없지만, 보통 toString.call()을 
// 사용한다.

// 조건문 if
if(true){
    console.log(true);
}
else{
    console.log(false);
}

// 조건문 switch, case의 조건과 값을 비교할 때 === 연산자를 
// 사용하는거 같다.
var num = "1"
switch(num){
    case 1:
        console.log("1");
        break;
    case 2:
        console.log("2");
        break;
    case 3:
        console.log("3");
        break;
    case 4:
        console.log("4");
        break;
    default:
        console.log("default");
        break;
}

var arr = [1,2,3]
for (var i = 0; i < arr.length; i++) {
    console.log(arr[i]);
}
arr.forEach((val, idx, arr) => {
    console.log(val);
    console.log(idx);
    console.log(arr);
});

// 문자열 처리
"ab:cd".split(":"); 
"ab:cd".replace(":", "$"); 
" abcde  ".trim();  

// 함수
function func1(a, b, c){
    return a + b + c;
}

// 인자 개수와 상관없이 호출 가능
console.log(func1(1));
console.log(func1(1,2));
console.log(func1(1,2,3));
console.log(func1(1,2,3,4));

// 함수 표현식
function func2(){
    var inner = function () {
        return "inner";
    }
    var result = inner();
    return result;
}

console.log(func2());

// 함수 표현식2, 이렇게 된다면? 타입에러가 난다?!
function func2(){
    var result = inner();
    var inner = function () {
        return "inner";
    }
    return result;
}

console.log(func2());

// 변수 호이스팅(hoisting)
// 자바스크립트 함수는 실행되기 전에 함수 안에 필요한 변수값들을 
// 미리 다 모아서 선언합니다.

// 함수의 기본 반환 값은 undefined
function func3(){}
console.log(func3());

// 함수의 arguments
function func4(){
    console.log(arguments);
}
func4();
func4(1,"2");
func4(1,2,3,4,5,6);
