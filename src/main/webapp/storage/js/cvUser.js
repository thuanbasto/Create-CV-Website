const like = document.querySelector(".like");
const btnLike = document.querySelector(".btnLike");
const checkLike = document.getElementById("checkLike").value
const user_ID = document.getElementById("user_ID").value;

let data = {
	from_user_ID : 0,
	to_user_ID : user_ID
}

if(checkLike === "true"){
	btnLike.innerHTML = "Dislike"
	btnLike.classList.remove("btn-primary")
	btnLike.classList += " btn-danger";
}
	

function likeCV(el){
	if (el.innerHTML === "Like"){
        el.innerHTML = "Dislike"
        el.classList.remove("btn-primary");
        el.classList += " btn-danger";
        like.children[0].textContent =  parseInt(like.children[0].textContent) + 1;
        
        axios.post('/CV/like', data)
        .then(res => {
        	return res;
        });
        
    } else {
        el.innerHTML = "Like"
        el.classList.remove("btn-danger");
        el.classList += " btn-primary";
        like.children[0].textContent =  parseInt(like.children[0].textContent) - 1;
        
        axios.post('/CV/dislike', data)
        .then(res => {
        	return res;
        });
    }
}


