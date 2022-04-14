package com.id.bni.co.bankzulfikar.domain;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK_JAVA")
public class Nasabah {

  @Id
  @Column(name = "NO_KTP")
  private String noKtp;

  @Column(name = "NAMA")
  private String nama;

  @Column(name = "ALAMAT")
  private String alamat;

  @Column(name = "NO_HP")
  private String noHp;

  @Column(name = "JENIS_KELAMIN")
  private String jenisKelamin;

  @Column(name = "KEY_GET")
  private String keyGet;


  public String getNoKtp() {
    return noKtp;
  }

  public void setNoKtp(String noKtp) {
    this.noKtp = noKtp;
  }


  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }


  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }


  public String getNoHp() {
    return noHp;
  }

  public void setNoHp(String noHp) {
    this.noHp = noHp;
  }


  public String getJenisKelamin() {
    return jenisKelamin;
  }

  public void setJenisKelamin(String jenisKelamin) {
    this.jenisKelamin = jenisKelamin;
  }


  public String getKeyGet() {
    return keyGet;
  }

  public void setKeyGet(String keyGet) {
    this.keyGet = keyGet;
  }

}
