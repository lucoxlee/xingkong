<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../static/layui/css/layui.css">
</head>
<body>
<h1>步骤</h1>
<div class="container-fluid">
    <div class="form-row">
        <div class="form-group col-md-2">
            <label for="containerName">容器名称</label>
            <input type="text" class="form-control" id="containerName">
        </div>

        <div class="form-group col-md-6">
            <label for="port">暴露端口</label>
            <input type="text" class="form-control" id="port" value="3333:22/tcp,1235:1234/tcp">
        </div>
    </div>
    <button type="button" class="btn btn-primary" onclick="makeContainer()">生成容器</button>
    <label id="row1"></label>
    <hr>
    <input type="text" class="form-control" id="data">
    <button type="button" class="btn btn-primary" onclick="inputData()">开始传数据</button>
    <label id="row2"></label>
    <hr>
    <button type="button" class="btn btn-primary">返回结果</button>
    <label id="row3"></label>

    <hr>

    <label >容器列表</label>
    <table class="table table-striped">
        <thead class="thead-light">
        <tr>
            <th scope="col">#</th>
            <th scope="col">state</th>
            <th scope="col">name</th>
            <th scope="col">image</th>
            <th scope="col">port</th>
            <th scope="col">operation</th>
        </tr>
        </thead>
        <tbody id="tbody">
        </tbody>
    </table>
    <hr>
    <div class="card" style="">
        <div class="card-body">
            <h1 class="card-title">容器连接参数</h1>
            <p class="card-text">ssh -p 端口 -i 私钥 app-admin@106.15.58.63</p>
            <a href="http://p9mtsawvo.bkt.clouddn.com/id_rsa_insecure" class="card-link">下载私钥</a>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="../static/layui/layui.js"></script>
<script type="application/javascript">

    var layer;
    layui.use(['layer'], function() {
        layer = layui.layer //弹层
    });

    $(function () {
        $.get("http://localhost:9090/rancher/list", function (data) {
            var arr = data.result;
            $.each(arr, function (index, item) {
                $('#tbody').append("<tr><th scope='row'>"+(index+1)+"</th><td>"+item.state+"</th><td>"+item.name
                        +"</td><td>"+item.image+"</td><td>"+item.port
                        +"</td><td><button type='button' class='btn btn-primary btn-sm' onclick='del(\""+item.id+"\", this)'>del</button></td></tr>");
            })
        })
    });

    function del(id, obj) {
        layer.confirm('is not?', {icon: 3, title:'提示'}, function(index){
            layer.close(index);

            if (id == null || id == '') {
                location.reload();
                return;
            }

            $.ajax({
                url: "http://localhost:9090/rancher/del/"+id,
                type: "DELETE",
                success: function(data) {
                    if (data) {
                        $(obj).parent().parent().remove();
                        layer.msg('删除成功');
                    } else {
                        layer.msg("删除失败");
                    }
                }
            })
        });
    }

    function makeContainer() {
        $.get("http://localhost:9090/rancher/add?containerName="+$("#containerName").val()+"&port="+$("#port").val(), function (data) {
            if (data) {
                layer.msg('生成成功');
                location.reload();
            } else {
                layer.msg("生成失败");
            }
        });
    }

    function inputData() {
        $.get("http://localhost:9090/hadoop/inputData?name=" + $("#data").val(), function (data) {
            $('#row2').html(data.input)
            $('#row3').html(data.output)
        });
    }


</script>
</body>
</html>