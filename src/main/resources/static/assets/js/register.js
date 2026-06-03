function togglePass(){
    let p = document.getElementById("password");
    let icon = document.getElementById("eyeIcon");

    if(p.type === "password"){
        p.type = "text";
        icon.classList.replace("bi-eye", "bi-eye-slash");
    } else {
        p.type = "password";
        icon.classList.replace("bi-eye-slash", "bi-eye");
    }
}