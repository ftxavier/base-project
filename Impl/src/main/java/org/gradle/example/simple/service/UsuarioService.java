package org.gradle.example.simple.service;

import java.util.List;

import org.gradle.example.simple.dao.UsuarioDao;
import org.gradle.example.simple.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Transactional
	public Usuario getUsuarioByLogin(String login) {
		return usuarioDao.findByLogin(login);
	}
	
	@Transactional
	public List<Usuario> list() {
		return usuarioDao.findAll();
	}
	
	@Transactional
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	public Usuario findById(Long identifier) {
		return usuarioDao.findById(identifier);
	}
}
