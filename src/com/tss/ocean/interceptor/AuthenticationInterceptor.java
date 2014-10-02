/*  1:   */ package com.tss.ocean.interceptor;
/*  2:   */ 
/*  3:   */ import java.util.logging.Level;
/*  4:   */ import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*  7:   */ import org.springframework.web.servlet.HandlerInterceptor;
/*  8:   */ import org.springframework.web.servlet.ModelAndView;
/*  5:   */ 
/*  6:   */ 
/*  9:   */ 
/* 10:   */ public class AuthenticationInterceptor
/* 11:   */   implements HandlerInterceptor
/* 12:   */ {
/* 13:20 */   private static final Logger logger = Logger.getLogger(AuthenticationInterceptor.class.getName());
/* 14:   */   
/* 15:   */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)
/* 16:   */     throws Exception
/* 17:   */   {
/* 18:24 */     logger.log(Level.OFF, "Interceptor: Pre-handle{0}:{1}", new Object[] { request.getRequestURI(), request.getContextPath() });
/* 19:25 */     if ((!request.getRequestURI().equals(request.getContextPath())) && (!request.getRequestURI().equals(request.getContextPath() + "/login.html")))
/* 20:   */     {
/* 21:26 */       boolean allow = request.isUserInRole("ROLE_USER");
/* 22:27 */       if (!allow)
/* 23:   */       {
/* 24:28 */         response.sendRedirect(request.getContextPath() + "/login.html");
/* 25:29 */         return false;
/* 26:   */       }
/* 27:   */     }
/* 28:32 */     return true;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void postHandle(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, ModelAndView mav)
/* 32:   */     throws Exception
/* 33:   */   {
/* 34:37 */     logger.log(Level.CONFIG, "post handle");
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void afterCompletion(HttpServletRequest hsr, HttpServletResponse hsr1, Object o, Exception excptn)
/* 38:   */     throws Exception
/* 39:   */   {
/* 40:42 */     logger.log(Level.CONFIG, "post handle");
/* 41:   */   }
/* 42:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.interceptor.AuthenticationInterceptor
 * JD-Core Version:    0.7.1
 */