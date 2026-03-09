package com.gabriel.emplms.service;

import com.gabriel.emplms.model.Schedule;

public interface ScheduleDataService {
    Schedule[] getAllSchedule() throws Exception;
    Schedule getSchedule(Integer id) throws Exception;
    Schedule createSchedule(Schedule schedule) throws Exception;
    void deleteSchedule(Integer id) throws Exception;
}