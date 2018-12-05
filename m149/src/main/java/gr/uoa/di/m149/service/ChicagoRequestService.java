package gr.uoa.di.m149.service;

import gr.uoa.di.m149.domain.ChicagoRequest;
import gr.uoa.di.m149.repository.StoredProcedureRepository;
import gr.uoa.di.m149.repository.StoredProcedureRepositoryImpl;
import gr.uoa.di.m149.tempdomain.DayRequests;
import gr.uoa.di.m149.tempdomain.TypeTotalRequests;
import gr.uoa.di.m149.repository.ChicagoRequestRepository;
import gr.uoa.di.m149.tempdomain.ZipTopRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.text.ParseException;
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

    public List<ChicagoRequest> getChicagoRequestsByZipcodeAndSteedAddress(int zipcode, String streetaddress, int page, int limit) {
        String streetlike = new StringBuilder("%" + streetaddress + "%").toString();
        if(zipcode >= 0) {
            if(limit != 0) {
                return repository.findAllByZipcodeAndStreetaddressLike(zipcode, streetlike, new PageRequest(page*limit, limit));
            }
            else {
                return repository.findAllByZipcodeAndStreetaddressLike(zipcode, streetlike, null);
            }
        }
        else {
            if(limit != 0) {
                return repository.findAllByStreetaddressLike(streetlike, new PageRequest(page*limit, limit));
            }
            else {
                return repository.findAllByStreetaddressLike(streetlike, null);
            }
        }
    }

    public ChicagoRequest getChicagoRequestById(Integer requestid) {
        return  repository.findOne(requestid);
    }

    public List<TypeTotalRequests> getTypeTotalRequests(String from, String to, int page, int limit) throws ParseException {
        return storedProcedureRepository.findTypeTotalRequests(from, to, page, limit);
    }

    public List<DayRequests> getRequestsPerDay(String request, String from, String to, int page, int limit) throws ParseException {
        return  storedProcedureRepository.findRequestsPerDay(request, from, to, page, limit);
    }

    public List<ZipTopRequests> getTopRequestsPerZipCode(String at, int page, int limit)  throws ParseException {
        return  storedProcedureRepository.findTopRequestsPerZipCode(at, page, limit);
    }

}
