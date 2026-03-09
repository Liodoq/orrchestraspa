package com.gabriel.emplms.service;

import com.gabriel.emplms.entity.ScheduleData;
import java.util.List;

public interface ScheduleDataService {
    List<ScheduleData> getAllSchedules() throws Exception;
    ScheduleData getSchedule(Integer scheduleId) throws Exception;
    ScheduleData createSchedule(ScheduleData schedule) throws Exception;
    ScheduleData updateSchedule(ScheduleData schedule) throws Exception;
    void deleteSchedule(Integer scheduleId) throws Exception;
}