webpackJsonp([11],{"2CbG":function(e,t,i){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var l=i("woOf"),a=i.n(l),n=i("VLUi"),s={key:null,word:null,blurry:!1,page:1,limit:5},r={name:"studentList",data:function(){return{editSkuInfo:{dialogVisible:!1,keyword:null},operateType:null,listQuery:a()({},s),list:null,total:null,listLoading:!0,selectProductCateValue:null,multipleSelection:[],facultyList:[],professionList:[],classes:[],editDialog:!1,teacher:{},dialogTitle:""}},created:function(){this.getList()},methods:{getList:function(){var e=this;this.listLoading=!0,this.listQuery.quire="and 1 = 1",this.listQuery.keyword&&(this.listQuery.quire+=" and (name like '%"+this.listQuery.keyword+"%' or jobNumber like '%"+this.listQuery.keyword+"%' or phone like '%"+this.listQuery.keyword+"%'  or email like '%"+this.listQuery.keyword+"%')"),this.listQuery.jobnumber&&(this.listQuery.quire+=" and jobnumber = "+this.listQuery.jobnumber),this.listQuery.name&&(this.listQuery.quire+=" and name = '"+this.listQuery.name+"'"),Object(n.e)(this.listQuery).then(function(t){e.listLoading=!1,e.list=t.data.data,e.total=1,console.log("获取到的数据为：",t)})},handleSizeChange:function(e){this.listQuery.page=1,this.listQuery.limit=e,this.getList()},handleCurrentChange:function(e){this.listQuery.page=e,this.getList()},handleSelectionChange:function(e){this.multipleSelection=e},handleResetSearch:function(){this.selectProductCateValue=[],this.listQuery=a()({},s)},handleDelete:function(e,t){var i=this;console.log("index=",e,t),this.$confirm("是否要进行删除操作?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){var l=[];t&&(console.log("index====",e,t),l.push(t.id)),i.multipleSelection.forEach(function(e){return l.push(e.id)}),Object(n.a)(l),i.getList()})},edit:function(){var e=this,t=this.teacher;console.log("返回的数据为：==================",t),t.id?Object(n.f)(this.teacher).then(function(t){console.log("返回的数据为：",t),e.getList()}):(Object(n.c)([this.teacher]).then(function(e){console.log("返回的数据为：",e)}),this.getList()),this.editDialog=!1}}},o={render:function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"app-container",staticStyle:{height:"500px","overflow-y":"scroll"}},[i("el-card",{staticClass:"filter-container",attrs:{shadow:"never"}},[i("div",[i("i",{staticClass:"el-icon-search"}),e._v(" "),i("span",[e._v("筛选搜索")]),e._v(" "),i("el-button",{staticStyle:{float:"right"},attrs:{type:"primary",size:"small"},on:{click:function(t){e.getList()}}},[e._v("查询结果")]),e._v(" "),i("el-button",{staticStyle:{float:"right","margin-right":"15px"},attrs:{size:"small"},on:{click:function(t){e.handleResetSearch()}}},[e._v("重置")])],1),e._v(" "),i("div",{staticStyle:{"margin-top":"15px"}},[i("el-form",{attrs:{inline:!0,model:e.listQuery,size:"small","label-width":"140px"}},[i("el-form-item",{attrs:{label:"输入搜索："}},[i("el-input",{staticStyle:{width:"203px"},attrs:{placeholder:"关键字"},model:{value:e.listQuery.keyword,callback:function(t){e.$set(e.listQuery,"keyword",t)},expression:"listQuery.keyword"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"工号："}},[i("el-input",{staticStyle:{width:"203px"},attrs:{placeholder:"工号"},model:{value:e.listQuery.jobnumber,callback:function(t){e.$set(e.listQuery,"jobnumber",t)},expression:"listQuery.jobnumber"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"姓名："}},[i("el-input",{staticStyle:{width:"203px"},attrs:{placeholder:"姓名"},model:{value:e.listQuery.name,callback:function(t){e.$set(e.listQuery,"name",t)},expression:"listQuery.name"}})],1)],1)],1)]),e._v(" "),i("el-card",{staticClass:"operate-container",attrs:{shadow:"never"}},[i("i",{staticClass:"el-icon-tickets"}),e._v(" "),i("span",[e._v("老师数据")]),e._v(" "),i("el-button",{staticClass:"btn-add",attrs:{type:"danger",size:"mini"},on:{click:function(t){e.handleDelete()}}},[e._v("删除")]),e._v(" "),i("el-button",{staticClass:"btn-add",attrs:{size:"mini"},on:{click:function(t){e.teacher={},e.editDialog=!0,e.dialogTitle="添加"}}},[e._v("添加")])],1),e._v(" "),i("div",{staticClass:"table-container"},[i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],ref:"studentTable",staticStyle:{width:"100%"},attrs:{data:e.list,border:""},on:{"selection-change":e.handleSelectionChange}},[i("el-table-column",{attrs:{type:"selection",width:"60",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{label:"头像",width:"100",align:"center"},scopedSlots:e._u([{key:"default",fn:function(e){return[i("img",{staticStyle:{height:"80px",width:"80px"},attrs:{src:e.row.imagerurl}})]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"工号",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.jobnumber))]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"姓名",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.name))]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"手机号码",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.phone))]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"邮箱",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(e._s(t.row.email))]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"操作"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{size:"mini"},on:{click:function(i){e.teacher=t.row,e.editDialog=!0,e.teacher.type="see",e.dialogTitle="查看"}}},[e._v("查看")]),e._v(" "),i("el-button",{attrs:{size:"mini"},on:{click:function(i){e.teacher=t.row,e.editDialog=!0,e.dialogTitle="编辑",e.teacher.type="edit"}}},[e._v("编辑")]),e._v(" "),i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(i){e.handleDelete(t.$index,t.row)}}},[e._v("删除")])]}}])})],1)],1),e._v(" "),i("div",{staticClass:"pagination-container"},[i("el-pagination",{attrs:{background:"",layout:"total, sizes,prev, pager, next,jumper","page-size":e.listQuery.limit,"page-sizes":[5,10,15],"current-page":e.listQuery.page,total:e.total},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange,"update:currentPage":function(t){e.$set(e.listQuery,"page",t)}}})],1),e._v(" "),i("el-dialog",{attrs:{title:e.dialogTitle,visible:e.editDialog,width:"30%"},on:{"update:visible":function(t){e.editDialog=t}}},[i("el-form",{attrs:{"label-width":"80px"}},[i("el-form-item",{attrs:{label:"工号"}},[i("el-input",{attrs:{disabled:"see"==e.teacher.type},model:{value:e.teacher.jobnumber,callback:function(t){e.$set(e.teacher,"jobnumber",t)},expression:"teacher.jobnumber"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"姓名"}},[i("el-input",{attrs:{disabled:"see"==e.teacher.type},model:{value:e.teacher.name,callback:function(t){e.$set(e.teacher,"name",t)},expression:"teacher.name"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"手机号码"}},[i("el-input",{attrs:{disabled:"see"==e.teacher.type},model:{value:e.teacher.phone,callback:function(t){e.$set(e.teacher,"phone",t)},expression:"teacher.phone"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"邮箱"}},[i("el-input",{attrs:{disabled:"see"==e.teacher.type},model:{value:e.teacher.email,callback:function(t){e.$set(e.teacher,"email",t)},expression:"teacher.email"}})],1)],1),e._v(" "),"see"!=e.teacher.type?i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.editDialog=!1}}},[e._v("取 消")]),e._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:function(t){e.edit()}}},[e._v("确 定")])],1):e._e()],1)],1)},staticRenderFns:[]};var c=i("VU/8")(r,o,!1,function(e){i("unOV")},null,null);t.default=c.exports},unOV:function(e,t){}});
//# sourceMappingURL=11.6ed61f9198aac016bbf5.js.map