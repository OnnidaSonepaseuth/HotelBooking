javascript
function togglePass(){
    let p = document.getElementById("password");
    let icon = document.getElementById("eyeIcon");

    if(p.type === "password"){
        p.type = "text";
        icon.classList.remove("bi-eye");
        icon.classList.add("bi-eye-slash");
    } else {
        p.type = "password";
        icon.classList.remove("bi-eye-slash");
        icon.classList.add("bi-eye");
    }
}
