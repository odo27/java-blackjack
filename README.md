# java-blackjack

블랙잭 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 미션 명세

### 도메인 구성 요소

- 카드 덱
    - 카드
        - 심볼
        - 숫자 (2~10, Ace, King, Queen, Jack)
- 참가자
    - 딜러
    - 플레이어
        - 이름
        - 가지고 있는 카드
- 최종 승패

### 기능 목록

#### 도메인 기능

* 카드

- [x] 카드를 생성한다.
- [x] 카드는 심볼(스페이드, 하트, 클로버, 다이아몬드)을 가진다.
- [x] 카드는 숫자(2~10, Ace, King, Queen, Jack)을 가진다.
    - [x] 각 숫자는 값을 가진다.


* 카드 덱

- [x] 카드 덱은 여러 장의 카드를 가진다.
    - [x] `예외` 카드 덱은 중복을 허용하지 않는다.
    - [x] `예외` 카드 덱의 카드 장수는 52장이어야 한다.
- [x] 카드 덱에서 주어진 장수만큼 카드를 뽑는다.

* 블랙잭 게임

- [x] 블랙잭 게임은 덱을 만든다.
- [ ] 블랙잭 게임은 참가자를 가진다.
    - [ ] `예외` 참가자 중 플레이어는 중복인 이름을 허용하지 않는다.
- [ ] 모든 참가자에게 카드를 2장씩 나눠준다.
- [ ] 플레이어의 보유 카드를 모두 확인한다.
- [ ] 딜러의 보유 카드를 한 장만 확인한다.
- [ ] 딜러의 보유 카드를 모두 확인한다.
- [ ] 플레이어가 블랙잭/버스트가 아닌지 확인한다.
- [ ] 특정 플레이어에게 카드를 준다.

* 카드 생성기

- [x] 카드들을 만든다.
- [x] 카드들을 섞는다.

* 참가자

- [x] 참가자는 카드를 한장씩 받을 수 있다.
- [x] 참가자가 가지고 있는 카드의 합을 계산한다.
    - 카드의 숫자가 A이면 1 또는 11 중 계산한다.
    - King, Queen, Jack은 10으로 계산한다.
- [x] 참가자가 블랙잭/버스트(현재 가진 카드 합이 21 이상)인지 판단한다.

* 플레이어

- [x] 플레이어는 이름을 가진다.
    - [x] `예외` 빈 문자열이거나 공백인 이름은 허용하지 않는다.

* 딜러

- [x] 딜러의 카드 합이 17 미만인지 판단한다.
- [ ] 합을 비교해 최종 승패를 결정한다.
    - 딜러가 특정 플레이어의 승패를 알려준다. (승리, 패배, 무승부)
    - 딜러가 자신의 승패 결과를 합산한다.

#### UI 기능

- [ ] 플레이어의 이름을 입력받는다.
- [ ] 이름을 쉼표 기준으로 분리한다.
- [ ] 카드를 더 받을지 여부를 정해진 키워드로 입력받는다.
- [ ] 카드를 나눠준 결과를 출력한다.
- [ ] 플레이어가 가진 카드들을 출력한다.
- [ ] 딜러가 카드를 받은 여부를 출력한다.
- [ ] 최종 카드 합산 결과를 출력한다.
- [ ] 최종 승패를 출력한다.
