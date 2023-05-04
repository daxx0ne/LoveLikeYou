package com.ll.gramgram.boundedContext.notification.eventListener;

import com.ll.gramgram.base.event.EventAfterLike;
import com.ll.gramgram.base.event.EventAfterModifyAttractiveType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional
@Slf4j
public class NotificationEventListener {
    @EventListener
    public void listen(EventAfterModifyAttractiveType event) {
        // 누군가의 호감사유가 변경되었을 경우
        log.debug("EventAfterModifyAttractiveType event : {}", event);
    }

    @EventListener
    public void listen(EventAfterLike event) {
        // 누군가가 호감표시를 한 경우
        log.debug("EventAfterLike event : {}", event);
    }
}