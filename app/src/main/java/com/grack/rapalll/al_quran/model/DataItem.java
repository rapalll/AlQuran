package com.grack.rapalll.al_quran.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DataItem {

	@SerializedName("number")
	private int number;

	@SerializedName("englishName")
	private String englishName;

	@SerializedName("numberOfAyahs")
	private int numberOfAyahs;

	@SerializedName("revelationType")
	private String revelationType;

	@SerializedName("name")
	private String name;

	@SerializedName("edition")
	private Edition edition;

	@SerializedName("ayahs")
	private List<AyahsItem> ayahs;

	@SerializedName("englishNameTranslation")
	private String englishNameTranslation;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public int getNumberOfAyahs() {
		return numberOfAyahs;
	}

	public void setNumberOfAyahs(int numberOfAyahs) {
		this.numberOfAyahs = numberOfAyahs;
	}

	public String getRevelationType() {
		return revelationType;
	}

	public void setRevelationType(String revelationType) {
		this.revelationType = revelationType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	public List<AyahsItem> getAyahs() {
		return ayahs;
	}

	public void setAyahs(List<AyahsItem> ayahs) {
		this.ayahs = ayahs;
	}

	public String getEnglishNameTranslation() {
		return englishNameTranslation;
	}

	public void setEnglishNameTranslation(String englishNameTranslation) {
		this.englishNameTranslation = englishNameTranslation;
	}

	@Override
	public String toString() {
		return
				"DataItem{" +
						"number = '" + number + '\'' +
						",englishName = '" + englishName + '\'' +
						",numberOfAyahs = '" + numberOfAyahs + '\'' +
						",revelationType = '" + revelationType + '\'' +
						",name = '" + name + '\'' +
						",edition = '" + edition + '\'' +
						",ayahs = '" + ayahs + '\'' +
						",englishNameTranslation = '" + englishNameTranslation + '\'' +
						"}";
	}
}