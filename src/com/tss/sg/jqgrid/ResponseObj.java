/*  1:   */ package com.tss.sg.jqgrid;
/*  2:   */ 
/*  3:   */ public class ResponseObj
/*  4:   */ {
/*  5:   */   private int status;
/*  6:13 */   private String id = "";
/*  7:   */   private Object message;
/*  8:   */   
/*  9:   */   public int getStatus()
/* 10:   */   {
/* 11:17 */     return this.status;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public void setStatus(int status)
/* 15:   */   {
/* 16:21 */     this.status = status;
/* 17:   */   }
/* 18:   */   
/* 19:   */   public String getId()
/* 20:   */   {
/* 21:25 */     return this.id;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public void setId(String id)
/* 25:   */   {
/* 26:29 */     this.id = id;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public Object getMessage()
/* 30:   */   {
/* 31:33 */     return this.message;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public void setMessage(Object message)
/* 35:   */   {
/* 36:37 */     this.message = message;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public String toString()
/* 40:   */   {
/* 41:42 */     return "{\"status\":" + this.status + ",\"id\":\"" + this.id + "\", \"message\":\"" + this.message + "\"}";
/* 42:   */   }
/* 43:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.sg.jqgrid.ResponseObj
 * JD-Core Version:    0.7.1
 */