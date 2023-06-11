package com.example.PayDayServer.game.building.model.deconstruct;

public class DeconstructResponse {
    public Long getDeconstructedBuildingId() {
        return deconstructedBuildingId;
    }

    public void setDeconstructedBuildingId(Long deconstructedBuildingId) {
        this.deconstructedBuildingId = deconstructedBuildingId;
    }

    public DeconstructResponse(Long deconstructedBuildingId) {
        this.deconstructedBuildingId = deconstructedBuildingId;
    }

    private Long deconstructedBuildingId;
}
