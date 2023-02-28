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
    public List<Schedule> findScheduleForPet(Long petId){
        return scheduleRepository.findByPetsId(petId);
    }
    public List<Schedule> findScheduleForEmployee(Long employeeId){return scheduleRepository.findByEmployeesId(employeeId);
    }
    public List<Schedule> findScheduleForCustomer(Long customerId){
      List<Pet> pets = petRepository.findAllByCustomerId(customerId);
      List<Long> petIds = pets.stream().map(Pet::getId).collect(Collectors.toList());
      return scheduleRepository.findByPetsIdIn(petIds);
    }
}
