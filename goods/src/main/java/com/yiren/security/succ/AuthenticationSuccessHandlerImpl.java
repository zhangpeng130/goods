package com.yiren.security.succ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthenticationSuccessHandlerImpl implements
		AuthenticationSuccessHandler {
	private String succUrl;

	public String getSuccUrl() {
		return succUrl;
	}

	public void setSuccUrl(String succUrl) {
		this.succUrl = succUrl;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		request.getRequestDispatcher(succUrl).forward(request, response);

	}
}
