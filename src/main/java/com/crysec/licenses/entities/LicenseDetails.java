package com.crysec.licenses.entities;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class LicenseDetails {

    private Double price;
    private Date initialDate;

    public LicenseDetails(Double price, Date initialDate) {
        this.price = price;
        this.initialDate = initialDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    @Override
    public String toString() {
        return "LicenseDetails{" +
                "price=" + price +
                ", initialDate=" + initialDate +
                '}';
    }
}
