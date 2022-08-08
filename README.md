index.jsp
sub1.jsp
sub2.jsp
get_nearby_wifi.jsp

→ 각각의 jsp파일들은 웹페이지에서 보여줄 수 있도록 구현해놓은 파일입니다.
index.jsp는 주소에 접속하면 제일 먼저 보여지는 페이지로 테이블 제목을 거리부터 작업일자까지 지정해놓았습니다.
sub1.jsp는 open API 와이파이의 정보를 가져오는 페이지로, 서울 공공 와이파이의 개수를 불러와 'n'개의 형태로 표현하고, 홈으로 이동할 수 있는 링크를 연결했습니다.
sub2.jsp는 위치 히스토리의 목록을 보여주는 페이지입니다.
get_nearby_wifi.jsp 파일은 메인페이지에서 LAT, LNT의 값을 입력했을 때 가장 가까운 20개의 리스트들을 보여주는 파일입니다.

Dbmanager.java 
→ 데이터를 구성하는 메인 자바 파일로 메인데이터와 근처 와이파이항목, 히스토리 항목, 데이터 삭제까지 처리할 수 있도록 구성된 자바 파일입니다.

Wifi_info_orm.java
→ 문제에 제시된 리스트의 전체 항목들을 저장해 놓은 자바 파일로, 항목들을 Getter와 Setter로 만들고, 웹페이지에서 볼 수 있도록 데이터를 저장합니다.

History_orm.java
→ 위치를 검색했던 기록들을 저장해 놓은 자바 파일로, Datagrip에서 생성한 id, LNT, LAT, 그리고 검색한 날짜에 대한 테이블 라벨을 받아오고
검색했던 기록 중 lnt, lat, search_date를 받아와 저장합니다.

WiFiService.java
→ 각 항목의 파일들을 Getter와 Setter로 받아와 저장. (json)

wifi_info.java
→ 공공와이파이 open API에 접속하여 데이터를 받아온다. gson과 json파일 형태로 저장합니다.

WifiInfo.java
→ WifiService.java에서 받아온 파일을 리스트의 형태로 저장합니다.

Result.java, TbPublicWifiInfo.java
→ wifi_info.java에서 Dbmanager.java 파일에 데이터를 저장하는 항목들 중의 일부

