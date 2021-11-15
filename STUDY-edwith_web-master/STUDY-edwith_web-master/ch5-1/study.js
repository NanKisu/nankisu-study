var healthObj = {
    name : "크롱",
    lastTime : "PM10:12",
    showHealth : function(){
        console.log(this.name + "님, 오늘은 " + this.lastTime + "에 운동을 하셨네요!"); 
    }
}

healthObj.showHealth();

////////////////////////////////////////////////////////////////////////////////////////////////////

function Health(name, lastTime){
    this.name = name;
    this.lastTime = lastTime;
    this.showHealth = function(){
        console.log(this.name + "님, 오늘은 " + this.lastTime + "에 운동을 하셨네요!"); 
    }
}

var obj1 = new Health("Crong", "AM 09:00");
var obj2 = new Health("Crong2", "AM 09:00");
obj1.showHealth();
console.log(obj1.showHealth == obj2.showHealth)
console.log(obj1.showHealth === obj2.showHealth)

////////////////////////////////////////////////////////////////////////////////////////////////////

function printMessage(){
    console.log(this.name + "님, 오늘은 " + this.lastTime + "에 운동을 하셨네요!"); 
}

function Health(name, lastTime){
    this.name = name;
    this.lastTime = lastTime;
    this.showHealth = printMessage;
}

var obj1 = new Health("Crong", "AM 09:00");
var obj2 = new Health("Crong2", "AM 09:00");
obj1.showHealth();
console.log(obj1.showHealth == obj2.showHealth)
console.log(obj1.showHealth === obj2.showHealth)

////////////////////////////////////////////////////////////////////////////////////////////////////

function Health(name, lastTime){
    this.name = name;
    this.lastTime = lastTime;
}
Health.prototype.showHealth = function(){
    console.log(this.name + "님, 오늘은 " + this.lastTime + "에 운동을 하셨네요!"); 
}

var obj1 = new Health("Crong", "AM 09:00");
var obj2 = new Health("Crong2", "AM 09:00");
obj1.showHealth();
console.log(obj1.showHealth == obj2.showHealth)
console.log(obj1.showHealth === obj2.showHealth)

