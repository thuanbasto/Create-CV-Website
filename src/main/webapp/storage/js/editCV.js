const saveAll = document.querySelector(".saveAll");
const popup = document.querySelector(".popup");
const typecv_ID = document.querySelector("#typecv_ID");

popup.setAttribute('style', 'display:none !important');

function changeColor(el){
    midrow.style.backgroundColor = el.value
    typeDisplay2.forEach(li =>{
        li.style.backgroundColor = el.value
    })
}

function changeTypeCV(el){
    if (confirm('Are you sure want to change type of CV? Dont forget to click button SaveAll before change.') === false)
        return ;
}

saveAll.addEventListener("click", () => {
    let data = [];
    document.querySelectorAll(".cardSkill").forEach((cardSkill) =>{
    	let skillName = cardSkill.children[0].children[0].value;
    	if (skillName == "" || skillName == null) return;
        let typeDisplay = cardSkill.children[0].children[1].children[0].value;
        let indexDisplay = cardSkill.classList[2] == 'left'?1:2;;
        let listDetailSkill = cardSkill.children[1].getElementsByTagName("input");
        let detailSkills = [];
        for (let i = 0; i < listDetailSkill.length; i++) {
            let temp = {
                detailSkill : listDetailSkill[i].value
            }
            detailSkills.push(temp);
        }
        let skill = {
            skillName : skillName,
            indexDisplay : indexDisplay,
            typeDisplay: typeDisplay,
            detailSkills : detailSkills
        }
        data.push(skill);
    })

    axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    axios({
        method: 'POST',
        url: '/CV/addSkill',
        data: { "listSkill": data }
    })
    
    let url_cv = '/CV/updateTypeCV/'+typecv_ID.value;
    axios({
        method: 'POST',
        url: url_cv,
        data: {}
    })
    
    popup.setAttribute('style', 'display:inline !important');
    saveAll.disabled = true;
    $('.toast').toast('show');
    setTimeout(() => {
        saveAll.disabled = false;
        popup.setAttribute('style', 'display:none !important'); 
    }, 3000);
})

function addSkill(el){
    var div = document.createElement("div");
    div.innerHTML = 
	"<div class='form-inline'>" +
        "<input class='skillInput form-control' placeholder='Skill. Ex: Language, Technical, Exp'/>" +
        "<div class='form-group m-1'>" +
        	"<select class='form-control typeDisplay'>" +
        		"<option>1</option>" +
        		"<option>2</option>" +
        		"</select>" +
        "</div>" +
        "<button id='deleteSkill' onclick='deleteSkill(this)' class='m-1 btn btn-danger'>X</button>" +
    "</div>" +
    "<ul>" +
        "<li class='form-inline'>" +
            "<input id='detailSkill' class='mt-2 form-control mb-2 mr-sm-2' placeholder='Detail of skill'/>" +
            "<button id='deleteDetailSkill' onclick='deleteDetailSkill(this)' class='btn btn-danger'>X</button>" +
            "<button id='addDetailSkill' onclick='addDetailSkill(this)' class='ml-2 btn btn-success'>+</button>" +
        "</li>" +
    "</ul>";
    div.classList += "cardSkill mb-3"
    if (el.classList.contains("btnAddLeft")){
        div.classList += " left";
    } else {
        div.classList += " right";
    }
    el.parentElement.appendChild(div);
}

function deleteSkill(el){
    el.parentElement.parentElement.remove();
}
function deleteDetailSkill(el){
    var button = document.createElement("button");
    button.classList += "ml-2 btn btn-success";
    button.id = "addDetailSkill";
    button.onclick = function() {addDetailSkill(this)};
    button.innerHTML = "+";

    if (el.parentElement.children.length == 3){
        if (el.parentElement.parentElement.children.length == 1){
            el.parentElement.parentElement.parentElement.remove();
        } else {
            el.parentElement.parentElement.children[el.parentElement.parentElement.children.length-2].appendChild(button);
            el.parentElement.remove();
        }
    } else {
        el.parentElement.remove();
    }
}

function addDetailSkill(el){
    var ul = el.parentElement.parentElement;
    var li = document.createElement("li");
    li.classList += "form-inline" 
    li.innerHTML =
        "<input id='detailSkill' class='mt-2 form-control mb-2 mr-sm-2' placeholder='Detail of skill'/>" +
        "<button id='deleteDetailSkill' onclick='deleteDetailSkill(this)' class='btn btn-danger'>X</button>" + 
        "<button id='addDetailSkill' onclick='addDetailSkill(this)' class='ml-2 btn btn-success'>+</button>";
    ul.appendChild(li);
    el.remove();
}
