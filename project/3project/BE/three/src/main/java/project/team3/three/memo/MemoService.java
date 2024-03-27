package project.team3.three.memo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    // 메인 메모 부분
    public Memo insert(MemoDto memoDto) {
        Memo memo = new Memo();
        memo.setMemo(memoDto.getMemo());
        return memoRepository.save(memo);
    }
    public Memo select(Long id){
        return memoRepository.findById(id).orElse(null);
    }
    public Memo update(Long id, MemoDto memoDto) {
        Optional<Memo> optionalMain = memoRepository.findById(id);
        if (optionalMain.isPresent()) {
            Memo memo = optionalMain.get();
            memo.setMemo(memoDto.getMemo());
            return memoRepository.save(memo);
        } else {
            return null;
        }
    }
    //메인 투두 부분



}
