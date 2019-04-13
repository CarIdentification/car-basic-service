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
            <dd><a href="/">文章管理</a></dd>
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
          <th lay-data="{field:'topicPic', width:80}">图片</th>
          <th lay-data="{field:'author', width:80}">文章作者</th>
          <th lay-data="{field:'title', width:80, sort: true}">标题</th>
          <th lay-data="{field:'introduce', width:80}">介绍</th>
          <th lay-data="{field:'viewCount', width:80}">浏览数</th>
          <th lay-data="{field:'content', width:135, sort: true}">内容</th>
          <th lay-data="{field:'createTime', width:80, sort: true, fixed: 'right'}">创建时间</th>
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


  <button data-method="notice" class="layui-btn">文章编辑</button>

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
        layer.open({
          //layer提供了5种层类型。可传入的值有：0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
          type: 1,
          title: "修改数据",
          area: ['420px', '330px'],
          content: $("#popUpdateTest"）//引用的弹出层的页面层的方式加载修改界面表单
      });
        //动态向表传递赋值可以参看文章进行修改界面的更新前数据的显示，当然也是异步请求的要数据的修改数据的获取
        setFormValue(obj,data);

      }
    });

    //监听弹出框表单提交，massage是修改界面的表单数据'submit(demo11),是修改按钮的绑定
    function setFormValue(obj,data){
      form.on('submit(demo11)', function(massage) {
        $.ajax({
          url:'/updateCollectorAndConfig',
          type:'POST',
          data:{id:data.id},
          success:function (msg) {
            var returnCode = msg.returnCode;//取得返回数据（Sting类型的字符串）的信息进行取值判断
            if(returnCode==200){
              layer.closeAll('loading');
              layer.load(2);
              layer.msg("修改成功", {icon: 6});
              setTimeout(function(){
                obj.update({
                  id:massage.data.id,
                  title:massage.data.title,
                  eqptType:massage.field.neweqptType
                });//修改成功修改表格数据不进行跳转
                layer.closeAll();//关闭所有的弹出层
              }, 1000);
              加载层-风格
            }else{
              layer.msg("修改失败", {icon: 5});
            }
          }
        })
      })

    }



    //添加采集设备
    $('#btn-add').on('click', function () {
      layer.open({
        type: 2,
        title: '采集设备添加',
        maxmin: true,
        area: ['420px', '330px'],
        shadeClose: false, //点击遮罩不会关闭
        content: 'CollectorAdd-form.html',//添加设备的from表单是在另一个html中，这是弹出方式的第三种方式
      });
    });


    //获取采集设备总数
    $('#btn-get').on('click', function () {
      var msg = "";
      $.ajax({
        url: "/getCollectorInfoTotalRow",
        type: "get",
        success: function (data) {
          var json = JSON.parse(data)
          msg = "采集设备的总数为：" + json.count;
          layer.open({
            type: 1,
            area: ['250px', '180px'],
            btn: '关闭',
            shadeClose: true, //点击遮罩关闭
            content: '<div style="padding:30px;">' + msg + '</div>'
            , yes: function () {
              layer.closeAll();
            }
          });
        }
      });

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

<div class="layui-row" id="popUpdateTest" style="display:none;">
  <div class="layui-col-md10">
    <form class="layui-form layui-from-pane" action="" style="margin-top:20px" >
      <div class="layui-form-item">
        <label class="layui-form-label">采集设备类型</label>
        <div class="layui-input-block">
          <select name="eqptType" lay-filter="eqptType">
            <option value="0a0003biac">0a0003biac</option>
            <option value="0a0003ahup" selected="">0a0003ahup</option>
          </select>
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">id</label>
        <div class="layui-input-block">
          <input type="text" name="id"  required  lay-verify="required" autocomplete="off" placeholder="id" class="layui-input">
        </div>
      </div>
      <div class="layui-form-item">
        <label class="layui-form-label">title</label>
        <div class="layui-input-block">
          <input type="text" name="title"  required  lay-verify="required" autocomplete="off" placeholder="titlr" class="layui-input">
        </div>
      </div>

      <div class="layui-form-item" style="margin-top:40px">
        <div class="layui-input-block">
          <button class="layui-btn  layui-btn-submit " lay-submit="" lay-filter="demo11">确认修改</button>
          <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>