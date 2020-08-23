package com.modelo.projeto.filters;

import com.modelo.projeto.entity.Usuario;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vcoelho
 */
@WebFilter("*")
public class AutenticacaoFilter implements Filter {

	public AutenticacaoFilter() {
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpSession httpSession = ((HttpServletRequest) request).getSession();
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		System.out.println("&&&&&&&&&&&&&&&:" + httpServletRequest.getRequestURI());
		if (!httpServletRequest.getRequestURI().contains("login.xhtml") && !httpServletRequest.getRequestURI().contains("/rest") && !httpServletRequest.getRequestURI().contains("/imagens")) {
			Usuario usuarioModel = (Usuario) httpSession.getAttribute("usuarioAutenticado");
			if (usuarioModel == null ) {
				httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.xhtml");
			} else {
				chain.doFilter(request, response);
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

}
