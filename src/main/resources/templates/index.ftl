<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>随识车</title>
  <link rel="stylesheet" href="https://joeytsai03.github.io/resource/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">随识车</div>
  </div>

  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree" lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">所有商品</a>
          <dl class="layui-nav-child">
            <dd><a href="/">车库管理</a></dd>
            <dd><a href="">超链接</a></dd>
            <dd><a href="">超链接</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>

  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
      <table class="layui-hide" id="test"></table>
    </div>
  </div>

  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © suishiche.com - c525东东在线coding
  </div>
</div>
<script src="https://joeytsai03.github.io/resource/layui/layui.js"></script>
<script type="text/javascript" >
  //JavaScript代码区域
  layui.use('element', function () {
    var element = layui.element;

  });
  layui.use('table', function () {
    var table = layui.table;
    table.render({
      elem: '#test'
      , url: 'http://localhost:8763/issue/list'
      , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
      , cols: [[
        {field: 'id', width: 80, title: 'ID', sort: true}
        , {field: 'username', width: 80, title: '用户名'}
        , {field: 'author', width: 80, title: '性别', sort: true}
        , {field: 'createTime', width: 80, title: '城市'}
        , {field: 'title', title: '签名', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
        , {field: 'topicPic', title: '积分', sort: true}
        , {field: 'viewCount', title: '评分', sort: true}
        , {field: 'content', title: '职业'}
        , {field: 'introduce', width: 137, title: '财富', sort: true}
      ]]
    });
  });
</script>
</body>
</html>