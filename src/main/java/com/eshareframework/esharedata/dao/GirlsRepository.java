package com.eshareframework.esharedata.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.eshareframework.esharedata.bean.Girls;

public interface GirlsRepository extends CrudRepository<Girls, Integer>,JpaSpecificationExecutor<Girls> {

}
