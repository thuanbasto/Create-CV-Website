const password = document.querySelector("#password");
const confirmPassword = document.querySelector("#confirmPassword");
const passwordErrorMatch = document.querySelector("#passwordErrorMatch");
const passwordErrors = document.querySelector("#password\\.errors")

const username = document.querySelector("#username");
const usernameErrors = document.querySelector("#username\\.errors");
const usernameErrorLength = document.querySelector("#usernameErrorLength");
const usernameErrorRegex = document.querySelector("#usernameErrorRegex");

const submit = document.querySelector("#submit");

submit.disabled = true;
usernameErrorLength.style.display = "none";
usernameErrorRegex.style.display = "none";
passwordErrorMatch.style.display = "none";
password.value = "";
confirmPassword.value = "";

const enableSubmit = () => {
	if (usernameErrorLength.style.display == "none" 
		&& usernameErrorRegex.style.display == "none" 
			&& passwordErrorMatch.style.display == "none"){
		submit.disabled = false;
	} else {
		submit.disabled = true;
	}
}

username.addEventListener("keyup", () => {
	if (usernameErrors != null)
		usernameErrors.style.display = "none";
	
    var nameRegex = /^[a-zA-Z0-9\-]+$/;
    var validUsername = nameRegex.test(username.value);
    
    if (validUsername === false){
        usernameErrorRegex.style.display = "block";
    } else {
        usernameErrorRegex.style.display = "none";
    }
    if (username.value.length < 6){
        usernameErrorLength.style.display = "block";
    } else {
        usernameErrorLength.style.display = "none";
    }
    
    enableSubmit();
})
password.addEventListener("keyup", () => {
	if (passwordErrors != null)
		passwordErrors.style.display = "none";
    
    if (confirmPassword.value !== password.value && confirmPassword.value !== ""){
    	passwordErrorMatch.style.display = "block";
    } else {
    	passwordErrorMatch.style.display = "none";
    }
    
    enableSubmit();
})
confirmPassword.addEventListener("keyup", () => {
	if (passwordErrors != null)
		passwordErrors.style.display = "none";
	
    if (confirmPassword.value !== password.value){
    	passwordErrorMatch.style.display = "block";
    } else {
    	passwordErrorMatch.style.display = "none";
    }
    
    enableSubmit();
})

