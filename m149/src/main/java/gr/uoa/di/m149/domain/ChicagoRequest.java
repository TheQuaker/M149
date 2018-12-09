package gr.uoa.di.m149.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "cr")
    @JsonIgnore
    private AbandonedVehiclesInfo abandonedVehiclesInfo;
    @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "cr")
    @JsonIgnore
    private CurrentActivityMostRecentAction currentActivityMostRecentAction;
    @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "cr")
    @JsonIgnore
    private GarbageCartsInfo garbageCartsInfo;
    @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "cr")
    @JsonIgnore
    private GraffitiRemovalInfo graffitiRemovalInfo;
    @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "cr")
    @JsonIgnore
    private PotholesReportedInfo potholesReportedInfo;
    @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "cr")
    @JsonIgnore
    private RodentBaitingInfo rodentBaitingInfo;
    @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "cr")
    @JsonIgnore
    private SanitationComplaintsInfo sanitationComplaintsInfo;
    @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "cr")
    @JsonIgnore
    private SSA ssa;
    @OneToOne(fetch = FetchType.LAZY, optional = true, mappedBy = "cr")
    @JsonIgnore
    TreeDebrisTrimsInfo treeDebrisTrimsInfo;

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

    public AbandonedVehiclesInfo getAbandonedVehiclesInfo() {
        return abandonedVehiclesInfo;
    }

    public void setAbandonedVehiclesInfo(AbandonedVehiclesInfo abandonedVehiclesInfo) {
        this.abandonedVehiclesInfo = abandonedVehiclesInfo;
    }

    public CurrentActivityMostRecentAction getCurrentActivityMostRecentAction() {
        return currentActivityMostRecentAction;
    }

    public void setCurrentActivityMostRecentAction(CurrentActivityMostRecentAction currentActivityMostRecentAction) {
        this.currentActivityMostRecentAction = currentActivityMostRecentAction;
    }

    public GarbageCartsInfo getGarbageCartsInfo() {
        return garbageCartsInfo;
    }

    public void setGarbageCartsInfo(GarbageCartsInfo garbageCartsInfo) {
        this.garbageCartsInfo = garbageCartsInfo;
    }

    public GraffitiRemovalInfo getGraffitiRemovalInfo() {
        return graffitiRemovalInfo;
    }

    public void setGraffitiRemovalInfo(GraffitiRemovalInfo graffitiRemovalInfo) {
        this.graffitiRemovalInfo = graffitiRemovalInfo;
    }

    public PotholesReportedInfo getPotholesReportedInfo() {
        return potholesReportedInfo;
    }

    public void setPotholesReportedInfo(PotholesReportedInfo potholesReportedInfo) {
        this.potholesReportedInfo = potholesReportedInfo;
    }

    public RodentBaitingInfo getRodentBaitingInfo() {
        return rodentBaitingInfo;
    }

    public void setRodentBaitingInfo(RodentBaitingInfo rodentBaitingInfo) {
        this.rodentBaitingInfo = rodentBaitingInfo;
    }

    public SanitationComplaintsInfo getSanitationComplaintsInfo() {
        return sanitationComplaintsInfo;
    }

    public void setSanitationComplaintsInfo(SanitationComplaintsInfo sanitationComplaintsInfo) {
        this.sanitationComplaintsInfo = sanitationComplaintsInfo;
    }

    public SSA getSsa() {
        return ssa;
    }

    public void setSsa(SSA ssa) {
        this.ssa = ssa;
    }

    public TreeDebrisTrimsInfo getTreeDebrisTrimsInfo() {
        return treeDebrisTrimsInfo;
    }

    public void setTreeDebrisTrimsInfo(TreeDebrisTrimsInfo treeDebrisTrimsInfo) {
        this.treeDebrisTrimsInfo = treeDebrisTrimsInfo;
    }
}
