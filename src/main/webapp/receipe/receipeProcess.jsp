<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>jQuery UI Sortable</title>
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<style>
/*.processitemBox {
    width:600px;
    height:50px;
    
    margin:10px;
}*/
/*
.processitemBox input {
	background:#f5f5f5;
	border:1px solid #e1e1e1;
	border-radius: 4px;
	font-size:16px;
	height:50px;
	vertical-align:middle;
}*/

.itemBoxHighlight {
    width:400px;
    height:50px;
    padding:10px;
    margin-bottom:10px;
    
}
.deleteBox {
    float:right;
    display:none;
    cursor:pointer;
}

.processTip {
	margin: 10px 0 10px 230px;
}


</style>
<style>
#sortable { list-style-type: none; margin: 0; padding: 0; width: 400px; }
#sortable li { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; font-size: 1.4em; height: 18px; }
#sortable li span { position: absolute; margin-left: -1.3em; }
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>
<script type="text/javascript">
//<![CDATA[
/** 아이템을 등록한다. */
function submitItem() {
    if(!validateItem()) {
    	return;
    }
    alert("등록");
}

/** 아이템 체크 */
/*function validateItem() {
    var items = $("input[type='text'][name='item']");
    if(items.length == 0) {
        alert("작성된 아이템이 없습니다.");
        return false;
    }

    var flag = true;
    for(var i = 0; i < items.length; i++) {
        if($(items.get(i)).val().trim() == "") {
            flag = false;
            alert("내용을 입력하지 않은 항목이 있습니다.");
            break;
        }
    }

    return flag;
}*/

/** UI 설정 */
$(function() {
    $("#processBoxWrap").sortable({
        placeholder:"itemBoxHighlight",
        start: function(event, ui) {
            ui.item.data('start_pos', ui.item.index());
        },
        stop: function(event, ui) {
            var spos = ui.item.data('start_pos');
            var epos = ui.item.index();
			      reorderP();
        }
    });
    //$("#processBoxWrap").disableSelection();
    
    $( "#sortable" ).sortable();
    $( "#sortable" ).disableSelection();
});

/** 아이템 순서 조정 */
function reorderP() {
    $(".processitemBox").each(function(i, box) {
       $(box).find(".process_no").html(i + 1);
       $(box).find("[name=process_no]").val(i + 1);//eunsol - ingredient_seq 추가
       $(box).find(".process_no");//eunsol - 실행시 드래그로 순서 가능한 부분이라 사용 가능할 것 같아요
    });
}

/** 아이템 추가 */
function createProcess() {
    $(createProcessBox())
    .appendTo("#processBoxWrap")
    .hover(
        function() {
            $(this).css('backgroundColor', '#f9f9f5');
            $(this).find('.deleteBox').show();
        },
        function() {
            $(this).css('background', 'none');
            $(this).find('.deleteBox').hide();
        }
    )
		.append("<div class='deleteBox' style='float:left;'>삭제</div>")
		.find(".deleteBox").click(function() {
        var valueCheck = false;
        $(this).parent().find('input').each(function() {
            if($(this).attr("name") != "type" && $(this).val() != '') {
                valueCheck = true;
            }
        });

        if(valueCheck) {
            var delCheck = confirm('입력하신 내용이 있습니다.\n삭제하시겠습니까?');
        }
        if(!valueCheck || delCheck == true) {
            $(this).parent().remove();
            reorderP();
        }
    });
    // 숫자를 다시 붙인다.
    reorderP();
}

/** 아이템 박스 작성 */
function createProcessBox() {
    var contents = "<div class='processitemBox'>"
                 + "<div style='float:left;'>"
                 + "<span class='process_no'></span><input type='hidden' name='process_no'>"
                 + "<input type='file' maxlength='60' size='40' style='background-color:transparent;  border:0px transparent solid; font-size:12px; width:20%;'>"
                 + "<input type='text' name='process_desc' style='width:610px; margin-left:15px;' placeholder='요리과정을 순서대로 입력하세요.'/>"
                 + "<div class='processTip'> tip) <input type='text' name='process_tip' style='width:560px; margint:100px;' placeholder='요리 팁이 있다면 입력해주세요.'> </div>"
                 + "</div>"
                 + "</div>";
    return contents;
}
//]]>
</script>
</head>
<body>


<br />

<div>
	<!-- 추가 버튼 -->
    <div class="buttons">
        <input type="button" id="addItem" value="추가하기" onclick="createProcess();" />
    </div>
	<div id="processBoxWrap"></div>
    
</div>


</body>
</html>