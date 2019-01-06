package com.grack.rapalll.al_quran.model.models;

import com.google.gson.annotations.SerializedName;

public class AyahsItem{

	@SerializedName("number")
	private int number;

	@SerializedName("hizbQuarter")
	private int hizbQuarter;

	@SerializedName("ruku")
	private int ruku;

	@SerializedName("manzil")
	private int manzil;

	@SerializedName("text")
	private String text;

	@SerializedName("page")
	private int page;

	@SerializedName("sajda")
	private boolean sajda;

	@SerializedName("numberInSurah")
	private int numberInSurah;

	@SerializedName("juz")
	private int juz;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setHizbQuarter(int hizbQuarter){
		this.hizbQuarter = hizbQuarter;
	}

	public int getHizbQuarter(){
		return hizbQuarter;
	}

	public void setRuku(int ruku){
		this.ruku = ruku;
	}

	public int getRuku(){
		return ruku;
	}

	public void setManzil(int manzil){
		this.manzil = manzil;
	}

	public int getManzil(){
		return manzil;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setSajda(boolean sajda){
		this.sajda = sajda;
	}

	public boolean isSajda(){
		return sajda;
	}

	public void setNumberInSurah(int numberInSurah){
		this.numberInSurah = numberInSurah;
	}

	public int getNumberInSurah(){
		return numberInSurah;
	}

	public void setJuz(int juz){
		this.juz = juz;
	}

	public int getJuz(){
		return juz;
	}

	@Override
 	public String toString(){
		return 
			"AyahsItem{" + 
			"number = '" + number + '\'' + 
			",hizbQuarter = '" + hizbQuarter + '\'' + 
			",ruku = '" + ruku + '\'' + 
			",manzil = '" + manzil + '\'' + 
			",text = '" + text + '\'' + 
			",page = '" + page + '\'' + 
			",sajda = '" + sajda + '\'' + 
			",numberInSurah = '" + numberInSurah + '\'' + 
			",juz = '" + juz + '\'' + 
			"}";
		}
}