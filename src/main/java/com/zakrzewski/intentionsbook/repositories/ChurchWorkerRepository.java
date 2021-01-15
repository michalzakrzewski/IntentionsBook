package com.zakrzewski.intentionsbook.repositories;

import com.zakrzewski.intentionsbook.dtos.ChurchWorkerRequest;
import com.zakrzewski.intentionsbook.entity.ChurchWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChurchWorkerRepository extends JpaRepository<ChurchWorker, Long> {

}
