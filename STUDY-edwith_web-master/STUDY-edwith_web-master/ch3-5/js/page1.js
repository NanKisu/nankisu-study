var names = [
    {name: "Nan Kisu"},
    {name: "Hong Gildong"},
    {name: "Hong Wonpyo"}
]

document.addEventListener("DOMContentLoaded", ()=>{
    var namesUl = document.querySelector("#names");
    names.forEach((name) => {
        var nameLi = "<li>My name is <span>" + name.name + "</span></li>"
        namesUl.innerHTML += nameLi;
    });
});

document.querySelector("ul").addEventListener("click", (e)=>{
    var target = e.target;
    if(target.tagName == "LI"){
        target = target.querySelector("span");
    }
    if(target.tagName == "span"){
        alert(target.innerText);
    }
});