package gr.uoa.di.m149.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="chicago_requests", schema = "public")
public class ChicagoRequest {

    @Transient
    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int requestid;
    Date creationdate;
    String status;
    Date completiondate;
    String servicerequestnumber;
    String typeofservicerequest;
    String streetaddress;
    int zipcode;
    BigDecimal xcoordinate;
    BigDecimal ycoordinate;
    int ward;
    int policedistrict;
    int communityarea;
    BigDecimal latitude;
    BigDecimal longitude;
    String location;

    public int getRequestid() {
        return requestid;
    }

    public void setRequestid(int requestid) {
        this.requestid = requestid;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    @Transient
    public String getCreationdateFormatted() {
        return df.format(creationdate);
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCompletiondate() {
        return completiondate;
    }

    @Transient
    public String getCompletiondateFormatted() {
        return df.format(completiondate);
    }

    public void setCompletiondate(Date completiondate) {
        this.completiondate = completiondate;
    }

    public String getServicerequestnumber() {
        return servicerequestnumber;
    }

    public void setServicerequestnumber(String servicerequestnumber) {
        this.servicerequestnumber = servicerequestnumber;
    }

    public String getTypeofservicerequest() {
        return typeofservicerequest;
    }

    public void setTypeofservicerequest(String typeofservicerequest) {
        this.typeofservicerequest = typeofservicerequest;
    }

    public String getStreetaddress() {
        return streetaddress;
    }

    public void setStreetaddress(String streetaddress) {
        this.streetaddress = streetaddress;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public BigDecimal getXcoordinate() {
        return xcoordinate;
    }

    public void setXcoordinate(BigDecimal xcoordinate) {
        this.xcoordinate = xcoordinate;
    }

    public BigDecimal getYcoordinate() {
        return ycoordinate;
    }

    public void setYcoordinate(BigDecimal ycoordinate) {
        this.ycoordinate = ycoordinate;
    }

    public int getWard() {
        return ward;
    }

    public void setWard(int ward) {
        this.ward = ward;
    }

    public int getPolicedistrict() {
        return policedistrict;
    }

    public void setPolicedistrict(int policedistrict) {
        this.policedistrict = policedistrict;
    }

    public int getCommunityarea() {
        return communityarea;
    }

    public void setCommunityarea(int communityarea) {
        this.communityarea = communityarea;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
