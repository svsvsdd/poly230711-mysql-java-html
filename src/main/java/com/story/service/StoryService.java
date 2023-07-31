package com.story.service;

import java.util.List;

import com.story.domain.StoryDTO;
import com.story.paging.Criteria;

public interface StoryService {
	public boolean registerStory(StoryDTO params);
	public StoryDTO getStoryDetail(long num);
	public boolean deleteStory(long num);
	public List<StoryDTO> getStoryList(StoryDTO params);
}
