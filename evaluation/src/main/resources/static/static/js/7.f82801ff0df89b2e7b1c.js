webpackJsonp([7],{h0S9:function(e,t,i){"use strict";t.c=function(e){return Object(s.a)({url:"/course/quire/list",method:"get",params:e})},t.e=function(e){return Object(s.a)({url:"/course/update",method:"put",params:e})},t.b=function(e){var t=e[0];return Object(s.a)({url:"/course/add",method:"post",params:{coding:t.coding,name:t.name,description:t.description}})},t.a=function(e){console.log("删除获取到的参数为==========",e);var t="";e&&e.forEach(function(e){console.log("444444",e),t+=e+","});return console.log("删除获取到的参数为",t),Object(s.a)({url:"/course/ids",method:"delete",params:{ids:t}})},t.d=function(e){return Object(s.a)({url:"/studentCourse/findTeacher",method:"get",params:{courseId:e}})};var s=i("vLgD")},wOLO:function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=i("woOf"),o=i.n(s),a=i("h0S9"),l=i("VLUi"),n=i("ArgV"),r=i("ts7I"),c={key:null,word:null,blurry:!1,page:1,limit:5},u={name:"studentList",data:function(){return{editSkuInfo:{dialogVisible:!1,keyword:null},operateType:null,listQuery:o()({},c),list:null,total:null,listLoading:!0,selectProductCateValue:null,multipleSelection:[],facultyList:[],professionList:[],classes:[],editDialog:!1,course:{},courseTeacher:{course:{name:""}},teacherList:[],teacherId:"",addTeacherView:!1,formLabelWidth:"120px",dialogTitle:"",userType:"",teacherListByCourseId:[],addCourseView:!1}},created:function(){this.getList(),this.getTeacherList(),this.findUserType()},methods:{findUserType:function(){var e=this;Object(n.b)().then(function(t){e.userType=t.data.userType})},getList:function(){var e=this;this.listLoading=!0,this.listQuery.quire="and 1 = 1",this.listQuery.keyword&&(this.listQuery.quire+=" and (name like '%"+this.listQuery.keyword+"%' or coding like '%"+this.listQuery.keyword+"%' or description like '%"+this.listQuery.keyword+"%')"),this.listQuery.coding&&(this.listQuery.quire+=" and coding = "+this.listQuery.coding),this.listQuery.name&&(this.listQuery.quire+=" and name = '"+this.listQuery.name+"'"),console.log("5656ddddd获取到的数据为：=========="),Object(a.c)(this.listQuery).then(function(t){e.listLoading=!1,e.list=t.data.data,e.total=1,console.log("565656asdsa获取到的数据为：",list)})},handleSizeChange:function(e){this.listQuery.page=1,this.listQuery.limit=e,this.getList()},getTeacherList:function(){var e=this;Object(l.e)().then(function(t){console.log("获取老师信息为",t),e.teacherList=t.data.data})},handleCurrentChange:function(e){this.listQuery.page=e,this.getList()},handleSelectionChange:function(e){this.multipleSelection=e},handleResetSearch:function(){this.selectProductCateValue=[],this.listQuery=o()({},c)},handleDelete:function(e,t){var i=this;console.log("index=",e,t),this.$confirm("是否要进行删除操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var s=[];t&&(console.log("index====",e,t),s.push(t.id)),i.multipleSelection.forEach(function(e){return s.push(e.id)}),Object(a.a)(s),i.getList()})},edit:function(){var e=this,t=this.course;console.log("返回的数据为：==================",t),t.id?Object(a.e)(this.course).then(function(t){console.log("返回的数据为：",t),e.getList()}):Object(a.b)([this.course]).then(function(t){console.log("返回的数据为：",t),e.getList()}),this.editDialog=!1},addTeacher:function(e,t){console.log("addTeacher获取的数据为：",e,t,this.teacherId),this.courseTeacher.course=t,this.addTeacherView=!0},chooseTeacher:function(){this.courseTeacher.teacherId=this.teacherId},submitAddTeacher:function(){var e=this;Object(l.b)(this.courseTeacher).then(function(t){e.addTeacherView=!1,console.log("获取结果",t)})},chooseCourse:function(e,t){t&&(this.courseTeacher.course=t,this.findCourseTeacher(t.id)),this.addCourseView=!0},submitChooseCourse:function(){var e=this;console.log("提交结果为：",this.teacherId,this.courseTeacher.course),Object(r.b)(this.courseTeacher.course.id,this.teacherId).then(function(t){console.log("加课结果为：",t),e.addCourseView=!1})},findCourseTeacher:function(e){var t=this;Object(a.d)(e).then(function(e){t.teacherListByCourseId=e.data})}}},d={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"app-container",staticStyle:{height:"500px","overflow-y":"scroll"}},[i("el-card",{staticClass:"filter-container",attrs:{shadow:"never"}},[i("div",[i("i",{staticClass:"el-icon-search"}),e._v(" "),i("span",[e._v("筛选搜索")]),e._v(" "),i("el-button",{staticStyle:{float:"right"},attrs:{type:"primary",size:"small"},on:{click:function(t){e.getList()}}},[e._v("查询结果")]),e._v(" "),i("el-button",{staticStyle:{float:"right","margin-right":"15px"},attrs:{size:"small"},on:{click:function(t){e.handleResetSearch()},"selection-change":e.handleSelectionChange}},[e._v("重置\n      ")])],1),e._v(" "),i("div",{staticStyle:{"margin-top":"15px"}},[i("el-form",{attrs:{inline:!0,model:e.listQuery,size:"small","label-width":"140px"}},[i("el-form-item",{attrs:{label:"输入搜索："}},[i("el-input",{staticStyle:{width:"203px"},attrs:{placeholder:"关键字"},model:{value:e.listQuery.keyword,callback:function(t){e.$set(e.listQuery,"keyword",t)},expression:"listQuery.keyword"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"课程编码："}},[i("el-input",{staticStyle:{width:"203px"},attrs:{placeholder:"课程编码"},model:{value:e.listQuery.coding,callback:function(t){e.$set(e.listQuery,"coding",t)},expression:"listQuery.coding"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"课程名字："}},[i("el-input",{staticStyle:{width:"203px"},attrs:{placeholder:"课程名字"},model:{value:e.listQuery.name,callback:function(t){e.$set(e.listQuery,"name",t)},expression:"listQuery.name"}})],1)],1)],1)]),e._v(" "),i("el-card",{staticClass:"operate-container",attrs:{shadow:"never"}},[i("i",{staticClass:"el-icon-tickets"}),e._v(" "),i("span",[e._v("课程数据")]),e._v(" "),"TEACHER"===e.userType?i("el-button",{staticClass:"btn-add",attrs:{type:"danger",size:"mini"},on:{click:function(t){e.handleDelete()}}},[e._v("删除")]):e._e(),e._v(" "),"TEACHER"===e.userType?i("el-button",{staticClass:"btn-add",attrs:{size:"mini"},on:{click:function(t){e.course={},e.editDialog=!0,e.dialogTitle="添加"}}},[e._v("添加\n    ")]):e._e()],1),e._v(" "),i("div",{staticClass:"table-container"},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],ref:"studentTable",staticStyle:{width:"100%"},attrs:{data:e.list,border:""},on:{"selection-change":e.handleSelectionChange}},[i("el-table-column",{attrs:{type:"selection",width:"60",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{label:"课程编号",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.coding))]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"课程名",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.name))]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"课程描述",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.description))]}}])}),e._v(" "),i("el-table-column",{staticStyle:{width:"600px"},attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{size:"mini"},on:{click:function(i){e.course=t.row,e.editDialog=!0,e.course.type="see",e.dialogTitle="查看"}}},[e._v("查看\n          ")]),e._v(" "),"TEACHER"===e.userType?i("el-button",{attrs:{size:"mini"},on:{click:function(i){e.course=t.row,e.editDialog=!0,e.dialogTitle="编辑",e.course.type="edit"}}},[e._v("编辑\n          ")]):e._e(),e._v(" "),"TEACHER"===e.userType?i("el-button",{attrs:{size:"mini",type:"success"},on:{click:function(i){e.addTeacher(t.$index,t.row)}}},[e._v("添加老师\n          ")]):e._e(),e._v(" "),"TEACHER"===e.userType?i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(i){e.handleDelete(t.$index,t.row)}}},[e._v("删除\n          ")]):e._e(),e._v(" "),"STUDENT"===e.userType?i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(i){e.chooseCourse(t.$index,t.row)}}},[e._v("选课\n          ")]):e._e()]}}])})],1)],1),e._v(" "),i("div",{staticClass:"pagination-container"},[i("el-pagination",{attrs:{background:"",layout:"total, sizes,prev, pager, next,jumper","page-size":e.listQuery.limit,"page-sizes":[5,10,15],"current-page":e.listQuery.page,total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.listQuery,"page",t)}}})],1),e._v(" "),i("el-dialog",{attrs:{title:e.dialogTitle,visible:e.editDialog,width:"30%"},on:{"update:visible":function(t){e.editDialog=t}}},[i("el-form",{attrs:{"label-width":"80px"}},[i("el-form-item",{attrs:{label:"课程名字"}},[i("el-input",{attrs:{disabled:"see"==e.course.type},model:{value:e.course.name,callback:function(t){e.$set(e.course,"name",t)},expression:"course.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"课程编号"}},[i("el-input",{attrs:{disabled:"see"==e.course.type},model:{value:e.course.coding,callback:function(t){e.$set(e.course,"coding",t)},expression:"course.coding"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"描述"}},[i("el-input",{attrs:{disabled:"see"==e.course.type},model:{value:e.course.description,callback:function(t){e.$set(e.course,"description",t)},expression:"course.description"}})],1)],1),e._v(" "),"see"!=e.course.type?i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.editDialog=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:function(t){e.edit()}}},[e._v("确 定")])],1):e._e()],1),e._v(" "),i("el-dialog",{attrs:{title:"添加老师",visible:e.addTeacherView},on:{"update:visible":function(t){e.addTeacherView=t}}},[i("el-form",{attrs:{model:e.courseTeacher,inline:""}},[i("el-form-item",{attrs:{label:"课程名字","label-width":e.formLabelWidth}},[i("el-input",{attrs:{autocomplete:"off",disabled:""},model:{value:e.courseTeacher.course.name,callback:function(t){e.$set(e.courseTeacher.course,"name",t)},expression:"courseTeacher.course.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"老师"}},[i("el-select",{attrs:{placeholder:"请选择老师",clearable:"",filterable:""},on:{change:e.chooseTeacher},model:{value:e.teacherId,callback:function(t){e.teacherId=t},expression:"teacherId"}},e._l(e.teacherList,function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.accountid}})}))],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.addTeacherView=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.submitAddTeacher}},[e._v("确 定")])],1)],1),e._v(" "),i("el-dialog",{attrs:{title:"选择老师",visible:e.addCourseView},on:{"update:visible":function(t){e.addCourseView=t}}},[i("el-form",{attrs:{model:e.courseTeacher,inline:""}},[i("el-form-item",{attrs:{label:"课程名字","label-width":e.formLabelWidth}},[i("el-input",{attrs:{autocomplete:"off",disabled:""},model:{value:e.courseTeacher.course.name,callback:function(t){e.$set(e.courseTeacher.course,"name",t)},expression:"courseTeacher.course.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"老师"}},[i("el-select",{attrs:{placeholder:"请选择老师",clearable:"",filterable:""},on:{change:e.chooseTeacher},model:{value:e.teacherId,callback:function(t){e.teacherId=t},expression:"teacherId"}},e._l(e.teacherListByCourseId,function(e){return i("el-option",{key:e.id,attrs:{label:e.name,value:e.accountid}})}))],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.addCourseView=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:e.submitChooseCourse}},[e._v("确 定")])],1)],1)],1)},staticRenderFns:[]};var h=i("VU/8")(u,d,!1,function(e){i("yJ2r")},null,null);t.default=h.exports},yJ2r:function(e,t){}});
//# sourceMappingURL=7.f82801ff0df89b2e7b1c.js.map