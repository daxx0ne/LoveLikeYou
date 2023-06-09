## Title: [2Week] 박다원

### 미션 요구사항 분석 & 체크리스트

---
**필수미션**: 호감표시 할 때 예외처리 케이스 3가지를 추가로 처리
- [x] case 4: 한 명의 인스타회원이 다른 인스타회원에게 중복으로 호감표시를 할 수 없음
- [x] case 5: 한 명의 인스타회원이 11명 이상의 호감상대를 등록 할 수 없음
- [x] case 6: case 4 가 발생했을 때 기존의 사유와 다른 사유로 호감을 표시하는 경우에는 성공으로 처리

**추가미션**: 네이버 로그인 연동
- [ ] 스프링 OAuth2 클라이언트 사용하여 네이버 로그인으로도 가입 및 로그인 처리가 되게끔 구현


### 2주차 미션 요약

---

**[접근 방법]**

case 4

- 'existingLikes' 리스트가 비어있지 않으면 이미 호감 표시한 기록이 존재한다는 뜻
  - 이때 경고 문구와 함께 RsData 객체를 반환하여 예외처리함
  - findByFromInstaMemberIdAndToInstaMemberId() 메서드를 사용하여 호감을 표시한 사실을 체크

case 5

- 먼저 해당 인스타회원이 이전에 등록한 모든 호감표시 목록을 조회한 후 11명 이상인지 판단
  - 조회된 리스트의 크기가 11 이상일 때 예외처리함

case 6

- case 4를 수정하여 기존에 이미 같은 호감을 표시한 경우와 호감을 표시한 사유가 다른 경우에는 기존 호감표시에서 사유만 수정하는 경우를 나눠서 생각함
  - 기존에 이미 같은 호감표시를 했으면 case 4에 했던 예외처리를 해줌
  - 호감표시 사유가 다르다면 'likeablePersonRepository.save(existingLike);' 구문을 통해 사유를 수정하고 저장
    - resultCode=S-2 를 반환



**[특이사항]**

추가 미션: 네이버 로그인 버튼 누르면 로그인 창으로 들어가지지만 동의하기를 누르면 login?error 창으로 넘어감 