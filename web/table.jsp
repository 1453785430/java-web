<%@ page import="java.util.List" %>
<%@ page import="com.web.entity.SysRegion" %>
<%--
  Created by IntelliJ IDEA.
  User: 14537
  Date: 2023/5/26
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>

<body>
<table>
    <thead>
    <tr>
        <th>Code</th>
        <th>名字</th>
        <th>简称</th>
        <th>地区编码</th>
        <th>级别</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<SysRegion> list = (List<SysRegion>) request.getAttribute("list");
        for (SysRegion sysRegion : list) {
            request.setAttribute("sysRegion", sysRegion);
    %>
    <tr>
        <td>${sysRegion.regionId}</td>
        <td>${sysRegion.regionName}</td>
        <td>${sysRegion.regionShortName}</td>
        <td>${sysRegion.regionCode}</td>
        <td>
            <c:if test="${sysRegion.regionLevel == 1}">
                省|直辖市
            </c:if>
            <c:if test="${sysRegion.regionLevel == 2}">
                市|地级市
            </c:if>
            <c:if test="${sysRegion.regionLevel == 3}">
                区|县
            </c:if>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>


<div>当前第${pageIndex}页:共${pageCount}页 总记录数:${count} <br>
    <div style="display: flex">

        <button id="shouYe">首页</button>

        <button id="up" onclick="paging(1)">上一页</button>

        <div
                id="skip_box">

        </div>

        <button id="down" onclick="paging(2)">下一页</button>

        <button id="weiYe">尾页</button>
    </div>
</div>

<div style="margin-top: 10px">
    <%--
        c:forEach 属性介绍
        begin 开始位
        end 结束位
        var 迭代变量(存放到page作用域中)
    --%>
    <c:forEach begin="1" end="9" var="i">
        <c:forEach begin="1" end="${i}" var="j">
            ${j}*${i}=${i*j}&nbsp;&nbsp;
        </c:forEach>
        <br>
    </c:forEach>

</div>
</body>
<script type="text/javascript">
    window.onload = function () {
        let up = document.getElementById("up");
        let down = document.getElementById("down");
        let pageIndex = ${pageIndex};
        if (pageIndex <= 1) {
            up.style.display = "none";
        }
        if (pageIndex >= ${pageCount}) {
            down.style.display = "none";
        }
        showSkip();

    }

    function paging(type) {
        let pageIndex = ${pageIndex};
        if (type == 1) {
            pageIndex--;
        } else {
            pageIndex++;
        }
        location.href = "paging.do?pageIndex=" + pageIndex;
    }

    function showSkip() {
        let pageCount =${pageCount};
        let pageIndex =${pageIndex};
        let skipBox = document.getElementById("skip_box");
        let a;
        if (pageCount <= 9) {
            a = pageCount;
            aaa(a, skipBox);
        } else {
            a = 9;
            if (pageIndex > 5) {
                bbb(pageCount, pageIndex, skipBox)
            } else {
                aaa(a, skipBox);
            }
        }


    }

    function aaa(count, skipBox) {
        for (let i = 1; i <= count; i++) {
            if (i ==${pageIndex}) {
                addBtn(i, skipBox, 1)
            } else {
                addBtn(i, skipBox)
            }

        }
    }

    function bbb(pageCount, pageIndex, skipBox) {
        let mid = 5;
        if (pageIndex >= mid) {
            mid = pageIndex;
        }
        skipBox.innerText = "";
        for (let i = 4; i >= 1; i--) {
            addBtn((mid - i), skipBox);
        }
        addBtn(mid, skipBox, 1);
        for (let i = 1; i <= 4; i++) {
            if (mid + i > pageCount) {
                break;
            }
            addBtn((mid + i), skipBox);
        }
    }

    function addBtn(value, skipBox, gl) {
        let btn = document.createElement("button");
        btn.innerText = value;
        if (gl) {
            btn.style.backgroundColor = "red";
            btn.style.color = "#e56969";
        }
        btn.onclick = function () {
            location.href = "paging.do?pageIndex=" + value;
        }
        skipBox.appendChild(btn);
    }
</script>
</html>
