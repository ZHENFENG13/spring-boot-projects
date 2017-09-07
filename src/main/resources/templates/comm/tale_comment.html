<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" th:fragment="tale_comment">
<body>
<script type="text/javascript">
    /*<![CDATA[*/
    (function () {
        window.TaleComment = {
            dom: function (id) {
                return document.getElementById(id);
            },
            create: function (tag, attr) {
                var el = document.createElement(tag);
                for (var key in attr) {
                    el.setAttribute(key, attr[key]);
                }
                return el;
            },
            reply: function (coid) {
                $('#comment-form input[name=coid]').val(coid);
                $("html,body").animate({scrollTop: $('div.comment-container').offset().top}, 500);
                $('#comment-form #textarea').focus();
            },
            subComment: function () {
                $.ajax({
                    type: 'post',
                    url: '/comment',
                    data: $('#comment-form').serialize(),
                    async: false,
                    dataType: 'json',
                    success: function (result) {
                        $('#comment-form input[name=coid]').val('');
                        if (result && result.success) {
                            alert("评论已提交至后台审核!");
                            window.location.reload();
                        } else {
                            if (result.msg) {
                                alert(result.msg);
                            }
                        }
                    }
                });
                return false;
            }
        };
    })();
    function getCommentCookie(name) {
        var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
        if (arr = document.cookie.match(reg))
            return unescape(decodeURI(arr[2]));
        else
            return null;
    }
    function addCommentInputValue() {
        document.getElementById('author').value = getCommentCookie('tale_remember_author');
        document.getElementById('mail').value = getCommentCookie('tale_remember_mail');
        document.getElementById('url').value = getCommentCookie('tale_remember_url');
    }
    addCommentInputValue();
    /*]]>*/
</script>
</body>
</html>