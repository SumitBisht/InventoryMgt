/*   1:    */ package com.techshark.hibernate.base;
/*   2:    */ 
/*   3:    */ import com.techshark.hibernate.ibase.GenericDAO;
/*   4:    */ import com.techshark.hibernate.util.HibernateUtil;
/*   5:    */ import java.io.PrintStream;
/*   6:    */ import java.io.Serializable;
/*   7:    */ import java.util.List;
/*   8:    */ import org.hibernate.Criteria;
/*   9:    */ import org.hibernate.HibernateException;
/*  10:    */ import org.hibernate.Query;
/*  11:    */ import org.hibernate.SQLQuery;
/*  12:    */ import org.hibernate.Session;
/*  13:    */ import org.hibernate.SessionFactory;
/*  14:    */ import org.hibernate.StaleStateException;
/*  15:    */ import org.hibernate.Transaction;
/*  16:    */ import org.hibernate.criterion.Restrictions;
/*  17:    */ import org.hibernate.metadata.ClassMetadata;
/*  18:    */ import org.slf4j.Logger;
/*  19:    */ import org.slf4j.LoggerFactory;
/*  20:    */ 
/*  21:    */ public abstract class GenericDAOImpl<DomainObject extends Serializable, KeyType extends Serializable>
/*  22:    */   implements GenericDAO<DomainObject, KeyType>
/*  23:    */ {
/*  24: 37 */   static final Logger LOG = LoggerFactory.getLogger(GenericDAOImpl.class);
/*  25:    */   private Class<DomainObject> persistentClass;
/*  26:    */   private Session session;
/*  27:    */   private SessionFactory sessionFactory;
/*  28: 41 */   private static String MODULE = "[GENERICDAOIMPL] ";
/*  29:    */   
/*  30:    */   public GenericDAOImpl()
/*  31:    */   {
/*  32: 49 */     this.persistentClass = ((Class)((java.lang.reflect.ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
/*  33:    */   }
/*  34:    */   
/*  35:    */   public Class<DomainObject> getPersistentClass()
/*  36:    */   {
/*  37: 53 */     return this.persistentClass;
/*  38:    */   }
/*  39:    */   
/*  40:    */   public SessionFactory getSessionFactory()
/*  41:    */   {
/*  42: 57 */     return this.sessionFactory;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setSessionFactory(SessionFactory sessionFactory)
/*  46:    */   {
/*  47: 61 */     this.sessionFactory = sessionFactory;
/*  48: 62 */     LOG.trace("setted seesion factory....");
/*  49:    */   }
/*  50:    */   
/*  51:    */   public List<DomainObject> getList()
/*  52:    */   {
/*  53: 72 */     Session session = getSession();
/*  54:    */     try
/*  55:    */     {
/*  56: 74 */       session.flush();
/*  57: 75 */       return session.createQuery("from " + getPersistentClass().getName()).list();
/*  58:    */     }
/*  59:    */     catch (HibernateException e)
/*  60:    */     {
/*  61: 77 */       LOG.error(MODULE + "Exception in getList() Method:" + e, e);
/*  62: 78 */       throw e;
/*  63:    */     }
/*  64:    */   }
/*  65:    */   
/*  66:    */   public int getRecordBySQLQuery(String sql)
/*  67:    */   {
/*  68: 89 */     Session session = getSession();
/*  69:    */     
/*  70: 91 */     int rows = 0;
/*  71:    */     try
/*  72:    */     {
/*  73: 94 */       Query query = session.createSQLQuery(sql).addEntity(getPersistentClass());
/*  74: 95 */       rows = query.executeUpdate();
/*  75:    */     }
/*  76:    */     catch (RuntimeException e)
/*  77:    */     {
/*  78: 97 */       e = 
/*  79:    */       
/*  80:    */ 
/*  81:    */ 
/*  82:    */ 
/*  83:    */ 
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:106 */         e;LOG.error(MODULE + "Exception in getRecordBySQLQuery() Method:" + e, e);
/*  88:    */     }
/*  89:    */     finally {}
/*  90:107 */     return rows;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public int getExecuteUpdate(String hql)
/*  94:    */   {
/*  95:111 */     Session session = getSession();
/*  96:    */     
/*  97:113 */     int rows = 0;
/*  98:    */     try
/*  99:    */     {
/* 100:116 */       Query query = session.createQuery(hql);
/* 101:117 */       LOG.debug(MODULE + "getExecuteUpdate" + "# Query : " + hql);
/* 102:118 */       rows = query.executeUpdate();
/* 103:    */     }
/* 104:    */     catch (RuntimeException e)
/* 105:    */     {
/* 106:120 */       e = 
/* 107:    */       
/* 108:    */ 
/* 109:    */ 
/* 110:    */ 
/* 111:    */ 
/* 112:    */ 
/* 113:    */ 
/* 114:    */ 
/* 115:129 */         e;LOG.error(MODULE + "Exception in getExecuteUpdate Method:" + e, e);
/* 116:    */     }
/* 117:    */     finally {}
/* 118:130 */     return rows;
/* 119:    */   }
/* 120:    */   
/* 121:    */   public DomainObject getRecordByKeyandValue(String keyName, Object keyValue)
/* 122:    */   {
/* 123:141 */     DomainObject returnValue = null;
/* 124:142 */     Session session = getSession();
/* 125:143 */     List<DomainObject> lst = null;
/* 126:    */     try
/* 127:    */     {
/* 128:145 */       Criteria query = session.createCriteria(getPersistentClass()).add(Restrictions.eq(keyName, keyValue));
/* 129:146 */       lst = query.list();
/* 130:147 */       if ((lst != null) && (lst.size() > 0)) {
/* 131:148 */         returnValue = (DomainObject)lst.get(0);
/* 132:    */       }
/* 133:    */     }
/* 134:    */     catch (HibernateException e)
/* 135:    */     {
/* 136:151 */       LOG.error(MODULE + "Exception in getRecordByKeyandValue Method:" + e, e);
/* 137:    */     }
/* 138:    */     finally
/* 139:    */     {
/* 140:153 */       if (session.isOpen()) {
/* 141:154 */         session.close();
/* 142:    */       }
/* 143:    */     }
/* 144:157 */     return returnValue;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public List<DomainObject> getListByKeyandValue(String colname, Object value)
/* 148:    */   {
/* 149:168 */     Session session = getSession();
/* 150:169 */     List<DomainObject> retList = null;
/* 151:    */     try
/* 152:    */     {
/* 153:171 */       Criteria query = session.createCriteria(getPersistentClass()).add(Restrictions.eq(colname, value));
/* 154:172 */       retList = query.list();
/* 155:    */     }
/* 156:    */     catch (HibernateException e)
/* 157:    */     {
/* 158:173 */       e = 
/* 159:    */       
/* 160:    */ 
/* 161:    */ 
/* 162:    */ 
/* 163:    */ 
/* 164:179 */         e;LOG.error(MODULE + "Exception in getListByKeyandValue Method:" + e, e);
/* 165:    */     }
/* 166:    */     finally {}
/* 167:180 */     return retList;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public List<DomainObject> getListByKeyandValue(String colname, List<Object> keyValue)
/* 171:    */   {
/* 172:191 */     Session session = getSession();
/* 173:192 */     List<DomainObject> retList = null;
/* 174:    */     try
/* 175:    */     {
/* 176:194 */       Criteria query = session.createCriteria(getPersistentClass()).add(Restrictions.in(colname, keyValue));
/* 177:195 */       retList = query.list();
/* 178:    */     }
/* 179:    */     catch (HibernateException e)
/* 180:    */     {
/* 181:196 */       e = 
/* 182:    */       
/* 183:    */ 
/* 184:    */ 
/* 185:    */ 
/* 186:    */ 
/* 187:202 */         e;LOG.error(MODULE + "Exception in getListByKeyandValue with List<Values> Method:" + e, e);
/* 188:    */     }
/* 189:    */     finally {}
/* 190:203 */     return retList;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public List<DomainObject> getListByCondition(String condition)
/* 194:    */   {
/* 195:213 */     Session session = getSession();
/* 196:214 */     List<DomainObject> lst = null;
/* 197:    */     try
/* 198:    */     {
/* 199:216 */       if ((condition == null) || ("null".equals(condition))) {
/* 200:217 */         condition = " ";
/* 201:    */       }
/* 202:219 */       lst = session.createQuery("from " + getPersistentClass().getName() + " " + condition).list();
/* 203:    */     }
/* 204:    */     catch (HibernateException e)
/* 205:    */     {
/* 206:221 */       LOG.error(MODULE + "Exception in getListByCondition Method:" + e, e);
/* 207:    */     }
/* 208:    */     finally
/* 209:    */     {
/* 210:223 */       if (session.isOpen()) {
/* 211:224 */         session.close();
/* 212:    */       }
/* 213:    */     }
/* 214:227 */     return lst;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public DomainObject getRecordByPrimaryKey(KeyType id)
/* 218:    */   {
/* 219:238 */     Session session = getSession();
/* 220:    */     try
/* 221:    */     {
/* 222:240 */       return (DomainObject)session.get(getPersistentClass(), id);
/* 223:    */     }
/* 224:    */     catch (HibernateException e)
/* 225:    */     {
/* 226:242 */       LOG.error(MODULE + "Exception in getRecordByPrimaryKey Method:" + e, e);
/* 227:243 */       throw e;
/* 228:    */     }
/* 229:    */     finally
/* 230:    */     {
/* 231:245 */       if (session.isOpen()) {
/* 232:246 */         session.close();
/* 233:    */       }
/* 234:    */     }
/* 235:    */   }
/* 236:    */   
/* 237:    */   public List<KeyType> getPrimaryKeyCollection(String condition)
/* 238:    */   {
/* 239:258 */     Session session = getSession();
/* 240:259 */     List<KeyType> lst = null;
/* 241:    */     try
/* 242:    */     {
/* 243:261 */       if ((condition == null) || ("null".equals(condition))) {
/* 244:262 */         condition = " ";
/* 245:    */       }
/* 246:264 */       ClassMetadata cm = this.sessionFactory.getClassMetadata(getPersistentClass().getName());
/* 247:265 */       String type = cm.getIdentifierPropertyName();
/* 248:266 */       lst = session.createQuery("select t." + type + " from " + getPersistentClass().getName() + " t" + " " + condition).list();
/* 249:    */     }
/* 250:    */     catch (HibernateException e)
/* 251:    */     {
/* 252:267 */       e = 
/* 253:    */       
/* 254:    */ 
/* 255:    */ 
/* 256:    */ 
/* 257:    */ 
/* 258:273 */         e;LOG.error(MODULE + "Exception in getPrimaryKeyCollection Method:" + e, e);
/* 259:    */     }
/* 260:    */     finally {}
/* 261:274 */     return lst;
/* 262:    */   }
/* 263:    */   
/* 264:    */   public KeyType insert(DomainObject object)
/* 265:    */   {
/* 266:285 */     Session session = getSession();
/* 267:    */     
/* 268:287 */     Transaction tx = null;
/* 269:    */     KeyType serialid;
/* 270:    */     try
/* 271:    */     {
/* 272:289 */       tx = session.beginTransaction();
/* 273:290 */       serialid = (KeyType) session.save(object);
/* 274:291 */       tx.commit();


System.out.println("OBJECT IS SAVED SUCCESSFULLY>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

/* 275:    */     }
/* 276:    */     catch (RuntimeException e)
/* 277:    */     {
/* 278:293 */       LOG.error(MODULE + "Exception in insert Method:" + e, e);
/* 279:294 */       if (tx != null) {
/* 280:295 */         tx.rollback();
/* 281:    */       }
/* 282:297 */       throw e;
/* 283:    */     }
/* 284:    */     finally
/* 285:    */     {
/* 286:299 */       if (session.isOpen()) {
/* 287:300 */         session.close();
/* 288:    */       }
/* 289:    */     }
/* 290:303 */     return serialid;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public int update(DomainObject object)
/* 294:    */   {
/* 295:314 */     int updateValue = -1;
/* 296:315 */     Session session = getSession();
/* 297:316 */     Transaction tx = null;
/* 298:    */     try
/* 299:    */     {
/* 300:318 */       if (object == null)
/* 301:    */       {
/* 302:319 */         LOG.debug(MODULE + " Null object could not update....RETURNING");
/* 303:320 */         return updateValue;
/* 304:    */       }
/* 305:322 */       tx = session.beginTransaction();
/* 306:323 */       session.update(object);
/* 307:324 */       tx.commit();
/* 308:325 */       updateValue = 1;
/* 309:    */     }
/* 310:    */     catch (RuntimeException e)
/* 311:    */     {
/* 312:327 */       updateValue = -1;
/* 313:328 */       LOG.error(MODULE + "Exception in update Method." + e, e);
/* 314:329 */       if (tx != null) {
/* 315:330 */         tx.rollback();
/* 316:    */       }
/* 317:332 */       throw e;
/* 318:    */     }
/* 319:    */     finally
/* 320:    */     {
/* 321:334 */       if (session.isOpen()) {
/* 322:335 */         session.close();
/* 323:    */       }
/* 324:    */     }
/* 325:338 */     return updateValue;
/* 326:    */   }
/* 327:    */   
/* 328:    */   public int delete(DomainObject object)
/* 329:    */   {
/* 330:347 */     Session session = getSession();
/* 331:348 */     int deletestatus = -1;
/* 332:349 */     Transaction tx = null;
/* 333:    */     try
/* 334:    */     {
/* 335:351 */       if (object == null)
/* 336:    */       {
/* 337:352 */         LOG.debug(MODULE + " Null object could not delete....RETURNING");
/* 338:353 */         return deletestatus;
/* 339:    */       }
/* 340:355 */       tx = session.beginTransaction();
/* 341:356 */       session.delete(object);
/* 342:357 */       tx.commit();
/* 343:358 */       deletestatus = 1;
/* 344:359 */       System.out.println("record deleted");
/* 345:    */     }
/* 346:    */     catch (StaleStateException e)
/* 347:    */     {
/* 348:361 */       deletestatus = -1;
/* 349:362 */       LOG.error(MODULE + "Exception in delete Method." + e, e);
/* 350:363 */       if (tx != null) {
/* 351:364 */         tx.rollback();
/* 352:    */       }
/* 353:    */     }
/* 354:    */     catch (RuntimeException e)
/* 355:    */     {
/* 356:367 */       deletestatus = -1;
/* 357:368 */       LOG.error(MODULE + "Exception in delete Method." + e, e);
/* 358:369 */       if (tx != null) {
/* 359:370 */         tx.rollback();
/* 360:    */       }
/* 361:372 */       throw e;
/* 362:    */     }
/* 363:    */     finally
/* 364:    */     {
/* 365:374 */       if (session.isOpen()) {
/* 366:375 */         session.close();
/* 367:    */       }
/* 368:    */     }
/* 369:378 */     return deletestatus;
/* 370:    */   }
/* 371:    */   
/* 372:    */   public void deleteById(KeyType id)
/* 373:    */   {
/* 374:388 */     Session session = getSession();
/* 375:389 */     Transaction tx = null;
/* 376:    */     try
/* 377:    */     {
/* 378:391 */       tx = session.beginTransaction();
/* 379:392 */       session.delete(session.get(getPersistentClass(), id));
/* 380:393 */       tx.commit();
/* 381:    */     }
/* 382:    */     catch (RuntimeException e)
/* 383:    */     {
/* 384:395 */       LOG.error(MODULE + "Exception in deletion through id." + e, e);
/* 385:396 */       if (tx != null) {
/* 386:397 */         tx.rollback();
/* 387:    */       }
/* 388:399 */       throw e;
/* 389:    */     }
/* 390:    */     finally
/* 391:    */     {
/* 392:401 */       if (session.isOpen()) {
/* 393:402 */         session.close();
/* 394:    */       }
/* 395:    */     }
/* 396:    */   }
/* 397:    */   
/* 398:    */   public int count()
/* 399:    */   {
/* 400:413 */     Session session = getSession();
/* 401:414 */     Long count = new Long(0L);
/* 402:    */     try
/* 403:    */     {
/* 404:416 */       count = (Long)session.createQuery("select count(t) from " + getPersistentClass().getName() + " t ").uniqueResult();
/* 405:    */     }
/* 406:    */     catch (HibernateException e)
/* 407:    */     {
/* 408:417 */       e = 
/* 409:    */       
/* 410:    */ 
/* 411:    */ 
/* 412:    */ 
/* 413:    */ 
/* 414:423 */         e;LOG.error(MODULE + "Exception in count Method:" + e, e);
/* 415:    */     }
/* 416:    */     finally {}
/* 417:424 */     return count.intValue();
/* 418:    */   }
/* 419:    */   
/* 420:    */   public int count(String condition)
/* 421:    */   {
/* 422:435 */     Session session = getSession();
/* 423:436 */     Long count = null;
/* 424:    */     try
/* 425:    */     {
/* 426:438 */       if ((condition == null) || ("null".equals(condition))) {
/* 427:439 */         condition = " ";
/* 428:    */       }
/* 429:441 */       count = (Long)session.createQuery("select count(t) from " + getPersistentClass().getName() + " t " + condition).uniqueResult();
/* 430:    */     }
/* 431:    */     catch (HibernateException e)
/* 432:    */     {
/* 433:442 */       e = 
/* 434:    */       
/* 435:    */ 
/* 436:    */ 
/* 437:    */ 
/* 438:    */ 
/* 439:448 */         e;LOG.error(MODULE + "Exception in count Method:" + e, e);
/* 440:    */     }
/* 441:    */     finally {}
/* 442:449 */     return count.intValue();
/* 443:    */   }
/* 444:    */   
/* 445:    */   public List getListBySQLQuery(String sql)
/* 446:    */   {
/* 447:470 */     Session session = getSession();
/* 448:471 */     List lst = null;
/* 449:    */     try
/* 450:    */     {
/* 451:473 */       if (sql != null) {
/* 452:474 */         lst = session.createSQLQuery(sql).list();
/* 453:    */       }
/* 454:    */     }
/* 455:    */     catch (RuntimeException e)
/* 456:    */     {
/* 457:476 */       e = 
/* 458:    */       
/* 459:    */ 
/* 460:    */ 
/* 461:    */ 
/* 462:    */ 
/* 463:    */ 
/* 464:483 */         e;lst = null;LOG.error(MODULE + "Exception in getRecordBySQLQuery Method:" + e, e);
/* 465:    */     }
/* 466:    */     finally {}
/* 467:484 */     return lst;
/* 468:    */   }
/* 469:    */   
/* 470:    */   public List getListByHQLQuery(String hql)
/* 471:    */   {
/* 472:494 */     Session session = getSession();
/* 473:495 */     List lst = null;
/* 474:    */     try
/* 475:    */     {
/* 476:497 */       lst = session.createQuery(hql).list();
/* 477:    */     }
/* 478:    */     catch (RuntimeException e)
/* 479:    */     {
/* 480:498 */       e = 
/* 481:    */       
/* 482:    */ 
/* 483:    */ 
/* 484:    */ 
/* 485:    */ 
/* 486:    */ 
/* 487:505 */         e;lst = null;LOG.error(MODULE + "Exception in getListByHQLQuery Method:" + e, e);
/* 488:    */     }
/* 489:    */     finally {}
/* 490:506 */     return lst;
/* 491:    */   }
/* 492:    */   
/* 493:    */   public List getListByFromClause(String hql)
/* 494:    */   {
/* 495:514 */     return getListByHQLQuery(hql);
/* 496:    */   }
/* 497:    */   
/* 498:    */   public List<DomainObject> getListByPage(String columnName, String sortOrder, int limit, int offset)
/* 499:    */   {
/* 500:521 */     Session session = getSession();
/* 501:522 */     List<DomainObject> lst = null;
/* 502:    */     try
/* 503:    */     {
/* 504:524 */       String query = " from " + getPersistentClass().getName() + " order by " + columnName + " " + sortOrder;
/* 505:525 */       lst = session.createQuery(query).setMaxResults(limit).setFirstResult(offset).list();
/* 506:    */     }
/* 507:    */     catch (RuntimeException e)
/* 508:    */     {
/* 509:526 */       e = 
/* 510:    */       
/* 511:    */ 
/* 512:    */ 
/* 513:    */ 
/* 514:    */ 
/* 515:    */ 
/* 516:533 */         e;lst = null;LOG.error(MODULE + "Exception in getListByFromClause Method:" + e, e);
/* 517:    */     }
/* 518:    */     finally {}
/* 519:534 */     return lst;
/* 520:    */   }
/* 521:    */   
/* 522:    */   public List getListByPage(String query, int limit, int offset)
/* 523:    */   {
/* 524:543 */     Session session = getSession();
/* 525:544 */     List lst = null;
/* 526:    */     try
/* 527:    */     {
/* 528:546 */       lst = session.createQuery(query).setMaxResults(limit).setFirstResult(offset).list();
/* 529:    */     }
/* 530:    */     catch (RuntimeException e)
/* 531:    */     {
/* 532:550 */       e = 
/* 533:    */       
/* 534:    */ 
/* 535:    */ 
/* 536:    */ 
/* 537:    */ 
/* 538:    */ 
/* 539:557 */         e;lst = null;LOG.error(MODULE + "Exception in getListByFromClause Method:" + e, e);
/* 540:    */     }
/* 541:    */     finally {}
/* 542:558 */     return lst;
/* 543:    */   }
/* 544:    */   
/* 545:    */   public String getJsonPageData(int pageNo, int offset, String sortColumn, String sortOrder)
/* 546:    */   {
/* 547:564 */     LOG.debug(MODULE + "Reached here for getting json response.");
/* 548:    */     
/* 549:    */ 
/* 550:567 */     int beginIndex = (pageNo - 1) * offset;
/* 551:568 */     int totalRecods = count();
/* 552:569 */     int totalPages = totalRecods / offset;
/* 553:570 */     LOG.debug(MODULE + "pageNo:" + pageNo + ":" + totalRecods + ":" + totalPages + ":" + totalRecods % offset);
/* 554:572 */     if (totalPages == 0) {
/* 555:573 */       totalPages = 1;
/* 556:    */     } else {
/* 557:575 */       totalPages = totalRecods / offset + (totalRecods % offset != 0 ? 1 : 0);
/* 558:    */     }
/* 559:578 */     LOG.debug(MODULE + "OFFSET : " + offset);
/* 560:579 */     LOG.debug(MODULE + "TOTAL RECORDS : " + totalRecods);
/* 561:580 */     LOG.debug(MODULE + "TOTAL PAGES : " + totalPages);
/* 562:581 */     LOG.debug(MODULE + "CURRENT PAGE : " + pageNo);
/* 563:    */     
/* 564:583 */     List<DomainObject> listByPage = getListByPage(sortColumn, sortOrder, offset, beginIndex);
/* 565:584 */     int totalSize = listByPage != null ? listByPage.size() : 0;
/* 566:    */     
/* 567:586 */     LOG.debug(MODULE + "TOTAL RECORDS : " + (offset > totalSize ? totalSize : offset));
/* 568:    */     
/* 569:    */ 
/* 570:    */ 
/* 571:590 */     String parse = "";
/* 572:591 */     return parse;
/* 573:    */   }
/* 574:    */   
/* 575:    */   public String getJson(int pageNo, int offset, String sortColumn, String sortOrder, List<DomainObject> list)
/* 576:    */   {
/* 577:596 */     LOG.debug(MODULE + "Reached here for getting json response.");
/* 578:    */     
/* 579:    */ 
/* 580:599 */     int beginIndex = (pageNo - 1) * offset;
/* 581:600 */     int totalRecods = count();
/* 582:601 */     int totalPages = totalRecods / offset;
/* 583:602 */     LOG.debug(MODULE + "pageNo:" + pageNo + ":" + totalRecods + ":" + totalPages + ":" + totalRecods % offset);
/* 584:604 */     if (totalPages == 0) {
/* 585:605 */       totalPages = 1;
/* 586:    */     } else {
/* 587:607 */       totalPages = totalRecods / offset + (totalRecods % offset != 0 ? 1 : 0);
/* 588:    */     }
/* 589:610 */     LOG.debug(MODULE + "OFFSET : " + offset);
/* 590:611 */     LOG.debug(MODULE + "TOTAL RECORDS : " + totalRecods);
/* 591:612 */     LOG.debug(MODULE + "TOTAL PAGES : " + totalPages);
/* 592:613 */     LOG.debug(MODULE + "CURRENT PAGE : " + pageNo);
/* 593:    */     
/* 594:    */ 
/* 595:616 */     int totalSize = list != null ? list.size() : 0;
/* 596:    */     
/* 597:618 */     LOG.debug(MODULE + "TOTAL RECORDS : " + (offset > totalSize ? totalSize : offset));
/* 598:    */     
/* 599:    */ 
/* 600:    */ 
/* 601:622 */     String parse = "";
/* 602:623 */     return parse;
/* 603:    */   }
/* 604:    */   
/* 605:    */   public List getListByHQLQuery(String hql, int totalrows, int firstrow)
/* 606:    */   {
/* 607:633 */     Session session = getSession();
/* 608:634 */     List lst = null;
/* 609:    */     try
/* 610:    */     {
/* 611:636 */       lst = session.createQuery(hql).setMaxResults(totalrows).setFirstResult(firstrow).list();
/* 612:    */     }
/* 613:    */     catch (RuntimeException e)
/* 614:    */     {
/* 615:637 */       e = 
/* 616:    */       
/* 617:    */ 
/* 618:    */ 
/* 619:    */ 
/* 620:    */ 
/* 621:    */ 
/* 622:644 */         e;lst = null;LOG.error(MODULE + "Exception in getListByHQLQuery Method:" + e, e);
/* 623:    */     }
/* 624:    */     finally {}
/* 625:645 */     return lst;
/* 626:    */   }
/* 627:    */   
/* 628:    */   public String[] getQueryAlias(String hql)
/* 629:    */   {
/* 630:649 */     Session session = getSession();
/* 631:650 */     String[] retalias = null;
/* 632:    */     try
/* 633:    */     {
/* 634:652 */       retalias = session.createQuery(hql).getReturnAliases();
/* 635:    */     }
/* 636:    */     catch (RuntimeException e)
/* 637:    */     {
/* 638:653 */       e = 
/* 639:    */       
/* 640:    */ 
/* 641:    */ 
/* 642:    */ 
/* 643:    */ 
/* 644:    */ 
/* 645:660 */         e;retalias = null;LOG.error(MODULE + "Exception in getListByHQLQuery Method:" + e, e);
/* 646:    */     }
/* 647:    */     finally {}
/* 648:661 */     return retalias;
/* 649:    */   }
/* 650:    */   
/* 651:    */   public void setSession(Session session)
/* 652:    */   {
/* 653:670 */     this.session = session;
/* 654:    */   }
/* 655:    */   
/* 656:    */   protected Session getSession()
/* 657:    */   {
/* 658:679 */     if ((this.session == null) || (!this.session.isOpen()))
/* 659:    */     {
/* 660:680 */       LOG.debug("Session is null or not open...");
/* 661:681 */       return HibernateUtil.getCurrentSession();
/* 662:    */     }
/* 663:683 */     LOG.debug("Session is current...");
/* 664:684 */     return this.session;
/* 665:    */   }
/* 666:    */   
/* 667:    */   public List getRecordListByKeyandValue(String keyName, Object keyValue)
/* 668:    */   {
/* 669:695 */     DomainObject returnValue = null;
/* 670:696 */     Session session = getSession();
/* 671:697 */     List<DomainObject> lst = null;
/* 672:    */     try
/* 673:    */     {
/* 674:699 */       Criteria query = session.createCriteria(getPersistentClass()).add(Restrictions.eq(keyName, keyValue));
/* 675:700 */       lst = query.list();
/* 676:701 */       if ((lst != null) && (lst.size() > 0)) {
/* 677:702 */         return lst;
/* 678:    */       }
/* 679:    */     }
/* 680:    */     catch (HibernateException e)
/* 681:    */     {
/* 682:705 */       LOG.error(MODULE + "Exception in getRecordByKeyandValue Method:" + e, e);
/* 683:    */     }
/* 684:    */     finally
/* 685:    */     {
/* 686:707 */       if ((session != null) && (session.isOpen())) {
/* 687:708 */         session.close();
/* 688:    */       }
/* 689:    */     }
/* 690:711 */     return lst;
/* 691:    */   }
/* 692:    */   
/* 693:    */   public void flush()
/* 694:    */   {
/* 695:715 */     getSession().flush();
/* 696:    */   }
/* 697:    */   
/* 698:    */   public void clear()
/* 699:    */   {
/* 700:719 */     getSession().clear();
/* 701:    */   }
/* 702:    */   
/* 703:    */   public void insertOrUpdate(DomainObject object)
/* 704:    */   {
/* 705:723 */     Session session = getSession();
/* 706:724 */     Transaction tx = null;
/* 707:    */     try
/* 708:    */     {
/* 709:726 */       tx = session.beginTransaction();
/* 710:727 */       session.saveOrUpdate(object);
/* 711:728 */       tx.commit();
/* 712:    */     }
/* 713:    */     catch (RuntimeException e)
/* 714:    */     {
/* 715:730 */       LOG.error(MODULE + "Exception in insert Method:" + e, e);
/* 716:731 */       if (tx != null) {
/* 717:732 */         tx.rollback();
/* 718:    */       }
/* 719:734 */       throw e;
/* 720:    */     }
/* 721:    */     finally
/* 722:    */     {
/* 723:736 */       if (session.isOpen()) {
/* 724:737 */         session.close();
/* 725:    */       }
/* 726:    */     }
/* 727:    */   }
/* 728:    */ }




/* Location:           E:\proj\WEB-INF\classes\

 * Qualified Name:     com.techshark.hibernate.base.GenericDAOImpl

 * JD-Core Version:    0.7.1

 */