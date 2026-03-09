package com.gabriel.emplms.service;

import com.gabriel.emplms.model.Service;

public interface ServiceDataService {
    Service[] getAllService() throws Exception;
    Service getService(Integer serviceId) throws Exception;
    Service createService(Service service) throws Exception;
    Service updateService(Service service) throws Exception;
    void deleteService(Integer serviceId) throws Exception;
}