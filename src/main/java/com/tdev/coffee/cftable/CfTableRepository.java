package com.tdev.coffee.cftable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CfTableRepository extends JpaRepository<CfTableEntity, Integer> {
}
