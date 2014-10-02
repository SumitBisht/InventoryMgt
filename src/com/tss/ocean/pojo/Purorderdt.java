/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.math.BigDecimal;
/*  5:   */ 
/*  6:   */ public class Purorderdt
/*  7:   */   implements Serializable
/*  8:   */ {
/*  9:   */   private Integer id;
/* 10:   */   private int purorderid;
/* 11:   */   private int itemid;
/* 12:   */   private int qty;
/* 13:   */   private BigDecimal price;
/* 14:   */   
/* 15:   */   public Purorderdt() {}
/* 16:   */   
/* 17:   */   public Purorderdt(int purorderid, int itemid, int qty, BigDecimal price)
/* 18:   */   {
/* 19:23 */     this.purorderid = purorderid;
/* 20:24 */     this.itemid = itemid;
/* 21:25 */     this.qty = qty;
/* 22:26 */     this.price = price;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public Integer getId()
/* 26:   */   {
/* 27:30 */     return this.id;
/* 28:   */   }
/* 29:   */   
/* 30:   */   public void setId(Integer id)
/* 31:   */   {
/* 32:34 */     this.id = id;
/* 33:   */   }
/* 34:   */   
/* 35:   */   public int getPurorderid()
/* 36:   */   {
/* 37:37 */     return this.purorderid;
/* 38:   */   }
/* 39:   */   
/* 40:   */   public void setPurorderid(int purorderid)
/* 41:   */   {
/* 42:41 */     this.purorderid = purorderid;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public int getItemid()
/* 46:   */   {
/* 47:44 */     return this.itemid;
/* 48:   */   }
/* 49:   */   
/* 50:   */   public void setItemid(int itemid)
/* 51:   */   {
/* 52:48 */     this.itemid = itemid;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public int getQty()
/* 56:   */   {
/* 57:51 */     return this.qty;
/* 58:   */   }
/* 59:   */   
/* 60:   */   public void setQty(int qty)
/* 61:   */   {
/* 62:55 */     this.qty = qty;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public BigDecimal getPrice()
/* 66:   */   {
/* 67:58 */     return this.price;
/* 68:   */   }
/* 69:   */   
/* 70:   */   public void setPrice(BigDecimal price)
/* 71:   */   {
/* 72:62 */     this.price = price;
/* 73:   */   }
/* 74:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Purorderdt
 * JD-Core Version:    0.7.1
 */