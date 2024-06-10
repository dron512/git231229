insert into user (email,password,nickname,phone,birthdate,resign,loginstate,role) values
('abc@naver.com','abc123!','닉네임','01011111111','000101','N','Y','USER'),
('aaa@naver.com','abc123!','고죠사토루','01022222222','990101','N','Y','USER'),
('bbb@naver.com','abc123!','고길동','01033333333','990101','N','Y','USER'),
('ccc@naver.com','abc123!','프리렌','01044444444','990101','N','Y','USER');

INSERT into menu (category,name,menu_ename,menu_explain,menu_price,menu_imgurl,menu_bannerimgurl) VALUES
('coffee','콜드 브루','Cold Brew','바리스타의 정성으로 탄생한 콜드 브루!',4900,'image/음료/콜드 브루.jpg','image/banner/빽다방.jpg'),
('coffee','바닐라 크림 콜드 브루','Vanilla Cream Cold Brew','콜드 브루에 더해진 바닐라 크림으로 깔끔하면서도 달콤한 콜드 브루를 즐길 수 있는 음료입니다.',5800,'image/음료/콜드 브루 커피/바닐라 크림 콜드 브루.jpg', 'image/banner/빽다방.jpg'),
('coffee','씨솔트 카라멜 콜드 브루','Sea Salt Caramel Cold Brew','구름 처럼 부드러운 씨솔트 폼과 번트 카라멜의 중독성 강한 단짠단짠 조합의 콜드 브루',6300,'image/음료/콜드 브루 커피/오트 콜드 브루.jpg', 'image/banner/빽다방.jpg'),
('coffee','돌체 콜드 브루','Dolce Cold Brew','무더운 여름철, 동남아 휴가지에서 즐기는 커ㅣ를 떠오르게 하는 스타벅스의 음료의 베스트 x 베스트 조합',6000,'image/음료/콜드 브루 커피/돌체 콜드 브루.jpg', 'image/banner/빽다방.jpg'),
('coffee','카라멜 프라푸치노','Caramel Frappuccino','카라멜과 커피가 어우러진 프라푸치노',5900,'image/음료/프라푸치노/카라멜 프라푸치노.jpg', 'image/banner/빽다방.jpg'),
('coffee','자바 칩 프라푸치노','Java Chip Frappuccino','커피, 모카 소스,진한 초콜릿 칩이 입안 가득 느껴지는 스타벅스에서만 맛볼 수 있는 프라프치노',6300,'image/음료/프라푸치노/자바 칩 프라푸치노.jpg', 'image/banner/빽다방.jpg'),
('coffee','제주 말차 크림 프라푸치노','Jeju Malcha Cream Frappuccino','깊고 진한 말차 본연의 맛과 향을 시원하고 부드럽게 즐길 수 있는 프라푸치노',6300,'image/음료/프라푸치노/제주 말차 크림 프라푸치노.jpg', 'image/banner/빽다방.jpg'),
('coffee','초콜릿 크림 칩 프라푸치노','Chocolate Cream Chip Frappuccino','모카 소스와 진한 초콜릿 칩, 초콜릿 드리즐이 올라간 달콤한 크림 프라푸치노',6000,'image/음료/프라푸치노/초콜릿 크림 칩 프라푸치노.jpg', 'image/음료/프라푸치노/초콜릿 크림 칩 프라푸치노 - 복사본.jpg'),
('coffee','아이스 카페 라떼','Iced Caffe Latte','풍부하고 진한 농도의 에스프레소가 시원한 우유와 얼음을 만나 고소함과 시원함을 즐길 수 있는 대표적인 커피 라떼',5000,'image/음료/에스프레소/아이스 카페 라떼.jpg', 'image/banner/빽다방.jpg'),
('coffee','아이스 카페 아메리카노','Iced Caffe Americano','진한 에스프레소에 시원한 정수물과 얼음을 더하여 스타벅스의 강렬한 에스프레소를 가장 부드럽고 시원하게 즐길 수 있는 커피',4500,'image/음료/에스프레소/아이스 카페 아메리카노.jpg', 'image/banner/빽다방.jpg');

