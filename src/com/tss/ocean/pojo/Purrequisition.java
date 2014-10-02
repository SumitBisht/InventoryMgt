/*   1:    */ package com.tss.ocean.pojo;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ import java.util.ArrayList;
/*   6:    */ import java.util.Date;
/*   7:    */ import java.util.HashSet;
/*   8:    */ import java.util.List;
/*   9:    */ import java.util.Set;
/*  10:    */ import javax.validation.constraints.NotNull;
/*  11:    */ import org.springframework.format.annotation.DateTimeFormat;
/*  12:    */ 
/*  13:    */ public class Purrequisition
/*  14:    */   implements Serializable
/*  15:    */ {
/*  16:    */   private Integer id;
/*  17:    */   private String prno;
/*  18:    */   @NotNull
/*  19:    */   private Integer suplierid;
/*  20:    */   @NotNull
/*  21:    */   private Integer status;
/*  22:    */   private Integer approvedby;
/*  23:    */   private Date approvedbydate;
/*  24:    */   private Integer nextapprovedby;
/*  25:    */   @DateTimeFormat(pattern="dd/MM/yyyy")
/*  26:    */   private Date createdat;
/*  27:    */   @DateTimeFormat(pattern="dd/MM/yyyy")
/*  28:    */   private Date updatedat;
/*  29:    */   private Boolean isbilled;
/*  30:    */   private BigDecimal price;
/*  31:    */   private Integer createdby;
/*  32:    */   private Integer updatedby;
/*  33: 35 */   private Set<Item> items = new HashSet();
/*  34: 36 */   private List<Purrequisitiondt> purrequisitiondts = new ArrayList();
/*  35:    */   
/*  36:    */   public Purrequisition() {}
/*  37:    */   
/*  38:    */   public Purrequisition(Date createdat)
/*  39:    */   {
/*  40: 42 */     this.createdat = createdat;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Purrequisition(String prno, Integer suplierid, Integer status, Integer approvedby, Date approvedbydate, Integer nextapprovedby, Date createdat, Date updatedat, Boolean isbilled, BigDecimal price, Integer createdby, Integer updatedby, Set<Item> items)
/*  44:    */   {
/*  45: 46 */     this.prno = prno;
/*  46: 47 */     this.suplierid = suplierid;
/*  47: 48 */     this.status = status;
/*  48: 49 */     this.approvedby = approvedby;
/*  49: 50 */     this.approvedbydate = approvedbydate;
/*  50: 51 */     this.nextapprovedby = nextapprovedby;
/*  51: 52 */     this.createdat = createdat;
/*  52: 53 */     this.updatedat = updatedat;
/*  53: 54 */     this.isbilled = isbilled;
/*  54: 55 */     this.price = price;
/*  55: 56 */     this.createdby = createdby;
/*  56: 57 */     this.updatedby = updatedby;
/*  57: 58 */     this.items = items;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public Integer getId()
/*  61:    */   {
/*  62: 62 */     return this.id;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setId(Integer id)
/*  66:    */   {
/*  67: 66 */     this.id = id;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getPrno()
/*  71:    */   {
/*  72: 70 */     return this.prno;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setPrno(String prno)
/*  76:    */   {
/*  77: 74 */     this.prno = prno;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public Integer getSuplierid()
/*  81:    */   {
/*  82: 78 */     return this.suplierid;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setSuplierid(Integer suplierid)
/*  86:    */   {
/*  87: 82 */     this.suplierid = suplierid;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public Integer getStatus()
/*  91:    */   {
/*  92: 86 */     return this.status;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setStatus(Integer status)
/*  96:    */   {
/*  97: 90 */     this.status = status;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public Integer getApprovedby()
/* 101:    */   {
/* 102: 94 */     return this.approvedby;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setApprovedby(Integer approvedby)
/* 106:    */   {
/* 107: 98 */     this.approvedby = approvedby;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public Date getApprovedbydate()
/* 111:    */   {
/* 112:102 */     return this.approvedbydate;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setApprovedbydate(Date approvedbydate)
/* 116:    */   {
/* 117:106 */     this.approvedbydate = approvedbydate;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public Integer getNextapprovedby()
/* 121:    */   {
/* 122:110 */     return this.nextapprovedby;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setNextapprovedby(Integer nextapprovedby)
/* 126:    */   {
/* 127:114 */     this.nextapprovedby = nextapprovedby;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public Date getCreatedat()
/* 131:    */   {
/* 132:118 */     return this.createdat;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setCreatedat(Date createdat)
/* 136:    */   {
/* 137:122 */     this.createdat = createdat;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public Date getUpdatedat()
/* 141:    */   {
/* 142:126 */     return this.updatedat;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setUpdatedat(Date updatedat)
/* 146:    */   {
/* 147:130 */     this.updatedat = updatedat;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public Boolean getIsbilled()
/* 151:    */   {
/* 152:134 */     return this.isbilled;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setIsbilled(Boolean isbilled)
/* 156:    */   {
/* 157:138 */     this.isbilled = isbilled;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public BigDecimal getPrice()
/* 161:    */   {
/* 162:142 */     return this.price;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setPrice(BigDecimal price)
/* 166:    */   {
/* 167:146 */     this.price = price;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public Integer getCreatedby()
/* 171:    */   {
/* 172:150 */     return this.createdby;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public void setCreatedby(Integer createdby)
/* 176:    */   {
/* 177:154 */     this.createdby = createdby;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public Integer getUpdatedby()
/* 181:    */   {
/* 182:158 */     return this.updatedby;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public void setUpdatedby(Integer updatedby)
/* 186:    */   {
/* 187:162 */     this.updatedby = updatedby;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public Set<Item> getItems()
/* 191:    */   {
/* 192:166 */     return this.items;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public void setItems(Set<Item> items)
/* 196:    */   {
/* 197:170 */     this.items = items;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public String toString()
/* 201:    */   {
/* 202:175 */     return "Purrequisition{id=" + this.id + ", prno=" + this.prno + ", suplierid=" + this.suplierid + ", status=" + this.status + ", approvedby=" + this.approvedby + ", approvedbydate=" + this.approvedbydate + ", nextapprovedby=" + this.nextapprovedby + ", createdat=" + this.createdat + ", updatedat=" + this.updatedat + ", isbilled=" + this.isbilled + ", price=" + this.price + ", createdby=" + this.createdby + ", updatedby=" + this.updatedby + ", items=" + this.items + '}';
/* 203:    */   }
/* 204:    */   
/* 205:    */   public List<Purrequisitiondt> getPurrequisitiondts()
/* 206:    */   {
/* 207:179 */     return this.purrequisitiondts;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public void setPurrequisitiondts(List<Purrequisitiondt> purrequisitiondts)
/* 211:    */   {
/* 212:183 */     this.purrequisitiondts = purrequisitiondts;
/* 213:    */   }
/* 214:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Purrequisition
 * JD-Core Version:    0.7.1
 */