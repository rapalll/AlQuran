package com.grack.rapalll.al_quran.model.models;


import com.google.gson.annotations.SerializedName;

public class Edition {

  @SerializedName("identifier")
  private String identifier;

  @SerializedName("englishName")
  private String englishName;

  @SerializedName("name")
  private String name;

  @SerializedName("format")
  private String format;

  @SerializedName("language")
  private String language;

  @SerializedName("type")
  private String type;

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public String getEnglishName() {
    return englishName;
  }

  public void setEnglishName(String englishName) {
    this.englishName = englishName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return
        "Edition{" +
            "identifier = '" + identifier + '\'' +
            ",englishName = '" + englishName + '\'' +
            ",name = '" + name + '\'' +
            ",format = '" + format + '\'' +
            ",language = '" + language + '\'' +
            ",type = '" + type + '\'' +
            "}";
  }
}