INSERT into menu (category,name,menu_ename,menu_price,menu_imgurl,menu_bannerimgurl) VALUES
('beverage','민트 블렌드 티','englishname','설명',5000,'image/음료/스타벅스 주스(병음료)/햇사과 주스 591ML.jpg','image/banner/빽다방.jpg'),
('beverage','아이스 민트 블렌드 티','englishname','설명',5000,'image/음료/스타벅스 주스(병음료)/햇사과 주스 591ML.jpg', 'image/banner/빽다방.jpg'),
('beverage','아이스 얼 그레이 티','englishname','설명',5000,'image/음료/스타벅스 주스(병음료)/햇사과 주스 591ML.jpg', 'image/banner/빽다방.jpg'),
('beverage','얼 그레이 티','englishname','설명',5000,'image/음료/스타벅스 주스(병음료)/햇사과 주스 591ML.jpg', 'image/banner/빽다방.jpg'),
('beverage','아이스 유자 민트 티','englishname','설명',5000,'image/음료/스타벅스 주스(병음료)/햇사과 주스 591ML.jpg', 'image/banner/빽다방.jpg'),
('beverage','레몬 진저 클렌즈 190ML','englishname','설명',5000,'image/음료/스타벅스 주스(병음료)/햇사과 주스 591ML.jpg', 'image/banner/빽다방.jpg'),
('beverage','케일 클렌즈 190ML','englishname','설명',5000,'image/음료/스타벅스 주스(병음료)/햇사과 주스 591ML.jpg', 'image/banner/빽다방.jpg'),
('beverage','딸기주스 190ML','englishname','설명',5000,'image/음료/스타벅스 주스(병음료)/햇사과 주스 591ML.jpg', 'image/banner/빽다방.jpg'),
('beverage','망고주스 190ML','englishname','설명',5000,'image/음료/스타벅스 주스(병음료)/햇사과 주스 591ML.jpg', 'image/banner/빽다방.jpg'),
('beverage','스타 루비 자몽 스위트 190ML','설명','englishname',5000,'image/음료/스타벅스 주스(병음료)/햇사과 주스 591ML.jpg', 'image/banner/빽다방.jpg'),
('food','피스타치오 핑크 롤','englishname','설명',5000,'image/푸드/샌드위치 & 샐러드/햄&루꼴라 올리브 샌드위치.jpg','image/banner/빽다방.jpg'),
('food','바질 토마토 크림치즈 베이글','englishname','설명',5000,'image/푸드/샌드위치 & 샐러드/햄&루꼴라 올리브 샌드위치.jpg', 'image/banner/빽다방.jpg'),
('food','탕종 블루베리 베이글','englishname','설명',5000,'image/푸드/샌드위치 & 샐러드/햄&루꼴라 올리브 샌드위치.jpg', 'image/banner/빽다방.jpg'),
('food','탕종 파마산 치즈 베이글','englishname','설명',5000,'image/푸드/샌드위치 & 샐러드/햄&루꼴라 올리브 샌드위치.jpg', 'image/banner/빽다방.jpg'),
('food','탕종 플레인 베이글','englishname','설명',5000,'image/푸드/샌드위치 & 샐러드/햄&루꼴라 올리브 샌드위치.jpg', 'image/banner/빽다방.jpg'),
('food','7 레이어 가나슈 케이크','englishname','설명',5000,'image/푸드/샌드위치 & 샐러드/햄&루꼴라 올리브 샌드위치.jpg', 'image/banner/빽다방.jpg'),
('food','딸기 생크림 케이크','englishname','설명',5000,'image/푸드/샌드위치 & 샐러드/햄&루꼴라 올리브 샌드위치.jpg', 'image/banner/빽다방.jpg'),
('food','치킨 & 머쉬룸 멜팅 치즈 샌드위치','englishname','설명',5000,'image/푸드/샌드위치 & 샐러드/햄&루꼴라 올리브 샌드위치.jpg', 'image/banner/빽다방.jpg'),
('food','치킨 베이컨 랩','englishname','설명',5000,'image/푸드/샌드위치 & 샐러드/햄&루꼴라 올리브 샌드위치.jpg', 'image/banner/빽다방.jpg'),
('goods','사이렌 클래식 그린 머그 355ml','englishname','설명',5000,'image/상품/글라스/리저브 골드 핸들 글라스 473ml.jpg','image/banner/빽다방.jpg'),
('goods','파스텔 블루 텀블러 473ml','englishname','설명',5000,'image/상품/글라스/리저브 골드 핸들 글라스 473ml.jpg', 'image/banner/빽다방.jpg'),
('goods','파스텔 핑크 텀블러 473ml','englishname','설명',5000,'image/상품/글라스/리저브 골드 핸들 글라스 473ml.jpg', 'image/banner/빽다방.jpg'),
('goods','SS 나수 하우스 텀블러 355ml','englishname','설명',5000,'image/상품/글라스/리저브 골드 핸들 글라스 473ml.jpg', 'image/banner/빽다방.jpg'),
('goods','(c)SS 콩코드 하우스 텀블러 591ml','englishname','설명',5000,'image/상품/글라스/리저브 골드 핸들 글라스 473ml.jpg', 'image/banner/빽다방.jpg'),
('goods','SS 코리아 크림 텀블러 473ml','englishname','설명',5000,'image/상품/글라스/리저브 골드 핸들 글라스 473ml.jpg', 'image/banner/빽다방.jpg'),
('goods','스타벅스 그린 멀티백','englishname','설명',5000,'image/상품/글라스/리저브 골드 핸들 글라스 473ml.jpg', 'image/banner/빽다방.jpg'),
('goods','(c)스타벅스 하우스 장우산','englishname','설명',5000,'image/상품/글라스/리저브 골드 핸들 글라스 473ml.jpg', 'image/banner/빽다방.jpg'),
('goods','(b)틴케이스 문구 세트','englishname','설명',5000,'image/상품/글라스/리저브 골드 핸들 글라스 473ml.jpg', 'image/banner/빽다방.jpg'),
('goods','(c)JNO 하우스 보온병 500ml','englishname','설명',5000,'image/상품/글라스/리저브 골드 핸들 글라스 473ml.jpg', 'image/banner/빽다방.jpg');

INSERT INTO home_ad (ad_head, ad_content, ad_upload_time, ad_due_date, category, image_url) VALUES
('회원가입안내', '회원가입안내 내용', NOW(), DATE_ADD(NOW(), INTERVAL 10 DAY), 1, 'image/HomeSigninAd/2024-09-11.jpeg'),
('이벤트1', '혜택1', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 2, 'image/HomeEvent/홈이벤트1.png'),
('이벤트2', '혜택2', NOW(), DATE_ADD(NOW(), INTERVAL 7 DAY), 2, 'image/HomeEvent/2024-04-18 제주 지역 리유저블 컵 이벤트.jpg');

