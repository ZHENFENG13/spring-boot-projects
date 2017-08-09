<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" th:with="title='系统设置',active='settings'">
<header th:replace="admin/header::headerFragment(${title},${active})"></header>
<link th:href="@{/admin/plugins/toggles/toggles.css}" rel="stylesheet"/>
<body class="fixed-left">
<div id="wrapper">
    <div th:replace="admin/header::header-body"></div>
    <div class="content-page">
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <h4 class="page-title">系统设置</h4>
                    </div>
                    <div class="col-md-6">
                        <div class="panel panel-color panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">全局设置</h3>
                            </div>
                            <div class="panel-body">
                                <form class="form-horizontal" role="form" id="global-form">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">站点名称</label>
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" name="site_title" placeholder="站点名称"
                                                   th:value="${options.site_title}" required="required" aria-required="true"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">站点描述</label>
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" name="site_description" placeholder="站点描述"
                                                   th:value="${options.site_description}" required="required" aria-required="true"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">ICP备案号</label>
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" name="site_record" placeholder="ICP备案号"
                                                   th:value="${options.site_record}" required="required" aria-required="true"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label">博客主题</label>
                                        <div class="col-md-9">
                                            <select name="site_theme" class="form-control">
                                                <option value="default" th:selected="${options.site_theme=='default'}?true:false">默认主题</option>
                                            </select>
                                        </div>
                                    </div>

                                    <input type="hidden" name="allow_install" id="allow_install"/>
                                    <div class="clearfix pull-right">
                                        <button type="button" class="btn btn-primary waves-effect waves-light" onclick="saveSetting()">
                                            保存设置
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="panel panel-color panel-inverse">
                            <div class="panel-heading">
                                <h3 class="panel-title">个性化设置</h3>
                            </div>
                            <div class="panel-body">
                                <form id="indivi-form" class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">微博账号</label>
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" name="social_weibo" th:value="${options.social_weibo}"
                                                   placeholder="微博账号，不输入则不显示"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">知乎账号</label>
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" name="social_zhihu" th:value="${options.social_zhihu}"
                                                   placeholder="知乎账号，不输入则不显示"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Github账号</label>
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" name="social_github"
                                                   th:value="${options.social_github}" placeholder="Github账号，不输入则不显示"/>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label">Twitter账号</label>
                                        <div class="col-md-9">
                                            <input type="text" class="form-control" name="social_twitter"
                                                   th:value="${options.social_twitter}" placeholder="Twitter账号，不输入则不显示"/>
                                        </div>
                                    </div>
                                    <div class="clearfix pull-right">
                                        <button type="button" class="btn btn-inverse waves-effect waves-light"
                                                onclick="saveIndiviSetting()">
                                            保存设置
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="clearfix"></div>

                    <div class="col-md-6">
                        <div class="panel panel-color panel-success">
                            <div class="panel-heading">
                                <h3 class="panel-title">系统备份（备份文件包含附件和主题）</h3>
                            </div>
                            <div class="panel-body">
                                <form id="backupForm" class="form-inline" role="form">
                                    <!--<div class="form-group">
                                        <label class="sr-only">备份格式</label>
                                        <input name="url" class="form-control" placeholder="请输入备份文件格式，如yyyy-MM-dd" required="" aria-required="true" type="url">
                                    </div>-->
                                    <div class="form-group col-md-6">
                                        <input id="backup_dir" style="width: 100%;" class="form-control" placeholder="请输入备份存放的磁盘路径" required="" aria-required="true" type="text"/>
                                    </div>

                                    <button type="button" class="btn btn-success waves-effect waves-light m-l-10" onclick="backup('attach');">备份文件</button>
                                    <button type="button" class="btn btn-danger waves-effect waves-light m-l-10" onclick="backup('db')">导出数据库SQL</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
                <div th:replace="admin/footer :: footer-content"></div>
            </div>
        </div>
    </div>
</div>
<div th:replace="admin/footer :: footer"></div>
<script src="//cdn.bootcss.com/jquery-toggles/2.0.4/toggles.min.js"></script>
<script type="text/javascript">
    /*<![CDATA[*/
    var tale = new $.tale();

    /**
     * 保存全局设置
     */
    function saveSetting() {
        var param = $('#global-form').serialize();
        tale.post({
            url : '/admin/setting',
            data: param,
            success: function (result) {
                if(result && result.success){
                    tale.alertOk('设置保存成功');
                } else {
                    tale.alertError(result.msg || '设置保存失败');
                }
            }
        });
    }

    /**
     * 保存个性化设置
     */
    function saveIndiviSetting() {
        var param = $('#indivi-form').serialize();
        tale.post({
            url : '/admin/setting',
            data: param,
            success: function (result) {
                if(result && result.success){
                    tale.alertOk('设置保存成功');
                } else {
                    tale.alertError(result.msg || '设置保存失败');
                }
            }
        });
    }
    /**
     * 设置是否允许重新安装
     */
    function allow_reinstall(obj) {
        var this_ = $(obj);
        var on = this_.find('.toggle-on.active').length;
        var off = this_.find('.toggle-off.active').length;
        if (on == 1) {
            $('#allow_install').val(0);
        }
        if (off == 1) {
            $('#allow_install').val(1);
        }
    }

    /**
     * 系统备份
     * @param type
     */
    function backup(type) {
        var param = {
            bk_type: type,
            bk_path: $('#backup_dir').val()
        };
        tale.post({
            url : '/admin/setting/backup',
            data: param,
            success: function (result) {
                if(result && result.success){
                    if(result.payload && result.payload.attach_path){
                        swal('备份成功', '您的附件备份在 <mark>'+ result.payload.attach_path +'</mark><br/><br/>' +
                            '主题备份存储在 <mark>'+ result.payload.theme_path +'</mark>', 'success');
                        $('#backup_dir').val('');
                    }
                    if(result.payload.sql_path){
                        window.location.href = '/upload/' + result.payload.sql_path;
                    }
                } else {
                    tale.alertError(result.msg || '备份失败');
                }
            }
        });
    }

    $('.allow-1').toggles({
        on: true,
        text: {
            on: '开启',
            off: '关闭'
        }
    });
    $('.allow-0').toggles({
        off: true,
        text: {
            on: '开启',
            off: '关闭'
        }
    });
    /*]]>*/
</script>
</body>
</html>