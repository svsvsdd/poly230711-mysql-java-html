package com.story.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.story.constant.Method;
import com.story.domain.StoryDTO;
import com.story.paging.Criteria;
import com.story.service.StoryService;
import com.story.util.UiUtils;

@Controller
public class StoryController extends UiUtils {
	
	@Autowired
	private StoryService storyService;
	
	@GetMapping(value = "/story/write.do")
	public String openStoryWrite(@RequestParam(value="num", required=false) Long num, Model model) {
		if(num == null) {
			model.addAttribute("story", new StoryDTO());
		} else {
			StoryDTO story = storyService.getStoryDetail(num);
			if(story == null) {
				return "redirect:/story/list.do";
			}
			model.addAttribute("story", story);
		}
		
		return "story/write";
	}
	
	@PostMapping(value="/story/register.do")
	public String registerStory(final StoryDTO params, Model model) {
		try {
			boolean isRegistered = storyService.registerStory(params);
			if(isRegistered == false) {
				return showMessageWithRedirect("게시글 등록에 실패하였습니다.", "/story/list.do", Method.GET, null, model);
			}
		} catch (DataAccessException e) {
			// TODO: handle exception
			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/story/list.do", Method.GET, null, model);
		} catch (Exception e) {
			// TODO: handle exception
			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/story/list.do", Method.GET, null, model);
		}
		return showMessageWithRedirect("게시글 등록이 완료되었습니다.", "/story/list.do", Method.GET, null, model);
	}
	
	@GetMapping(value="/story/list.do")
	public String openStoryList(@ModelAttribute("params")StoryDTO params, Model model) {
		List<StoryDTO> storyList = storyService.getStoryList(params);
		model.addAttribute("storyList", storyList);
		return "story/list";
	}
	
	@GetMapping(value="/story/view.do")
	public String openStoryDetail(@RequestParam(value="num", required=false) Long num, Model model) {
		if(num == null) {
			return showMessageWithRedirect("올바르지 않은 접근입니다.", "/story/list.do", Method.GET, null, model);
		}
		StoryDTO story = storyService.getStoryDetail(num);
		if(story == null || "Y".equals(story.getDelYn())) {
			return showMessageWithRedirect("없는 게시글이거나, 이미 삭제된 게시글입니다.", "/story/list.do", Method.GET, null, model);
		}
		model.addAttribute("story", story);
		
		return "story/view";
	}
	
	@PostMapping(value = "/story/delete.do")
	public String deleteStory(@RequestParam(value="num", required=false) Long num, Model model) {
		if(num == null) {
			return showMessageWithRedirect("올바르지 않은 접근입니다.", "/story/list.do", Method.GET, null, model);
		}
		try {
			boolean isDeleted = storyService.deleteStory(num);
			if(isDeleted == false) {
				return showMessageWithRedirect("게시글 삭제에 실패하였습니다.", "/story/list.do", Method.GET, null, model);
			}
		} catch (DataAccessException e) {
			// TODO: handle exception
			return showMessageWithRedirect("데이터베이스 처리 과정에 문제가 발생하였습니다.", "/story/list.do", Method.GET, null, model);
		} catch (Exception e) {
			// TODO: handle exception
			return showMessageWithRedirect("시스템에 문제가 발생하였습니다.", "/story/list.do", Method.GET, null, model);			
		}
		return showMessageWithRedirect("게시글 삭제가 완료되었습니다.", "/story/list.do", Method.GET, null, model);
	}
}