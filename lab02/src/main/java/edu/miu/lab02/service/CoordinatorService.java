package edu.miu.lab02.service.impl;

import edu.miu.lab02.entity.Coordinator;
import edu.miu.lab02.entity.Event;

import java.util.List;

public interface CoordinatorService {
    List<Event> getEventsByCoordinatorId(int coordinatorId);
}
