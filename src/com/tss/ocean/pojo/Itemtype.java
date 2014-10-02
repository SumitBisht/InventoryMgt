/*  1:   */ package com.tss.ocean.pojo;
/*  2:   */ 
/*  3:   */ import java.io.Serializable;
/*  4:   */ import java.util.Set;
/*  5:   */ import javax.validation.constraints.Size;
/*  6:   */ import org.hibernate.validator.constraints.NotEmpty;
/*  7:   */ 
/*  8:   */ public class Itemtype
/*  9:   */   implements Serializable
/* 10:   */ {
/* 11:   */   private Integer id;
/* 12:   */   @NotEmpty(message="Please enter item name.")
/* 13:   */   @Size(min=1, max=45, message="Item name must between 1 and 45 characters")
/* 14:   */   private String name;
/* 15:   */   @Size(min=0, max=65535, message="Item description must between 0 and 65535 characters")
/* 16:   */   private String description;
/* 17:   */   private Set<Item> itemList;
/* 18:   */   
/* 19:   */   public Itemtype() {}
/* 20:   */   
/* 21:   */   public Itemtype(String name, String description)
/* 22:   */   {
/* 23:30 */     this.name = name;
/* 24:31 */     this.description = description;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public Integer getId()
/* 28:   */   {
/* 29:35 */     return this.id;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void setId(Integer id)
/* 33:   */   {
/* 34:39 */     this.id = id;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public String getName()
/* 38:   */   {
/* 39:43 */     return this.name;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public void setName(String name)
/* 43:   */   {
/* 44:47 */     this.name = name;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public String getDescription()
/* 48:   */   {
/* 49:51 */     return this.description;
/* 50:   */   }
/* 51:   */   
/* 52:   */   public void setDescription(String description)
/* 53:   */   {
/* 54:55 */     this.description = description;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public Set<Item> getItemList()
/* 58:   */   {
/* 59:59 */     return this.itemList;
/* 60:   */   }
/* 61:   */   
/* 62:   */   public void setItemList(Set<Item> itemList)
/* 63:   */   {
/* 64:63 */     this.itemList = itemList;
/* 65:   */   }
/* 66:   */   
/* 67:   */   public String toString()
/* 68:   */   {
/* 69:68 */     return "Itemtype{id=" + this.id + ", name=" + this.name + ", description=" + this.description + '}';
/* 70:   */   }
/* 71:   */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Itemtype
 * JD-Core Version:    0.7.1
 */