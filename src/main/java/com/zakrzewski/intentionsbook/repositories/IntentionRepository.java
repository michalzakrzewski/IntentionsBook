package com.zakrzewski.intentionsbook.repositories;

import com.zakrzewski.intentionsbook.entity.Intention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntentionRepository extends JpaRepository<Intention, Long> {
}
