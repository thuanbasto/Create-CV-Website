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

const listCity = document.querySelector(".listCity");

const stringCity = "An Giang,Bà Rịa - Vũng Tàu,Bắc Giang,Bắc Kạn,Bạc Liêu,Bắc Ninh,Bến Tre,Bình Định,Bình Dương,Bình Phước,Bình Thuận,Cà Mau,Cao Bằng,Đắk Lắk,Đắk Nông,Điện Biên,Đồng Nai,Đồng Tháp,Gia Lai,Hà Giang,Hà Nam,Hà Tĩnh,Hải Dương,Hậu Giang,Hòa Bình,Hưng Yên,Khánh Hòa,Kiên Giang,Kon Tum,Lai Châu,Lâm Đồng,Lạng Sơn,Lào Cai,Long An,Nam Định,Nghệ An,Ninh Bình,Ninh Thuận,Phú Thọ,Quảng Bình,Quảng Nam,Quảng Ngãi,Quảng Ninh,Quảng Trị,Sóc Trăng,Sơn La,Tây Ninh,Thái Bình,Thái Nguyên,Thanh Hóa,Thừa Thiên Huế,Tiền Giang,Trà Vinh,Tuyên Quang,Vĩnh Long,Vĩnh Phúc,Yên Bái,Phú Yên,Cần Thơ,Đà Nẵng,Hải Phòng,Hà Nội,Hồ Chí Minh";
const citys = stringCity.split(",");
const itemSelectedOfListCity = listCity.options[listCity.selectedIndex].text;

citys.forEach(city => {
	if (city == itemSelectedOfListCity){
		
	}
	else {
		let option = document.createElement("option");
		option.value = city;
		option.text = city;
		listCity.add(option);
	}
})

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
