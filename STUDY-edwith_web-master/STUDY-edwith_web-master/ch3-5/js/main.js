window.addEventListener("load", ()=>{
    alert("[load] " + document.querySelector("h1"))
});

document.addEventListener("DOMContentLoaded", ()=>{
    alert("[DOMContentLoaded] " + document.querySelector("h1"))
});
