package com.treeeasy.dao;

import java.util.List;
import com.treeeasy.entity.TreeData;

public interface TreeDAO {
	
    List<TreeData> getAllTreesData();
    TreeData getTreeDataById(int pid);
    void addTreeData(TreeData treeData);
    void updateTreeData(TreeData treeData);
    void deleteTreeData(int pid);
    boolean treeDataExists(String name, String description);
}
 