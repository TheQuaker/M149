package gr.uoa.di.m149.service;

import gr.uoa.di.m149.domain.ChicagoRequest;
import gr.uoa.di.m149.domain.TypeTotalRequests;
import gr.uoa.di.m149.repository.ChicagoRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


@Service
public class ChicagoRequestService {

    @Autowired
    ChicagoRequestRepository repository;

    @PersistenceContext
    EntityManager manager;

    private final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public ChicagoRequest addChicagoRequest(ChicagoRequest cr) {
        repository.save(cr);
        return cr;
    }

    public Iterable<ChicagoRequest> getChicagoRequests() {
        return repository.findAll();
    }

    public ChicagoRequest getChicagoRequestById(Integer requestid) {
        return  repository.findOne(requestid);
    }

    public List<TypeTotalRequests> getTypeTotalRequests(String from, String to) throws ParseException {
        java.util.Date fromDate = df.parse(from);
        java.util.Date toDate = df.parse(to);
        StringBuilder sql = new StringBuilder("select totalRequestsPerType(:fromDate,:toDate)");
        StoredProcedureQuery query = manager.createStoredProcedureQuery("totalRequestsPerType", "TypeTotalRequestsMapping");
        query.registerStoredProcedureParameter("fromDate", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("toDate", Date.class, ParameterMode.IN);
        query.setParameter("fromDate", fromDate, TemporalType.DATE);
        query.setParameter("toDate", toDate, TemporalType.DATE);
        query.execute();
        List<TypeTotalRequests> ret = (List<TypeTotalRequests>) query.getResultList();
        return ret;
    }
}
