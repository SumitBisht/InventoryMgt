/*  1:   */ package com.tss.sg.jqgrid;
/*  2:   */ 
/*  3:   */ import java.io.IOException;
/*  4:   */ import java.util.HashMap;
/*  5:   */ import java.util.List;
/*  6:   */ import java.util.Map;
/*  7:   */ import java.util.logging.Level;
/*  8:   */ import java.util.logging.Logger;
/*  9:   */ import org.codehaus.jackson.JsonGenerationException;
/* 10:   */ import org.codehaus.jackson.map.JsonMappingException;
/* 11:   */ import org.codehaus.jackson.map.ObjectMapper;
/* 12:   */ 
/* 13:   */ public class JqGridData
/* 14:   */ {
/* 15:   */   private int total;
/* 16:   */   private String sEcho;
/* 17:   */   private int iTotalRecords;
/* 18:   */   private int iTotalDisplayRecords;
/* 19:   */   private List rows;
/* 20:   */   
/* 21:   */   public JqGridData(String sEcho, int iTotalDisplayRecords, int iTotalRecords, List rows)
/* 22:   */   {
/* 23:46 */     this.iTotalDisplayRecords = iTotalDisplayRecords;
/* 24:47 */     this.sEcho = sEcho;
/* 25:48 */     this.iTotalRecords = iTotalRecords;
/* 26:49 */     this.rows = rows;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public String getJsonString()
/* 30:   */   {
/* 31:70 */     ObjectMapper maper = new ObjectMapper();
/* 32:   */     
/* 33:   */ 
/* 34:73 */     Map<String, Object> map = new HashMap();
/* 35:74 */     map.put("sEcho", this.sEcho);
/* 36:75 */     map.put("iTotalRecords", Integer.valueOf(this.iTotalRecords));
/* 37:76 */     map.put("iTotalDisplayRecords", Integer.valueOf(this.iTotalDisplayRecords));
/* 38:77 */     map.put("aaData", this.rows);
/* 39:78 */     String json = "";
/* 40:   */     try
/* 41:   */     {
/* 42:80 */       json = maper.writeValueAsString(map);
/* 43:   */     }
/* 44:   */     catch (JsonGenerationException ex)
/* 45:   */     {
/* 46:82 */       Logger.getLogger(JqGridData.class.getName()).log(Level.SEVERE, null, ex);
/* 47:   */     }
/* 48:   */     catch (JsonMappingException ex)
/* 49:   */     {
/* 50:84 */       Logger.getLogger(JqGridData.class.getName()).log(Level.SEVERE, null, ex);
/* 51:   */     }
/* 52:   */     catch (IOException ex)
/* 53:   */     {
/* 54:86 */       Logger.getLogger(JqGridData.class.getName()).log(Level.SEVERE, null, ex);
/* 55:   */     }
/* 56:89 */     return json;
/* 57:   */   }
/* 58:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.sg.jqgrid.JqGridData
 * JD-Core Version:    0.7.1
 */