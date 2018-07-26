<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>步骤</h1>
<div class="container-fluid">
    <button type="button" class="btn btn-primary" onclick="makeContainer()">生成容器</button>
    <label id="row1"></label>
    <hr>
    <input type="text" class="form-control" id="data" >
    <button type="button" class="btn btn-primary" onclick="inputData()">开始传数据</button>
    <label id="row2"></label>
    <hr>
    <button type="button" class="btn btn-primary">返回结果</button>
    <label id="row3"></label>

</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="application/javascript">
    function makeContainer() {

    }
    function inputData() {
        $.get("http://localhost:9090/hadoop/inputData?name="+$("#data").val(),function(data){
            $('#row2').html(data.input)
            $('#row3').html(data.output)
        });
    }


</script>
</body>
</html>