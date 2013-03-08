package org.gradle.example.simple.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
@Path("/")
public class HomeController {
	
	@Get @Path("/")
	public String index() {
		return "Home";
	}
}
