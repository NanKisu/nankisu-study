// 1) 배열의 함수영 메소드
var data = [{ title: "hello", content: "간지철철", price: 12000 },
{ title: "crong", content: "괜춘한 상품", price: 5500 },
{ title: "codesquad", content: "쩌는상품", price: 1200 }];

for (var i = 0; i < data.length; i++) {
    console.log(data[i]);
}

data.forEach((data, idx) => {
    console.log(data);
});

var newData = data.map((data) => {
    var newData = { ...data, price: data.price * 2 };
    return newData;
});

newData.forEach((data, idx) => {
    console.log(data);
});

var newData2 = newData.filter((data) => {
    return data.price > 10000;
})

console.log(newData2);

var newData3 = data.reduce((depo, cur, idx) => {
    depo[idx] = { ...cur }
    return depo;
}, []);

// 2) 객체 리터럴과 this
var healthObj = {
    name: "달리기",
    lastTime: "PM10:12",
    showHealth: function () {
        console.log(this.name + "님, 오늘은 " + this.lastTime + "에 운동을 하셨네요");
    }
}

healthObj.showHealth();

const obj = {
    getName() {
        return this.name;
    },
    setName(name) {
        this.name = name;
    }
}
obj.setName("crong");
const result = obj.getName();

function get() {
    return this;
}

get(); //window. 함수가 실행될때의 컨텍스트는 window를 참조한다.
new get(); //object. new키워드를 쓰면 새로운 object context가 생성된다.

// 3) bind로 this 제어하기
// Regular Function의 this는 함수를 호출한 객체, 동적으로 정해진다.
// Arrow Function의 this는 함수를 정의한 곳의 상위 스코프에서 상속, 정적으로 정해진다.
var healthObj = {
    name : "달리기",
    lastTime : "PM10:12",
    showHealth : function() {
        console.log(this)
        setTimeout(function(){
            console.log(this);
        }, 500);
    }
}

healthObj.showHealth();

var healthObj = {
    name : "달리기",
    lastTime : "PM10:12",
    showHealth : () => {
        console.log(this)
        setTimeout(function(){
            console.log(this);
        }, 500);
    }
}

healthObj.showHealth();

var healthObj = {
    name : "달리기",
    lastTime : "PM10:12",
    showHealth : function(){
        console.log(this)
        setTimeout(() => {
            console.log(this);
        }, 500);
    }
}

healthObj.showHealth();

var healthObj = {
    name : "달리기",
    lastTime : "PM10:12",
    showHealth : () => {
        console.log(this)
        setTimeout(() => {
            console.log(this)
        }, 500);
    }
}

healthObj.showHealth();