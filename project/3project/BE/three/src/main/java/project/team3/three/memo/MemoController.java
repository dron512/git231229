package project.team3.three.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("main")
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;
    //메인 부분
    @PostMapping("/memo") // 메모 등록
    public Memo Insert(@RequestBody MemoDto memodto){
        return memoService.insert(memodto);
    }
    @GetMapping("/memo/{id}") // id로 메모 찾기
    public Memo Select(@PathVariable Long id){
        return memoService.select(id);
    }
    @PutMapping("/memo/{id}") // id로 메모 업데이트
    public Memo updateMemo(@PathVariable Long id, @RequestBody MemoDto memoDto) {
        return memoService.update(id, memoDto);
    }
    //투두부분

}
