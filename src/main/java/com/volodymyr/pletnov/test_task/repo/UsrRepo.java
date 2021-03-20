package com.volodymyr.pletnov.test_task.repo;

import com.volodymyr.pletnov.test_task.model.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsrRepo extends JpaRepository<Usr,Integer> {

	Optional<Usr> findByFioEncr(String fioEncr);
}
