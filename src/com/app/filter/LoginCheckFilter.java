package com.app.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	private List<String> uriList=null;
	
	@Override
	public void init(FilterConfig fc) throws ServletException {
		String uriStr=fc.getInitParameter("noCheckURI");
		StringTokenizer st=new StringTokenizer(uriStr,",");
		uriList=new ArrayList<String>();
		while(st.hasMoreElements()){
			String uri=st.nextToken();
			uriList.add(uri);
		}
		System.out.println(uriList);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		try{
			HttpServletRequest req=(HttpServletRequest)request;
			HttpServletResponse res=(HttpServletResponse)response;
			//clear cache on logout
			res.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
			res.setHeader("Pragma","no-cache");
			res.setDateHeader("Expires", 0);
			
			String reqUri=req.getRequestURI();
			boolean flag=uriList.contains(reqUri);
			//if not in list do session checking
			if(!flag){
				//read current session
				HttpSession session=req.getSession(false);
				if(session==null || session.getAttribute("username")==null){
					res.sendRedirect(req.getContextPath()+"/mvc/login");
				}
			}
			fc.doFilter(request, response);
		} catch(Exception e){
			e.printStackTrace();
		}
		//continue if url exists in the list
	}
	@Override
	public void destroy() {
		uriList=null;
	}
}
