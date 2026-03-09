package com.gabriel.emplms.transform;

import com.gabriel.emplms.entity.ScheduleData;
import com.gabriel.emplms.model.Schedule;
import org.springframework.stereotype.Service;

@Service
public class TransformScheduleServiceImpl implements TransformScheduleService {

    @Override
    public ScheduleData transform(Schedule schedule) {
        ScheduleData scheduleData = new ScheduleData();
        
        scheduleData.setScheduleId(schedule.getScheduleId());
        scheduleData.setAvailableDate(schedule.getAvailableDate());
        scheduleData.setAvailableTime(schedule.getAvailableTime());
        
        // New slots are always set to not booked by default
        scheduleData.setBooked(false);
        return scheduleData;
    }

    @Override
    public Schedule transform(ScheduleData scheduleData) {
        Schedule schedule = new Schedule();
        schedule.setScheduleId(scheduleData.getScheduleId());
        schedule.setAvailableDate(scheduleData.getAvailableDate());
        schedule.setAvailableTime(scheduleData.getAvailableTime());
        
        // New slots are always set to not booked by default
        schedule.setBooked(false);
        return schedule;
    }
}