
// Função para mudar a classe do botão toggle do menu responsivo
document.querySelector(".toggle").addEventListener("click", changeToggleState, false);
function changeToggleState() {
	if (this.className == "toggle") {
		this.className += " toggle-open"
	} else {
		this.className = "toggle"
	}
}

// ====================================Script modal Pefil======================================	

// EventListener atrelado ao botão toggle para executar o callback
// changeToggleState quando o botão for clicado/pressionado.


document.querySelector(".modal-close-btn").addEventListener("click", changeDisplayStyle, false)
function changeDisplayStyle() {

	document.querySelector(".modal-content").style.transition = "0.2s";
	document.querySelector(".modal-content").style.width = "200px";
	document.querySelector(".modal-content").style.height = "20%";
	document.querySelector(".modal-content").style.backgroundColor = "rgba(0,0,0,0)"

	setTimeout(function() {
		document.querySelector(".modal-container").style.display = "none"
	}, 200);

	
}


for ( i = 0; i < document.querySelectorAll(".modal").length; i++ ) {
	document.querySelectorAll(".modal")[i].addEventListener("click", showModal, false)
}


function showModal () {
	document.querySelector(".modal-container").style.display = "flex"
	setTimeout(function() {
		document.querySelector(".modal-content").style.transition = "0.2s";
		document.querySelector(".modal-content").style.width = "980px";
		document.querySelector(".modal-content").style.height = "80%";
		document.querySelector(".modal-content").style.backgroundColor = "rgba(255,255,255,1)"

	}, 10);


}

