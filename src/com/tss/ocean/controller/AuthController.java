/*  1:   */ package com.tss.ocean.controller;
/*  2:   */ 
/*  3:   */ import com.tss.ocean.pojo.Users;
/*  4:   */ import java.util.Locale;
/*  5:   */ import java.util.logging.Level;
/*  6:   */ import java.util.logging.Logger;
/*  7:   */ import javax.servlet.http.HttpServletRequest;
/*  8:   */ import javax.servlet.http.HttpSession;
/*  9:   */ import org.springframework.stereotype.Controller;
/* 10:   */ import org.springframework.ui.Model;
/* 11:   */ import org.springframework.web.bind.annotation.RequestMapping;
/* 12:   */ 
/* 13:   */ @Controller
/* 14:   */ public class AuthController
/* 15:   */ {
/* 16:24 */   private static final Logger logger = Logger.getLogger(AuthController.class.getName());
/* 17:   */   
/* 18:   */   @RequestMapping(value={"login.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 19:   */   public String login(Model model, Users loginform, Locale locale, HttpServletRequest request)
/* 20:   */     throws Exception
/* 21:   */   {
/* 22:29 */     String username = loginform.getName();
/* 23:30 */     String password = loginform.getPassword();
/* 24:   */     
/* 25:32 */     logger.log(Level.OFF, "auth called...");
/* 26:34 */     if ((username != null) && (password != null) && (!"".equals(username)) && (!"".equals(password)))
/* 27:   */     {
/* 28:39 */       request.getSession().setAttribute("LOGGEDIN_USER", loginform);
/* 29:   */       
/* 30:   */ 
/* 31:42 */       request.getSession().setAttribute("title", "Management System 1.0");
/* 32:   */       
/* 33:44 */       return "redirect:/";
/* 34:   */     }
/* 35:50 */     return "redirect:/login.html";
/* 36:   */   }
/* 37:   */   
/* 38:   */   @RequestMapping(value={"/login.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 39:   */   public String getlogin()
/* 40:   */     throws Exception
/* 41:   */   {
/* 42:56 */     return "login";
/* 43:   */   }
/* 44:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.controller.AuthController
 * JD-Core Version:    0.7.1
 */