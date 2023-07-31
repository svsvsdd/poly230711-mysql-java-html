package com.story.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.story.domain.StoryDTO;
import com.story.mapper.StoryMapper;
import com.story.paging.Criteria;
import com.story.paging.PaginationInfo;

@Service
public class StoryServiceImpl implements StoryService {
	@Autowired
	private StoryMapper storyMapper;
	
	@Override
	public boolean registerStory(StoryDTO params) {
		int queryResult = 0;
		
		if(params.getNum() == null) {
			queryResult = storyMapper.insertStory(params);
		} else {
			queryResult = storyMapper.updateStory(params);
		}
		return (queryResult == 1) ? true : false;
	}
	
	@Override
	public StoryDTO getStoryDetail(long num) {
		return storyMapper.selectStoryDetail(num);
	}

	@Override
	public boolean deleteStory(long num) {
		// TODO Auto-generated method stub
		int queryResult = 0;
		
		StoryDTO story = storyMapper.selectStoryDetail(num);
		
		if (story != null && "N".equals(story.getDelYn())) {
			queryResult = storyMapper.deleteStory(num);
		}
		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<StoryDTO> getStoryList(StoryDTO params) {
		// TODO Auto-generated method stub
		List<StoryDTO> storyList = Collections.emptyList();
		
		int storyTotalCount = storyMapper.selectStoryTotalCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(storyTotalCount);
		params.setPaginationInfo(paginationInfo);
		
		if(storyTotalCount > 0) {
			storyList = storyMapper.selectStoryList(params);
		}
		return storyList;
	}
}
