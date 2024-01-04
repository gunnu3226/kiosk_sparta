# 키오스크 만들기 (개인 과제)

## 과제를 진행하며 시도한 것
1. 상품의 데이터는 언제든지 변할 수 있기 때문에 단순히 상품을 추가/삭제 하더라도 서비스 코드를 수정하지 않도록 한다.
- 메뉴, 상품의 개수는 변할 수 있기 때문에 상품 넘버링은 동적으로 한다.
  -> 메뉴, 상품의 개수가 늘어나도 출력, 입력을 받아 처리하는데 상관이 없다.
- 메뉴, 상품에 변화가 있을 때는 resisterMenu, 옵션에 변화가 있을 땐 option을 수정한다면 다른 코드는 건드리지 않아도 된다.

2. 메뉴를 등록할 때 생성자를 계속 호출하는 로직을 제거하려고 Product와 Menu를 싱글톤 패턴으로 리팩토링 하다가 실패.
  -> 스프링으로 넘어가면 db가 있으니까 넘겨도 되려나...?

## 추가적으로 넣을 수 있는 기능
- 장바구니에서 일부 상품 삭제
- 관리자 모드에서 메뉴 등록, 삭제 -> 키오스크가 돌아가는 상황만 유지, 껐다 키면 다시 초기화(DB가 없기 때문)

## 과제 요구사항 및 출력 예시

---

- 필수 요구사항

  > **Java 클래스 설계 시 필수 요구사항!**
  >
  > - 메뉴 클래스는 이름, 설명 필드를 가지는 클래스로 만들어주세요.
  > - 상품 클래스는 이름, 가격, 설명 필드를 가지는 클래스로 만들어주세요.
  > - 상품 클래스의 이름, 설명 필드는 메뉴 클래스를 상속받아 사용하는 구조로 개발해주세요.
  > - 주문 클래스도 만들어서 상품 객체를 담을 수 있도록 해주세요.


## 1. 메인 메뉴판 화면
- 메인 메뉴판이 출력되며 메뉴판에는 상품 메뉴가 출력 됩니다.
- 상품 메뉴는 간단한 설명과 함께 출력 되며 최소 3개 이상 출력 됩니다.
- 상품 메뉴 아래에는 Order(주문)와 Cancel(주문 취소) 옵션을 출력해줍니다.
   
     
   ![스크린샷 2024-01-05 오전 2 27 19](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/799539e8-4969-4667-8133-7324ec1a9dd5)


## 2. 상품 메뉴판 화면
- 상품 메뉴 선택 시 해당 카테고리의 메뉴판이 출력됩니다.
- 메뉴판에는 각 메뉴의 이름과 가격과 간단한 설명이 표시됩니다.
   
  - 햄버거 메뉴판
    ![스크린샷 2024-01-05 오전 2 30 54](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/919a9377-9b99-4e6d-b680-87b59124aad5)  
  
    스낵 메뉴판
  ![스크린샷 2024-01-05 오전 2 31 09](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/0c88ae11-675f-4abf-859e-ab0c32d1b944)  
  
  - 음료 메뉴판
    ![스크린샷 2024-01-05 오전 2 31 22](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/84714621-c6ea-4b3e-95e5-bdace5833754)  


## 3. 상품 옵션 기능(선택)
- 상품에 옵션을 선택 후 장바구니에 추가 할 수 있게 세분화 합니다.
  - 햄버거 옵션
    ![스크린샷 2024-01-05 오전 2 38 28](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/29ba7cf5-d320-48ee-921c-6fd80ab4e0b9)
  
  - 스낵 옵션
    ![스크린샷 2024-01-05 오전 2 38 52](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/dafc5bc7-17fc-4d69-b3a6-bf4b62860f2f)
  
  - 음료 옵션
    ![스크린샷 2024-01-05 오전 2 39 08](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/252ed37f-9baa-459d-9b6d-3e18d852914a)

## 4. 중복 상품 개수 체크 기능(선택)
- 주문 페이지에 들어가면 중복 상품의 개수도 표기되고 옵션에 따라 다른 상품으로 분류된다.
  - 주문 페이지
  ![스크린샷 2024-01-05 오전 2 42 42](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/00e43ca8-6a4e-4117-8d73-3ce11a6f41b2)

## 5. 진행하던 주문 취소 기능
- 메뉴판에서 `6.Cancel` 입력시 주문을 취소할지 확인을 요청하는 문구가 출력 됩니다.
- `1.확인` 을 입력하면 장바구니는 초기화되고 취소 완료 문구와 함께 메뉴판이 출력 됩니다.
  - 주문 취소 페이지
  - ![스크린샷 2024-01-05 오전 2 47 37](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/4f70c0a7-5987-4bc2-9017-90c9b8bd77a6)

## 5. 주문 기능
  - `1.주문` 입력 시 대기번호를 발급해줍니다.
  - 장바구니는 초기화되고 3초 후에 메인 메뉴판으로 돌아갑니다.
    - 주문 완료
    - ![스크린샷 2024-01-05 오전 2 49 52](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/d27d1224-58e7-408a-82c0-55e1b222a8be)
  
## 6. 관리자 페이지 기능(선택)
- 키오스크가 작동 후 판매상품과 판매 금액을 볼 수 있다.
- 화면에 표시되지 않았지만 0을 입력하면 진입하도록 되어있다.
  - 관리자 페이지
  - ![스크린샷 2024-01-05 오전 2 51 40](https://github.com/gunnu3226/kiosk_sparta/assets/139452702/fb1c0f64-5cfe-46ec-a461-28c744b528cb)