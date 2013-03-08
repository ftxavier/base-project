package org.gradle.example.simple.test.util;

import br.eti.ftxavier.base.model.Usuario;

public class TestUtil {

	public static Usuario getUsuario(String login) {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setNome("Nome");
		usuario.setSenha("senha");
		return usuario;
	}
}
