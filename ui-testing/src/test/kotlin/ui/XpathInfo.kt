package ui

class XpathInfo {
    companion object {
        // 로그인 페이지 이동
        const val NAVIGATE_LOGIN_PAGE = "//*[@id='app']/div/div[1]/div/ul/li[1]/button"
        // 로그인 id 입력
        const val INPUT_LOGIN_ID = "//div[@id='app']/div/div[2]/div[2]/div/div/div/div/input"
        // 로그인 password 입력
        const val INPUT_LOGIN_PASSWORD = "//div[@id='app']/div/div[2]/div[2]/div/div/div[2]/div/input"
        // 로그인 버튼 클릭
        const val CLICK_LOGIN_BUTTION = "//div[@id='app']/div/div[2]/div[2]/div/div[3]"
        // 공지사항 확인 및 닫기
        const val CLICK_NOTICE_MODAL = "//div[@id='app']/div/div[2]/div[5]/div/div[2]/div/div/button/i"
        // 위탁 관리
        const val NAVIGATE_CONSIGNMENT = "//div[@id='app']/div/div/div/div[2]/div/div[5]/a/span"
        // 위탁 상품 가져오기
        const val NAVIGATE_CONSIGNMENT_SEARCH = "//div[@id='app']/div/div/div/div[2]/div/div[5]/div/div/div/a/span"
        // 도매매 클릭
        const val CLICK_CONSIGNMENT_SEARCH_DOMEME = "//div[@id='app']/div/div[2]/div[2]/div/div[1]/div[2]/div[1]/span"
        // 검색 조건 선택
        const val CLICK_CONSIGNMENT_SEARCH_TYPE = "//div[@id='app']/div/div[2]/div[2]/div/div[2]/div[2]/div/div[1]"
        // 상품명 클릭
        const val CLICK_CONSIGNMENT_SEARCH_TYPE_PRODUCT_NAME = "//div[@id='app']/div/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[3]/p"
        // 검색어 입력
        const val INPUT_CONSIGNMENT_SEARCH_PRODUCT_NAME = "//div[@id='app']/div/div[2]/div[2]/div/div[2]/div[2]/input"
        // 검색 클릭
        const val CLICK_CONSIGNMENT_SEARCH_BUTTON= "//div[@id='app']/div/div[2]/div[3]/div[1]/p"
        // 검색 결과 total count
        const val GET_TEXT_CONSIGNMENT_SEARCH_RESULT_COUNT = "//div[@id='app']/div/div[2]/div[5]/div[1]/h4/em/span"
        // 위탁 상품 조회 펼치기
        const val CLICK_CONSIGNMENT_SEARCH_MORE_LIST_BOTTON = "/html/body/div/div/div[2]/div[5]/div[4]/div/p"
        // 위탁 상품 조회 리스트 상품명
        var ROW_CONSIGNMENT_SEARCH_LIST_PRODUCT_NAME = "/html/body/div/div/div[2]/div[5]/div[3]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div[#count#]/div[3]/div/span/div/p"
        // 위탁 상품 조회 리스트 상품번호
        var ROW_CONSIGNMENT_SEARCH_LIST_PRODUCT_NO = "/html/body/div/div/div[2]/div[5]/div[3]/div/div/div[1]/div[2]/div[3]/div[2]/div/div/div[#count#]/div[2]/div/span"
        // 위탁 상품 상세보기 닫기
        const val CLICK_CONSIGNMENT_SEARCH_DETAIL_CLOSE = "/html/body/div/div/div[2]/div[7]/div/div[2]/div/div[1]/button/i"
    }
}