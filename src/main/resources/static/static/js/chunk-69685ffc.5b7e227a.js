(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-69685ffc"],{"17a5":function(t,e,n){},"41a3":function(t,e,n){"use strict";var i=n("17a5"),a=n.n(i);a.a},4791:function(t,e,n){"use strict";n.d(e,"a",(function(){return o}));n("d3b7"),n("4f6c");var i=n("bc3a"),a=n.n(i);function o(t){return new Promise((function(e,n){var i=a.a.create({timeout:45e3});i(t).then((function(t){console.log("成功"),e(t)})).catch((function(t){console.log("失败"),n(t)}))}))}},"4f6c":function(t,e,n){"use strict"},"89d7":function(t,e,n){"use strict";n.r(e);var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"theBaseMainBox"}},[n("div",{staticStyle:{width:"80%",height:"auto","margin-bottom":"20px","margin-left":"70px"}},[n("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":t.activeIndex,mode:"horizontal",router:!0,"unique-opened":!0},on:{select:t.handleSelect}},[n("el-menu-item",{attrs:{index:"/work/apply/workshopInfo"}},[t._v("车间信息")]),n("el-menu-item",{attrs:{index:"/work/apply/lineInfo"}},[t._v("产线信息")]),n("el-menu-item",{attrs:{index:"/work/apply/stationInfo"}},[t._v("工位信息")])],1)],1),n("div",{attrs:{id:"theBaseMain"}},[n("router-view")],1)])},a=[],o=n("4791"),c={name:"applyPro",data:function(){return{activeIndex:"1",loading:!1,path:""}},activated:function(){this.$router.push(this.path)},created:function(){},beforeRouteLeave:function(t,e,n){this.path=this.$route.path,n()},methods:{handleSelect:function(t,e){this.$emit("routes",e)},getData:function(){Object(o["a"])({url:"workshop/apply",methods:"get"}).then((function(t){})).catch((function(t){}))},preclick:function(t){var e=this;this.page.curpage=t,this.loading=!0,setTimeout((function(){e.getData(),e.loading=!1}),1e3)},nextclick:function(t){var e=this;this.page.curpage=t,this.loading=!0,setTimeout((function(){e.getData(),e.loading=!1}),1e3)},curChange:function(t){var e=this;this.page.curpage=t,this.loading=!0,setTimeout((function(){e.getData(),e.loading=!1}),1e3)}}},u=c,r=(n("41a3"),n("2877")),s=Object(r["a"])(u,i,a,!1,null,"6e3678e3",null);e["default"]=s.exports}}]);
//# sourceMappingURL=chunk-69685ffc.5b7e227a.js.map