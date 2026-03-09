package com.gabriel.emplms.serviceimpl;

import com.gabriel.emplms.entity.ScheduleData;
import com.gabriel.emplms.model.Schedule;
import com.gabriel.emplms.repository.ScheduleDataRepository;
import com.gabriel.emplms.service.ScheduleDataService;
import com.gabriel.emplms.transform.TransformScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleServiceImpl implements ScheduleDataService {
    Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

    @Autowired
    ScheduleDataRepository scheduleDataRepository;

    @Autowired
    TransformScheduleService transformScheduleService;

    @Override
    public Schedule[] getAllSchedule() {
        List<ScheduleData> schedulesData = new ArrayList<>();
        List<Schedule> schedules = new ArrayList<>();

        scheduleDataRepository.findAll().forEach(schedulesData::add);
        Iterator<ScheduleData> it = schedulesData.iterator();

        while(it.hasNext()) {
            ScheduleData data = it.next();
            Schedule model = transformScheduleService.transform(data);
            schedules.add(model);
        }

        Schedule[] array = new Schedule[schedules.size()];
        for (int i=0; i<schedules.size(); i++){
            array[i] = schedules.get(i);
        }
        return array;
    }

    @Override
    public Schedule createSchedule(Schedule schedule) {
        logger.info(" add:Input " + schedule.toString());
        ScheduleData data = transformScheduleService.transform(schedule);
        
        data.setBooked(false);
        
        data = scheduleDataRepository.save(data);
        logger.info(" Success:Saved schedule ID " + data.getScheduleId());

        return transformScheduleService.transform(data);
    }

    @Override
    public Schedule getSchedule(Integer id) {
        logger.info(" Input id >> " + Integer.toString(id));
        Optional<ScheduleData> optional = scheduleDataRepository.findById(id);

        if(optional.isPresent()) {
            return transformScheduleService.transform(optional.get());
        }

        logger.info(" Failed >> unable to locate schedule id: " + Integer.toString(id));
        return null;
    }

    @Override
    public void deleteSchedule(Integer id) {
        logger.info(" Input >> " + Integer.toString(id));
        Optional<ScheduleData> optional = scheduleDataRepository.findById(id);

        if(optional.isPresent()) {
            scheduleDataRepository.delete(optional.get());
            logger.info(" Success >> Deleted schedule " + id);
        } else {
            logger.info(" Failed >> unable to locate schedule id: " + Integer.toString(id));
        }
    }
}