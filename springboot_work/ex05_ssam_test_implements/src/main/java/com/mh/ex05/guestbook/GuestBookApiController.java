package com.mh.ex05.guestbook;

import com.mh.ex05.member.Member;
import com.mh.ex05.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/guestbookapi")
public class GuestBookApiController {

    private final GuestBookRepository guestBookRepository;
    private final MemberRepository memberRepository;

    @GetMapping("/list")
    public ResponseEntity<List<GuestBook>> list(){
        List<GuestBook> list = guestBookRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get/{idx}")
    public ResponseEntity<GuestBook> find(@PathVariable long idx){
        GuestBook gb = guestBookRepository.findById(idx).orElse(null);
        return ResponseEntity.ok(gb);
    }

    @PostMapping("save")
    public ResponseEntity<GuestBook> postsave(@RequestBody GuestBook gb){
        Member member = memberRepository.findById(1l).orElse(new Member());
        gb.setMember(member);
        GuestBook dbgb = guestBookRepository.save(gb);
        return ResponseEntity.ok(dbgb);
    }

    @PutMapping("update")
    public ResponseEntity<GuestBook> putsave(@RequestBody GuestBook gb){
        Member member = memberRepository.findById(1l).orElse(new Member());
        gb.setMember(member);
        GuestBook dbgb = guestBookRepository.save(gb);
        return ResponseEntity.ok(dbgb);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> delete(@RequestBody GuestBook gb){
        guestBookRepository.deleteById(gb.getIdx());
        return ResponseEntity.ok("delete"+gb.getIdx());
    }

}
