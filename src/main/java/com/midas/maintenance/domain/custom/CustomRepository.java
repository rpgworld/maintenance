package com.midas.maintenance.domain.custom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomRepository extends JpaRepository<Custom, Long> {

    Optional<Custom> findByName(String name);
}
