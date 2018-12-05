package gr.uoa.di.m149.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "chicago_requests")
public class ChicagoRequest {

    @Transient
    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long requestid;
    private Date creationdate;
    private String status;
    private Date completiondate;
    private String servicerequestnumber;
    private String typeofservicerequest;
    private String streetaddress;
    private Integer zipcode;
    private BigDecimal xcoordinate;
    private BigDecimal ycoordinate;
    private Integer ward;
    private Integer policedistrict;
    private Integer communityarea;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String location;

    public long getRequestid() {
        return requestid;
    }

    public void setRequestid(long requestid) {
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

    public void setZipcode(Integer zipcode) {
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

    public void setWard(Integer ward) {
        this.ward = ward;
    }

    public int getPolicedistrict() {
        return policedistrict;
    }

    public void setPolicedistrict(Integer policedistrict) {
        this.policedistrict = policedistrict;
}

    public int getCommunityarea() {
        return communityarea;
    }

    public void setCommunityarea(Integer communityarea) {
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
