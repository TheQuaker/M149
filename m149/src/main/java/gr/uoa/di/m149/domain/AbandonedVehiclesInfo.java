package gr.uoa.di.m149.domain;

import javax.persistence.*;

@Entity
@Table(name = "abandoned_vehicles_info")
public class AbandonedVehiclesInfo {

    @Id
    private long requestid;
    private String licenseplate;
    private String vehiclemakemodel;
    private String vehiclecolor;
    private double daysparked;

    @OneToOne
    @JoinColumn(name = "requestid")
    @MapsId
    private ChicagoRequest cr;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
        this.requestid = requestid;
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate;
    }

    public String getVehiclemakemodel() {
        return vehiclemakemodel;
    }

    public void setVehiclemakemodel(String vehiclemakemodel) {
        this.vehiclemakemodel = vehiclemakemodel;
    }

    public String getVehiclecolor() {
        return vehiclecolor;
    }

    public void setVehiclecolor(String vehiclecolor) {
        this.vehiclecolor = vehiclecolor;
    }

    public double getDaysparked() {
        return daysparked;
    }

    public void setDaysparked(double daysparked) {
        this.daysparked = daysparked;
    }

    public ChicagoRequest getCr() {
        return cr;
    }

    public void setCr(ChicagoRequest cr) {
        this.cr = cr;
    }
}
