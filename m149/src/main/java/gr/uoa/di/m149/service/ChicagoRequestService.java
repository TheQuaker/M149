package gr.uoa.di.m149.service;

import gr.uoa.di.m149.domain.ChicagoRequest;
import gr.uoa.di.m149.tempdomain.DayRequests;
import gr.uoa.di.m149.tempdomain.TypeTotalRequests;
import gr.uoa.di.m149.repository.ChicagoRequestRepository;
import gr.uoa.di.m149.tempdomain.ZipTopRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class ChicagoRequestService {

    @Autowired
    ChicagoRequestRepository repository;

    @PersistenceContext
    EntityManager manager;

    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private final DateFormat df2 = new SimpleDateFormat("hh:mm:ss");

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
        StoredProcedureQuery query = manager.createStoredProcedureQuery("totalRequestsPerType");
        query.registerStoredProcedureParameter("fromDate", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("toDate", Date.class, ParameterMode.IN);
        query.setParameter("fromDate", fromDate, TemporalType.DATE);
        query.setParameter("toDate", toDate, TemporalType.DATE);
        query.execute();
        List<TypeTotalRequests> ret = (List<TypeTotalRequests>) query.getResultList();
        return ret;
    }

    public List<DayRequests> getRequestsPerDay(String request, String from, String to) throws ParseException {
        Time startTime = new Time(df.parse(from).getTime());
        Time endTime = new Time(df.parse(to).getTime());
        StoredProcedureQuery query = manager.createStoredProcedureQuery("requestsPerDay");
        query.registerStoredProcedureParameter("request", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("startTime", Time.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("endTime", Time.class, ParameterMode.IN);
        query.setParameter("request", request);
        query.setParameter("startTime", startTime);
        query.setParameter("endTime", endTime);
        query.execute();
        List<DayRequests> ret = (List<DayRequests>) query.getResultList();
        return ret;
    }

    public List<ZipTopRequests> getTopRequestsPerZipCode(String at) throws ParseException {
        Date atDate = df.parse(at);
        StoredProcedureQuery query = manager.createStoredProcedureQuery("topRequestPerZipCode");
        query.registerStoredProcedureParameter("atDate", java.sql.Date.class, ParameterMode.IN);
        query.setParameter("atDate", atDate, TemporalType.DATE);
        query.execute();
        List<ZipTopRequests> ret = (List<ZipTopRequests>) query.getResultList();
        return ret;
    }
}
