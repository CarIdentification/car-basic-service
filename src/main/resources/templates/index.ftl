<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>随识车</title>
  <link rel="stylesheet" href="https://joeytsai03.github.io/resource/layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body ">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo" style="font-size:30px; color: #0D5661 ">随识车</div>
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
      <table class="layui-table"
             lay-data="{width: 1100, height:332, url:'http://localhost:8763/issue/list', page:true, id:'idTest'}"
             lay-filter="demo">
        <thead>
        <tr>
          <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
          <th lay-data="{field:'id', width:80, sort: true, fixed: true}">ID</th>
          <th lay-data="{field:'username', width:80}">用户名</th>
          <th lay-data="{field:'author', width:80, sort: true}">性别</th>
          <th lay-data="{field:'createTime', width:80}">城市</th>
          <th lay-data="{field:'title', width:160}">签名</th>
          <th lay-data="{field:'topicPic', width:80, sort: true}">积分</th>

          <th lay-data="{field:'viewCount', width:80}">职业</th>
          <th lay-data="{field:'content', width:135, sort: true}">财富</th>
          <th lay-data="{field:'introduce', width:80, sort: true, fixed: 'right'}">评分</th>
          <th lay-data="{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}"></th>
        </tr>
        </thead>
      </table>
      <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
      </script>
    </div>
  </div>

  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © suishiche.com - c525东东在线coding
  </div>
</div>
<script src="https://joeytsai03.github.io/resource/layui/layui.js"></script>
<script type="text/javascript">
  //JavaScript代码区域
  layui.use('element', function () {
    var element = layui.element;

  });

  layui.use('table', function () {
    var table = layui.table;
    //监听表格复选框选择
    table.on('checkbox(demo)', function (obj) {
      console.log(obj)
    });
    //监听工具条
    table.on('tool(demo)', function (obj) {
      var data = obj.data;
      if (obj.event === 'detail') {
        layer.msg('ID：' + data.id + ' 的查看操作');
      } else if (obj.event === 'del') {
        layer.confirm('真的删除行么', function (index) {
          obj.del();
          layer.close(index);
        });
      } else if (obj.event === 'edit') {
        layer.alert('编辑行：<br>' + JSON.stringify(data))
      }
    });

    var $ = layui.$, active = {
      getCheckData: function () { //获取选中数据
        var checkStatus = table.checkStatus('idTest'), data = checkStatus.data;
        layer.alert(JSON.stringify(data));
      }, getCheckLength: function () { //获取选中数目
        var checkStatus = table.checkStatus('idTest'), data = checkStatus.data;
        layer.msg('选中了：' + data.length + ' 个');
      }, isAll: function () { //验证是否全选
        var checkStatus = table.checkStatus('idTest');
        layer.msg(checkStatus.isAll ? '全选' : '未全选')
      }
    };

    $('.demoTable .layui-btn').on('click', function () {
      var type = $(this).data('type');
      active[type] ? active[type].call(this) : '';
    });
  });

</script>
</body>
</html>