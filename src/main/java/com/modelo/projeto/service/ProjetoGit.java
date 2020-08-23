/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.projeto.service;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author vcoelho
 */
@Path("projeto")
public class ProjetoGit {

	@Context
	private UriInfo context;

	/**
	 * Creates a new instance of ProjetoGit
	 */
	public ProjetoGit() {
	}

	/**
	 * Retrieves representation of an instance of com.modelo.projeto.service.ProjetoGit
	 * @return an instance of java.lang.String
	 */
	@GET
    @Produces(MediaType.TEXT_HTML)
	public String getJson() {
		return "<a href=\"https://github.com/viniFalcon400/modelo_projeto\">Cliqui aqui para acesso o Projeto no Git</a>";
	}

}
