function markdown(textarea, toolbar, preview) {
    var options = {};
    options.strings = {
        bold: '加粗 <strong> Ctrl+B',
        boldexample: '加粗文字',

        italic: '斜体 <em> Ctrl+I',
        italicexample: '斜体文字',

        link: '链接 <a> Ctrl+L',
        linkdescription: '请输入链接描述',

        quote:  '引用 <blockquote> Ctrl+Q',
        quoteexample: '引用文字',

        code: '代码 <pre><code> Ctrl+K',
        codeexample: '请输入代码',

        image: '图片 <img> Ctrl+G',
        imagedescription: '请输入图片描述',

        olist: '数字列表 <ol> Ctrl+O',
        ulist: '普通列表 <ul> Ctrl+U',
        litem: '列表项目',

        heading: '标题 <h1>/<h2> Ctrl+H',
        headingexample: '标题文字',

        hr: '分割线 <hr> Ctrl+R',
        more: '摘要分割线 <!--more--> Ctrl+M',

        undo: '撤销 - Ctrl+Z',
        redo: '重做 - Ctrl+Y',
        redomac: '重做 - Ctrl+Shift+Z',

        imagedialog: '<p><b>插入图片</b></p><p>请在下方的输入框内输入要插入的远程图片地址</p>',
        linkdialog: '<p><b>插入链接</b></p><p>请在下方的输入框内输入要插入的链接地址</p>',

        ok: '确定',
        cancel: '取消'
    };

    var converter = new Markdown.Converter(),
        editor = new Markdown.Editor(converter, '', options),
        diffMatch = new diff_match_patch(), last = '', preview = $('#md-preview'),
        mark = '@mark' + Math.ceil(Math.random() * 100000000) + '@',
        span = '<span class="diff" />';

    // 设置markdown
    Markdown.Extra.init(converter, {
        extensions  :   ["tables", "fenced_code_gfm", "def_list", "attr_list", "footnotes"]
    });

    // 自动跟随
    converter.hooks.chain('postConversion', function (html) {
        // clear special html tags
        html = html.replace(/<\/?(\!doctype|html|head|body|link|title|input|select|button|textarea|style|noscript)[^>]*>/ig, function (all) {
            return all.replace(/&/g, '&amp;')
                .replace(/</g, '&lt;')
                .replace(/>/g, '&gt;')
                .replace(/'/g, '&#039;')
                .replace(/"/g, '&quot;');
        });

        // clear hard breaks
        html = html.replace(/\s*((?:<br>\n)+)\s*(<\/?(?:p|div|h[1-6]|blockquote|pre|table|dl|ol|ul|address|form|fieldset|iframe|hr|legend|article|section|nav|aside|hgroup|header|footer|figcaption|li|dd|dt)[^\w])/gm, '$2');

        if (html.indexOf('<!--more-->') > 0) {
            var parts = html.split(/\s*<\!\-\-more\-\->\s*/),
                summary = parts.shift(),
                details = parts.join('');

            html = '<div class="summary">' + summary + '</div>'
                + '<div class="details">' + details + '</div>';
        }


        var diffs = diffMatch.diff_main(last, html);
        last = html;

        if (diffs.length > 0) {
            var stack = [], markStr = mark;

            for (var i = 0; i < diffs.length; i ++) {
                var diff = diffs[i], op = diff[0], str = diff[1]
                sp = str.lastIndexOf('<'), ep = str.lastIndexOf('>');

                if (op != 0) {
                    if (sp >=0 && sp > ep) {
                        if (op > 0) {
                            stack.push(str.substring(0, sp) + markStr + str.substring(sp));
                        } else {
                            var lastStr = stack[stack.length - 1], lastSp = lastStr.lastIndexOf('<');
                            stack[stack.length - 1] = lastStr.substring(0, lastSp) + markStr + lastStr.substring(lastSp);
                        }
                    } else {
                        if (op > 0) {
                            stack.push(str + markStr);
                        } else {
                            stack.push(markStr);
                        }
                    }

                    markStr = '';
                } else {
                    stack.push(str);
                }
            }

            html = stack.join('');

            if (!markStr) {
                var pos = html.indexOf(mark), prev = html.substring(0, pos),
                    next = html.substr(pos + mark.length),
                    sp = prev.lastIndexOf('<'), ep = prev.lastIndexOf('>');

                if (sp >= 0 && sp > ep) {
                    html = prev.substring(0, sp) + span + prev.substring(sp) + next;
                } else {
                    html = prev + span + next;
                }
            }
        }

        return html;
    });

    editor.hooks.chain('onPreviewRefresh', function () {
        var diff = $('.diff', preview), scrolled = false;

        $('img', preview).load(function () {
            if (scrolled) {
                preview.scrollTo(diff, {
                    offset  :   - 50
                });
            }
        });

        if (diff.length > 0) {
            var p = diff.position(), lh = diff.parent().css('line-height');
            lh = !!lh ? parseInt(lh) : 0;

            if (p.top < 0 || p.top > preview.height() - lh) {
                preview.scrollTo(diff, {
                    offset  :   - 50
                });
                scrolled = true;
            }
        }
    });

    var input = $('#text'), th = textarea.height(), ph = preview.height();

    editor.hooks.chain('enterFakeFullScreen', function () {
        th = textarea.height();
        ph = preview.height();
        $(document.body).addClass('fullscreen');
        var h = $(window).height() - toolbar.outerHeight();

        textarea.css('height', h);
        preview.css('height', h);
    });

    editor.hooks.chain('enterFullScreen', function () {
        $(document.body).addClass('fullscreen');

        var h = window.screen.height - toolbar.outerHeight();
        textarea.css('height', h);
        preview.css('height', h);
    });

    editor.hooks.chain('exitFullScreen', function () {
        $(document.body).removeClass('fullscreen');
        textarea.height(th);
        preview.height(ph);
    });

    editor.run();

    // 编辑预览切换
    var edittab = $('#md-button-bar').prepend('<div class="md-edittab"><a href="#md-editarea" class="active">撰写</a><a href="#md-preview">预览</a></div>'),
        editarea = $(textarea.parent()).attr("id", "md-editarea");

    $(".md-edittab a").click(function() {
        $(".md-edittab a").removeClass('active');
        $(this).addClass("active");
        $("#md-editarea, #md-preview").addClass("md-hidetab");

        var selected_tab = $(this).attr("href"),
            selected_el = $(selected_tab).removeClass("md-hidetab");

        // 预览时隐藏编辑器按钮
        if (selected_tab == "#md-preview") {
            $("#md-button-row").addClass("md-visualhide");
        } else {
            $("#md-button-row").removeClass("md-visualhide");
        }

        // 预览和编辑窗口高度一致
        $("#md-preview").outerHeight($("#md-editarea").innerHeight());

        return false;
    });
}