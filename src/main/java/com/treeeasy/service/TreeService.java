package com.treeeasy.service;

import java.util.List;
import com.treeeasy.entity.TreeData;

public interface TreeService {
	
     List<TreeData> getAllTreesData();
     TreeData getTreeDataById(int pid);
     boolean addTreeData(TreeData treeData);
     void updateTreeData(TreeData treeData);
     void deleteTreeData(int pid);
}
