package com.sudarshan.sud.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sudarshan.sud.entities.Asset;

@Repository
public interface AssetRepository 
            extends CrudRepository<Asset, Long> {
 
}