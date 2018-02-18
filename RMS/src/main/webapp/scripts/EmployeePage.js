document.getElementById("request").addEventListener("click", function(){
    document.getElementById("updateForm").setAttribute("style", "display: none");
    document.getElementById("requestForm").setAttribute("style", "display: inline");
});

document.getElementById("update").addEventListener("click", function(){
    document.getElementById("requestForm").setAttribute("style", "display: none");
    document.getElementById("updateForm").setAttribute("style", "display: inline");
});


