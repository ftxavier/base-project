package br.eti.ftxavier.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.eti.ftxavier.base.model.Role;
import br.eti.ftxavier.base.model.Usuario;
import br.eti.ftxavier.base.service.RoleService;
import br.eti.ftxavier.base.service.UsuarioService;
import br.eti.ftxavier.base.util.UserSession;

@Resource
@Path("/usuario/")
public class UsuarioController {
	
	private Result result;
	private UserSession userSession;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	
	public UsuarioController(Result result, UserSession userSession) {
		this.result = result;
		this.userSession = userSession;
	}

	@Get @Path("/")
	public List<Usuario> list() {
		return usuarioService.list();
	}
	
	@Get @Path("/{usuario.id}/edit")
	public Usuario edit(Usuario usuario) {
		List<Role> roles = roleService.list();
		usuario = usuarioService.findById(usuario.getId()); 
		roles.removeAll(usuario.getRoles());
		result.include("roles", roles);
		return usuario;
	}
	
	@Post @Path("/save")
	public void save(Usuario usuario) {
		usuarioService.save(usuario);
		result.redirectTo(UsuarioController.class).list();
	}
	
	@Get @Path("/new")
	public Usuario novo() {
		List<Role> roles = roleService.list();
		result.include("roles", roles);
		return new Usuario();
	}
}
