package com.gabriel.emplms.transform;

import com.gabriel.emplms.entity.ServiceData;
import com.gabriel.emplms.model.Service;

public interface TransformServiceService {
    ServiceData transform(Service service);
    Service transform(ServiceData serviceData);
}