(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5960a6ee"],{"0442":function(t,e,a){"use strict";var n=a("ba4a"),r=a.n(n);r.a},"1bab":function(t,e,a){"use strict";a.d(e,"a",(function(){return i}));a("d3b7");var n=a("bc3a"),r=a.n(n);function i(t){return new Promise((function(e,a){var n=r.a.create({timeout:3e3});n(t).then((function(t){e(t)})).catch((function(t){a(t)}))}))}},"4d63":function(t,e,a){var n=a("83ab"),r=a("da84"),i=a("94ca"),s=a("7156"),o=a("9bf2").f,l=a("241c").f,c=a("44e7"),u=a("ad6d"),d=a("9f7f"),p=a("6eeb"),f=a("d039"),g=a("69f3").set,h=a("2626"),m=a("b622"),b=m("match"),_=r.RegExp,y=_.prototype,v=/a/g,w=/a/g,x=new _(v)!==v,D=d.UNSUPPORTED_Y,k=n&&i("RegExp",!x||D||f((function(){return w[b]=!1,_(v)!=v||_(w)==w||"/a/i"!=_(v,"i")})));if(k){var S=function(t,e){var a,n=this instanceof S,r=c(t),i=void 0===e;if(!n&&r&&t.constructor===S&&i)return t;x?r&&!i&&(t=t.source):t instanceof S&&(i&&(e=u.call(t)),t=t.source),D&&(a=!!e&&e.indexOf("y")>-1,a&&(e=e.replace(/y/g,"")));var o=s(x?new _(t,e):_(t,e),n?this:y,S);return D&&a&&g(o,{sticky:a}),o},C=function(t){t in S||o(S,t,{configurable:!0,get:function(){return _[t]},set:function(e){_[t]=e}})},M=l(_),$=0;while(M.length>$)C(M[$++]);y.constructor=S,S.prototype=y,p(r,"RegExp",S)}h("RegExp")},5060:function(t,e,a){"use strict";a.d(e,"a",(function(){return i})),a.d(e,"b",(function(){return s}));a("d3b7"),a("4d63"),a("ac1f"),a("25f0"),a("5319");var n=a("1bab"),r=a("4360");function i(t,e){if(e.data instanceof Object){var a=r["a"].getters.userinfo;delete a.accessList,console.log(a),e.data.user=r["a"].getters.userinfo}return e.timeout=e.timeout?e.timeout:2500,new Promise((function(a,r){Object(n["a"])(e).then((function(e){var n=e.data.code;if(200===n)a(e);else if(-1===n){var i=e.data.message;t.$message.error(i)}else 100===n&&r(e)})).catch((function(e){t.$message.error("服务器开小差了!")}))}))}function s(t){if(!t)return"";var e=new Date(t);return e.format("yyyy-MM-dd")}Date.prototype.format=function(t){var e={"M+":this.getMonth()+1,"d+":this.getDate(),"h+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};for(var a in/(y+)/.test(t)&&(t=t.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length))),e)new RegExp("("+a+")").test(t)&&(t=t.replace(RegExp.$1,1==RegExp.$1.length?e[a]:("00"+e[a]).substr((""+e[a]).length)));return t}},7156:function(t,e,a){var n=a("861d"),r=a("d2bb");t.exports=function(t,e,a){var i,s;return r&&"function"==typeof(i=e.constructor)&&i!==a&&n(s=i.prototype)&&s!==a.prototype&&r(t,s),t}},ba4a:function(t,e,a){},babf:function(t,e,a){"use strict";a.r(e);var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"UserApply"}},[a("el-tabs",{staticStyle:{"margin-top":"30px"},attrs:{"tab-position":"left",stretch:!0},on:{"tab-click":function(e){t.currentTime=new Date}}},[a("el-tab-pane",{attrs:{label:"人员变动审核",lazy:!0}},[a("div",{attrs:{slot:"label"},slot:"label"},[t.statusCount?a("el-badge",{staticClass:"item",attrs:{value:t.statusCount}},[a("span",[t._v("人员变动审核")])]):a("div",{staticClass:"item"},[a("span",[t._v("人员变动审核")])])],1),a("DepartmentChangeManagement",{attrs:{"table-do-layout":t.currentTime},on:{getCount:t.getCount}})],1),a("el-tab-pane",{staticStyle:{"padding-left":"20px"},attrs:{label:"其他审批"}},[a("div",{staticStyle:{width:"inherit",padding:"20px 120px 20px 20px"}})])],1)],1)},r=[],i=a("f751"),s=a("1bab"),o={name:"UserApply",components:{DepartmentChangeManagement:i["a"]},data:function(){return{statusCount:0,currentTime:""}},methods:{getCount:function(){var t=this;Object(s["a"])({url:"data/applyManagement/toBeAddress",method:"post"}).then((function(e){t.statusCount=e.data}))}},activated:function(){this.getCount()}},l=o,c=a("2877"),u=Object(c["a"])(l,n,r,!1,null,"3ac557b1",null);e["default"]=u.exports},f751:function(t,e,a){"use strict";var n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{ref:"DepartmentChangeManagement",attrs:{id:"DepartmentChangeManagement"}},[a("div",{attrs:{id:"TableHeader"}},[a("el-button",{attrs:{size:"small"},on:{click:t.clearFilter}},[t._v("清除所有过滤器")]),a("el-button",{attrs:{size:"small",type:this.multipleSelection.length>0?"danger":""},on:{click:function(e){return t.batchHandle()}}},[t._v("批量审核 ")]),a("div",{staticStyle:{margin:"auto"}}),a("div",{attrs:{id:"FilterBar"}},[a("div",{staticClass:"filter-bar-item"},[a("span",{staticStyle:{"margin-right":"5px"}},[t._v("申请人")]),a("el-input",{attrs:{placeholder:"查询申请人id",size:"small"},model:{value:t.filter_transfer_id,callback:function(e){t.filter_transfer_id=t._n(e)},expression:"filter_transfer_id"}})],1),a("el-button",{attrs:{size:"small"},on:{click:t.getData}},[t._v("查询")])],1)],1),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],ref:"elementTable2",staticClass:"elementTable",attrs:{stripe:"",fit:"",height:670,"default-sort":{prop:"id",order:"ascending"},data:t.tableData},on:{"sort-change":t.sortChange,"filter-change":t.filterChange,"selection-change":t.selectionChange}},[a("el-table-column",{attrs:{type:"selection",selectable:t.checkSelectable,width:"55"}}),a("el-table-column",{attrs:{width:"60",type:"index"}}),a("el-table-column",{attrs:{"min-width":"60","column-key":"transfer_id",prop:"transfer_id",sortable:"custom",label:"申请人"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.transfer_id))])]}}])}),a("el-table-column",{attrs:{prop:"from_department","min-width":"60","column-key":"from_department",label:"原部门"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.from_department))])]}}])}),a("el-table-column",{attrs:{prop:"to_department","min-width":"60","column-key":"to_department",label:"新部门"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.to_department))])]}}])}),a("el-table-column",{attrs:{prop:"status",width:"100","column-key":"status",sortable:"custom",label:"状态"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-tag",{attrs:{type:t.tagColor(e.row.status),"disable-transitions":""}},[t._v(t._s(e.row.status)+" ")])]}}])}),a("el-table-column",{attrs:{prop:"created_by","column-key":"created_by",sortable:"custom",label:"操作人"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.created_by))])]}}])}),a("el-table-column",{attrs:{prop:"created_time","column-key":"created_time",sortable:"custom",label:"操作时间"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t.formatter(e.row.created_time)))])]}}])}),a("el-table-column",{attrs:{prop:"handled_by","column-key":"handled_by",sortable:"custom",label:"处理人"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(e.row.handled_by))])]}}])}),a("el-table-column",{attrs:{prop:"handled_time","column-key":"handled_time",sortable:"custom",label:"处理时间"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t.formatter(e.row.handled_time)))])]}}])}),a("el-table-column",{attrs:{fixed:"right",label:"操作",width:"160"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("div",{staticStyle:{display:"flex"}},[a("el-button",{attrs:{disabled:"待审核"!==e.row.status,type:"success",size:"mini"},nativeOn:{click:function(a){return a.preventDefault(),t.handleAgree(e.$index,e.row)}}},[t._v(" 同意 ")]),a("el-button",{attrs:{disabled:"待审核"!==e.row.status,type:"danger",size:"mini"},nativeOn:{click:function(a){return a.preventDefault(),t.handleDecline(e.$index,e.row)}}},[t._v(" 拒绝 ")])],1)]}}])})],1),a("el-pagination",{attrs:{id:"TablePagination",background:"",layout:"total,prev, pager, next,jumper,sizes",total:t.totalNum,"page-size":t.pageSize,"page-sizes":[15,30,50,100,99999],"current-page":t.pageNum},on:{"current-change":t.pageChange,"size-change":t.sizeChange,"update:currentPage":function(e){t.pageNum=e},"update:current-page":function(e){t.pageNum=e}}})],1)},r=[],i=(a("d3b7"),a("5060")),s={name:"DepartmentChangeManagement",components:{},data:function(){return{tableData:[],pageSize:30,pageNum:1,totalNum:50,loading:!1,mode:"update",multipleSelection:[],filter_transfer_id:"",sort:"created_time",sortMethod:"asc"}},created:function(){this.getData()},props:{tableDoLayout:Date},methods:{getData:function(){var t=this;this.$emit("getCount"),this.loading=!0;var e={filter_transfer_id:this.filter_transfer_id?this.filter_transfer_id:0,filter_created_by:"",status:[]};return e.pageSize=this.pageSize,e.pageNum=this.pageNum,e.sort=this.sort,e.sortMethod=this.sortMethod,Object(i["a"])(this,{url:"data/applyManagement/applyList",method:"post",data:e}).then((function(e){console.log(e.data);var a=e.data,n=a.total,r=a.applyList;t.tableData=r,t.totalNum=n})).finally((function(){t.loading=!1}))},formatter:function(t){return Object(i["b"])(t)},checkSelectable:function(t,e){return"待审核"===t.status},clearFilter:function(){this.filter_transfer_id=0,this.sort="created_time",this.sortMethod="asc",this.$refs.elementTable2.clearFilter(),this.getData()},sortChange:function(t){var e=t.column,a=t.prop,n=t.order;this.sort=a,this.sortMethod="descending"===n?"desc":"asc",console.log(e,a,n),this.getData()},filterChange:function(t){this.getData()},pageChange:function(t){this.pageNum=t,this.getData()},sizeChange:function(t){this.pageSize=t,this.pageNum=1,this.getData()},selectionChange:function(t){this.multipleSelection=t},batchHandle:function(){var t=this,e=this.multipleSelection;if(0!==e.length){var a=e.length;this.$confirm("确定审核选择的".concat(a,"个申请？"),"提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){var a=0;t.$confirm("是否同意申请？","提示",{confirmButtonText:"同意",cancelButtonText:"拒绝",type:"warning"}).then((function(){return a=1})).catch((function(){return a=0})).finally((function(){t.loading=!0;for(var n=[],r=0;r<e.length;r++)n.push({handled_id:123456789,apply_id:e[r].log_id,isAccept:a,user:t.$store.getters.userinfo});Object(i["a"])(t,{url:"data/applyManagement/applyAddress",method:"post",data:n}).catch((function(e){t.$message({type:"success",message:"操作成功!"}),t.multipleSelection=[],t.getData()}))})).finally((function(){t.loading=!1}))})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))}else this.$message.info("未选择任何申请")},handleAgree:function(t,e){this.currentObj=e,this.applyRequest(e.log_id,1)},handleDecline:function(t,e){this.currentObj=e,this.applyRequest(e.log_id,0)},applyRequest:function(t,e){var a=this;return Object(i["a"])(this,{url:"data/applyManagement/applySingleAddress",method:"post",data:{handled_id:123456789,apply_id:t,isAccept:e}}).then((function(t){})).catch((function(t){a.$message.success("操作成功"),a.getData()}))}},computed:{tagColor:function(){return function(t){return"同意"===t?"success":"拒绝"===t?"danger":"primary"}}},watch:{tableDoLayout:function(t){this.getData(),this.$refs.elementTable2.doLayout()}},activated:function(){this.getData(),this.$refs.elementTable2.doLayout()}},o=s,l=(a("0442"),a("2877")),c=Object(l["a"])(o,n,r,!1,null,"7a0d7c0c",null);e["a"]=c.exports}}]);
//# sourceMappingURL=chunk-5960a6ee.1f489e96.js.map