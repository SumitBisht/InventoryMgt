/*  1:   */ package com.tss.ocean.util;
/*  2:   */ 
/*  3:   */ import java.util.ArrayList;
/*  4:   */ import java.util.Collection;
/*  5:   */ import java.util.HashSet;
/*  6:   */ import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/*  7:   */ import org.springframework.security.authentication.AuthenticationProvider;
/*  8:   */ import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
/*  9:   */ import org.springframework.security.core.Authentication;
/* 10:   */ import org.springframework.security.core.AuthenticationException;
/* 11:   */ import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.tss.ocean.pojo.Users;
import com.tss.ocean.service.IUserservice;
/* 12:   */ 
/* 13:   */ public class UserAuthenticationProvider
/* 14:   */   implements AuthenticationProvider
/* 15:   */ {
	
	@Autowired
	IUserservice userService;
	
/* 16:   */   private static final String ROLE_PREFIX = "ROLE_";
/* 17:   */   
/* 18:   */   public Authentication authenticate(Authentication authentication)
/* 19:   */     throws AuthenticationException
/* 20:   */   {
/* 21:28 */    

	 Users u=userService.getRecordByKeyandValue("name", authentication.getName());
	   
	   
		System.out.println("Authenticating............"+authentication.getName()+"_______"+ authentication.getCredentials().toString());
		if (u!=null){
		if(u.getPassword().equals(authentication.getCredentials().toString()))
		{
	     Collection authorities = new ArrayList(buildRolesFromUser(authentication.getName()));
	    authorities.addAll(getActivatedModulesAsRoles());
	    return new UsernamePasswordAuthenticationToken(u.getName(), u.getPassword(), authorities);
		}
		
		else {
			Collection authorities = new ArrayList(buildRolesFromUser(authentication.getName()));
			
			 List activatedModules = new ArrayList();
		    activatedModules.add(new SimpleGrantedAuthority("ROLE_ANONIMOUS"));
		    authorities.addAll(activatedModules);
		    return new UsernamePasswordAuthenticationToken(u.getName(), u.getPassword(), authorities);

		}
		}
		else {
		    return new UsernamePasswordAuthenticationToken(null, null, null);

		}


/* 24:   */   }
/* 25:   */   
/* 26:   */   private Collection getActivatedModulesAsRoles()
/* 27:   */   {
/* 28:37 */     List activatedModules = new ArrayList();
/* 29:38 */     activatedModules.add(new SimpleGrantedAuthority("ROLE_USER"));
/* 30:39 */     return activatedModules;
/* 31:   */   }
/* 32:   */   
/* 33:   */   private Collection buildRolesFromUser(String username)
/* 34:   */   {
/* 35:43 */     Collection authorities = new HashSet();
/* 36:44 */     return authorities;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public boolean supports(Class authentication)
/* 40:   */   {
/* 41:49 */     return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
/* 42:   */   }
/* 43:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.util.UserAuthenticationProvider
 * JD-Core Version:    0.7.1
 */