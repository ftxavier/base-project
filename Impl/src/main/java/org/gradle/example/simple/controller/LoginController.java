package org.gradle.example.simple.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class LoginController {
	private Result result;
	
	public LoginController(Result result) {
		this.result = result;
    }

	@Get @Path("/login")
	public void login() {
		
	}
	
	@Get @Path("/login/error")
	public void error() {
		result.include("error", true);
		result.forwardTo(LoginController.class).login();
	}
}
