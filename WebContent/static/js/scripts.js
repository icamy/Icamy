// Função para mudar a classe do botão toggle do menu responsivo
function changeToggleState() {
	if (this.className == "toggle") {
		this.className += " toggle-open"
	} else {
		this.className = "toggle"
	}
}
// EventListener atrelado ao botão toggle para executar o callback
// changeToggleState quando o botão for clicado/pressionado.
document.querySelector(".toggle").addEventListener("click", changeToggleState, false);


function changeDisplayStyle() {
	document.querySelector(".modal-container").style.display = "none"
}
document.querySelector(".modal-close-btn").addEventListener("click", changeDisplayStyle, false)

function showModal () {
	document.querySelector(".modal-container").style.display = "flex"
}

for ( i = 0; i < document.querySelectorAll(".modal").length; i++ ) {
	document.querySelectorAll(".modal")[i].addEventListener("click", showModal, false)
}