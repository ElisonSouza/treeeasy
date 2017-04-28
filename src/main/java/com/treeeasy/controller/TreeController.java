package com.treeeasy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.treeeasy.service.TreeService;
import com.treeeasy.entity.TreeData;;

@Controller
@RequestMapping("/info")
public class TreeController {
	
	@Autowired
	private TreeService treeService;
	
	@RequestMapping("/home")
	public String home() {
 		return "home";
 	}
	
	@RequestMapping(value="/tree/{id}", method = RequestMethod.GET )
	public ResponseEntity<TreeData> getTreeDataById(@PathVariable("id") Integer id) {
		TreeData treeData = treeService.getTreeDataById(id);
		return new ResponseEntity<TreeData>(treeData, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/tree", method = RequestMethod.GET)
	public ResponseEntity<List<TreeData>> getAllTreesData() {
		List<TreeData> list = treeService.getAllTreesData();
		return new ResponseEntity<List<TreeData>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/tree", method = RequestMethod.POST)
	public ResponseEntity<Void> addTreeData(@RequestBody TreeData treeData, UriComponentsBuilder builder) {
        boolean flag = treeService.addTreeData(treeData);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/tree/{id}").buildAndExpand(treeData.getPid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/tree/{id}", method = RequestMethod.PUT )
	public ResponseEntity<TreeData> updateTreeData(@RequestBody TreeData treeData) {
		treeService.updateTreeData(treeData);
		return new ResponseEntity<TreeData>(treeData, HttpStatus.OK);
	}
	
	@RequestMapping(value="/tree/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deleteTreeData(@PathVariable("id") Integer id) {
		treeService.deleteTreeData(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 