/*   1:    */ package com.tss.ocean.controller;
/*   2:    */ 
/*   3:    */ import com.tss.ocean.idao.IItemDAO;
/*   4:    */ import com.tss.ocean.idao.IItemtypeDAO;
/*   5:    */ import com.tss.ocean.idao.IItemunitDAO;
/*   6:    */ import com.tss.ocean.pojo.Employees;
/*   7:    */ import com.tss.ocean.pojo.Item;
/*   8:    */ import com.tss.ocean.pojo.Itemtype;
/*   9:    */ import com.tss.ocean.pojo.Itemunit;
/*  10:    */ import java.util.List;
/*  11:    */ import java.util.Map;
/*  12:    */ import java.util.logging.Level;
/*  13:    */ import java.util.logging.Logger;
/*  14:    */ import javax.servlet.http.HttpServletRequest;
/*  15:    */ import org.springframework.beans.factory.annotation.Autowired;
/*  16:    */ import org.springframework.security.access.prepost.PreAuthorize;
/*  17:    */ import org.springframework.stereotype.Controller;
/*  18:    */ import org.springframework.ui.Model;
/*  19:    */ import org.springframework.web.bind.annotation.RequestMapping;
/*  20:    */ 
/*  21:    */ @Controller
/*  22:    */ public class ViewController
/*  23:    */ {
/*  24:    */   @Autowired
/*  25:    */   IItemtypeDAO itemTypeDAO;
/*  26:    */   @Autowired
/*  27:    */   IItemunitDAO itemunitDAO;
/*  28:    */   @Autowired
/*  29:    */   IItemDAO itemDAO;
/*  30: 42 */   private static final Logger logger = Logger.getLogger(ViewController.class.getName());
/*  31:    */   
/*  32:    */   @RequestMapping(value={"/inventory_management.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  33:    */   public String inventorymgmt(Model model, HttpServletRequest request)
/*  34:    */     throws Exception
/*  35:    */   {
/*  36: 46 */     logger.log(Level.OFF, "inventory_management called.");
/*  37:    */     
/*  38: 48 */     return "item";
/*  39:    */   }
/*  40:    */   
/*  41:    */   @RequestMapping(value={"/item.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  42:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/*  43:    */   public String itemmgmt(Model model, HttpServletRequest request)
/*  44:    */     throws Exception
/*  45:    */   {
/*  46: 54 */     logger.log(Level.OFF, "item called.");
/*  47: 55 */     logger.log(Level.OFF, "item called size ### " + this.itemDAO.getList().size());
/*  48: 56 */     model.addAttribute("itemList", this.itemDAO.getList());
/*  49: 57 */     return "item";
/*  50:    */   }
/*  51:    */   
/*  52:    */   @RequestMapping(value={"/item_category.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  53:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/*  54:    */   public String item_category(Model model, HttpServletRequest request)
/*  55:    */     throws Exception
/*  56:    */   {
/*  57: 63 */     logger.log(Level.OFF, "item_category called.");
/*  58: 64 */     logger.log(Level.OFF, "List details are loaded by the system.");
/*  59: 65 */     List<Itemtype> itemTypeList = this.itemTypeDAO.getList();
/*  60: 66 */     model.addAttribute("itemTypeList", itemTypeList);
/*  61: 67 */     return "item_category";
/*  62:    */   }
/*  63:    */   
/*  64:    */   @RequestMapping(value={"/item_unit.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  65:    */   @PreAuthorize("hasAnyRole('ROLE_USER')  ")
/*  66:    */   public String item_unit(Model model, HttpServletRequest request)
/*  67:    */     throws Exception
/*  68:    */   {
/*  69: 73 */     logger.log(Level.OFF, "item_unit called.");
/*  70: 74 */     model.addAttribute("itemUnit", this.itemunitDAO.getList());
/*  71: 75 */     return "item_unit";
/*  72:    */   }
/*  73:    */   
/*  74:    */   @RequestMapping(value={"/add-item.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  75:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/*  76:    */   public String add_item(Map<String, Object> model, HttpServletRequest request)
/*  77:    */     throws Exception
/*  78:    */   {
/*  79: 81 */     logger.log(Level.OFF, "add-item called.");
/*  80: 82 */     model.put("itemForm", new Item());
/*  81: 83 */     model.put("itemUnitList", this.itemunitDAO.getList());
/*  82: 84 */     model.put("itemTypeList", this.itemTypeDAO.getList());
/*  83: 85 */     return "add-item";
/*  84:    */   }
/*  85:    */   
/*  86:    */   @RequestMapping(value={"/add-item_category.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  87:    */   @PreAuthorize("hasAnyRole('ROLE_USER') ")
/*  88:    */   public String add_item_category(Map<String, Object> model, HttpServletRequest request)
/*  89:    */     throws Exception
/*  90:    */   {
/*  91: 91 */     logger.log(Level.OFF, "add-item_category called.");
/*  92: 92 */     Itemtype itemtype = new Itemtype();
/*  93: 93 */     model.put("itemTypeForm", itemtype);
/*  94: 94 */     return "add-item_category";
/*  95:    */   }
/*  96:    */   
/*  97:    */   @RequestMapping(value={"/add-item_unit.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*  98:    */   @PreAuthorize("hasAnyRole('ROLE_USER')")
/*  99:    */   public String add_item_unit(Map<String, Object> model, HttpServletRequest request)
/* 100:    */     throws Exception
/* 101:    */   {
/* 102:100 */     logger.log(Level.OFF, "add-item_unit called.");
/* 103:101 */     model.put("itemUnit", new Itemunit());
/* 104:102 */     return "add-item_unit";
/* 105:    */   }
/* 106:    */   
/* 107:    */   @RequestMapping(value={"/hr_management.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 108:    */   public String hr_management(Model model, HttpServletRequest request)
/* 109:    */     throws Exception
/* 110:    */   {
/* 111:108 */     logger.log(Level.OFF, "hr_management called.");
/* 112:109 */     return "hr/hr_management";
/* 113:    */   }
/* 114:    */   
/* 115:    */   @RequestMapping(value={"/employees.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 116:    */   public String employees(Model model, HttpServletRequest request)
/* 117:    */     throws Exception
/* 118:    */   {
/* 119:114 */     logger.log(Level.OFF, "hr_management called.");
/* 120:115 */     return "hr/hr_management";
/* 121:    */   }
/* 122:    */   
/* 123:    */   @RequestMapping(value={"/addemployee.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 124:    */   public String hr_addemployee(Model model, HttpServletRequest request)
/* 125:    */     throws Exception
/* 126:    */   {
/* 127:120 */     logger.log(Level.OFF, "hr_addemployee called.");
/* 128:121 */     model.addAttribute("employee", new Employees());
/* 129:122 */     return "hr/hr_add_employee";
/* 130:    */   }
/* 131:    */   
/* 132:    */   @RequestMapping(value={"/attendences.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 133:    */   public String attendences(Model model, HttpServletRequest request)
/* 134:    */     throws Exception
/* 135:    */   {
/* 136:157 */     logger.log(Level.OFF, "attendences called.");
/* 137:158 */     return "hr/attendences";
/* 138:    */   }
/* 139:    */   
/* 140:    */   @RequestMapping(value={"/finance_management.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/* 141:    */   public String finance_management(Model model, HttpServletRequest request)
/* 142:    */     throws Exception
/* 143:    */   {
/* 144:164 */     logger.log(Level.OFF, "finance_management called.");
/* 145:165 */     return "finance_management";
/* 146:    */   }
/* 147:    */ }


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.controller.ViewController
 * JD-Core Version:    0.7.1
 */