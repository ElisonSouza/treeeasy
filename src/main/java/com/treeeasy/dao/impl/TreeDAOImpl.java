package com.treeeasy.dao.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.treeeasy.entity.TreeData;
import com.treeeasy.dao.TreeDAO;

@Transactional
@Repository
public class TreeDAOImpl implements TreeDAO {
	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@Override
	public TreeData getTreeDataById(int pid) {
		return hibernateTemplate.get(TreeData.class, pid);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TreeData> getAllTreesData() {
		String hql = "FROM TreeData as tree ORDER BY tree.pid";
		return (List<TreeData>) hibernateTemplate.find(hql);
	}
	
	@Override
	public void addTreeData(TreeData treeData) {
		hibernateTemplate.save(treeData);
	}
	
	@Override
	public void updateTreeData(TreeData treeData) {
		TreeData tree = getTreeDataById(treeData.getPid());
		tree.setName(treeData.getName());
		tree.setDescription(treeData.getDescription());
		hibernateTemplate.update(tree);
	}
	
	@Override
	public void deleteTreeData(int pid) {
		hibernateTemplate.delete(getTreeDataById(pid));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean treeDataExists(String name, String description) {
		String hql = "FROM TreeData as tree WHERE tree.name = ? and tree.description = ?";
		List<TreeData> trees = (List<TreeData>) hibernateTemplate.find(hql, name, description);
		return trees.size() > 0 ? true : false;
	}
}
