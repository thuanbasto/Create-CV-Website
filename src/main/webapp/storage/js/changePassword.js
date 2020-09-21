const newPassword = document.querySelector("#newPassword");
const confirmNewPassword = document.querySelector("#confirmNewPassword");
const passwordErrorMatch = document.querySelector("#passwordErrorMatch");
const msg = document.querySelector(".msg");
const submit = document.querySelector("#submit");

submit.disabled = true;
passwordErrorMatch.style.display = "none";
newPassword.value = "";
confirmNewPassword.value = "";

if (window.location.href.includes("success")){
    msg.innerHTML = "Change password success.";
} else if (window.location.href.includes("failed")){
    msg.classList.remove("text-success");
    msg.classList += " text-danger";
    msg.innerHTML = "Change password failed.";
}

const enableSubmit = () => {
	if (passwordErrorMatch.style.display == "none"){
		submit.disabled = false;
	} else {
		submit.disabled = true;
	}
}

newPassword.addEventListener("keyup", () => {
	msg.innerHTML = "";
	
    if (newPassword.value !== confirmNewPassword.value && confirmNewPassword.value !== ""){
    	passwordErrorMatch.style.display = "block";
    } else {
    	passwordErrorMatch.style.display = "none";
    }
    
    enableSubmit();
})
confirmNewPassword.addEventListener("keyup", () => {
	msg.innerHTML = "";
	
    if (confirmNewPassword.value !== newPassword.value){
    	passwordErrorMatch.style.display = "block";
    } else {
    	passwordErrorMatch.style.display = "none";
    }
    
    enableSubmit();
})