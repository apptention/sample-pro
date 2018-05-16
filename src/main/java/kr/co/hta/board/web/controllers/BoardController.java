package kr.co.hta.board.web.controllers;

import java.io.File;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.hta.board.annotation.LoginUser;
import kr.co.hta.board.service.BoardService;
import kr.co.hta.board.vo.Board;
import kr.co.hta.board.vo.User;
import kr.co.hta.board.web.form.BoardRegisterForm;
import kr.co.hta.board.web.view.DownloadView;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private DownloadView downloadView;
	
	private String directory = "C:\\upload\\formfile";
	
	@RequestMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("boards", boardService.getBoards());
		
		return "board/list.jsp";
	}

	@RequestMapping("/add.do")
	public String add(BoardRegisterForm boardForm, @LoginUser User loginUser) throws Exception {
		Board board = new Board();
		
		BeanUtils.copyProperties(boardForm, board);
		board.setNick(loginUser.getNick());
		board.setContents(boardForm.getContents());
		MultipartFile file = boardForm.getUploadFile();
		String filename = file.getOriginalFilename();
		
		if(!file.isEmpty()) {
			board.setFilename(filename);
			FileCopyUtils.copy(file.getBytes(), new File(directory, filename));
		} else { 
			board.setFilename(""); //JdbcTemplate은 null이어도 해준다.
		}

		boardService.addBoard(board);
			
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/del.do", params={"no"})
	public String del(@RequestParam("no") int boardNo, @LoginUser User loginUser) {
		boardService.deleteBoardByNo(boardNo, loginUser.getNick());
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/detail.do", params={"no"})
	public String detail(@RequestParam("no") int boardNo, Model model) throws Exception {
		model.addAttribute("board", boardService.getBoardByNo(boardNo));
		
		return "board/detail.jsp";
	}
	
	@RequestMapping(value="/down.do", params={"no"})
	public ModelAndView down(@RequestParam("no") int boardNo, ModelAndView mav) throws Exception {
		Board board = boardService.getBoardByNo(boardNo);
		mav.addObject("directory", directory);
		mav.addObject("filename", board.getFilename());
		mav.setView(downloadView);
		
		return mav;
	}
	
	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public String registerForm() {
		
		return "board/form.jsp";
	}
	
	@RequestMapping(value="/form.do", method=RequestMethod.POST)
	public String register() {
		
		return "redirect:/board/list.do";
	}
	
	@RequestMapping(value="/modify.do", method=RequestMethod.GET)
	public String modifyForm() {
		
		return "board/modifyform.jsp";
	}
	
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	public String modify() {
		
		return "redirect:/board/list.do";
	}
	
}