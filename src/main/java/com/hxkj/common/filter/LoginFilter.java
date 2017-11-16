package com.hxkj.common.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.hxkj.common.constant.Constant;
import com.hxkj.common.util.UrlUtil;


/**
 * 登录拦截器（放置在 Jfinal 拦截器之前的 filter)
 * @author Administrator
 *
 */
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		// 有则返回，无则创建；
		HttpSession session = request.getSession(); 
		
		// 当前路径
		String curUrl = UrlUtil.formatUrl(request.getRequestURI());
		
		//上下文路径
		String contextPath = request.getContextPath();
		req.setAttribute("ctx", contextPath);
		 
		// 不拦截 登陆、静态资源
		if(!curUrl.endsWith("login/index") 
				&&!curUrl.endsWith("login/action") 
				&& !curUrl.startsWith(contextPath+"/res")){
			
			// 未登陆，跳转到登陆界面
			if(session.getAttribute(Constant.SYSTEM_USER)==null){
				response.sendRedirect(request.getContextPath()+"/login/index");
				return; 
			}
			
			// 当前路径为 contextPath 或者 contextPath+"index" 时 跳转到  main
			if(curUrl.equals(contextPath) || curUrl.equals(contextPath+"/index")){
				response.sendRedirect(request.getContextPath()+"/main");
				return; 
			}
		}


		filterChain.doFilter(req, res);
	}


	@Override
	public void destroy() {

	}
}
