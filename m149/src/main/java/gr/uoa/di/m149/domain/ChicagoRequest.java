package gr.uoa.di.m149.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "chicago_requests")
public class ChicagoRequest {

    @Transient
    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Id
    private long requestid;
    private Timestamp creationdate;
    private String status;
    private Timestamp completiondate;
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

    public Timestamp getCreationdate() {
        return creationdate;
    }

    @Transient
    public String getCreationdateFormatted() {
        if(creationdate != null) {
            return df.format(creationdate);
        }
        else return null;
    }

    public void setCreationdate(Timestamp creationdate) {
        this.creationdate = creationdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCompletiondate() {
        return completiondate;
    }

    @Transient
    public String getCompletiondateFormatted() {
        if(completiondate != null) {
            return df.format(completiondate);
        }
        else return null;
    }

    public void setCompletiondate(Timestamp completiondate) {
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

    public Integer getZipcode() {
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

    public Integer getWard() {
        return ward;
    }

    public void setWard(Integer ward) {
        this.ward = ward;
    }

    public Integer getPolicedistrict() {
        return policedistrict;
    }

    public void setPolicedistrict(Integer policedistrict) {
        this.policedistrict = policedistrict;
}

    public Integer getCommunityarea() {
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
