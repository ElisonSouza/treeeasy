package com.treeeasy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.treeeasy.service.TreeService;
import com.treeeasy.dao.TreeDAO;
import com.treeeasy.entity.TreeData;

@Service
public class TreeServiceImpl implements TreeService {
	
	@Autowired
	private TreeDAO treeDAO;
	
	@Override
	public TreeData getTreeDataById(int pid) {
		TreeData obj = treeDAO.getTreeDataById(pid);
		return obj;
	}
	
	@Override
	public List<TreeData> getAllTreesData(){
		return treeDAO.getAllTreesData();
	}
	
	@Override
	public synchronized boolean addTreeData(TreeData treeData){
       if (treeDAO.treeDataExists(treeData.getName(), treeData.getDescription())) {
    	   return false;
       } else {
    	   treeDAO.addTreeData(treeData);
    	   return true;
       }
	}
	
	@Override
	public void updateTreeData(TreeData treeData) {
		treeDAO.updateTreeData(treeData);
	}
	
	@Override
	public void deleteTreeData(int pid) {
		treeDAO.deleteTreeData(pid);
	}
}
