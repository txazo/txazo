package org.txazo.java.pattern.behavior.chain.tomcat.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws Exception {
        System.out.println("CharacterFilter doFilter before");
        chain.doFilter(request, response);
        System.out.println("CharacterFilter doFilter after");
    }

}
