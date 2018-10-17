package com.lxq.loginFilter;

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
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() { //�û���������Ͽ�������SESSION��ʱ ִ���������
		System.out.println("====����====");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ��������������Ҫ�õ�request,response,session����
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		//session.setAttribute("UserName", "admin");
		String userName = (String) session.getAttribute("UserName");
		// ����û������URI
		String path = servletRequest.getRequestURI();
		if(path.indexOf("/framework/")>-1){
			if("".equals(userName)||"null".equals(userName)||userName==null){
				servletResponse.sendRedirect("/login.jsp");
				return;
			}
			//servletResponse.sendRedirect("/framework/index.jsp");
			//return;
		}
		chain.doFilter(request, response);
	}

	/**
	 *@see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("===��ʼ��===");
	}

}
