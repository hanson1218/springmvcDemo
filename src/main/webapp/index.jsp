<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/core.js"></script>
	<script src="http://cdn.bootcss.com/vue/2.1.10/vue.js"></script>
	<script src="http://cdn.bootcss.com/vue-router/2.2.0/vue-router.js"></script>
	<script src="http://cdn.bootcss.com/vue-resource/1.1.0/vue-resource.js"></script>
	<div id="app">
		<p>{{ message }}</p>
	</div>

	<script>
		new Vue({
			el : '#app',
			data : {
				message : 'Hello Vue.js!'
			}
		})
	</script>

	<div id="vue_det">
		<h5>site : {{site}}</h5>
		<h5>url : {{url}}</h5>
		<h5>{{details()}}</h5>
		<
	</div>
	<script type="text/javascript">
    var vm = new Vue({
        el: '#vue_det',
        data: {
            site: "菜鸟教程",
            url: "www.runoob.com",
            alexa: "10000"
        },
        methods: {
            details: function() {
                return  this.site + " - test";
            }
        }
    })
    
</script>
</body>
</html>