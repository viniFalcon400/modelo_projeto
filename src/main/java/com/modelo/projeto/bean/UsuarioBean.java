package com.modelo.projeto.bean;

import com.modelo.projeto.entity.Usuario;
import com.modelo.projeto.transaction.UsuarioTransaction;
import com.modelo.projeto.util.Transacional;
import com.modelo.projeto.util.Uteis;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vcoelho
 */
@Named(value = "usuarioBean")
@SessionScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioTransaction usuarioTransaction;

	private Usuario usuario = new Usuario();
	private String password;
	private String message, uname;
	private List<Usuario> listaUsuarios;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String loginProject() {
		Usuario usuarioLogin = usuarioTransaction.buscaUsuario(uname, password);
		if (usuarioLogin != null) {
			HttpSession session = Uteis.getSession();
			session.setAttribute("username", uname);
			session.setAttribute("usuarioAutenticado", usuarioLogin);
			return "index";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Inválidos", "Login Inválido"));
			return "login";
		}
	}

	public String logout() {
		HttpSession session = Uteis.getSession();
		session.invalidate();
		return "login";
	}

	public void buscar() {
		usuario = usuarioTransaction.buscar(usuario.getId());
	}

	@Transacional
	public void salvar() throws Exception {
		if (usuario == null || usuario.getId() == null) {
			usuarioTransaction.insert(usuario);
		} else {
			usuarioTransaction.update(usuario);
		}
	}

	@Transacional
	public String remover() {
		usuarioTransaction.remover(usuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario removido com sucesso!"));
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "usuario/usuario-pesquisa?faces-redirect=true";
	}

	public void iniciar() {
		this.listaUsuarios = usuarioTransaction.todos();
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

}
