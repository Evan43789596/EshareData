package com.eshareframework.esharedata.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.eshareframework.esharedata.service.IGirlsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.eshareframework.esharedata.bean.Girls;
import com.eshareframework.esharedata.dao.GirlsRepository;

@Service
@Transactional
public class GirlsServiceImpl implements IGirlsService {

	// 自动注入dao
	@Resource
	private GirlsRepository  girlsRepository; //jpa   1,spring 封装 2，自定义sql
	
	
	@Override
	public List<Girls> getGirlsList() {
		 
		return (List<Girls>) girlsRepository.findAll();  // 心路历程  循序渐进 
	}


	@Override
	public Page<Girls> getListByPage(int i, Integer size) {
		 
		// 1. 设置排序
		Pageable pageable = new PageRequest(i, size,Sort.Direction.ASC,"id");
		// 2.封装分页
		Page<Girls> gpage = girlsRepository.findAll(new Specification<Girls>() {

			@Override
			public Predicate toPredicate(Root<Girls> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				 
				List<Predicate> list = new ArrayList<Predicate>();
				// 此处可以增加对字段的查询，然后再分页
				Predicate[] p = new Predicate[list.size()];
				
				return criteriaBuilder.and(list.toArray(p)); 
			}
			
			
		}, pageable);
		
		return gpage;
	}


	/*
	 * 秀女的注册
	 * @see IGirlsService#insert(Girls)
	 */
	@Override
	@Transactional
	public void insert(Girls g) {
	 
		   girlsRepository.save(g); 
	 
	}


	@Override
	public void delById(Integer id) {
		 
		girlsRepository.delete(id); // 实战型，应用型人才，非科研人才
	}


	@Override
	public Girls findOneById(Integer id) {
		 
		return girlsRepository.findOne(id);
	}


	@Override
	public void doUpdate(Girls g) {
		 
		 girlsRepository.save(g);
		
	}

}
