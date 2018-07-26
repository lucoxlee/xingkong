<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>步骤</h1>
<div class="container-fluid">
    <button type="button" class="btn btn-primary" onclick="makeFile()">生成文件</button>
    <label id="row1"></label>
    <hr>
    <button type="button" class="btn btn-primary" onclick="copyFile()">上传文件到hdfs</button>
    <label id="row2"></label>
    <hr>
    <button type="button" class="btn btn-primary" onclick="doJob()">分析hdfs文件存入hbase</button>
    <label id="row3"></label>
    <hr>
    <label >查询hbase接口</label>
    <input type="text" class="form-control" id="data" >
    <button type="button" class="btn btn-primary" onclick="getRowByKey()">获取指定name</button>
    <button type="button" class="btn btn-primary" onclick="getRegexRowByKey()">获取正则name</button>
    <button type="button" class="btn btn-primary" onclick="cityNumAll()">获取全部，慎点</button>
    <div id="row4"></div>

</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="application/javascript">
    function makeFile() {
        $.get("http://localhost:9090/hadoop/makeFile",function(data){
            $('#row1').html(data)
        });
    }
    function copyFile() {
        $.get("http://localhost:9090/hadoop/copyFile",function(data){
            $('#row2').html(data)
        });

    }
    function doJob() {
        $.get("http://localhost:9090/hadoop/doJob",function(data){
            $('#row3').html(data)
        });

    }
    function getRowByKey() {
        $.get("http://localhost:9090/hadoop/getRowByKey?name="+$("#data").val(),function(data){
            $('#row4').html(JSON.stringify(data))
        });

    }
    function getRegexRowByKey() {
        $.get("http://localhost:9090/hadoop/getRegexRowByKey?regex="+$("#data").val(),function(data){
            $('#row4').html(JSON.stringify(data))
        });

    }
    function cityNumAll() {
        $.get("http://localhost:9090/hadoop/cityNumAll",function(data){
            $('#row4').html(JSON.stringify(data))
        });

    }

</script>
</body>
</html>