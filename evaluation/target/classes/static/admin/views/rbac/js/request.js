// 生成所搜信息
$.ajax({
    type: "get",
    url: "http://www.zhangpei.bishe.com/resources/list/by",
    async: true,
    success: function (res) {
        console.log("res", res)
        var value = res.permission;
        var result = `<select id="permissionSelect" name="permissionName" lay-verify="" lay-filter="selectRoleName" lay-search>
	    	  <option value="" selected>搜索资源信息(通过名字)</option>`;
        $.each(value, function (index, item) {
            result += `<option value="${item.id}">${item.name}</option>`;
        });
        result += `</select>  `;
        console.log("result", result)
        $(".layui-form").html(result);
    }
});

// 点击创建资源信息
$("#addPermission").click(function () {
    console.log("点击添加");
    var name = "permission";
    //页面层
    layer.open({
        title: "添加资源信息",
        type: 2,
        anim: 5,
        scrollbar:false,
        skin: 'layui-layer-rim', //加上边框
        area: ['350px', '360px'], //宽高
        content: "addPermission.html", //调到新增页面
        btn: ['提交','取消'],
        yes: function (index, layero) {
            console.log("提交信息", index, layero)
        },
        cancel:function (index,layro) {
            console.log("取消",index,layro)
        }
    });
});

// 表格信息展示和操作
layui.use(['table', 'form'], function () {
    var table = layui.table;
    var permiisionTable = table.render({
        elem: '#permissions',
        url: 'http://www.zhangpei.bishe.com/resources/list/by',
        toolbar: true,
        title: '用户数据表',
        cols: [
            [{
                title: '序号',
                width: 40,
                fixed: 'left',
                unresize: true,
                type: 'numbers'
            }, {
                field: 'id',
                title: 'ID',
                width: 80,
                fixed: 'left',
                unresize: true,
                sort: true
            }, {
                field: 'name',
                title: '名字',
                edit: 'text'
            }, {
                field: 'description',
                title: '描述',
                edit: 'text'
            }, {
                field: 'url',
                title: '请求路径',
                edit: 'text'
            }, {
                field: 'method',
                title: '请求方法',
                width: 100,
                edit: 'text'
            }, {
                field: 'use',
                title: '开启/关闭',
                width: 100,
                type: 'normal'
            }, {
                field: 'permissionAll',
                title: '认证访问',
                width: 100,
                edit: 'text'
            }]
        ],
        page: true,
        response: {
            statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
        },
        parseData: function (res) { //将原始数据解析成 table 组件所规定的数据
            console.log('加载数据', res)
            return {
                "code": res.code, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.data.total, //解析数据长度
                "data": res.data.data //解析数据列表
            };
        }
    });

    var form = layui.form

    form.on('select(selectRoleName)', function (data) {
        console.log("点击选择后获取到的信息为", data)
        var value = data.value;
        var options = data.elem.options;
        if (value === "") {
            // 返回所有数据
            console.log("undefined======")
        } else {
            // 按类别返回数据
            var result = options[++value].label;
            console.log("提取出来的值为:", result);
            console.log("index", value)
            permiisionTable.reload({
                where: {
                    permissionName: result
                }, page: {
                    curr: 1
                }
            })
        }

    });

});