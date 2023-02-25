package com.udacity.jdnd.course3.critter.Service;

import com.udacity.jdnd.course3.critter.Entity.Pet;
import com.udacity.jdnd.course3.critter.Entity.Schedule;
import com.udacity.jdnd.course3.critter.Repository.PetRepository;
import com.udacity.jdnd.course3.critter.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    PetRepository petRepository;

    public Schedule createSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }
    public List<Schedule> findAllSchedules(){
        return scheduleRepository.findAll();
    }
    public List<Schedule> findScheduleForPet(Long id){
        return scheduleRepository.findByPetsId(id);
    }
    public List<Schedule> findScheduleForEmployee(Long id){return scheduleRepository.findByEmployeesId(id);
    }
    public List<Schedule> findScheduleForCustomer(Long id){
      List<Pet> pets = petRepository.findAllByCustomerId(id);
      List<Long> ids = pets.stream().map(Pet::getId).collect(Collectors.toList());
      return scheduleRepository.findByPetsIdIn(ids);
    }
}
