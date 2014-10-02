/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ 
/*  5:   */ public class Purrequisitiondt
/*  6:   */   implements Serializable
/*  7:   */ {
/*  8:   */   private Integer id;
/*  9:   */   private int purreqid;
/* 10:   */   private int itemid;
/* 11:   */   private Item item;
/* 12:   */   private int qty;
/* 13:   */   private double price;
/* 14:   */   
/* 15:   */   public Purrequisitiondt() {}
/* 16:   */   
/* 17:   */   public Purrequisitiondt(int purreqid, int itemid, int qty, Item item)
/* 18:   */   {
/* 19:25 */     this.purreqid = purreqid;
/* 20:26 */     this.itemid = itemid;
/* 21:27 */     this.qty = qty;
/* 22:28 */     this.item = item;
/* 23:   */   }
/* 24:   */   
/* 25:   */   public Purrequisitiondt(int purreqid, int itemid, int qty, Item item, double price)
/* 26:   */   {
/* 27:31 */     this.purreqid = purreqid;
/* 28:32 */     this.itemid = itemid;
/* 29:33 */     this.qty = qty;
/* 30:34 */     this.item = item;
/* 31:35 */     this.price = price;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public Integer getId()
/* 35:   */   {
/* 36:39 */     return this.id;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setId(Integer id)
/* 40:   */   {
/* 41:43 */     this.id = id;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public int getPurreqid()
/* 45:   */   {
/* 46:46 */     return this.purreqid;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setPurreqid(int purreqid)
/* 50:   */   {
/* 51:50 */     this.purreqid = purreqid;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public int getItemid()
/* 55:   */   {
/* 56:53 */     return this.itemid;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setItemid(int itemid)
/* 60:   */   {
/* 61:57 */     this.itemid = itemid;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public int getQty()
/* 65:   */   {
/* 66:60 */     return this.qty;
/* 67:   */   }
/* 68:   */   
/* 69:   */   public void setQty(int qty)
/* 70:   */   {
/* 71:64 */     this.qty = qty;
/* 72:   */   }
/* 73:   */   
/* 74:   */   public double getPrice()
/* 75:   */   {
/* 76:67 */     return this.price;
/* 77:   */   }
/* 78:   */   
/* 79:   */   public void setPrice(double price)
/* 80:   */   {
/* 81:71 */     this.price = price;
/* 82:   */   }
/* 83:   */   
/* 84:   */   public Item getItem()
/* 85:   */   {
/* 86:75 */     return this.item;
/* 87:   */   }
/* 88:   */   
/* 89:   */   public void setItem(Item item)
/* 90:   */   {
/* 91:79 */     this.item = item;
/* 92:   */   }
/* 93:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Purrequisitiondt
 * JD-Core Version:    0.7.1
 */