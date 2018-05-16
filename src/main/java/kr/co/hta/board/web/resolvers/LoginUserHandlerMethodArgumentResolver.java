package kr.co.hta.board.web.resolvers;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import kr.co.hta.board.annotation.LoginUser;
import kr.co.hta.board.vo.User;

@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

	// 매개변수 리졸브를 적용할 수 있는 대상인지 검사하는 역할을 수행
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(LoginUser.class);
	}

	// supportsParameter()의 반환값이 true일때 실행되는 메소드
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		return (User) webRequest.getAttribute("LOGIN_USER", NativeWebRequest.SCOPE_SESSION);
	}

}