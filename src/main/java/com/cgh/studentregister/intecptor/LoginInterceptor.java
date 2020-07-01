package com.cgh.studentregister.intecptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录拦截�?
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 获取请求的URL
		Cookie[] cookies = request.getCookies();
		boolean flag = false;
		if(cookies!=null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("admin_name")) {
					if (cookie.getValue().equals("admin")) {
						flag = true;
					}
				}
			}
		}else{

			request.setAttribute("msg", "您还没有登录，请先登录！");
			response.sendRedirect("http://localhost:8080/login");
			return flag;
		}
		if (flag == true) {
			return true;
		}
		// 不符合条件的给出提示信息，并转发到登录页�?
		request.setAttribute("msg", "您还没有登录，请先登录！");
		request.getRequestDispatcher("/login").forward(request, response);
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
