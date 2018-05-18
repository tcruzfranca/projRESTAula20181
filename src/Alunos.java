

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Alunos
 */
@WebServlet("/alunos")
public class Alunos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Alunos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aluno;
		List<String> alunos;
		String mensagem;
		
		aluno = request.getParameter("nomeAluno");
		alunos = (List)request.getServletContext().getAttribute("alunos");
		//mensagem padrao
		mensagem = "aluno "+aluno+" não encontrado. Tente cadastrá-lo.";
		
		if (alunos != null) {
			for (String a : alunos) {
				if (a.equals(aluno)) {
					mensagem = "o aluno "+aluno+" já foi cadastrado";
				}
			}
		}
		else {
			mensagem = "Ainda não há nenhum aluno cadastrado.";
		}
		
		response.getWriter().println("GET:"+mensagem);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String aluno = request.getParameter("nomeAluno");
		
		List<String> alunos;
		
		alunos = (List)request.getServletContext().getAttribute("alunos");
		
		if (alunos == null) {
			alunos = new ArrayList<String>();
			request.getServletContext().setAttribute("alunos", alunos);
		}
		
		alunos.add(aluno);
		
		response.getWriter().println("<h1> aluno "+ aluno +" adicionado </h1>");

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String aluno;
		String alunoNovoNome;
		List<String> alunos;
		String mensagem;
		
		aluno = request.getParameter("nomeAluno");
		alunoNovoNome = request.getParameter("novoNomeAluno");
		alunos = (List)request.getServletContext().getAttribute("alunos");
		//mensagem padrao
		mensagem = "aluno "+aluno+" não encontrado. Tente primeiro cadastrá-lo.";
		
		if (alunos != null) {
			for (String a : alunos) {
				if (a.equals(aluno)) {
					
					mensagem = "o aluno "+aluno+" agora é "+alunoNovoNome;
					aluno = alunoNovoNome;
				}
			}
		}
		else {
			mensagem = "Ainda não há nenhum aluno cadastrado.";
		}
		
		response.getWriter().println("PUT:"+mensagem);		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String aluno;
		List<String> alunos;
		String mensagem;
		
		aluno = request.getParameter("nomeAluno");
		alunos = (List)request.getServletContext().getAttribute("alunos");
		//mensagem padrao
		mensagem = "aluno "+aluno+" não encontrado.";
		
		if (alunos != null) {
			for (String a : alunos) {
				if (a.equals(aluno)) {					
					mensagem = "o aluno "+aluno+" foi removido";
					alunos.remove(aluno);
				}
			}
		}
		else {
			mensagem = "Ainda não há nenhum aluno cadastrado.";
		}
		
		response.getWriter().println("DELETE:"+mensagem);
	
	}

}
