package kr.co.hta.board.web.interceptors;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterCeptor implements HandlerInterceptor {

	private Set<String> urls;
	
	public void setUrls(Set<String> urls) {
		this.urls = urls;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("LOGIN_USER") != null) {
			return true;
		}
		
		if(urls.contains(request.getRequestURI())) {
			return true;
		}
		
		response.sendRedirect("/user/login.do?err=deny");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}