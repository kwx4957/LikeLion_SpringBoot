package dev.projectlion.demo.week7.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;

@Component
public class HeaderLoggingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("start processiong of {}",handlerMethod.getMethod().getName());
        Enumeration<String> headNames = request.getHeaderNames();
        while (headNames.hasMoreElements()){
            String headerName = headNames.nextElement();
            logger.info("{}: {}", headerName , request.getHeader(headerName));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Collection<String> headrNames = response.getHeaderNames();
        for(String headName: headrNames){
            logger.info("{}: {}", headName , request.getHeader(headName));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        logger.info("start processiong of {}",handlerMethod.getMethod().getName());
        if( ex != null) logger.error("exception occuer",ex);
    }

    private static final Logger logger = LoggerFactory.getLogger(HandlerInterceptor.class);


}
