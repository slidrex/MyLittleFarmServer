package com.example.PayDayServer.game.plot.model.expand;

public class PlotExpandRequest {
    private Long plotId;

    public Long getPlotId() {
        return plotId;
    }

    public void setPlotId(Long plotId) {
        this.plotId = plotId;
    }

    public boolean isHorizontalExpand() {
        return horizontalExpand;
    }

    public void setHorizontalExpand(boolean horizontalExpand) {
        this.horizontalExpand = horizontalExpand;
    }

    private boolean horizontalExpand;
}
