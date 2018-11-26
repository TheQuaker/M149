package gr.uoa.di.m149.service;

import gr.uoa.di.m149.domain.ChicagoRequest;
import gr.uoa.di.m149.repository.ChicagoRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChicagoRequestService {

    @Autowired
    ChicagoRequestRepository repository;

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
}
