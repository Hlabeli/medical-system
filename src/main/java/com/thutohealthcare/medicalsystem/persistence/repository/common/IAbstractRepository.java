package com.thutohealthcare.medicalsystem.persistence.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
@Repository
public interface IAbstractRepository<T> extends JpaRepository<T, Long> {
}
