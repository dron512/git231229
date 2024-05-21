package com.mh.green2nd.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public String eventdetail(Long eventId) {

        Event event = eventRepository.findById(eventId).orElseThrow(
                () -> new IllegalArgumentException(" ʕ •ᴥ•ʔ ━☆ 이벤트가 없습니다. ʕ •ᴥ•ʔ ━☆")
        );
        return event.getEventimgurl();
    }
}
