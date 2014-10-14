/*   1:    */ package com.tss.ocean.pojo;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ import java.util.Objects;
/*   6:    */ import javax.validation.constraints.DecimalMin;
/*   7:    */ import javax.validation.constraints.Min;
/*   8:    */ import javax.validation.constraints.NotNull;
/*   9:    */ 
/*  10:    */ public class Item
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13:    */   private Integer id;
/*  14:    */   @NotNull
/*  15:    */   private String name;
/*  16:    */   private String alias;
/*  17:    */   private int categoryid;
/*  18:    */   private Itemtype typeid;
/*  19:    */   @DecimalMin(value="0", message="The decimal value can not be less than 0 digit ")
/*  20:    */   private BigDecimal price;
/*  21:    */   private int taxid;
/*  22:    */   @Min(value=0L, message="The minimum stock should be 0")
/*  23:    */   private int currstock;
/*  24:    */   private Itemunit unitid;
/*  25:    */   private String barcode;
/*  26:    */   public int hashCode()
/*  27:    */   {
/*  28: 33 */     int hash = 3;
/*  29: 34 */     hash = 89 * hash + Objects.hashCode(this.id);
/*  30: 35 */     hash = 89 * hash + Objects.hashCode(this.name);
/*  31: 36 */     hash = 89 * hash + Objects.hashCode(this.alias);
/*  32: 37 */     hash = 89 * hash + this.categoryid;
/*  33: 38 */     hash = 89 * hash + Objects.hashCode(this.typeid);
/*  34: 39 */     hash = 89 * hash + Objects.hashCode(this.price);
/*  35: 40 */     hash = 89 * hash + this.taxid;
/*  36: 41 */     hash = 89 * hash + this.currstock;
/*  37: 42 */     hash = 89 * hash + Objects.hashCode(this.unitid);
/*  38: 43 */     return hash;
/*  39:    */   }
/*  40:    */   
/*  41:    */   public boolean equals(Object obj)
/*  42:    */   {
/*  43: 48 */     if (obj == null) {
/*  44: 49 */       return false;
/*  45:    */     }
/*  46: 51 */     if (getClass() != obj.getClass()) {
/*  47: 52 */       return false;
/*  48:    */     }
/*  49: 54 */     Item other = (Item)obj;
/*  50: 55 */     if (!Objects.equals(this.id, other.id)) {
/*  51: 56 */       return false;
/*  52:    */     }
/*  53: 58 */     if (!Objects.equals(this.name, other.name)) {
/*  54: 59 */       return false;
/*  55:    */     }
/*  56: 61 */     if (!Objects.equals(this.alias, other.alias)) {
/*  57: 62 */       return false;
/*  58:    */     }
/*  59: 64 */     if (this.categoryid != other.categoryid) {
/*  60: 65 */       return false;
/*  61:    */     }
/*  62: 67 */     if (!Objects.equals(this.typeid, other.typeid)) {
/*  63: 68 */       return false;
/*  64:    */     }
/*  65: 70 */     if (!Objects.equals(this.price, other.price)) {
/*  66: 71 */       return false;
/*  67:    */     }
/*  68: 73 */     if (this.taxid != other.taxid) {
/*  69: 74 */       return false;
/*  70:    */     }
/*  71: 76 */     if (this.currstock != other.currstock) {
/*  72: 77 */       return false;
/*  73:    */     }
/*  74: 79 */     if (!Objects.equals(this.unitid, other.unitid)) {
/*  75: 80 */       return false;
/*  76:    */     }
/*  77: 82 */     return true;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public Item() {}
/*  81:    */   
/*  82:    */   public Item(String name, String alias, int categoryid, Itemtype typeid, BigDecimal price, int taxid, Itemunit unitid, int currstock)
/*  83:    */   {
/*  84: 89 */     this.name = name;
/*  85: 90 */     this.alias = alias;
/*  86: 91 */     this.categoryid = categoryid;
/*  87: 92 */     this.typeid = typeid;
/*  88: 93 */     this.price = price;
/*  89: 94 */     this.taxid = taxid;
/*  90: 95 */     this.unitid = unitid;
/*  91: 96 */     this.currstock = currstock;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public Integer getId()
/*  95:    */   {
/*  96:100 */     return this.id;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setId(Integer id)
/* 100:    */   {
/* 101:104 */     this.id = id;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public String getName()
/* 105:    */   {
/* 106:108 */     return this.name;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setName(String name)
/* 110:    */   {
/* 111:112 */     this.name = name;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public String getAlias()
/* 115:    */   {
/* 116:116 */     return this.alias;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setAlias(String alias)
/* 120:    */   {
/* 121:120 */     this.alias = alias;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public int getCategoryid()
/* 125:    */   {
/* 126:124 */     return this.categoryid;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public void setCategoryid(int categoryid)
/* 130:    */   {
/* 131:128 */     this.categoryid = categoryid;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public Itemtype getTypeid()
/* 135:    */   {
/* 136:132 */     return this.typeid;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public void setTypeid(Itemtype typeid)
/* 140:    */   {
/* 141:136 */     this.typeid = typeid;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public BigDecimal getPrice()
/* 145:    */   {
/* 146:140 */     return this.price;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public void setPrice(BigDecimal price)
/* 150:    */   {
/* 151:144 */     this.price = price;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public int getTaxid()
/* 155:    */   {
/* 156:148 */     return this.taxid;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public void setTaxid(int taxid)
/* 160:    */   {
/* 161:152 */     this.taxid = taxid;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public Itemunit getUnitid()
/* 165:    */   {
/* 166:156 */     return this.unitid;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void setUnitid(Itemunit unitid)
/* 170:    */   {
/* 171:160 */     this.unitid = unitid;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public int getCurrstock()
/* 175:    */   {
/* 176:164 */     return this.currstock;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public void setCurrstock(int currstock)
/* 180:    */   {
/* 181:168 */     this.currstock = currstock;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public String toString()
/* 185:    */   {
/* 186:173 */     return "Item{id=" + this.id + ", name=" + this.name + ", alias=" + this.alias + ", categoryid=" + this.categoryid + ", typeid=" + this.typeid + ", price=" + this.price + ", taxid=" + this.taxid + ", currstock=" + this.currstock + ", unitid=" + this.unitid + '}';
/* 187:    */   }
/* 188:    */
public String getBarcode() {
	return barcode;
}
public void setBarcode(String barcode) {
	this.barcode = barcode;
} }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Item
 * JD-Core Version:    0.7.1
 */