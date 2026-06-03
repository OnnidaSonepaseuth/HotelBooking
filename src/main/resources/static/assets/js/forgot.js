function toggleOld(){
    let x = document.getElementById("oldPass");
    x.type = x.type === "password" ? "text" : "password";
}

function toggleNew(){
    let x = document.getElementById("newPass");
    x.type = x.type === "password" ? "text" : "password";
}