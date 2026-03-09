package com.gabriel.emplms.transform;

import com.gabriel.emplms.entity.ServiceData;

import org.springframework.stereotype.Service;

@Service
public class TransformServiceServiceImpl implements TransformServiceService {

    @Override
    public ServiceData transform(com.gabriel.emplms.model.Service service) {
        ServiceData serviceData = new ServiceData();
        
        serviceData.setServiceId(service.getServiceId());
        serviceData.setServiceName(service.getServiceName());
        serviceData.setPrice(service.getPrice());
        return serviceData;
    }

     @Override
    public com.gabriel.emplms.model.Service transform(ServiceData serviceData) {
        com.gabriel.emplms.model.Service service = new com.gabriel.emplms.model.Service();
        
        service.setServiceId(serviceData.getServiceId());
        service.setServiceName(serviceData.getServiceName());
        service.setPrice(serviceData.getPrice());
        return service;
    }
}