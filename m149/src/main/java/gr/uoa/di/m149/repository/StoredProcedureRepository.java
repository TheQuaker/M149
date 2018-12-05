package gr.uoa.di.m149.repository;

import gr.uoa.di.m149.tempdomain.DayRequests;
import gr.uoa.di.m149.tempdomain.TypeTotalRequests;
import gr.uoa.di.m149.tempdomain.ZipTopRequests;
import java.text.ParseException;
import java.util.List;


public interface StoredProcedureRepository {

    public List<TypeTotalRequests> findTypeTotalRequests(String from, String to, int page, int limit) throws ParseException;
    public List<DayRequests> findRequestsPerDay(String request, String from, String to, int page, int limit) throws ParseException;
    public List<ZipTopRequests> findTopRequestsPerZipCode(String at, int page, int limit) throws ParseException;
}
