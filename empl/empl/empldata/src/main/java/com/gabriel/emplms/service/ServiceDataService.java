package com.gabriel.emplms.service;

import com.gabriel.emplms.entity.ServiceData;
import java.util.List;

public interface ServiceDataService {
    List<ServiceData> getAllServices() throws Exception;
    ServiceData getService(Integer serviceId) throws Exception;
    ServiceData createService(ServiceData service) throws Exception;
    ServiceData updateService(ServiceData service) throws Exception;
    void deleteService(Integer serviceId) throws Exception;
}