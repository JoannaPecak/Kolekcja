package pl.sternik.jp.weekend.heloo;

import java.iMyRESTFilter1MyRESTFilter1.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "/MyRESTFilter", 
//servletNames = { "HelloServlet" }, 
urlPatterns = { "/hello" })
public class MyRESTFilter1 implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        
        System.out.println("--------------- aaaaaaa ---------------");
        
        chain.doFilter(req, res);
        
        System.out.println("--------------- bbbbbbb ---------------");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
