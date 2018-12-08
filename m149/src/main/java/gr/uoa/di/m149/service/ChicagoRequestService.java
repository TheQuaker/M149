package gr.uoa.di.m149.service;

import gr.uoa.di.m149.domain.ChicagoRequest;
import gr.uoa.di.m149.repository.StoredProcedureRepository;
import gr.uoa.di.m149.repository.StoredProcedureRepositoryImpl;
import gr.uoa.di.m149.tempdomain.DayRequests;
import gr.uoa.di.m149.tempdomain.TypeOfRequest;
import gr.uoa.di.m149.tempdomain.TypeTotalRequests;
import gr.uoa.di.m149.repository.ChicagoRequestRepository;
import gr.uoa.di.m149.tempdomain.ZipTopRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Service
public class ChicagoRequestService {

    @Autowired
    ChicagoRequestRepository repository;

    @Autowired
    StoredProcedureRepositoryImpl storedProcedureRepository;

    public ChicagoRequest addChicagoRequest(ChicagoRequest cr) {
        repository.save(cr);
        return cr;
    }

    public Iterable<ChicagoRequest> getChicagoRequests() {
        return repository.findAll();
    }

    public List<ChicagoRequest> getChicagoRequestsByZipcodeAndSteedAddress(int zipcode, String streetaddress) {
        String streetlike = new StringBuilder("%" + streetaddress + "%").toString();
        if(zipcode >= 0) {
                return repository.findAllByZipcodeAndStreetaddressLike(zipcode, streetlike);
        }
        else {
                return repository.findAllByStreetaddressLike(streetlike);
        }
    }

    public ChicagoRequest getChicagoRequestById(Integer requestid) {
        return  repository.findOne(requestid);
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
        for(String type : repository.getTypeOfServiceRequests()) {
            ret.add(new TypeOfRequest(type));
        }
        return ret;
    }

}
