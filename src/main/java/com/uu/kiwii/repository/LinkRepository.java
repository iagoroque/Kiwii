package com.uu.kiwii.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uu.kiwii.model.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long>{

    @Override
    List<Link> findAll();
}
