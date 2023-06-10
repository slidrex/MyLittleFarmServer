package com.example.PayDayServer.game.plot.repository;

import com.example.PayDayServer.game.plot.entity.PlotEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlotRepository extends CrudRepository<PlotEntity, Long> {
}
