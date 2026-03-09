package com.gabriel.emplms.transform;

import com.gabriel.emplms.entity.ScheduleData;
import com.gabriel.emplms.model.Schedule;

public interface TransformScheduleService {
    ScheduleData transform(Schedule schedule);
    Schedule transform(ScheduleData scheduleData);
}