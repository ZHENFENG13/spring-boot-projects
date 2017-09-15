<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" th:with="title='保存文章',active='publish'">
<header th:replace="admin/header::headerFragment(${title},${active})"></header>
<link th:href="@{/admin/plugins/tagsinput/jquery.tagsinput.css}" rel="stylesheet"/>
<link th:href="@{/admin/plugins/select2.dist.css/select2-bootstrap.css}" rel="stylesheet"/>
<link th:href="@{/admin/plugins/toggles/toggles.css}" rel="stylesheet"/>

<link href="//cdn.bootcss.com/multi-select/0.9.12/css/multi-select.css" rel="stylesheet"/>
<link href="//cdn.bootcss.com/select2/3.4.8/select2.min.css" rel="stylesheet"/>
<link th:href="@{/admin/plugins/md/css/style.css}" rel="stylesheet"/>
<style>
    #tags_tagsinput {
        background-color: #fafafa;
        border: 1px solid #eeeeee;
    }

    #tags_addTag input {
        width: 100%;
    }

    #tags_addTag {
        margin-top: -5px;
    }
</style>
<body class="fixed-left">
<div id="wrapper">
    <div th:replace="admin/header::header-body"></div>
    <div class="content-page">
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <h4 class="page-title">
                            <th:block th:if="${null != contents}">
                                编辑文章
                            </th:block>
                            <th:block th:unless="${null != contents}">
                                发布文章
                            </th:block>
                        </h4>
                    </div>
                    <div class="col-md-12">
                        <form id="articleForm" role="form" novalidate="novalidate">
                            <input type="hidden" name="categories" id="categories"/>
                            <input type="hidden" name="cid"
                                   th:value="${contents!=null and contents.cid!=null}?${contents.cid}: ''" id="cid"/>
                            <input type="hidden" name="status"
                                   th:value="${contents!=null and contents.status !=null}?${contents.status}: 'publish'"
                                   id="status"/>
                            <input type="hidden" name="allowComment"
                                   th:value="${contents!=null and contents.allowComment !=null}?${contents.allowComment}: true"
                                   id="allow_comment"/>
                            <input type="hidden" name="allowPing"
                                   th:value="${contents!=null and contents.allowPing !=null}?${contents.allowPing}: true"
                                   id="allow_ping"/>
                            <input type="hidden" name="allowFeed"
                                   th:value="${contents!=null and contents.allowFeed !=null}?${contents.allowFeed}: true"
                                   id="allow_feed"/>
                            <input type="hidden" name="content" id="content-editor"/>

                            <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                                <input type="text" class="form-control" placeholder="请输入文章标题（必须）" name="title"
                                       required="required"
                                       aria-required="true"
                                       th:value="${contents!=null and contents.title!=null }?${contents.title}: ''"/>
                            </div>

                            <div class="form-group col-md-6" style="padding: 0 0 0 10px;">
                                <input type="text" class="form-control"
                                       placeholder="自定义访问路径，如：my-first-article  默认为文章id" name="slug"
                                       th:value="${contents!=null and contents.slug !=null}?${contents.slug}: ''"/>
                            </div>

                            <div class="form-group col-md-6" style="padding: 0 10px 0 0;">
                                <input name="tags" id="tags" type="text" class="form-control" placeholder="请填写文章标签"
                                       th:value="${contents!=null and contents.tags !=null}?${contents.tags}: ''"/>
                            </div>

                            <div class="form-group col-md-6">
                                <select id="multiple-sel" class="select2 form-control" multiple="multiple"
                                        data-placeholder="请选择分类...">
                                    <th:block th:if="${null == categories}">
                                        <option value="默认分类" selected="selected">默认分类</option>
                                    </th:block>
                                    <th:block th:unless="${null == categories}">
                                        <th:block th:each="c : ${categories}">
                                            <option th:value="${c.name}" th:text="${c.name}"
                                                    th:selected="${null !=contents and adminCommons.exist_cat(c, contents.categories)}?true:false"></option>
                                        </th:block>
                                    </th:block>
                                </select>
                            </div>
                            <div class="clearfix"></div>
                            <div class="form-group">
                                <textarea style="height: 450px" autocomplete="off" id="text" name="text"
                                          class="markdown-textarea"
                                          th:utext="${contents!=null and contents.content !=null}?${contents.content}: ''"></textarea>
                            </div>

                            <div class="form-group col-md-3 col-sm-4">
                                <label class="col-sm-4">开启评论</label>
                                <div class="col-sm-8">
                                    <div th:class="${contents!=null and contents.allowComment!=null }?'toggle toggle-success allow-'+${contents.allowComment}:'toggle toggle-success allow-true'"
                                         onclick="allow_comment(this);"></div>
                                </div>
                            </div>

                            <div class="form-group col-md-3 col-sm-4">
                                <label class="col-sm-4">允许Ping</label>
                                <div class="col-sm-8">
                                    <div th:class="${contents!=null and contents.allowPing !=null}?'toggle toggle-success allow-'+${contents.allowPing}:'toggle toggle-success allow-true'"
                                         onclick="allow_ping(this);"></div>
                                </div>
                            </div>

                            <div class="form-group col-md-3 col-sm-4">
                                <label class="col-sm-4">允许订阅</label>
                                <div class="col-sm-8">
                                    <div th:class="${contents!=null and  contents.allowFeed !=null}?'toggle toggle-success allow-'+${contents.allowFeed}: 'toggle toggle-success allow-true'"
                                         onclick="allow_feed(this);"></div>
                                </div>
                            </div>

                            <div class="clearfix"></div>

                            <div class="text-right">
                                <a class="btn btn-default waves-effect waves-light" th:href="@{/admin/article}">返回列表</a>
                                <button type="button" class="btn btn-primary waves-effect waves-light"
                                        onclick="subArticle('publish');">
                                    保存文章
                                </button>
                                <button type="button" class="btn btn-warning waves-effect waves-light"
                                        onclick="subArticle('draft');">
                                    存为草稿
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
                <div th:replace="admin/footer :: footer-content"></div>
            </div>
        </div>
    </div>
</div>
<div th:replace="admin/footer :: footer"></div>

<script th:src="@{/admin/plugins/tagsinput/jquery.tagsinput.min.js}"></script>
<script th:src="@{/admin/plugins/jquery-multi-select/jquery.quicksearch.js}"></script>

<script th:src="@{/admin/plugins/md/js/jquery.scrollto.js}"></script>
<script th:src="@{/admin/plugins/md/js/pagedown.js}"></script>
<script th:src="@{/admin/plugins/md/js/pagedown-extra.js}"></script>
<script th:src="@{/admin/plugins/md/js/diff.js}"></script>
<script th:src="@{/admin/plugins/md/js/md.js}"></script>

<script th:src="@{//cdn.bootcss.com/multi-select/0.9.12/js/jquery.multi-select.min.js}"></script>
<script th:src="@{//cdn.bootcss.com/select2/3.4.8/select2.min.js}"></script>
<script th:src="@{//cdn.bootcss.com/jquery-toggles/2.0.4/toggles.min.js}"></script>
<script th:src="@{/admin/js/article.js}"></script>
</body>
</html>