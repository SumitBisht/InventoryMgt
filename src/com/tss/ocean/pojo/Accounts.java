/*   1:    */ package com.tss.ocean.pojo;
/*   2:    */ 
/*   3:    */ import java.io.Serializable;
/*   4:    */ import java.math.BigDecimal;
/*   5:    */ import javax.validation.constraints.NotNull;
/*   6:    */ import javax.validation.constraints.Size;
/*   7:    */ import org.hibernate.validator.constraints.Email;
/*   8:    */ import org.hibernate.validator.constraints.NotEmpty;
/*   9:    */ 
/*  10:    */ public class Accounts
/*  11:    */   implements Serializable
/*  12:    */ {
/*  13:    */   private Integer id;
/*  14:    */   @NotEmpty
/*  15:    */   @Size(min=1, max=45)
/*  16:    */   private String name;
/*  17:    */   @NotNull
/*  18:    */   private Integer type;
/*  19:    */   @NotEmpty
/*  20:    */   @Size(min=1, max=100)
/*  21:    */   private String address;
/*  22:    */   @NotEmpty
/*  23:    */   @Size(min=1, max=100)
/*  24:    */   private String address2;
/*  25:    */   @NotEmpty
/*  26:    */   @Size(min=1, max=45)
/*  27:    */   private String postal;
/*  28:    */   @NotEmpty
/*  29:    */   @Size(min=1, max=45)
/*  30:    */   private String city;
/*  31:    */   @NotEmpty
/*  32:    */   @Size(min=1, max=45)
/*  33:    */   private String state;
/*  34:    */   @NotEmpty
/*  35:    */   @Size(min=1, max=45)
/*  36:    */   private String country;
/*  37:    */   @NotEmpty
/*  38:    */   @Size(min=1, max=45)
/*  39:    */   private String firstname;
/*  40:    */   @NotEmpty
/*  41:    */   @Size(min=1, max=45)
/*  42:    */   private String lastname;
/*  43:    */   @NotEmpty
/*  44:    */   @Size(min=1, max=100)
/*  45:    */   @Email
/*  46:    */   private String email;
/*  47:    */   @NotEmpty
/*  48:    */   @Size(min=1, max=45)
/*  49:    */   private String phone;
/*  50:    */   private String phone2;
/*  51:    */   private String fax;
/*  52:    */   private String notes;
/*  53:    */   private Boolean visible;
/*  54:    */   private BigDecimal maxdebt;
/*  55:    */   private BigDecimal curdebt;
/*  56:    */   private byte[] image;
/*  57:    */   
/*  58:    */   public Accounts() {}
/*  59:    */   
/*  60:    */   public Accounts(String name, Integer type)
/*  61:    */   {
/*  62: 66 */     this.name = name;
/*  63: 67 */     this.type = type;
/*  64:    */   }
/*  65:    */   
/*  66:    */   public Accounts(String name, Integer type, String address, String address2, String postal, String city, String state, String country, String firstname, String lastname, String email, String phone, String phone2, String fax, String notes, Boolean visible, BigDecimal maxdebt, BigDecimal curdebt, byte[] image)
/*  67:    */   {
/*  68: 70 */     this.name = name;
/*  69: 71 */     this.type = type;
/*  70: 72 */     this.address = address;
/*  71: 73 */     this.address2 = address2;
/*  72: 74 */     this.postal = postal;
/*  73: 75 */     this.city = city;
/*  74: 76 */     this.state = state;
/*  75: 77 */     this.country = country;
/*  76: 78 */     this.firstname = firstname;
/*  77: 79 */     this.lastname = lastname;
/*  78: 80 */     this.email = email;
/*  79: 81 */     this.phone = phone;
/*  80: 82 */     this.phone2 = phone2;
/*  81: 83 */     this.fax = fax;
/*  82: 84 */     this.notes = notes;
/*  83: 85 */     this.visible = visible;
/*  84: 86 */     this.maxdebt = maxdebt;
/*  85: 87 */     this.curdebt = curdebt;
/*  86: 88 */     this.image = image;
/*  87:    */   }
/*  88:    */   
/*  89:    */   public Integer getId()
/*  90:    */   {
/*  91: 92 */     return this.id;
/*  92:    */   }
/*  93:    */   
/*  94:    */   public void setId(Integer id)
/*  95:    */   {
/*  96: 96 */     this.id = id;
/*  97:    */   }
/*  98:    */   
/*  99:    */   public String getName()
/* 100:    */   {
/* 101: 99 */     return this.name;
/* 102:    */   }
/* 103:    */   
/* 104:    */   public void setName(String name)
/* 105:    */   {
/* 106:103 */     this.name = name;
/* 107:    */   }
/* 108:    */   
/* 109:    */   public Integer getType()
/* 110:    */   {
/* 111:106 */     return this.type;
/* 112:    */   }
/* 113:    */   
/* 114:    */   public void setType(Integer type)
/* 115:    */   {
/* 116:110 */     this.type = type;
/* 117:    */   }
/* 118:    */   
/* 119:    */   public String getAddress()
/* 120:    */   {
/* 121:113 */     return this.address;
/* 122:    */   }
/* 123:    */   
/* 124:    */   public void setAddress(String address)
/* 125:    */   {
/* 126:117 */     this.address = address;
/* 127:    */   }
/* 128:    */   
/* 129:    */   public String getAddress2()
/* 130:    */   {
/* 131:120 */     return this.address2;
/* 132:    */   }
/* 133:    */   
/* 134:    */   public void setAddress2(String address2)
/* 135:    */   {
/* 136:124 */     this.address2 = address2;
/* 137:    */   }
/* 138:    */   
/* 139:    */   public String getPostal()
/* 140:    */   {
/* 141:127 */     return this.postal;
/* 142:    */   }
/* 143:    */   
/* 144:    */   public void setPostal(String postal)
/* 145:    */   {
/* 146:131 */     this.postal = postal;
/* 147:    */   }
/* 148:    */   
/* 149:    */   public String getCity()
/* 150:    */   {
/* 151:134 */     return this.city;
/* 152:    */   }
/* 153:    */   
/* 154:    */   public void setCity(String city)
/* 155:    */   {
/* 156:138 */     this.city = city;
/* 157:    */   }
/* 158:    */   
/* 159:    */   public String getState()
/* 160:    */   {
/* 161:141 */     return this.state;
/* 162:    */   }
/* 163:    */   
/* 164:    */   public void setState(String state)
/* 165:    */   {
/* 166:145 */     this.state = state;
/* 167:    */   }
/* 168:    */   
/* 169:    */   public String getCountry()
/* 170:    */   {
/* 171:148 */     return this.country;
/* 172:    */   }
/* 173:    */   
/* 174:    */   public void setCountry(String country)
/* 175:    */   {
/* 176:152 */     this.country = country;
/* 177:    */   }
/* 178:    */   
/* 179:    */   public String getFirstname()
/* 180:    */   {
/* 181:155 */     return this.firstname;
/* 182:    */   }
/* 183:    */   
/* 184:    */   public void setFirstname(String firstname)
/* 185:    */   {
/* 186:159 */     this.firstname = firstname;
/* 187:    */   }
/* 188:    */   
/* 189:    */   public String getLastname()
/* 190:    */   {
/* 191:162 */     return this.lastname;
/* 192:    */   }
/* 193:    */   
/* 194:    */   public void setLastname(String lastname)
/* 195:    */   {
/* 196:166 */     this.lastname = lastname;
/* 197:    */   }
/* 198:    */   
/* 199:    */   public String getEmail()
/* 200:    */   {
/* 201:169 */     return this.email;
/* 202:    */   }
/* 203:    */   
/* 204:    */   public void setEmail(String email)
/* 205:    */   {
/* 206:173 */     this.email = email;
/* 207:    */   }
/* 208:    */   
/* 209:    */   public String getPhone()
/* 210:    */   {
/* 211:176 */     return this.phone;
/* 212:    */   }
/* 213:    */   
/* 214:    */   public void setPhone(String phone)
/* 215:    */   {
/* 216:180 */     this.phone = phone;
/* 217:    */   }
/* 218:    */   
/* 219:    */   public String getPhone2()
/* 220:    */   {
/* 221:183 */     return this.phone2;
/* 222:    */   }
/* 223:    */   
/* 224:    */   public void setPhone2(String phone2)
/* 225:    */   {
/* 226:187 */     this.phone2 = phone2;
/* 227:    */   }
/* 228:    */   
/* 229:    */   public String getFax()
/* 230:    */   {
/* 231:190 */     return this.fax;
/* 232:    */   }
/* 233:    */   
/* 234:    */   public void setFax(String fax)
/* 235:    */   {
/* 236:194 */     this.fax = fax;
/* 237:    */   }
/* 238:    */   
/* 239:    */   public String getNotes()
/* 240:    */   {
/* 241:197 */     return this.notes;
/* 242:    */   }
/* 243:    */   
/* 244:    */   public void setNotes(String notes)
/* 245:    */   {
/* 246:201 */     this.notes = notes;
/* 247:    */   }
/* 248:    */   
/* 249:    */   public Boolean getVisible()
/* 250:    */   {
/* 251:204 */     return this.visible;
/* 252:    */   }
/* 253:    */   
/* 254:    */   public void setVisible(Boolean visible)
/* 255:    */   {
/* 256:208 */     this.visible = visible;
/* 257:    */   }
/* 258:    */   
/* 259:    */   public BigDecimal getMaxdebt()
/* 260:    */   {
/* 261:211 */     return this.maxdebt;
/* 262:    */   }
/* 263:    */   
/* 264:    */   public void setMaxdebt(BigDecimal maxdebt)
/* 265:    */   {
/* 266:215 */     this.maxdebt = maxdebt;
/* 267:    */   }
/* 268:    */   
/* 269:    */   public BigDecimal getCurdebt()
/* 270:    */   {
/* 271:218 */     return this.curdebt;
/* 272:    */   }
/* 273:    */   
/* 274:    */   public void setCurdebt(BigDecimal curdebt)
/* 275:    */   {
/* 276:222 */     this.curdebt = curdebt;
/* 277:    */   }
/* 278:    */   
/* 279:    */   public byte[] getImage()
/* 280:    */   {
/* 281:225 */     return this.image;
/* 282:    */   }
/* 283:    */   
/* 284:    */   public void setImage(byte[] image)
/* 285:    */   {
/* 286:229 */     this.image = image;
/* 287:    */   }
/* 288:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.pojo.Accounts
 * JD-Core Version:    0.7.1
 */