package com.example.PayDayServer.game.building.repository;

import com.example.PayDayServer.game.building.entity.entities.BuildingEntity;
import com.example.PayDayServer.game.building.entity.templates.BuildingTemplateEntity;
import org.springframework.data.repository.CrudRepository;

public interface BuildingRepository extends CrudRepository<BuildingEntity, Long> {
}
