<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko" xmlns:v="urn:schemas-microsoft-com:vml">
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>샘플코드</title>
        
</head>
<body>
<script type="text/javascript" src="http://openapi.map.naver.com/openapi/naverMap.naver?ver=2.0&key=16145c93390d410d28d7e6ed565f3fdb"></script>
<div id="map" style="border:1px solid #000;"></div>
<script type="text/javascript">
                var oSeoulCityPoint = new nhn.api.map.LatLng(37.5351571, 126.9024122);
                var defaultLevel = 11;
                var oMap = new nhn.api.map.Map(document.getElementById('map'), { 
                                                point : oSeoulCityPoint,
                                                zoom : defaultLevel,
                                                enableWheelZoom : true,
                                                enableDragPan : true,
                                                enableDblClickZoom : false,
                                                mapMode : 0,
                                                minMaxLevel : [ 1, 14 ],
                                                size : new nhn.api.map.Size(800, 480)           });
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
                var oMarker = new nhn.api.map.Marker(oIcon, { title : 'KH정보교육원(당산) '});  //마커 찍는 부분 아이콘모양,라벨이름
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
</body>
</html>
                      
                                