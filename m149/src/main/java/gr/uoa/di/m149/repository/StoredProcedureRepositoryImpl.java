package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.tempdomain.DayRequests;
import gr.uoa.di.m149.tempdomain.TypeTotalRequests;
import gr.uoa.di.m149.tempdomain.ZipTopRequests;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class StoredProcedureRepositoryImpl implements StoredProcedureRepository{

    private final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private final DateFormat df2 = new SimpleDateFormat("hh:mm:ss");

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<TypeTotalRequests> findTypeTotalRequests(String from, String to) throws ParseException {
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

    @Override
    public List<DayRequests> findRequestsPerDay(String request, String from, String to) throws ParseException {
        Time startTime = new Time(df2.parse(from).getTime());
        Time endTime = new Time(df2.parse(to).getTime());
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

    @Override
    public List<ZipTopRequests> findTopRequestsPerZipCode(String at)  throws ParseException {
        Date atDate = df.parse(at);
        StoredProcedureQuery query = manager.createStoredProcedureQuery("topRequestPerZipCode");
        query.registerStoredProcedureParameter("atDate", java.sql.Date.class, ParameterMode.IN);
        query.setParameter("atDate", atDate, TemporalType.DATE);
        query.execute();
        List<ZipTopRequests> ret = (List<ZipTopRequests>) query.getResultList();
        return ret;
    }
}
