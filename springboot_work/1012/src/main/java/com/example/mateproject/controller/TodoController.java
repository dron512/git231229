package com.example.mateproject.controller;

import com.example.mateproject.dao.MemberRepository;
import com.example.mateproject.dao.TodoRepository;
import com.example.mateproject.dto.Member;
import com.example.mateproject.dto.Todolist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @Autowired
    MemberRepository memberRepository;


    @GetMapping("insert")
    @ResponseBody
    public String insert(Todolist todolist) {
        System.out.println(todolist);
        todoRepository.doInsert(todolist);
        return "test";
    }

//
//    @PostMapping("insert")
//    public String pinsert(Todolist todolist){
//        System.out.println(todolist);
//        todoRepository.doInsert(todolist);
//        return "redirect:/todo/list";
//    }





    @GetMapping("list")
    public String view(Model model) {
//        Member dbMember = memberRepository.doSelectRow(member);
        model.addAttribute("mem",memberRepository.doSelect());
        model.addAttribute("todo", todoRepository.doSelect());
        return "todo/list";
    }


    @PostMapping("delete")
    @ResponseBody
    public String delete(Todolist todolist) {
        todoRepository.doDelete(todolist);
        return "문자날아감";
    }


    @PostMapping("insert")
    public String pinsert(@ModelAttribute Todolist todolist, Model model) {
        Todolist existingTodo = todoRepository.selectrow(todolist.getId());
        model.addAttribute("mem",memberRepository.doSelect());

        // 기존의 finishDate 값과 새로운 finishDate 값을 비교하여 업데이트
        if (existingTodo != null) {
            existingTodo.setFinishDate(todolist.getFinishDate());
            todoRepository.doUpdate(existingTodo); // 업데이트 메서드를 호출
        }

        return "redirect:/todo/list";
    }

//    @RequestMapping(value = "/todo/insert", method = RequestMethod.POST)
//    public String insertTodo(@RequestParam("mem_id") String mem_id, @RequestParam("content") String content, @RequestParam("goalDate") Date goalDate) {
//        // 여기서 'mem_id'는 폼에서 선택한 회원의 mem_id입니다.
//        // 'content'와 'endDate'도 필요한 필드입니다.
//
//        // todo 객체를 생성하고 mem_id를 member_id로 설정
//        Todolist todolist = new Todolist();
//        todolist.setMember_id(mem_id);
//        todolist.setContent(content);
//        todolist.setGoalDate(goalDate);
//
//        // todo를 데이터베이스에 저장하는 로직을 구현하세요.
//
//        return "redirect:/todo/list";
//
//    }



//    @PostMapping("complete")
//    @ResponseBody
//    public String completeTask(@RequestParam Long taskId, @RequestParam Date currentDate) {
//        Todolist todo = todoRepository.findTodoById(taskId);
//        todo.setFinishDate(currentDate);
//        todoRepository.updateTodo(todo);
//        return "Task completed";
//    }


}
