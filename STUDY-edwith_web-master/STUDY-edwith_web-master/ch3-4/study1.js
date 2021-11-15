// setInterval
var interval;

function funcForInterval(){
    interval = setInterval(() => {
        console.log(new Date().toLocaleTimeString());
    }, 1000);
}

funcForInterval();

clearInterval(interval);

// setTimeout
var cnt = 0;

function funcForSetTimeout(){
    console.log(new Date().toLocaleTimeString());
    setTimeout(() => {
        if(cnt < 10){
            funcForSetTimeout();
            cnt++;
        }
    }, 100);
}

funcForSetTimeout();

var cnt2 = 0
while(cnt2 < 1000000000){cnt2++}

//requestAnimaitionFrame
var cnt = 0;

function run(){
    console.log(new Date().toLocaleTimeString());
    setTimeout(() => {
        if(cnt < 10){
            funcForSetTimeout();
            cnt++;
        }
    }, 100);
}

requestAnimationFrame(run);

var cnt2 = 0
while(cnt2 < 1000000000){cnt2++}
