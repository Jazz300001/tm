package com.example.taskmanager.tm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalCont {

    @Autowired
    private GoalServ goalServ;

    @GetMapping("/")
    public ResponseEntity<List<Goal>> getAllGoals() {
        List<Goal> goals = goalServ.getAllGoals();
        return ResponseEntity.ok().body(goals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable(value = "id") int goalId) {
        Goal goal = goalServ.getGoalById(goalId).orElseThrow(() -> new ResourceNotFoundException("Goal not found with id: " + goalId));
        return ResponseEntity.ok().body(goal);
    }

    @PostMapping("/")
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        Goal savedGoal = goalServ.saveOrUpdateGoal(goal);
        return ResponseEntity.ok().body(savedGoal);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable(value = "id") int goalId, @RequestBody Goal goalDetails) {
        Goal goal = goalServ.getGoalById(goalId).orElseThrow(() -> new ResourceNotFoundException("Goal not found with id: " + goalId));
        goal.setTitle(goalDetails.getTitle());
        goal.setDetails(goalDetails.getDetails());
        goal.setTargetDate(goalDetails.getTargetDate());
        goal.setStatus(goalDetails.getStatus());
        Goal updatedGoal = goalServ.saveOrUpdateGoal(goal);
        return ResponseEntity.ok().body(updatedGoal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGoal(@PathVariable(value = "id") int goalId) {
        goalServ.deleteGoal(goalId);
        return ResponseEntity.ok().build();
    }
}

