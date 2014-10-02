package com.tss.ocean.service;

import org.springframework.transaction.annotation.Transactional;

public abstract interface IACLEntiyService
{
  @Transactional
  public abstract int assignACL(int paramInt1, int paramInt2, String paramString, int paramInt3);
  
  @Transactional
  public abstract void revokeACL(int paramInt1, int paramInt2, String paramString);
  
  @Transactional
  public abstract void revokeAllACL(int paramInt1, int paramInt2);
  
  @Transactional
  public abstract void revokeAllACL(String paramString);
  
  public abstract boolean hasACL(int paramInt1, int paramInt2, String paramString, int paramInt3);
}


/* Location:           C:\Users\Raz\Desktop\InvMgmt\WEB-INF\classes\
 * Qualified Name:     com.tss.ocean.service.IACLEntiyService
 * JD-Core Version:    0.7.1
 */