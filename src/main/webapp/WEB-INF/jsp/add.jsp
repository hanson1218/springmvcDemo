<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <form action="./add" method="post">  
    <table align="center" border="1" width="350">  
        <tr>  
            <td class="2" align="center" colspan="2">  
                <h2>添加用户信息</h2>  
            </td>  
        </tr>  
        <tr>  
            <td align="right">姓名：</td>  
            <td>  
                <input type="text" name="name">  
            </td>  
        </tr>  
        <tr>  
            <td align="right">国家：</td>  
            <td>  
                <input type="text" name="country">  
            </td>  
        </tr>  
        <tr>  
            <td align="right">性别：</td>  
            <td>  
                <input type="text" name="sex">  
            </td>  
        </tr>  
        <tr>  
            <td class="2" align="center" colspan="2">  
                <input type="submit" value="添　加">  
            </td>  
        </tr>  
    </table>  
</form>  

</body>
</html>