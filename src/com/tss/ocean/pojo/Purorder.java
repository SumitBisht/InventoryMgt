/*   1:    */ package com.tss.ocean.pojo;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ import java.util.Date;
/*   6:    */ import javax.validation.constraints.NotNull;
/*   7:    */ import org.springframework.format.annotation.DateTimeFormat;
/*   8:    */ 
/*   9:    */ public class Purorder
/*  10:    */   implements Serializable
/*  11:    */ {
/*  12:    */   private Integer id;
/*  13:    */   @NotNull
/*  14:    */   private Integer purrequisition;
/*  15:    */   @NotNull
/*  16:    */   private Integer supplier;
/*  17:    */   @DateTimeFormat(pattern="dd/MM/yyyy")
/*  18:    */   @NotNull
/*  19:    */   private Date createdat;
/*  20:    */   @DateTimeFormat(pattern="dd/MM/yyyy")
/*  21:    */   private Date updatedat;
/*  22:    */   private Integer createdby;
/*  23:    */   private BigDecimal price;
/*  24:    */   private Integer updatedby;
/*  25:    */   
/*  26:    */   public Purorder() {}
/*  27:    */   
/*  28:    */   public Purorder(Date createdat)
/*  29:    */   {
/*  30: 35 */     this.createdat = createdat;
/*  31:    */   }
/*  32:    */   
/*  33:    */   public Purorder(Integer purrequisition, Integer supplier, Date createdat, Date updatedat, Integer createdby, BigDecimal price, Integer updatedby)
/*  34:    */   {
/*  35: 38 */     this.purrequisition = purrequisition;
/*  36: 39 */     this.supplier = supplier;
/*  37: 40 */     this.createdat = createdat;
/*  38: 41 */     this.updatedat = updatedat;
/*  39: 42 */     this.createdby = createdby;
/*  40: 43 */     this.price = price;
/*  41: 44 */     this.updatedby = updatedby;
/*  42:    */   }
/*  43:    */   
/*  44:    */   public Integer getId()
/*  45:    */   {
/*  46: 48 */     return this.id;
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void setId(Integer id)
/*  50:    */   {
/*  51: 52 */     this.id = id;
/*  52:    */   }
/*  53:    */   
/*  54:    */   public Integer getPurrequisition()
/*  55:    */   {
/*  56: 55 */     return this.purrequisition;
/*  57:    */   }
/*  58:    */   
/*  59:    */   public void setPurrequisition(Integer purrequisition)
/*  60:    */   {
/*  61: 59 */     this.purrequisition = purrequisition;
/*  62:    */   }
/*  63:    */   
/*  64:    */   public Integer getSupplier()
/*  65:    */   {
/*  66: 62 */     return this.supplier;
/*  67:    */   }
/*  68:    */   
/*  69:    */   public void setSupplier(Integer supplier)
/*  70:    */   {
/*  71: 66 */     this.supplier = supplier;
/*  72:    */   }
/*  73:    */   
/*  74:    */   public Date getCreatedat()
/*  75:    */   {
/*  76: 69 */     return this.createdat;
/*  77:    */   }
/*  78:    */   
/*  79:    */   public void setCreatedat(Date createdat)
/*  80:    */   {
/*  81: 73 */     this.createdat = createdat;
/*  82:    */   }
/*  83:    */   
/*  84:    */   public Date getUpdatedat()
/*  85:    */   {
/*  86: 76 */     return this.updatedat;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public void setUpdatedat(Date updatedat)
/*  90:    */   {
/*  91: 80 */     this.updatedat = updatedat;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public Integer getCreatedby()
/*  95:    */   {
/*  96: 83 */     return this.createdby;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public void setCreatedby(Integer createdby)
/* 100:    */   {
/* 101: 87 */     this.createdby = createdby;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public BigDecimal getPrice()
/* 105:    */   {
/* 106: 90 */     return this.price;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public void setPrice(BigDecimal price)
/* 110:    */   {
/* 111: 94 */     this.price = price;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public Integer getUpdatedby()
/* 115:    */   {
/* 116: 97 */     return this.updatedby;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public void setUpdatedby(Integer updatedby)
/* 120:    */   {
/* 121:101 */     this.updatedby = updatedby;
/* 122:    */   }
/* 123:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Purorder
 * JD-Core Version:    0.7.1
 */