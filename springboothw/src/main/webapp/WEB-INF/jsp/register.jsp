<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>  
<html>
    <body>
    <h1>Customer Entry Form</h1>
    <!--action tell which url or file to sed the form data when the form is submitted (through submit button) -->
    <frm:form method="post" action="/registercomplete" modelAttribute="mycustomer">     <!--model Attribute specifys name of model object that backs this form  -->
    <table>
        <tr>
            <td>
                Customer ID
            </td>
            <td>
                <frm:input path="id"/>
            </td>
        </tr>
        <tr>
            <td>
                Name
            </td>
            <td>
                <frm:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                Email
            </td>
            <td>
                <frm:input path="email"/>
            </td>
        </tr>
        <tr>
            <td>
                Age
            </td>
            <td>
                <frm:input path="age"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Add Customer"> 
            </td>
        </tr>


    </table>

    </frm:form>




    </body> 
</html>