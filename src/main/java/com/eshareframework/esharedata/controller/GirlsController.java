package com.eshareframework.esharedata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eshareframework.esharedata.bean.Girls;
import com.eshareframework.esharedata.service.IGirlsService;
import com.eshareframework.esharedata.utils.ValueUtils;

/**
 * 清朝秀女选秀一览表的controller类
 * 
 * @author Administrator
 *
 */
@RestController
public class GirlsController {

	
	
	// 1.自动注入IGirlsService类
	@Autowired
	private IGirlsService  girlsServiceImpl;



	
  /*
   * 查询数据库所有秀女的姓氏家族
   */
  @RequestMapping("/getList.do")
  public ModelAndView getGirlsList() {
	  
	  ModelAndView mv = new ModelAndView();
	  
	  List<Girls> glist =  girlsServiceImpl.getGirlsList();
	  mv.addObject("glist", glist);
	  mv.setViewName("list");  // 如鱼得水
	  // 思考：list.jsp 放在什么位置  什么地方配置路径
	  return mv;
	  
  }
  
  

  @RequestMapping("/getListByPage.do")
  public ModelAndView getListByPage(@RequestParam(value="pageNumber",defaultValue="1")Integer pageNumber,
		  @RequestParam(value="size",defaultValue="5")Integer size) {
	  
	  // hibernate和mybatis的不同，hibernate封装的分页是从0开始，而不是从1开始
	  Page<Girls> datas = girlsServiceImpl.getListByPage(pageNumber-1,size);
	  
	  ModelAndView mv = new ModelAndView();
	  mv.addObject("datas", datas); 
	  mv.setViewName("list");
	 
	  return mv;
	  
  }
	
  

  @RequestMapping("getGirlsById.do")
  @ResponseBody
  public Girls getUserById(Integer id) {
   
		System.out.println("girlsRepository: " );
		System.out.println("id: " + id);
      return null;
  }
  
  /*添加入册秀女
   * 
   */
  @RequestMapping("insert.do")
  @ResponseBody
  public String insert(Girls g) {
   
	     girlsServiceImpl.insert(g);
	 
		 return ValueUtils.YES;
	 
  }

  /*
   * 删除入册错误的信息
   */
  @RequestMapping("delById.do")
  @ResponseBody
  public String delById(Integer id){
	  
	    girlsServiceImpl.delById(id);
	  return ValueUtils.YES;
	  
  }

  /*
   * toupdate
   */
  @RequestMapping("findOneById.do")
  public ModelAndView toUpdate(Integer id){
	  
	 Girls g =  girlsServiceImpl.findOneById(id);
	 ModelAndView mv = new  ModelAndView();
	 mv.addObject("girls", g);
	 mv.setViewName("toupdate");
	  
	 return mv;
  }
  
  /*
   * 更新注册
   */
  @RequestMapping("doupdate.do")
  public  String doUpdate(Girls g) {
	  
	  girlsServiceImpl.doUpdate(g);
	  
	return ValueUtils.YES;
	  
  }
}
