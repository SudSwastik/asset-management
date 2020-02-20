package com.sudarshan.sud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.sud.dao.AssetRepository;
import com.sudarshan.sud.entities.Asset;
import com.sudarshan.sud.exception.RecordNotFoundException;


@Service
public class AssetService {
     
    @Autowired
    AssetRepository repository;
     
    public List<Asset> getAllEmployees()
    {
        List<Asset> result = (List<Asset>) repository.findAll();
         
        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Asset>();
        }
    }
     
    public Asset getEmployeeById(Long id) throws RecordNotFoundException 
    {
        Optional<Asset> employee = repository.findById(id);
         
        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    }
     
    public Asset createOrUpdateEmployee(Asset entity) 
    {
        if(entity.getId()  == null) 
        {
            entity = repository.save(entity);
             
            return entity;
        } 
        else
        {
            Optional<Asset> employee = repository.findById(entity.getId());
             
            if(employee.isPresent()) 
            {
                Asset newEntity = employee.get();
                newEntity.setAssetId(entity.getAssetId());
                newEntity.setEmployeeId(entity.getEmployeeId());
                newEntity.setInUse(entity.getInUse());
                newEntity.setModelName(entity.getModelName());
                newEntity.setProductColor(entity.getProductColor());
                newEntity.setProductName(entity.getProductName());
                newEntity.setProductCondition(entity.getProductCondition());
                newEntity = repository.save(newEntity);
                 
                return newEntity;
            } else {
                entity = repository.save(entity);
                 
                return entity;
            }
        }
    } 
     
    public void deleteEmployeeById(Long id) throws RecordNotFoundException 
    {
        Optional<Asset> employee = repository.findById(id);
         
        if(employee.isPresent()) 
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
    } 
}