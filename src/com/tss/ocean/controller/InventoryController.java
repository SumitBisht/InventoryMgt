/*   1:    */ package com.tss.ocean.controller;
/*   2:    */ 
/*   3:    */ import com.tss.ocean.idao.IItemDAO;
/*   4:    */ import com.tss.ocean.idao.IItemtypeDAO;
/*   5:    */ import com.tss.ocean.idao.IItemunitDAO;
/*   6:    */ import com.tss.ocean.pojo.Item;
/*   7:    */ import com.tss.ocean.pojo.Itemtype;
/*   8:    */ import com.tss.ocean.pojo.Itemunit;
/*   9:    */ import java.util.Map;
/*  10:    */ import java.util.logging.Level;
/*  11:    */ import java.util.logging.Logger;
/*  12:    */ import javax.servlet.http.HttpServletRequest;
/*  13:    */ import javax.validation.Valid;
/*  14:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  15:    */ import org.springframework.security.access.prepost.PreAuthorize;
/*  16:    */ import org.springframework.stereotype.Controller;
/*  17:    */ import org.springframework.validation.BindingResult;
/*  18:    */ import org.springframework.web.bind.annotation.ModelAttribute;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ import org.springframework.web.bind.annotation.RequestParam;
/*  21:    */ import org.springframework.web.bind.annotation.ResponseBody;
/*  22:    */ import org.springframework.web.servlet.ModelAndView;
/*  23:    */ 
/*  24:    */ @Controller
/*  25:    */ public class InventoryController
/*  26:    */ {
/*  27: 38 */   private static final Logger logger = Logger.getLogger(ViewController.class.getName());
/*  28:    */   @Autowired
/*  29:    */   IItemtypeDAO itemTypeDAO;
/*  30:    */   @Autowired
/*  31:    */   IItemunitDAO itemunitDAO;
/*  32:    */   @Autowired
/*  33:    */   IItemDAO itemDAO;
/*  34:    */   
/*  35:    */   @RequestMapping(value={"/AddInventory.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  36:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('itemcategory','add')")
/*  37:    */   public ModelAndView inventorymgmt(@ModelAttribute("itemTypeForm") @Valid Itemtype itemTypeForm, BindingResult result, Map<String, Object> model)
/*  38:    */     throws Exception
/*  39:    */   {
/*  40: 53 */     logger.log(Level.OFF, "Add Inventory called with inventory details ####### ." + itemTypeForm);
/*  41: 55 */     if (result.hasErrors())
/*  42:    */     {
/*  43: 56 */       logger.log(Level.OFF, "Error occured while inserting the reconrd for the item type." + result.getAllErrors());
/*  44: 57 */       ModelAndView modelAndView = new ModelAndView("add-item_category");
/*  45:    */       
/*  46: 59 */       modelAndView.addAllObjects(model);
/*  47: 60 */       return modelAndView;
/*  48:    */     }
/*  49: 62 */     logger.log(Level.OFF, "Insert result ####### ." + this.itemTypeDAO.insert(itemTypeForm));
/*  50: 63 */     return new ModelAndView("redirect:/item_category.html");
/*  51:    */   }
/*  52:    */   
/*  53:    */   @RequestMapping(value={"/UpdateItemCategory.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  54:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('itemcategory','update')")
/*  55:    */   public ModelAndView updateItemCategory(@ModelAttribute("itemTypeForm") @Valid Itemtype itemTypeForm, BindingResult result, Map<String, Object> model)
/*  56:    */     throws Exception
/*  57:    */   {
/*  58: 70 */     logger.log(Level.WARNING, "Update Inventory called with inventory details ####### ." + itemTypeForm);
/*  59: 72 */     if (result.hasErrors())
/*  60:    */     {
/*  61: 73 */       logger.log(Level.OFF, "Error occured while inserting the reconrd for the item type." + result.getAllErrors());
/*  62: 74 */       ModelAndView modelAndView = new ModelAndView("add-item_category");
/*  63:    */       
/*  64: 76 */       modelAndView.addAllObjects(model);
/*  65: 77 */       return modelAndView;
/*  66:    */     }
/*  67: 79 */     Itemtype oldType = (Itemtype)this.itemTypeDAO.getRecordByPrimaryKey(itemTypeForm.getId());
/*  68: 80 */     if (oldType != null)
/*  69:    */     {
/*  70: 81 */       oldType.setName(itemTypeForm.getName());
/*  71: 82 */       oldType.setDescription(itemTypeForm.getDescription());
/*  72: 83 */       int status = this.itemTypeDAO.update(oldType);
/*  73: 84 */       logger.log(Level.OFF, "Insert result ####### ." + status);
/*  74:    */     }
/*  75: 86 */     return new ModelAndView("redirect:/item_category.html");
/*  76:    */   }
/*  77:    */   
/*  78:    */   @RequestMapping(value={"/AddItemUnits.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*  79:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('itemunit','add')")
/*  80:    */   public ModelAndView addItemUnits(@ModelAttribute("itemUnit") @Valid Itemunit itemUnit, BindingResult result, Map<String, Object> model)
/*  81:    */     throws Exception
/*  82:    */   {
/*  83: 93 */     logger.log(Level.OFF, "Add Item Units with detail ####### ." + itemUnit);
/*  84: 95 */     if (result.hasErrors())
/*  85:    */     {
/*  86: 96 */       logger.log(Level.OFF, "Error occured while inserting the reconrd for the item unit." + result.getAllErrors());
/*  87: 97 */       ModelAndView modelAndView = new ModelAndView("add-item_unit");
/*  88:    */       
/*  89: 99 */       modelAndView.addAllObjects(model);
/*  90:100 */       return modelAndView;
/*  91:    */     }
/*  92:102 */     int status = -1;
/*  93:103 */     if (itemUnit.getId() == null)
/*  94:    */     {
/*  95:104 */       status = ((Integer)this.itemunitDAO.insert(itemUnit)).intValue();
/*  96:    */     }
/*  97:    */     else
/*  98:    */     {
/*  99:106 */       Itemunit oldItemUnit = (Itemunit)this.itemunitDAO.getRecordByPrimaryKey(itemUnit.getId());
/* 100:107 */       oldItemUnit.setName(itemUnit.getName());
/* 101:108 */       oldItemUnit.setDescription(itemUnit.getDescription());
/* 102:109 */       status = this.itemunitDAO.update(oldItemUnit);
/* 103:    */     }
/* 104:111 */     logger.log(Level.OFF, "Insert result ####### success." + status);
/* 105:112 */     return new ModelAndView("redirect:/item_unit.html");
/* 106:    */   }
/* 107:    */   
/* 108:    */   @RequestMapping(value={"/AddItem.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 109:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('item','add')")
/* 110:    */   public ModelAndView addItem(@ModelAttribute("itemForm") @Valid Item item, BindingResult result, Map<String, Object> model)
/* 111:    */     throws Exception
/* 112:    */   {
/* 113:119 */     if (item.getId() == null)
/* 114:    */     {
/* 115:120 */       logger.log(Level.OFF, "Add Item with detail ####### ." + item);
/* 116:121 */       if (result.hasErrors())
/* 117:    */       {
/* 118:122 */         logger.log(Level.OFF, "Error occured while inserting the reconrd for the item." + result.getAllErrors());
/* 119:123 */         ModelAndView modelAndView = new ModelAndView("add-item");
/* 120:    */         
/* 121:125 */         model.put("itemUnitList", this.itemunitDAO.getList());
/* 122:126 */         model.put("itemTypeList", this.itemTypeDAO.getList());
/* 123:127 */         modelAndView.addAllObjects(model);
/* 124:128 */         return modelAndView;
/* 125:    */       }
/* 126:130 */       item.setAlias("123");
/* 127:131 */       logger.log(Level.OFF, "Insert result ####### ." + this.itemDAO.insert(item));
/* 128:132 */       return new ModelAndView("redirect:/item.html");
/* 129:    */     }
/* 130:136 */     logger.log(Level.OFF, "Edit Item with detail ####### ." + item);
/* 131:137 */     if (result.hasErrors())
/* 132:    */     {
/* 133:138 */       logger.log(Level.OFF, "Error occured while editing the reconrd for the item." + result.getAllErrors());
/* 134:139 */       ModelAndView modelAndView = new ModelAndView("add-item");
/* 135:    */       
/* 136:141 */       model.put("itemUnitList", this.itemunitDAO.getList());
/* 137:142 */       model.put("itemTypeList", this.itemTypeDAO.getList());
/* 138:143 */       modelAndView.addAllObjects(model);
/* 139:144 */       return modelAndView;
/* 140:    */     }
/* 141:146 */     Item oldItem = (Item)this.itemDAO.getRecordByPrimaryKey(item.getId());
/* 142:147 */     oldItem.setName(item.getName());
/* 143:148 */     oldItem.setPrice(item.getPrice());
/* 144:149 */     oldItem.setTaxid(item.getTaxid());
/* 145:150 */     oldItem.setCategoryid(item.getCategoryid());
/* 146:151 */     oldItem.setCurrstock(item.getCurrstock());
/* 147:152 */     logger.log(Level.OFF, "Update result ####### ." + this.itemDAO.update(oldItem));
/* 148:153 */     return new ModelAndView("redirect:/item.html");
/* 149:    */   }
/* 150:    */   
/* 151:    */   @RequestMapping(value={"/EditItem.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 152:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('item','update')")
/* 153:    */   public ModelAndView editItem(@ModelAttribute("itemForm") @Valid Item item, BindingResult result, Map<String, Object> model)
/* 154:    */     throws Exception
/* 155:    */   {
/* 156:160 */     logger.log(Level.OFF, "Edit Item with detail ####### ." + item);
/* 157:161 */     if (result.hasErrors())
/* 158:    */     {
/* 159:162 */       logger.log(Level.OFF, "Error occured while editing the reconrd for the item." + result.getAllErrors());
/* 160:163 */       ModelAndView modelAndView = new ModelAndView("add-item");
/* 161:    */       
/* 162:165 */       model.put("itemUnitList", this.itemunitDAO.getList());
/* 163:166 */       model.put("itemTypeList", this.itemTypeDAO.getList());
/* 164:167 */       modelAndView.addAllObjects(model);
/* 165:168 */       return modelAndView;
/* 166:    */     }
/* 167:170 */     Item oldItem = (Item)this.itemDAO.getRecordByPrimaryKey(item.getId());
/* 168:171 */     oldItem.setName(item.getName());
/* 169:172 */     oldItem.setPrice(item.getPrice());
/* 170:173 */     oldItem.setTaxid(item.getTaxid());
/* 171:174 */     oldItem.setCategoryid(item.getCategoryid());
/* 172:175 */     oldItem.setCurrstock(item.getCurrstock());
/* 173:176 */     logger.log(Level.OFF, "Update result ####### ." + this.itemDAO.update(oldItem));
/* 174:177 */     return new ModelAndView("redirect:/item_unit.html");
/* 175:    */   }
/* 176:    */   
/* 177:    */   @RequestMapping(value={"/DeleteItemCategory.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 178:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('itemcategory','delete')")
/* 179:    */   public ModelAndView deleteItemCategory(@RequestParam("deleteId") int deleteId, Map<String, Object> model)
/* 180:    */     throws Exception
/* 181:    */   {
/* 182:183 */     logger.log(Level.FINE, "Delete item category called.");
/* 183:184 */     Itemtype itemType = (Itemtype)this.itemTypeDAO.getRecordByPrimaryKey(Integer.valueOf(deleteId));
/* 184:185 */     if (itemType != null)
/* 185:    */     {
/* 186:186 */       int updateResult = this.itemTypeDAO.delete(itemType);
/* 187:187 */       if (updateResult > 0) {
/* 188:188 */         logger.log(Level.INFO, "Item Type with id {0} deleted successfully", itemType.getId());
/* 189:    */       } else {
/* 190:190 */         logger.log(Level.WARNING, "Error occurred while deleting item type with id {0}", itemType.getId());
/* 191:    */       }
/* 192:    */     }
/* 193:193 */     logger.log(Level.INFO, "Item Type with id {0} is already deleted", Integer.valueOf(deleteId));
/* 194:194 */     return new ModelAndView("redirect:/item_category.html");
/* 195:    */   }
/* 196:    */   
/* 197:    */   @RequestMapping(value={"/DeleteItem.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 198:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('item','delete')")
/* 199:    */   public ModelAndView deleteItem(@RequestParam("deleteId") int deleteId, Map<String, Object> model)
/* 200:    */     throws Exception
/* 201:    */   {
/* 202:200 */     logger.log(Level.FINE, "Delete item called.");
/* 203:201 */     Item itemBean = (Item)this.itemDAO.getRecordByPrimaryKey(Integer.valueOf(deleteId));
/* 204:202 */     if (itemBean != null)
/* 205:    */     {
/* 206:203 */       int updateResult = this.itemDAO.delete(itemBean);
/* 207:204 */       if (updateResult > 0) {
/* 208:205 */         logger.log(Level.INFO, "Item id {0} deleted successfully", itemBean.getId());
/* 209:    */       } else {
/* 210:207 */         logger.log(Level.WARNING, "Error occurred while deleting item with id {0}", itemBean.getId());
/* 211:    */       }
/* 212:    */     }
/* 213:210 */     logger.log(Level.INFO, "Item with id {0} is already deleted", Integer.valueOf(deleteId));
/* 214:211 */     return new ModelAndView("redirect:/item.html");
/* 215:    */   }
/* 216:    */   
/* 217:    */   @RequestMapping(value={"/DeleteItemUnits.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 218:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('itemunit','delete')")
/* 219:    */   public ModelAndView deleteItemUnits(@RequestParam("deleteId") int deleteId, Map<String, Object> model)
/* 220:    */     throws Exception
/* 221:    */   {
/* 222:217 */     logger.log(Level.FINE, "Delete item category units called.");
/* 223:218 */     Itemunit itemUnit = (Itemunit)this.itemunitDAO.getRecordByPrimaryKey(Integer.valueOf(deleteId));
/* 224:219 */     if (itemUnit != null)
/* 225:    */     {
/* 226:220 */       int updateResult = this.itemunitDAO.delete(itemUnit);
/* 227:221 */       if (updateResult > 0) {
/* 228:222 */         logger.log(Level.INFO, "Item Units with id {0} deleted successfully", itemUnit.getId());
/* 229:    */       } else {
/* 230:224 */         logger.log(Level.WARNING, "Error occurred while deleting item units with id {0}", itemUnit.getId());
/* 231:    */       }
/* 232:    */     }
/* 233:227 */     logger.log(Level.INFO, "Item Units with id {0} is already deleted", Integer.valueOf(deleteId));
/* 234:228 */     return new ModelAndView("redirect:/item_unit.html");
/* 235:    */   }
/* 236:    */   
/* 237:    */   @RequestMapping({"/UpdateItemUnits.html"})
/* 238:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('itemunit','update')")
/* 239:    */   public String updateItemUnits(@RequestParam("updateItemId") int updateItemId, Map<String, Object> model)
/* 240:    */     throws Exception
/* 241:    */   {
/* 242:234 */     logger.log(Level.OFF, "Update Item Unit called.");
/* 243:235 */     model.put("itemUnit", this.itemunitDAO.getRecordByPrimaryKey(Integer.valueOf(updateItemId)));
/* 244:236 */     return "update-item_unit";
/* 245:    */   }
/* 246:    */   
/* 247:    */   @RequestMapping({"/UpdateItemCategory.html"})
/* 248:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('itemcategory','update')")
/* 249:    */   public String updateItemCategory(@RequestParam("updateItemId") int updateItemId, Map<String, Object> model)
/* 250:    */     throws Exception
/* 251:    */   {
/* 252:242 */     logger.log(Level.OFF, "Update Item Category called.");
/* 253:243 */     model.put("itemTypeForm", this.itemTypeDAO.getRecordByPrimaryKey(Integer.valueOf(updateItemId)));
/* 254:244 */     return "update-item_category";
/* 255:    */   }
/* 256:    */   
/* 257:    */   @RequestMapping(value={"/UpdateItem.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 258:    */   @PreAuthorize("hasAnyRole('ROLE_USER') AND hasPermission('item','update')")
/* 259:    */   public String edit_item(@RequestParam("updateItemId") int updateItemId, Map<String, Object> model, HttpServletRequest request)
/* 260:    */     throws Exception
/* 261:    */   {
/* 262:249 */     logger.log(Level.OFF, "add-item called.");
/* 263:250 */     model.put("itemForm", this.itemDAO.getRecordByPrimaryKey(Integer.valueOf(updateItemId)));
/* 264:251 */     model.put("itemUnitList", this.itemunitDAO.getList());
/* 265:252 */     model.put("itemTypeList", this.itemTypeDAO.getList());
/* 266:253 */     return "add-item";
/* 267:    */   }
/* 268:    */   
/* 269:    */   @RequestMapping(value={"/additemdummy.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 270:    */   @ResponseBody
/* 271:    */   public String add_itemdummy(@RequestParam("item") String item, Map<String, Object> model, HttpServletRequest request)
/* 272:    */     throws Exception
/* 273:    */   {
/* 274:258 */     logger.log(Level.OFF, "add-item called.");
/* 275:259 */     model.put("itemForm", new Item());
/* 276:260 */     model.put("itemUnitList", this.itemunitDAO.getList());
/* 277:261 */     model.put("itemTypeList", this.itemTypeDAO.getList());
/* 278:262 */     ModelAndView mv = new ModelAndView("add-item", model);
/* 279:263 */     return "add-item";
/* 280:    */   }
/* 281:    */   
/* 282:    */   @RequestMapping(value={"/validateitem.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/* 283:    */   @ResponseBody
/* 284:    */   public String validate_Itemname(@RequestParam("item") String item, Map<String, Object> model, HttpServletRequest request)
/* 285:    */     throws Exception
/* 286:    */   {
/* 287:268 */     logger.log(Level.OFF, "add-item called.");
/* 288:269 */     Item oItem = (Item)this.itemDAO.getRecordByKeyandValue("name", item);
/* 289:270 */     StringBuilder sb = new StringBuilder();
/* 290:271 */     if (oItem == null) {
/* 291:272 */       sb.append("{\"code\":\"401\",\"message\":\"Item name is wrong.\"}");
/* 292:    */     } else {
/* 293:274 */       sb.append("{\"code\":\"200\",\"message\":\"Success\"}");
/* 294:    */     }
/* 295:277 */     return sb.toString();
/* 296:    */   }
/* 297:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.controller.InventoryController
 * JD-Core Version:    0.7.1
 */