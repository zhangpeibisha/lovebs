webpackJsonp([3],{SzKx:function(e,s){},ZPM0:function(e,s,t){"use strict";Object.defineProperty(s,"__esModule",{value:!0});var i={props:{question:{type:Object,required:!0},qIndex:{type:Number,required:!0}},data:function(){return{chooseId:""}},methods:{answer:function(e){console.log("eeee",e),console.log("this.question",this.question),this.$parent.answer({questionnaireEnum:this.question.questionnaireType,questionId:this.question.id,title:this.question.title,suggest:e.target.value})},radioChoose:function(){this.$parent.answer({questionnaireEnum:this.question.questionnaireType,questionId:this.question.id,title:this.question.title,chooseId:this.chooseId})},checkboxChoose:function(){var e="";this.question.items.filter(function(e){return e.choose}).forEach(function(s){e+=s.id+","}),this.$parent.answer({questionnaireEnum:this.question.questionnaireType,questionId:this.question.id,title:this.question.title,chooseId:e.length>0?e.substring(0,e.length-1):e})}}},o={render:function(){var e=this,s=e.$createElement,t=e._self._c||s;return t("li",[t("div",{staticClass:"content"},[t("p",[e._v(e._s(e.question.title))]),e._v(" "),"text"!==e.question.questionnaireType?t("ol",{staticClass:"answers"},e._l(e.question.items,function(s){return t("li",{staticClass:"answer"},["checkbox"===e.question.questionnaireType&&"checkbox"==e.question.questionnaireType?t("input",{directives:[{name:"model",rawName:"v-model",value:s.choose,expression:"answer.choose"}],staticClass:"select",attrs:{name:e.question.id,type:"checkbox"},domProps:{value:""+s.id,checked:Array.isArray(s.choose)?e._i(s.choose,""+s.id)>-1:s.choose},on:{change:[function(t){var i=s.choose,o=t.target,n=!!o.checked;if(Array.isArray(i)){var a=""+s.id,c=e._i(i,a);o.checked?c<0&&e.$set(s,"choose",i.concat([a])):c>-1&&e.$set(s,"choose",i.slice(0,c).concat(i.slice(c+1)))}else e.$set(s,"choose",n)},e.checkboxChoose]}}):"radio"===e.question.questionnaireType&&"checkbox"==e.question.questionnaireType?t("input",{directives:[{name:"model",rawName:"v-model",value:s.choose,expression:"answer.choose"}],staticClass:"select",attrs:{name:e.question.id,type:"radio"},domProps:{value:""+s.id,checked:e._q(s.choose,""+s.id)},on:{change:[function(t){e.$set(s,"choose",""+s.id)},e.checkboxChoose]}}):"checkbox"==e.question.questionnaireType?t("input",{directives:[{name:"model",rawName:"v-model",value:s.choose,expression:"answer.choose"}],staticClass:"select",attrs:{name:e.question.id,type:e.question.questionnaireType},domProps:{value:""+s.id,value:s.choose},on:{change:e.checkboxChoose,input:function(t){t.target.composing||e.$set(s,"choose",t.target.value)}}}):e._e(),e._v(" "),"checkbox"===e.question.questionnaireType&&"radio"==e.question.questionnaireType?t("input",{directives:[{name:"model",rawName:"v-model",value:e.chooseId,expression:"chooseId"}],staticClass:"select",attrs:{name:e.question.id,type:"checkbox"},domProps:{value:""+s.id,checked:Array.isArray(e.chooseId)?e._i(e.chooseId,""+s.id)>-1:e.chooseId},on:{change:[function(t){var i=e.chooseId,o=t.target,n=!!o.checked;if(Array.isArray(i)){var a=""+s.id,c=e._i(i,a);o.checked?c<0&&(e.chooseId=i.concat([a])):c>-1&&(e.chooseId=i.slice(0,c).concat(i.slice(c+1)))}else e.chooseId=n},e.radioChoose]}}):"radio"===e.question.questionnaireType&&"radio"==e.question.questionnaireType?t("input",{directives:[{name:"model",rawName:"v-model",value:e.chooseId,expression:"chooseId"}],staticClass:"select",attrs:{name:e.question.id,type:"radio"},domProps:{value:""+s.id,checked:e._q(e.chooseId,""+s.id)},on:{change:[function(t){e.chooseId=""+s.id},e.radioChoose]}}):"radio"==e.question.questionnaireType?t("input",{directives:[{name:"model",rawName:"v-model",value:e.chooseId,expression:"chooseId"}],staticClass:"select",attrs:{name:e.question.id,type:e.question.questionnaireType},domProps:{value:""+s.id,value:e.chooseId},on:{change:e.radioChoose,input:function(s){s.target.composing||(e.chooseId=s.target.value)}}}):e._e(),e._v(" "),t("div",{staticClass:"option"},[t("div",{staticClass:"input-fix"},[t("p",[e._v(e._s(s.title))])])])])})):e._e(),e._v(" "),"text"===e.question.questionnaireType?t("div",{staticClass:"option"},[t("textarea",{staticClass:"textarea",on:{change:function(s){e.answer(s)}}})]):e._e()]),e._v(" "),t("div",{staticClass:"side"},[t("div",{staticClass:"order"},[e._v("Q"+e._s(e.qIndex+1))])])])},staticRenderFns:[]};var n=t("VU/8")(i,o,!1,function(e){t("SzKx")},"data-v-7257caec",null).exports,a=t("NoTa"),c=t("UDO9"),r=t("l2la"),u=t("Ozlq"),d={data:function(){window.sessionStorage.getItem("edit-mode")?window.sessionStorage.getItem("edit-mode"):("create",window.sessionStorage.setItem("edit-mode","create"));return{title:"评教卷题目",questions:[],showAlert:!1,publish:!1,showModal:!1,routerCanDeactivate:!1,expires:"",qnId:-1,isLoading:!1,answers:{questionReplies:[]},publishId:-1}},computed:{},methods:{saveData:function(){var e=this;this.answers.status="commit",this.answers.studentId="",Object(u.c)({publisId:this.publishId},this.answers).then(function(s){console.log("提交返回结果",s),e.$message({message:"恭喜你，提交评教卷成功",type:"success"}),e.$router.push({path:"/home"})})},answer:function(e){console.log("a==",e),1==this.answers.questionReplies.filter(function(s){return s.questionId==e.questionId}).length?this.answers.questionReplies=this.answers.questionReplies.map(function(s){return s.questionId==e.questionId?e:s}):this.answers.questionReplies.push(e)},transposition:function(e,s,t){var i=e.splice(s,1)[0];e.splice(t,0,i)},saveBtnHandler:function(){this.saveData()},getParams:function(){this.publishId=this.$route.query.publishEvaluationId,console.log("获取到的发布id为==========",this.publishId)},findEvaluationById:function(e){var s=this;Object(u.f)(e).then(function(e){if(console.log("查询评教卷信息",e),200===e.code){var t=e.data;s.questions=t.content.questions,s.title=t.title,s.author=t.author}})},findPublishQuestionById:function(){var e=this;console.log("获取到的发布id为",this.publishId),Object(u.g)(this.publishId).then(function(s){var t=s.data;console.log("获取到的data为",s),e.findEvaluationById(t.questionnaireid)})}},created:function(){this.getParams(),this.findPublishQuestionById()},components:{Question:n,Calendar:a.a,Alert:c.a,Modal:r.a},route:{canDeactivate:function(){return!!this.canDeactivate||(this.showModal=!0,!1)}}},l={render:function(){var e=this,s=e.$createElement,t=e._self._c||s;return t("div",{staticClass:"layout"},[t("div",{staticClass:"qn-wrap"},[t("div",{staticClass:"qn"},[t("header",{staticClass:"header"},[t("p",{staticClass:"title"},[e._v(e._s(e.title))])]),e._v(" "),t("div",{staticClass:"body"},[t("div",{staticClass:"body-wrap"},[0!==e.questions.length?t("ol",{staticClass:"questions"},e._l(e.questions,function(e,s){return t("question",{tag:"li",staticClass:"question",attrs:{"track-by":"$index",qIndex:s,question:e}})})):e._e()])]),e._v(" "),t("footer",{staticClass:"footer"},[t("div",{staticClass:"pick-date"}),e._v(" "),t("div",{staticClass:"operation"},[t("span",{staticClass:"btn",class:{disabled:e.isLoading},on:{click:e.saveData}},[e._v("提交评教卷")])])])])])])},staticRenderFns:[]};var h=t("VU/8")(d,l,!1,function(e){t("aoYh")},null,null);s.default=h.exports},aoYh:function(e,s){}});
//# sourceMappingURL=3.a18e76499aea547ff8b5.js.map