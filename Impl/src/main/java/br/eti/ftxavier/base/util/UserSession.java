package br.eti.ftxavier.base.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;
import br.eti.ftxavier.base.model.Usuario;
import br.eti.ftxavier.base.service.UsuarioService;

@Component
@SessionScoped
public class UserSession {

	private Usuario usuario;

	@Autowired
	private UsuarioService usuarioService;

	public Usuario getUsuario() {
		if (usuario == null) {
			User user = (User) SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			if (user != null)
				usuario = usuarioService.getUsuarioByLogin(user.getUsername());
		}
		return usuario;

	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
