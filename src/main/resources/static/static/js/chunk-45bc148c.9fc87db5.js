(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-45bc148c"],{5899:function(t,e){t.exports="\t\n\v\f\r                　\u2028\u2029\ufeff"},"58a8":function(t,e,r){var n=r("1d80"),a=r("5899"),o="["+a+"]",c=RegExp("^"+o+o+"*"),i=RegExp(o+o+"*$"),u=function(t){return function(e){var r=String(n(e));return 1&t&&(r=r.replace(c,"")),2&t&&(r=r.replace(i,"")),r}};t.exports={start:u(1),end:u(2),trim:u(3)}},7156:function(t,e,r){var n=r("861d"),a=r("d2bb");t.exports=function(t,e,r){var o,c;return a&&"function"==typeof(o=e.constructor)&&o!==r&&n(c=o.prototype)&&c!==r.prototype&&a(t,c),t}},"8f11":function(t,e,r){"use strict";r.d(e,"a",(function(){return o}));var n=r("bc3a"),a=r.n(n);function o(t){var e=a.a.create({});return e(t)}},a9e3:function(t,e,r){"use strict";var n=r("83ab"),a=r("da84"),o=r("94ca"),c=r("6eeb"),i=r("5135"),u=r("c6b6"),l=r("7156"),s=r("c04e"),f=r("d039"),d=r("7c73"),p=r("241c").f,m=r("06cf").f,b=r("9bf2").f,h=r("58a8").trim,v="Number",g=a[v],I=g.prototype,N=u(d(I))==v,w=function(t){var e,r,n,a,o,c,i,u,l=s(t,!1);if("string"==typeof l&&l.length>2)if(l=h(l),e=l.charCodeAt(0),43===e||45===e){if(r=l.charCodeAt(2),88===r||120===r)return NaN}else if(48===e){switch(l.charCodeAt(1)){case 66:case 98:n=2,a=49;break;case 79:case 111:n=8,a=55;break;default:return+l}for(o=l.slice(2),c=o.length,i=0;i<c;i++)if(u=o.charCodeAt(i),u<48||u>a)return NaN;return parseInt(o,n)}return+l};if(o(v,!g(" 0o1")||!g("0b1")||g("+0x1"))){for(var y,A=function(t){var e=arguments.length<1?0:t,r=this;return r instanceof A&&(N?f((function(){I.valueOf.call(r)})):u(r)!=v)?l(new g(w(e)),r,A):w(e)},E=n?p(g):"MAX_VALUE,MIN_VALUE,NaN,NEGATIVE_INFINITY,POSITIVE_INFINITY,EPSILON,isFinite,isInteger,isNaN,isSafeInteger,MAX_SAFE_INTEGER,MIN_SAFE_INTEGER,parseFloat,parseInt,isInteger".split(","),_=0;E.length>_;_++)i(g,y=E[_])&&!i(A,y)&&b(A,y,m(g,y));A.prototype=I,I.constructor=A,c(a,v,A)}},fa15:function(t,e,r){"use strict";r.r(e);var n=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{attrs:{id:"process"}},[r("el-table",{staticStyle:{"margin-left":"50px",width:"1270px"},attrs:{data:t.result,border:""}},[r("el-table-column",{attrs:{prop:"no",label:"生产过程单号"}}),r("el-table-column",{attrs:{prop:"step",label:"步骤序号"}}),r("el-table-column",{attrs:{prop:"materialArriveTime",label:"生产开始时间",formatter:t.timeFormat}}),r("el-table-column",{attrs:{prop:"demandQuantity",label:"所需数量"}}),r("el-table-column",{attrs:{prop:"producedQuantity",label:"完成数量"}}),r("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.materialArriveTime?e.row.materialArriveTime&&e.row.demandQuantity>e.row.producedQuantity?r("div",[r("el-input",{attrs:{type:"number",min:"1"},model:{value:t.count[e.row.id],callback:function(r){t.$set(t.count,e.row.id,r)},expression:"count[scope.row.id]"}}),r("el-button",{on:{click:function(r){return t.add(e.row.id,e.row.producedQuantity,e.row.demandQuantity)}}},[t._v(" 添加 ")])],1):r("div",[t._v("已完工！！")]):r("el-button",{on:{click:function(r){return t.begin(e.row.id)}}},[t._v(" 开始生产 ")])]}}])})],1)],1)},a=[],o=(r("fb6a"),r("a9e3"),r("2b0e")),c=r("8f11"),i={name:"Process",data:function(){return{result:{},planId:this.$route.params.id,count:{}}},watch:{"$route.params":function(t,e){this.planId=t.id}},activated:function(){var t=this;Object(c["a"])({url:"/process/getProcessesByPlan",params:{id:this.planId}}).then((function(e){t.result=e.data.result;for(var r=0;r<t.result.length;r++)o["default"].set(t.count,t.result[r].id,0)})).catch((function(t){console.log(t)}))},methods:{timeFormat:function(t,e){return t.materialArriveTime?t.materialArriveTime.slice(0,10):t.materialArriveTime},begin:function(t){var e=this;confirm("确认收到物料了？")&&Object(c["a"])({url:"/process/materialArrive",params:{id:t}}).then((function(t){console.log(t),Object(c["a"])({url:"/process/getProcessesByPlan",params:{id:e.planId}}).then((function(t){e.result=t.data.result;for(var r=0;r<e.result.length;r++)o["default"].set(e.count,e.result[r].id,0)})).catch((function(t){console.log("错误")}))})).catch((function(t){console.log("错误")}))},add:function(t,e,r){var n=this;e=Number(e),r=Number(r),Number(this.count[t])+e>r?alert("数量过多"):confirm("确定要增加："+this.count[t])&&Object(c["a"])({url:"/process/increaseProduct",params:{id:t,count:this.count[t]}}).then((function(t){console.log(t),Object(c["a"])({url:"/process/getProcessesByPlan",params:{id:n.planId}}).then((function(t){n.result=t.data.result;for(var e=0;e<n.result.length;e++)o["default"],set(n.count,n.result[e].id,0)})).catch((function(t){console.log(t)}))})).catch((function(t){console.log(t)}))}}},u=i,l=r("2877"),s=Object(l["a"])(u,n,a,!1,null,null,null);e["default"]=s.exports}}]);
//# sourceMappingURL=chunk-45bc148c.9fc87db5.js.map