package com.h5180054.selim_asik_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SaatModel {
    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("Yil")
    @Expose
    private String yil;
    @SerializedName("KasaCapi")
    @Expose
    private String kasaCapi;
    @SerializedName("CamTipi")
    @Expose
    private String camTipi;
    @SerializedName("Mekanizma")
    @Expose
    private String mekanizma;
    @SerializedName("KordonMalzemesi")
    @Expose
    private String kordonMalzemesi;
    @SerializedName("SaatTarzi")
    @Expose
    private String saatTarzi;
    @SerializedName("Fiyat")
    @Expose
    private String fiyat;
    @SerializedName("GreyMarketFiyati")
    @Expose
    private String greyMarketFiyati;
    @SerializedName("BannerUrl")
    @Expose
    private String bannerUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("SaatDetayi")
    @Expose
    private String saatDetayi;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYil() {
        return yil;
    }

    public void setYil(String yil) {
        this.yil = yil;
    }

    public String getKasaCapi() {
        return kasaCapi;
    }

    public void setKasaCapi(String kasaCapi) {
        this.kasaCapi = kasaCapi;
    }

    public String getCamTipi() {
        return camTipi;
    }

    public void setCamTipi(String camTipi) {
        this.camTipi = camTipi;
    }

    public String getMekanizma() {
        return mekanizma;
    }

    public void setMekanizma(String mekanizma) {
        this.mekanizma = mekanizma;
    }

    public String getKordonMalzemesi() {
        return kordonMalzemesi;
    }

    public void setKordonMalzemesi(String kordonMalzemesi) {
        this.kordonMalzemesi = kordonMalzemesi;
    }

    public String getSaatTarzi() {
        return saatTarzi;
    }

    public void setSaatTarzi(String saatTarzi) {
        this.saatTarzi = saatTarzi;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getGreyMarketFiyati() {
        return greyMarketFiyati;
    }

    public void setGreyMarketFiyati(String greyMarketFiyati) {
        this.greyMarketFiyati = greyMarketFiyati;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getSaatDetayi() {
        return saatDetayi;
    }

    public void setSaatDetayi(String saatDetayi) {
        this.saatDetayi = saatDetayi;
    }
}
