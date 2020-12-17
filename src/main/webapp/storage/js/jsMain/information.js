const save = document.querySelector("#save");
const edit = document.querySelector("#edit");
const cancel = document.querySelector("#cancel");
const span = document.querySelectorAll(".span");

save.style.display = "none";
cancel.style.display = "none";

document.querySelector("#name").style.display = "none";
document.querySelector("#birthday").style.display = "none";
document.querySelector("#phone").style.display = "none";
document.querySelector("#address").style.display = "none";
document.querySelector("#email").style.display = "none";
document.querySelector("#username").style.display = "none";
document.querySelector("#facebook").style.display = "none";
document.querySelector("#career").style.display = "none";
document.querySelector("#maxim").style.display = "none";
document.querySelector(".divUploadFile").style.display = "none";

const editDate = () => {
	var birthday = document.querySelector("#birthday");
	birthday.value = birthday.value.replace("-","/");
	birthday.value = birthday.value.replace("-","/");
}
editDate();

edit.addEventListener("click", (event) => {
	edit.style.display = "none";
	cancel.style.display = "block";
	
	document.querySelector("#name").style.display = "block";
	document.querySelector("#birthday").style.display = "block";
	document.querySelector("#phone").style.display = "block";
	document.querySelector("#address").style.display = "block";
	document.querySelector("#email").style.display = "block";
	document.querySelector("#username").style.display = "block";
	document.querySelector("#facebook").style.display = "block";
	document.querySelector("#career").style.display = "block";
	document.querySelector("#maxim").style.display = "block";
	document.querySelector(".divUploadFile").style.display = "block";
	
	span.forEach((item) => {
		item.style.display ="none";
	})
	document.querySelector(".tagfb").style.display = "none";

	save.style.display = "block";
	event.preventDefault();
})

cancel.addEventListener("click", (event) => {
	edit.style.display = "block";
	cancel.style.display = "none";
	
	document.querySelector("#name").style.display = "none";
	document.querySelector("#birthday").style.display = "none";
	document.querySelector("#phone").style.display = "none";
	document.querySelector("#address").style.display = "none";
	document.querySelector("#email").style.display = "none";
	document.querySelector("#username").style.display = "none";
	document.querySelector("#facebook").style.display = "none";
	document.querySelector("#career").style.display = "none";
	document.querySelector("#maxim").style.display = "none";
	document.querySelector(".divUploadFile").style.display = "none";
	
	span.forEach((item) => {
		item.style.display ="block";
	})
	document.querySelector(".tagfb").style.display = "block";
	
	save.style.display = "none";
	event.preventDefault();
})
