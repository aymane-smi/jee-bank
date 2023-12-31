package com.bank.DAO;

import com.bank.Entity.MissionEmployee;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface AssertionDAO {
    public Optional<MissionEmployee> create(MissionEmployee missionEmployee);
    public int delete(int id);
    public Optional<List<MissionEmployee>> findByEmployee(int registrationNbr);
    public Optional<HashMap<Integer, Integer>> getStatistics();
}
