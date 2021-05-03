//Initialize Select2 Elements
$('.select2').select2();
//wangEditor变量
var editorD;

$(function () {
    $('.alert-danger').css("display", "none");

    //富文本编辑器
    const E = window.wangEditor;
    editorD = new E('#wangEditor')
    // 设置编辑区域高度为 750px
    editorD.config.height = 750
    //配置服务端图片上传地址
    editorD.config.uploadImgServer = '/admin/upload/file'
    editorD.config.uploadFileName = 'file'
    //限制图片大小 2M
    editorD.config.uploadImgMaxSize = 2 * 1024 * 1024
    //限制一次最多能传几张图片 一次最多上传 1 个图片
    editorD.config.uploadImgMaxLength = 1
    //隐藏插入网络图片的功能
    editorD.config.showLinkImg = false
    editorD.config.uploadImgHooks = {
        // 图片上传并返回了结果，图片插入已成功
        success: function (xhr) {
            console.log('success', xhr)
        },
        // 图片上传并返回了结果，但图片插入时出错了
        fail: function (xhr, editor, resData) {
            console.log('fail', resData)
        },
        // 上传图片出错，一般为 http 请求的错误
        error: function (xhr, editor, resData) {
            console.log('error', xhr, resData)
        },
        // 上传图片超时
        timeout: function (xhr) {
            console.log('timeout')
        },
        customInsert: function (insertImgFn, result) {
            if (result != null && result.resultCode == 200) {
                // insertImgFn 可把图片插入到编辑器，传入图片 src ，执行函数即可
                insertImgFn(result.data)
            } else {
                alert("error");
            }
        }
    }
    editorD.create();

    new AjaxUpload('#uploadCoverImage', {
        action: '/admin/upload/file',
        name: 'file',
        autoSubmit: true,
        responseType: "json",
        onSubmit: function (file, extension) {
            if (!(extension && /^(jpg|jpeg|png|gif)$/.test(extension.toLowerCase()))) {
                alert('只支持jpg、png、gif格式的文件！');
                return false;
            }
        },
        onComplete: function (file, r) {
            if (r != null && r.resultCode == 200) {
                $("#newsCoverImage").attr("src", r.data);
                $("#newsCoverImage").attr("style", "width: 128px;height: 128px;display:block;");
                return false;
            } else {
                alert("error");
            }
        }
    });
});

$('#confirmButton').click(function () {
    var newsTitle = $('#newsTitle').val();
    var categoryId = $('#newsCategoryId').val();
    var newsContent = editorD.txt.html();
    if (isNull(newsTitle)) {
        swal("请输入文章标题", {
            icon: "error",
        });
        return;
    }
    if (!validLength(newsTitle, 150)) {
        swal("标题过长", {
            icon: "error",
        });
        return;
    }
    if (isNull(categoryId)) {
        swal("请选择文章分类", {
            icon: "error",
        });
        return;
    }
    if (isNull(newsContent)) {
        swal("请输入文章内容", {
            icon: "error",
        });
        return;
    }
    if (!validLength(newsContent, 100000)) {
        swal("文章内容过长", {
            icon: "error",
        });
        return;
    }
    $('#articleModal').modal('show');
});

$('#saveButton').click(function () {
    var newsId = $('#newsId').val();
    var newsTitle = $('#newsTitle').val();
    var newsCategoryId = $('#newsCategoryId').val();
    var newsContent = editorD.txt.html();
    var newsCoverImage = $('#newsCoverImage')[0].src;
    var newsStatus = $("input[name='newsStatus']:checked").val();
    if (isNull(newsCoverImage) || newsCoverImage.indexOf('img-upload') != -1) {
        swal("封面图片不能为空", {
            icon: "error",
        });
        return;
    }
    var url = '/admin/news/save';
    var swlMessage = '保存成功';
    var data = {
        "newsTitle": newsTitle,  "newsCategoryId": newsCategoryId,
        "newsContent": newsContent, "newsCoverImage": newsCoverImage, "newsStatus": newsStatus
    };
    if (newsId > 0) {
        url = '/admin/news/update';
        swlMessage = '修改成功';
        data = {
            "newsId": newsId,
            "newsTitle": newsTitle,
            "newsCategoryId": newsCategoryId,
            "newsContent": newsContent,
            "newsCoverImage": newsCoverImage,
            "newsStatus": newsStatus
        };
    }
    console.log(data);
    $.ajax({
        type: 'POST',//方法类型
        url: url,
        data: data,
        success: function (result) {
            if (result.resultCode == 200) {
                $('#articleModal').modal('hide');
                swal({
                    title: swlMessage,
                    type: 'success',
                    showCancelButton: false,
                    confirmButtonColor: '#3085d6',
                    confirmButtonText: '返回资讯列表',
                    confirmButtonClass: 'btn btn-success',
                    buttonsStyling: false
                }).then(function () {
                    window.location.href = "/admin/news";
                })
            }
            else {
                $('#articleModal').modal('hide');
                swal(result.message, {
                    icon: "error",
                });
            }
            ;
        },
        error: function () {
            swal("操作失败", {
                icon: "error",
            });
        }
    });
});

$('#cancelButton').click(function () {
    window.location.href = "/admin/news";
});
