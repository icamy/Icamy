
// Função para mudar a classe do botão toggle do menu responsivo
document.querySelector(".toggle").addEventListener("click", changeToggleState, false);
function changeToggleState() {
	if (this.className == "toggle") {
		this.className += " toggle-open"
	} else {
		this.className = "toggle"
	}
}

// ====================================Script modal home=========================================

// EventListener para Abrir modal no botao (Encontre o profissional ideal)

	document.onresize = function() {
		if (document.querySelector(".modal-container-home").classList.contains("_modal-visible")) {
			openModal();
			console.log("Churros");
		}
	}

	document.querySelector(".conteudo-hero span").addEventListener("click", openModal, false)

	function openModal () {
		if (window.matchMedia("(max-width: 960px)").matches) {
			document.querySelector(".modal-container-home").style.display = "flex";
			setTimeout(function() {
				document.querySelector(".modal-content-home").style.opacity = "1";
				//document.querySelector(".modal-content-home").style.width = "90%";
				document.querySelector(".modal-content-home").style.height = "80%";
				document.querySelector(".modal-content-home").style.backgroundColor = "rgba(255,255,255,1)";
			}, 20)
		} else {
			document.querySelector(".modal-container-home").style.display = "flex";
			setTimeout(function() {
				document.querySelector(".modal-content-home").style.opacity = "1";
				//document.querySelector(".modal-content-home").style.width = "30%";
				document.querySelector(".modal-content-home").style.height = "80%";
				document.querySelector(".modal-content-home").style.backgroundColor = "rgba(255,255,255,1)"
			}, 20)
		}
		document.querySelector(".modal-container-home").classList.add("_modal-visible");
	}

// EventListener para Fechar modal no botao (Encontre o profissional ideal)
document.querySelector(".modal-close-btn-home").addEventListener("click", closeModal, false)

function closeModal(){
	document.querySelector(".modal-content-home").style.opacity = "0";
	document.querySelector(".modal-content-home").style.width = "200px";
	document.querySelector(".modal-content-home").style.height = "20%";
	document.querySelector(".modal-content-home").style.backgroundColor = "rgba(0,0,0,0)"
	setTimeout(function() {
		document.querySelector(".modal-container-home").style.display = "none";
	}, 20);
}
