package org.gradle.example.simple.controller;

import java.util.List;

import org.gradle.example.simple.model.Usuario;
import org.gradle.example.simple.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
@Path("/usuario/")
public class UsuarioController {
	
	private Result result;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public UsuarioController(Result result) {
		this.result = result;
	}

	@Get @Path("/")
	public List<Usuario> list() {
		return usuarioService.list();
	}
	
	@Get @Path("/{usuario.id}/edit")
	public Usuario edit(Usuario usuario) {
		return usuarioService.findById(usuario.getId());
	}
	
	@Post @Path("/save")
	public void save(Usuario usuario) {
		usuarioService.save(usuario);
		result.redirectTo(UsuarioController.class).list();
	}
	
	@Get @Path("/new")
	public Usuario novo() {
		return new Usuario();
	}
}
