/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Set;
/*  5:   */ import org.hibernate.validator.constraints.NotEmpty;
/*  6:   */ 
/*  7:   */ public class Itemunit
/*  8:   */   implements Serializable
/*  9:   */ {
/* 10:   */   private Integer id;
/* 11:   */   @NotEmpty
/* 12:   */   private String name;
/* 13:   */   private String description;
/* 14:   */   private Set<Item> itemList;
/* 15:   */   
/* 16:   */   public Itemunit() {}
/* 17:   */   
/* 18:   */   public Itemunit(String name, String description)
/* 19:   */   {
/* 20:23 */     this.name = name;
/* 21:24 */     this.description = description;
/* 22:   */   }
/* 23:   */   
/* 24:   */   public Integer getId()
/* 25:   */   {
/* 26:28 */     return this.id;
/* 27:   */   }
/* 28:   */   
/* 29:   */   public void setId(Integer id)
/* 30:   */   {
/* 31:32 */     this.id = id;
/* 32:   */   }
/* 33:   */   
/* 34:   */   public String getName()
/* 35:   */   {
/* 36:36 */     return this.name;
/* 37:   */   }
/* 38:   */   
/* 39:   */   public void setName(String name)
/* 40:   */   {
/* 41:40 */     this.name = name;
/* 42:   */   }
/* 43:   */   
/* 44:   */   public String getDescription()
/* 45:   */   {
/* 46:44 */     return this.description;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public void setDescription(String description)
/* 50:   */   {
/* 51:48 */     this.description = description;
/* 52:   */   }
/* 53:   */   
/* 54:   */   public Set<Item> getItemList()
/* 55:   */   {
/* 56:52 */     return this.itemList;
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void setItemList(Set<Item> itemList)
/* 60:   */   {
/* 61:56 */     this.itemList = itemList;
/* 62:   */   }
/* 63:   */   
/* 64:   */   public String toString()
/* 65:   */   {
/* 66:61 */     return "Itemunit{id=" + this.id + ", name=" + this.name + ", description=" + this.description + '}';
/* 67:   */   }
/* 68:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Itemunit
 * JD-Core Version:    0.7.1
 */