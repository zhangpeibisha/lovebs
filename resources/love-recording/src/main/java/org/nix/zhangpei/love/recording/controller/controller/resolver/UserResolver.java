package org.nix.zhangpei.love.recording.controller.controller.resolver;

import org.nix.zhangpei.love.recording.service.vo.UserVO;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 方便获取当前用户信息
 * @author zhangpei
 * @version 1.0
 * @date 2018/12/29
 */
public class UserResolver implements HandlerMethodArgumentResolver {

    public static final String USER_SESSION_NAME = "user";

    /**
     * 解析器是否支持当前参数
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        // 指定参数如果被应用MyParam注解，则使用该解析器。
        // 如果直接返回true，则代表将此解析器用于所有参数
        System.err.println("=====================================================");
        System.out.println(methodParameter.getParameterType().getName());
        System.err.println("=====================================================");
        return methodParameter.hasParameterAnnotation(User.class) &&
                methodParameter.getParameterType().getName().equals(UserVO.class.getName());
    }

    /**
     * 将request中的请求参数解析到当前Controller参数上
     * @param methodParameter 需要被解析的Controller参数，此参数必须首先传给{@link #supportsParameter}并返回true
     * @param modelAndViewContainer 当前request的ModelAndViewContainer
     * @param nativeWebRequest 当前request
     * @param webDataBinderFactory 生成{@link WebDataBinderFactory}实例的工厂
     * @return 解析后的Controller参数
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        // 获取用户信息，作用范围为一个会话时间
        Object attribute = nativeWebRequest.getAttribute(USER_SESSION_NAME, RequestAttributes.SCOPE_SESSION);
        if (attribute == null){
            throw new FindParameterFailException(String.format("会话中没有%s参数的value值",USER_SESSION_NAME));
        }
        return attribute;
    }


}
