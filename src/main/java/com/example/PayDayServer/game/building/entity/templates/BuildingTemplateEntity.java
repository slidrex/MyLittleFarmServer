package com.example.PayDayServer.game.building.entity.templates;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "buildings")
public class BuildingTemplateEntity {
    
    @Id
    private String id;
    @Field("building_id")
    private Integer buildingId;
    @Field("name")
    private String buildingName;
    @Field("levels")
    private List<BuildingLevel> buildingLevels;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public List<BuildingLevel> getBuildingLevels() {
        return buildingLevels;
    }

    public void setBuildingLevels(List<BuildingLevel> buildingLevels) {
        this.buildingLevels = buildingLevels;
    }
}
