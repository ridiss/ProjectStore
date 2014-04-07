<%@ page contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko" xmlns:v="urn:schemas-microsoft-com:vml">
<head>
<title>매장 정보 보기</title>
<script type="text/javascript">
<!-- 
function deleteSave(){
    var result = confirm("게시물을 삭제하시겠습니까?");
        if(result)document.write("삭제하였습니다.");
        else document.write("취소하였습니다.");
        }
 -->
</script>
</head>

<body>
<center><b>매장 정보 보기</b><br />
<form method="post" action="ms_DeleteAction.action" name="viewForm" onsubmit="return deleteSave();">
  <table width="500" border="1">
    <tr height="30">
        <td align="center"  width="125">매장등록번호</td>
        <td align="center"  width="75">${msDTO.no}</td>
        <td align="center"  width="125" >매장명</td>
        <td align="center"  width="125">${msDTO.store}</td>
    </tr>
    
    <tr height="30">
        <td align="center" width="130"  >매장주소</td>
        <td align="center" width="370"  colspan="3">${msDTO.s_Addr}</td>
    </tr>
    
    <tr height="100">
        <td align="center" width="350"  rowspan="2" colspan="2">
        <%--<a href="${msDTO.s_Action}.action" />  이미지 링크 연습--%>
       <img src="/ProjectStore/ms_UploadFile/store/${msDTO.sfile_Savname}"  width="350" height="200"/></td>
        <td align="center" width="50" >위도&lt;Lat&gt;</td>
        <td align="center" width="100">${msDTO.s_Lat}</td>
    </tr>
    <tr height="100">
        <td align="center" width="50" >경도&lt;Lng&gt;</td>
        <td align="center" width="100">${msDTO.s_Lng}</td>
    </tr>
    
    <tr height="30">
        <td align="center" width="100" >이동액션주소</td>
        <td align="center" width="150">${msDTO.s_Action}</td>
        <td align="center" width="125" >카테고리</td>
        <td align="center" width="125">${msDTO.m_Category}</td>
    </tr>
    
    <tr height="100">
        <td align="center" width="350"  rowspan="2" colspan="2">
        <img src="/ProjectStore/ms_UploadFile/a/${msDTO.m_Afile_Savname}"  width="350" height="200"/></td>
        <td align="center" width="50" >메뉴A</td>
        <td align="center" width="100">${msDTO.m_A}</td>
    </tr>
    <tr height="100">
        <td align="center" width="50" >메뉴A가격</td>
        <td align="center" width="100">${msDTO.m_Ap}원</td>
    </tr>
    
    <tr height="100">
        <td align="center" width="350"  rowspan="2" colspan="2">
        <img src="/ProjectStore/ms_UploadFile/b/${msDTO.m_Bfile_Savname}" width="350" height="200" /></td>
        <td align="center" width="50" >메뉴B</td>
        <td align="center" width="100">${msDTO.m_B}</td>
    </tr>
    <tr height="100">
        <td align="center" width="50" >메뉴B가격</td>
        <td align="center" width="100">${msDTO.m_Bp}원</td>
    </tr>
    
    <tr height="100">
        <td align="center" width="350"  rowspan="2" colspan="2">
        <img src="/ProjectStore/ms_UploadFile/c/${msDTO.m_Cfile_Savname}" width="350" height="200" /></td>
        <td align="center" width="50" >메뉴C</td>
        <td align="center" width="100">${msDTO.m_C}</td>
    </tr>
    <tr height="100">
        <td align="center" width="50" >메뉴C가격</td>
        <td align="center" width="100">${msDTO.m_Cp}원</td>
    </tr>
    
    
    <tr><%--지도 --%>
    <td align="center" colspan="4" >
<script type="text/javascript" src="http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=1eb8921b5db3c0cfd2f92e21983d6e7e"></script>
<div id="map" style="border:1px solid #000;"></div>
<script type="text/javascript">
                var oSeoulCityPoint = new nhn.api.map.LatLng("${msDTO.s_Lat}", "${msDTO.s_Lng}");
                var defaultLevel = 11;
                var oMap = new nhn.api.map.Map(document.getElementById('map'), { 
                                                point : oSeoulCityPoint,
                                                zoom : defaultLevel,
                                                enableWheelZoom : true,
                                                enableDragPan : true,
                                                enableDblClickZoom : false,
                                                mapMode : 0,
                                                minMaxLevel : [ 1, 14 ],
                                                size : new nhn.api.map.Size(500, 240)           });
                var oSlider = new nhn.api.map.ZoomControl();
                oMap.addControl(oSlider);
                oSlider.setPosition({
                        top : 10,
                        left : 10
                });

                var oMapTypeBtn = new nhn.api.map.MapTypeBtn();
                oMap.addControl(oMapTypeBtn);
                oMapTypeBtn.setPosition({
                        bottom : 10,
                        right : 80
                });
                
                var oSize = new nhn.api.map.Size(28, 37);
                var oOffset = new nhn.api.map.Size(14, 37);
                var oIcon = new nhn.api.map.Icon('http://static.naver.com/maps2/icons/pin_spot2.png', oSize, oOffset); //아이콘 정보
                var oMarker = new nhn.api.map.Marker(oIcon, { title : '${msDTO.store}'});  //마커 찍는 부분 아이콘모양,라벨이름
                oMarker.setPoint(oSeoulCityPoint);
                oMap.addOverlay(oMarker);
                
                var oLabel = new nhn.api.map.MarkerLabel(); // - 마커 라벨 선언.
                oMap.addOverlay(oLabel); // - 마커 라벨 지도에 추가. 기본은 라벨이 보이지 않는 상태로 추가됨.
                oLabel.setVisible(true, oMarker); //라벨 보여주기 옵션(true일때 항상 표시 /false일때 자동 숨기기)
                oMap.addOverlay(oLabel);
                
                var oInfoWnd = new nhn.api.map.InfoWindow();
                oInfoWnd.setVisible(false);
                oMap.addOverlay(oInfoWnd);

                oInfoWnd.setPosition({
                        top : 20,
                        left :20
                });
                oInfoWnd.attach('changeVisible', function(oCustomEvent) {
                        if (oCustomEvent.visible) {
                                oLabel.setVisible(false);
                        }
                });
                oMap.attach('mouseleave', function(oCustomEvent) {

                        var oTarget = oCustomEvent.target;
                        // 마커위에서 마우스 나간거면
                        if (oTarget instanceof nhn.api.map.Marker) {
                                oLabel.setVisible(false);
                        }
                });
        </script>
        </td>
    </tr>
    
    <tr>
        <td align="center" width="200"  colspan="2">등록일</td>
        <td align="center" width="300"  colspan="2">${msDTO.sreg_Date}</td>
    </tr>
    
    <tr>
    <input type="hidden" name="no" value="${msDTO.no }" /><%--삭제시 넘어가는 히든값 --%>
    <input type="hidden" name="currentPage" value="${currentPage}" /><%--삭제시 넘어가는 히든값 --%>
        <td align="center" width="500"  colspan="4">
        <input type="button"  value="매장수정" onClick="window.location='ms_UpdateFormAction.action?no=${msDTO.no}&currentPage=${currentPage}'" />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="submit"  value="매장삭제" />
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  value="매장목록" onClick="window.location='ms_ListAction.action'" />
        </td>
    </tr>
    
  
  </table>
</form>
</center>
</body>
</html>