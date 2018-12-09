package gr.uoa.di.m149.service;

import gr.uoa.di.m149.domain.*;
import gr.uoa.di.m149.dto.NewIncident;
import gr.uoa.di.m149.repository.*;
import gr.uoa.di.m149.tempdomain.DayRequests;
import gr.uoa.di.m149.tempdomain.TypeOfRequest;
import gr.uoa.di.m149.tempdomain.TypeTotalRequests;
import gr.uoa.di.m149.tempdomain.ZipTopRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ChicagoRequestService {

    @Autowired
    ChicagoRequestRepository chicagoRequestRepository;
    @Autowired
    AbandonedVehicleInfoRepository abandonedVehicleInfoRepository;
    @Autowired
    CurrentActivityMostRecentActionRepository currentActivityMostRecentActionRepository;
    @Autowired
    GarbageCartsInfoRepository garbageCartsInfoRepository;
    @Autowired
    GraffitiRemovalInfoRepository graffitiRemovalInfoRepository;
    @Autowired
    PotholesReportedInfoRepository potholesReportedInfoRepository;
    @Autowired
    RodentBaitingInfoRepository rodentBaitingInfoRepository;
    @Autowired
    SanitationComplaintsInfoRepository sanitationComplaintsInfoRepository;
    @Autowired
    SSARepository ssaRepository;
    @Autowired
    TreeDebrisTrimsInfoRepository treeDebrisTrimsInfoRepository;
    @Autowired
    StoredProcedureRepositoryImpl storedProcedureRepository;

    public boolean addChicagoRequest(NewIncident newIncident) {
        ChicagoRequest chicagoRequest = newIncident.getChicagoRequest();
        if(chicagoRequest == null) {
            return false;
        }
        chicagoRequest.setRequestid(getLastId() + 1);
        chicagoRequest.setCreationdate(new Timestamp(System.currentTimeMillis()));
        chicagoRequest.setServicerequestnumber("CR-" + chicagoRequest.getRequestid());
        chicagoRequest.setStatus("Open");
        chicagoRequestRepository.save(chicagoRequest);
        AbandonedVehiclesInfo abandonedVehiclesInfo = newIncident.getAbandonedVehiclesInfo();
        if(abandonedVehiclesInfo != null) {
            abandonedVehiclesInfo.setRequestid(chicagoRequest.getRequestid());
            abandonedVehicleInfoRepository.save(abandonedVehiclesInfo);
        }
        CurrentActivityMostRecentAction currentActivityMostRecentAction = newIncident.getCurrentActivityMostRecentAction();
        if(currentActivityMostRecentAction != null) {
            currentActivityMostRecentAction.setRequestid(chicagoRequest.getRequestid());
            currentActivityMostRecentActionRepository.save(currentActivityMostRecentAction);
        }
        GarbageCartsInfo garbageCartsInfo = newIncident.getGarbageCartsInfo();
        if(garbageCartsInfo != null) {
            garbageCartsInfo.setRequestid(chicagoRequest.getRequestid());
            garbageCartsInfoRepository.save(garbageCartsInfo);
        }
        GraffitiRemovalInfo graffitiRemovalInfo = newIncident.getGraffitiRemovalInfo();
        if(graffitiRemovalInfo != null) {
            graffitiRemovalInfo.setRequestid(chicagoRequest.getRequestid());
            graffitiRemovalInfoRepository.save(graffitiRemovalInfo);
        }
        PotholesReportedInfo potholesReportedInfo = newIncident.getPotholesReportedInfo();
        if(potholesReportedInfo != null) {
            potholesReportedInfo.setRequestid(chicagoRequest.getRequestid());
            potholesReportedInfoRepository.save(potholesReportedInfo);
        }
        RodentBaitingInfo rodentBaitingInfo = newIncident.getRodentBaitingInfo();
        if(rodentBaitingInfo != null) {
            rodentBaitingInfo.setRequestid(chicagoRequest.getRequestid());
            rodentBaitingInfoRepository.save(rodentBaitingInfo);
        }
        SanitationComplaintsInfo sanitationComplaintsInfo = newIncident.getSanitationComplaintsInfo();
        if(sanitationComplaintsInfo != null) {
            sanitationComplaintsInfo.setRequestid(chicagoRequest.getRequestid());
            sanitationComplaintsInfoRepository.save(sanitationComplaintsInfo);
        }
        SSA ssa = newIncident.getSsa();
        if(ssa != null) {
            ssa.setCr(chicagoRequest);
            ssaRepository.save(ssa);
        }
        TreeDebrisTrimsInfo treeDebrisTrimsInfo = newIncident.getTreeDebrisTrimsInfo();
        if(treeDebrisTrimsInfo != null) {
            treeDebrisTrimsInfo.setCr(chicagoRequest);
            treeDebrisTrimsInfoRepository.save(treeDebrisTrimsInfo);
        }
        return true;
    }

    public Iterable<ChicagoRequest> getChicagoRequests() {
        return chicagoRequestRepository.findAll();
    }

    public List<ChicagoRequest> getChicagoRequestsByZipcodeAndSteedAddress(int zipcode, String streetaddress) {
        String streetlike = new StringBuilder("%" + streetaddress + "%").toString();
        if(zipcode >= 0) {
                return chicagoRequestRepository.findAllByZipcodeAndStreetaddressLike(zipcode, streetlike);
        }
        else {
                return chicagoRequestRepository.findAllByStreetaddressLike(streetlike);
        }
    }

    public ChicagoRequest getChicagoRequestById(Integer requestid) {
        return  chicagoRequestRepository.findOne(requestid);
    }

    public List<TypeTotalRequests> getTypeTotalRequests(String from, String to) throws ParseException {
        return storedProcedureRepository.findTypeTotalRequests(from, to);
    }

    public List<DayRequests> getRequestsPerDay(String request, String from, String to) throws ParseException {
        return  storedProcedureRepository.findRequestsPerDay(request, from, to);
    }

    public List<ZipTopRequests> getTopRequestsPerZipCode(String at)  throws ParseException {
        return  storedProcedureRepository.findTopRequestsPerZipCode(at);
    }

    public List<TypeOfRequest> getTypeOfRequests() {
        List<TypeOfRequest> ret = new ArrayList<>();
        for(String type : chicagoRequestRepository.getTypeOfServiceRequests()) {
            ret.add(new TypeOfRequest(type));
        }
        return ret;
    }

    private long getLastId() {
        return chicagoRequestRepository.getLastId();
    }
}
