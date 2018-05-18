<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Testando Recurso REST</title>

<script type="text/javascript">

	function escolherMetodo(){
		
		op = document.getElementById("operacao").value;
		des = document.getElementById("tipoOperacao");
		met = document.getElementById("meuForm");
		novoText = document.getElementById("novoNomeAluno");
		
		
		if (op == "consultar"){
			
			met.method = "get";
			des.innerHTML = "consultar(get)";
			novoText.style.display = "none";
			
		}
		else if (op == "criar"){
			met.method = "post";
			des.innerHTML = "criar(post)";
			novoText.style.display = "none";
		}
		else if (op == "alterar"){
			met.method = "put";
			des.innerHTML = "alterar(put)";
			novoText.style.display = "block";
			alert(op);
		}
		if (op == "excluir"){
			met.method = "delete";
			des.innerHTML = "excluir(delete)";
			novoText.style.display = "none";
		}
		
	}

</script>

</head>
<body>

Escolha a opercao: <input type="text" id="operacao" /> <input type="button" value="selecionar" onclick="escolherMetodo();" />

<form action="alunos" method="" id="meuForm">

	<h2>operacao: <p id="tipoOperacao"></p></h2>
	Nome: <input type="text" name="nomeAluno" /><br>
	<p id="novoNomeAluno" style="display:none;"> Novo Nome: <input type="text" name="novoNomeAluno"/></p>
	<input type="submit" value="Enviar"/>

</form>

</body>
</html>