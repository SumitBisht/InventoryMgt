/*  1:   */ package com.tss.ocean.util;
/*  2:   */ 
/*  3:   */ import java.math.BigInteger;
/*  4:   */ import java.security.SecureRandom;
/*  5:   */ import java.util.Locale;
/*  6:   */ import org.springframework.context.MessageSource;
/*  7:   */ 
/*  8:   */ public class Utilities
/*  9:   */ {
/* 10:16 */   private static final SecureRandom random = new SecureRandom();
/* 11:   */   
/* 12:   */   public static String getSpringMessage(MessageSource messageSource, String key, Locale locale)
/* 13:   */   {
/* 14:19 */     return messageSource.getMessage(key, null, "(DEFAULT TEXT)", locale);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public static String getRandomString(int length)
/* 18:   */   {
/* 19:23 */     return new BigInteger(length, random).toString();
/* 20:   */   }
/* 21:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.util.Utilities
 * JD-Core Version:    0.7.1
 */