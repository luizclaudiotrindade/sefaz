package br.com.sefaz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.sefaz.model.Usuario;
import br.com.sefaz.model.UsuarioDao;

@Controller
public class SistemaController {
	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Usuario usuario, HttpSession session, Model model) {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuarioLogado = dao.autenticar(usuario);
		if (usuarioLogado != null) {
			session.setAttribute("usuarioLogado", usuarioLogado);
			return "usuario/areaUsuario";
		}
		model.addAttribute("msg", "Não foi encontrado nenhum com o login e senha informados.");
		return "index";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}

	@RequestMapping("/usuario/cadastro")
	public String adicionarUsuario() {
		return "usuario/incluirUsuario";

	}

	@RequestMapping("/usuario/save")
	public String save(Usuario usuario, HttpSession session) {

		UsuarioDao dao = new UsuarioDao();
		if (dao.verificarExistencia(usuario)) {
			session.setAttribute("usuarioEncontrado", "Usuario já cadastrado no sistema, Tente novamente");
			return "usuario/incluirUsuario";
		}
		dao.salvar(usuario);
		return "usuario/usuarioCadastrado";
	}

	@RequestMapping("/usuario/list")
	public String listarUsuario(Model model) {
		UsuarioDao dao = new UsuarioDao();
		List<Usuario> listaUsuario = dao.listar(null);
		model.addAttribute("listaUsuario", listaUsuario);
		model.addAttribute("mensagem", "Usuarios Listados Com Sucesso");
		return "usuario/listarUsuario";
	}

	@RequestMapping("/usuario/filter")
	public String filtrarUsuario(Usuario usuario, Model model) {
		UsuarioDao dao = new UsuarioDao();
		List<Usuario> listaUsuario = dao.listar(usuario);
		model.addAttribute("listaUsuario", listaUsuario);
		return "usuario/listarUsuario";
	}

	@RequestMapping("/usuario/edit")
	public String edit(@RequestParam("id") Integer id, Model model) {
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.buscarPorId(id);
		model.addAttribute("usuario", usuario);
		return "usuario/alterarUsuario";
	}

	@RequestMapping("/usuario/update")
	public String update(Usuario usuario, Model model) {
		UsuarioDao dao = new UsuarioDao();
		dao.alterar(usuario);
		model.addAttribute("mensagem", "Usuario Alterado com Sucesso !");
		return "forward:list";
	}

	@RequestMapping("/usuario/delete")
	public String delete(@RequestParam("id") Integer id, Model model) {
		UsuarioDao dao = new UsuarioDao();
		dao.remover(id);
		model.addAttribute("mensagem", "Usuario Removido com Sucesso");
		return "forward:list";
	}

	@RequestMapping("usuario/footer")
	public String footer() {
		return "usuario/footer";
	}

}
