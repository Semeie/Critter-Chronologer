package com.udacity.jdnd.course3.critter.Service;

import com.udacity.jdnd.course3.critter.Entity.Pet;
import com.udacity.jdnd.course3.critter.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class PetService {
    @Autowired
    PetRepository petRepository;

    public Pet savePet(Pet pet){
        return petRepository.save(pet);
    }

    public Pet findPet(Long id){
        return petRepository.findById(id).get();
    }

    public List<Pet> findAllPets(){
        return petRepository.findAll();
    }
    public List<Pet> findPetsByIds(List<Long> ids){
        return petRepository.findAllById(ids);
    }

    public List<Pet> findPetsByOwner(Long id){
        return petRepository.findAllByCustomerId(id);
    }
}

