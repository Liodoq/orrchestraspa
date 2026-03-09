package com.gabriel.emplms.serviceimpl;

import com.gabriel.emplms.entity.ServiceData;
import com.gabriel.emplms.model.Service;
import com.gabriel.emplms.repository.ServiceDataRepository;
import com.gabriel.emplms.service.ServiceDataService;
import com.gabriel.emplms.transform.TransformServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceDataService {
    Logger logger = LoggerFactory.getLogger(ServiceServiceImpl.class);

    @Autowired
    ServiceDataRepository serviceDataRepository;

    @Autowired
    TransformServiceService transformServiceService;

    @Override
    public Service[] getAllService() {
        List<ServiceData> servicesData = new ArrayList<>();
        List<Service> services = new ArrayList<>();

        serviceDataRepository.findAll().forEach(servicesData::add);
        Iterator<ServiceData> it = servicesData.iterator();

        while(it.hasNext()) {
            ServiceData serviceData = it.next();
            Service service = transformServiceService.transform(serviceData);
            services.add(service);
        }

        Service[] array = new Service[services.size()];
        for (int i=0; i<services.size(); i++){
            array[i] = services.get(i);
        }
        return array;
    }

    @Override
    public Service createService(Service service) {
        logger.info(" add:Input " + service.toString());
        ServiceData serviceData = transformServiceService.transform(service);
        
        serviceData = serviceDataRepository.save(serviceData);
        logger.info(" Success:Saved service ID " + serviceData.getServiceId());

        return transformServiceService.transform(serviceData);
    }

    @Override
    public Service updateService(Service service) {
        ServiceData serviceData = transformServiceService.transform(service);
        serviceData = serviceDataRepository.save(serviceData);
        return transformServiceService.transform(serviceData);
    }

    @Override
    public Service getService(Integer id) {
        logger.info(" Input id >> " + Integer.toString(id));
        Optional<ServiceData> optional = serviceDataRepository.findById(id);

        if(optional.isPresent()) {
            return transformServiceService.transform(optional.get());
        }

        logger.info(" Failed >> unable to locate service id: " + Integer.toString(id));
        return null;
    }

    @Override
    public void deleteService(Integer id) {
        logger.info(" Input >> " + Integer.toString(id));
        Optional<ServiceData> optional = serviceDataRepository.findById(id);

        if(optional.isPresent()) {
            serviceDataRepository.delete(optional.get());
            logger.info(" Success >> Deleted service " + id);
        } else {
            logger.info(" Failed >> unable to locate service id: " + Integer.toString(id));
        }
    }
}