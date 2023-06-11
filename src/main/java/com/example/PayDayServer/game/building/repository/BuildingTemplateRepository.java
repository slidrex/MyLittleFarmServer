package com.example.PayDayServer.game.building.repository;

import com.example.PayDayServer.game.building.entity.templates.BuildingTemplateEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BuildingTemplateRepository extends MongoRepository<BuildingTemplateEntity, String> {
    Optional<BuildingTemplateEntity> getByBuildingId(Integer buildingId);
}
