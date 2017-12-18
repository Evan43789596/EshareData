package com.eshareframework.esharedata.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.eshareframework.esharedata.bean.Girls;
@Service
@Transactional
public interface IGirlsService {
	
	public List<Girls> getGirlsList();

	public Page<Girls> getListByPage(int i, Integer size);

	public void insert(Girls g);

	public void delById(Integer id);

	public Girls findOneById(Integer id);

	public void doUpdate(Girls g); 	   
	
}
