package com.meutesouro.entity;

import java.sql.Date;

/**
 * Títulos Publicos
 * 
 */
public class MoneyTitle {

	private String mName;
	private Date mExpiredDate;
	private TitleTax  mCurrentTitleTax;
	private TitleTax mAnualTitleTax;
	
	public String getName() {
		return mName;
	}
	public void setName(String name) {
		this.mName = name;
	}
	public Date getExpiredDate() {
		return mExpiredDate;
	}
	public void setExpiredDate(Date expiredDate) {
		this.mExpiredDate = expiredDate;
	}
	public TitleTax getCurrentTitleTax() {
		return mCurrentTitleTax;
	}
	public void setCurrentTitleTax(TitleTax currentTitleTax) {
		this.mCurrentTitleTax = currentTitleTax;
	}
	public TitleTax getAnualTitleTax() {
		return mAnualTitleTax;
	}
	public void setAnualTitleTax(TitleTax anualTitleTax) {
		this.mAnualTitleTax = anualTitleTax;
	}
	
}
