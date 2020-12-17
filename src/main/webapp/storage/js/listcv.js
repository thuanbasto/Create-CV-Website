const listCity = document.querySelector(".listCity");
const search = document.querySelector(".search");
const listAge = document.querySelector(".listAge");
const listCareer = document.querySelector(".listCareer");

const stringCity = "An Giang,Bà Rịa - Vũng Tàu,Bắc Giang,Bắc Kạn,Bạc Liêu,Bắc Ninh,Bến Tre,Bình Định,Bình Dương,Bình Phước,Bình Thuận,Cà Mau,Cao Bằng,Đắk Lắk,Đắk Nông,Điện Biên,Đồng Nai,Đồng Tháp,Gia Lai,Hà Giang,Hà Nam,Hà Tĩnh,Hải Dương,Hậu Giang,Hòa Bình,Hưng Yên,Khánh Hòa,Kiên Giang,Kon Tum,Lai Châu,Lâm Đồng,Lạng Sơn,Lào Cai,Long An,Nam Định,Nghệ An,Ninh Bình,Ninh Thuận,Phú Thọ,Quảng Bình,Quảng Nam,Quảng Ngãi,Quảng Ninh,Quảng Trị,Sóc Trăng,Sơn La,Tây Ninh,Thái Bình,Thái Nguyên,Thanh Hóa,Thừa Thiên Huế,Tiền Giang,Trà Vinh,Tuyên Quang,Vĩnh Long,Vĩnh Phúc,Yên Bái,Phú Yên,Cần Thơ,Đà Nẵng,Hải Phòng,Hà Nội,Hồ Chí Minh";
const citys = stringCity.split(",");
citys.forEach(city => {
    let option = document.createElement("option");
    option.value = city;
    option.text = city;
    listCity.add(option);
})

search.addEventListener("click", () => {
	let career = listCareer.value;
	let age = listAge.value;
	let city = listCity.value;
	let url = search.value + "/" + career + "/" + age + "/" + city;
//	let url = search.value + "?career=" + career + "&age=" + age + "&city" + city;
	window.location.href = url;
//    axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
//    axios({
//        method: 'POST',
//        url: url,
//        data: {}
//    }).then(data => {
//    	console.log(data.data);
//    }).catch(error => console.log(error));
    
})