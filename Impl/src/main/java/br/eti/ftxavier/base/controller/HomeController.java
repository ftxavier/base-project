package br.eti.ftxavier.base.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.eti.ftxavier.base.util.UserSession;

@Resource
@Path("/")
public class HomeController {
	
	private UserSession userSession;
	
	public HomeController(UserSession userSession) {
		this.userSession = userSession;
	}

	@Get
	@Path("/")
	public String index() {
		return "Hello " + userSession.getUsuario().getNome();
	}
}
