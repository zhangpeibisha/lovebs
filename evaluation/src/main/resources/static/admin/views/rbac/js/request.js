$.ajax({
	type:"get",
	url:"https://www.easy-mock.com/mock/5c8de5546fe7c7611499c741/evaluation/admin/permission/list",
	async:true,
	success:function(res){
		console.log("res",res)
		var value = res.permission;
		var result = `<select id="permissionSelect" name="permissionName" lay-verify="" lay-filter="selectRoleName" lay-search>
	    	  <option value="" selected>搜索资源信息(通过名字)</option>`;
		$.each(value, function(index,item) {
			result += `<option value="${item.id}">${item.name}</option>`;
		});
		result += `</select>  `;
		console.log("result",result)
		$(".layui-form").html(result);
	}
});