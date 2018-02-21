<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<<TITLE>Adam Web</TITLE>
<SCRIPT language="javascript">
    function addRow(tableID) {

        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        var counts=rowCount-1;
  
        var cell1 = row.insertCell(0);
        var id = document.createElement("input");
        id.type = "number";
        id.name="user.persons["+counts+"].id";
        cell1.appendChild(id);

        var cell2 = row.insertCell(1);
        var last_name = document.createElement("input");
        last_name.type = "text";
        last_name.name="user.persons["+counts+"].last_name";
        cell2.appendChild(last_name);

        var cell3 = row.insertCell(2);
        var first_name = document.createElement("input");
        first_name.type = "text";
        first_name.name="user.persons["+counts+"].first_name";
        cell3.appendChild(first_name);
  
        var cell4 = row.insertCell(3);
        var email = document.createElement("input");
        email.type = "email";
        email.name="user.persons["+counts+"].email";
        cell4.appendChild(email);

    }
</SCRIPT>
</head>
 
<body>
<h2>Persons</h2>
<s:actionerror />
<s:form action="login.action" method="post">
Persons :
<TABLE id="personsTable" width="350px" border="1">
    <TR>
        <TD>ID</TD>
        <TD>Last Name</TD>
        <TD>First Name</TD>
        <TD>Email</TD>
    </TR>
    <TR>
        <TD><INPUT type="number" name="user.persons[0].id" /></TD>
        <TD><INPUT type="text" name="user.persons[0].last_name" /></TD>
        <TD><INPUT type="text" name="user.persons[0].first_name" /></TD>
        <TD><INPUT type="email" name="user.persons[0].email" /></TD>
    </TR>
</TABLE>
<INPUT type="button" value="Add More" onclick="addRow('personsTable')" />
    <s:submit method="execute" key="label.login" align="center" />
</s:form>
</body>
</html>