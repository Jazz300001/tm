package com.example.taskmanager.tm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalServ {

    @Autowired
    private GoalRep goalRep;

    public List<Goal> getAllGoals() {
        return goalRep.findAll();
    }

    public Optional<Goal> getGoalById(int id) {
        return goalRep.findById(id);
    }

    public Goal saveOrUpdateGoal(Goal goal) {
        return goalRep.save(goal);
    }

    public void deleteGoal(int id) {
        goalRep.deleteById(id);
    }
}
