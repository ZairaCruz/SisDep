function valida(){
	if (depreciacao.codigo.value == ""){
		alert("Campos obrigatórios faltando!");
		depreciacao.codigo.focus();
		return false;
	}
}
