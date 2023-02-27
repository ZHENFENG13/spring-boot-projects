//Initialize Select2 Elements
$('.select2').select2();
//wangEditor变量
var editor;

$(function () {
    $('.alert-danger').css("display", "none");

    //富文本编辑器
    const E = window.wangEditor;

    const editorConfig = { MENU_CONF: {} }
    editorConfig.MENU_CONF['uploadImage'] = {
          //配置服务端图片上传地址
          server: '/admin/upload/file',
          // 超时时间5s
          timeout: 5 * 1000,
          fieldName: 'file',
          // 选择文件时的类型限制，默认为 ['image/*']
          allowedFileTypes: ['image/*'],
          // 限制图片大小 4M
          maxFileSize: 4 * 1024 * 1024,
          base64LimitSize: 5 * 1024,

          onBeforeUpload(file) {
            console.log('onBeforeUpload', file)

            return file // will upload this file
            // return false // prevent upload
          },
          onProgress(progress) {
            console.log('onProgress', progress)
          },
          onSuccess(file, res) {
            console.log('onSuccess', file, res)
          },
          onFailed(file, res) {
            alert(res.message)
            console.log('onFailed', file, res)
          },
          onError(file, err, res) {
            alert(err.message)
            console.error('onError', file, err, res)
          },
          customInsert: function (result,insertFn) {
            if (result != null && result.resultCode == 200) {
                // insertFn 可把图片插入到编辑器，传入图片 src ，执行函数即可
                insertFn(result.data,'',result.data)
            } else if (result != null && result.resultCode != 200) {
                alert('error');
            } else {
                alert('error');
            }
          }
    }

    editor = E.createEditor({
      selector: '#editor-text-area',
      html: $(".editor-text").val(),
      config: editorConfig
    })

    const toolbar = E.createToolbar({
      editor,
      selector: '#editor-toolbar',
    })

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
    var newsContent = editor.getHtml();
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
    var newsContent = editor.getHtml();
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
