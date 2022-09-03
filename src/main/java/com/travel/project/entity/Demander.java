package com.travel.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "demander")
public class Demander {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "sicil_no")
  private String sicilNo;

  @Column(name = "isim")
  private String isim;

  @Column(name = "bas_tarih")
  private String basTarih;

  @Column(name = "son_tarih")
  private String sonTarih;

  @Column(name = "istikamet")
  private String istikamet;

  @Column(name = "tahmini_masraf")
  private String tahminiMasraf;

  public Demander() {}

  public Demander(
      Integer id,
      String sicilNo,
      String isim,
      String basTarih,
      String sonTarih,
      String istikamet,
      String tahminiMasraf) {
    this.id = id;
    this.sicilNo = sicilNo;
    this.isim = isim;
    this.basTarih = basTarih;
    this.sonTarih = sonTarih;
    this.istikamet = istikamet;
    this.tahminiMasraf = tahminiMasraf;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSicilNo() {
    return sicilNo;
  }

  public void setSicilNo(String sicilNo) {
    this.sicilNo = sicilNo;
  }

  public String getIsim() {
    return isim;
  }

  public void setIsim(String isim) {
    this.isim = isim;
  }

  public String getBasTarih() {
    return basTarih;
  }

  public void setBasTarih(String basTarih) {
    this.basTarih = basTarih;
  }

  public String getSonTarih() {
    return sonTarih;
  }

  public void setSonTarih(String sonTarih) {
    this.sonTarih = sonTarih;
  }

  public String getIstikamet() {
    return istikamet;
  }

  public void setIstikamet(String istikamet) {
    this.istikamet = istikamet;
  }

  public String getTahminiMasraf() {
    return tahminiMasraf;
  }

  public void setTahminiMasraf(String tahminiMasraf) {
    this.tahminiMasraf = tahminiMasraf;
  }

  @Override
  public String toString() {
    return "Id: "
        + id
        + "Sicil No: "
        + sicilNo
        + "Isim: "
        + isim
        + "Baslangic Tarihi: "
        + basTarih
        + "Bitis Tarihi: "
        + sonTarih
        + "Istikamet: "
        + istikamet
        + "Tahmini Masraf: "
        + tahminiMasraf;
  }
}
