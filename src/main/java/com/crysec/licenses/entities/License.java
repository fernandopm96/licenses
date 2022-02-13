package com.crysec.licenses.entities;

import javax.persistence.*;

@Entity
public class License {

    @Id
    @GeneratedValue
    private Long licenseId;
    private String name; // Nombre de la licencia
    private Role role; // Rol que se aplica
    @Embedded
    private LicenseDetails licenseDetails; // Detalles de licencia

    public License(){

    }

    public License(String name, Role role, LicenseDetails licenseDetails) {
        this.name = name;
        this.role = role;
        this.licenseDetails = licenseDetails;
    }

    public Long getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LicenseDetails getLicenseDetails() {
        return licenseDetails;
    }

    public void setLicenseDetails(LicenseDetails licenseDetails) {
        this.licenseDetails = licenseDetails;
    }

    @Override
    public String toString() {
        return "License{" +
                "licenseId=" + licenseId +
                ", name='" + name + '\'' +
                ", licenseDetails=" + licenseDetails +
                '}';
    }
}
