<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>  
<html>
    <body>
    <h1>Student Entry Form</h1>
    <!--action tell which url or file to sed the form data when the form is submitted (through submit button) -->
    <frm:form method="post" action="/registerstudentcomplete" modelAttribute="mystudent">     <!--model Attribute specifys name of model object that backs this form  -->
    <table>
        <tr>
            <td>
                Student ID
            </td>
            <td>
                <frm:input path="stuID"/>
            </td>
        </tr>
        <tr>
            <td>
                Student Name
            </td>
            <td>
                <frm:input path="stuName"/>
            </td>
        </tr>
        <tr>
            <td>
                Student Email
            </td>
            <td>
                <frm:input path="stuEmail"/>
            </td>
        </tr>
        <tr>
            <td>
               Student Age
            </td>
            <td>
                <frm:input path="stuAge"/>
            </td>
        </tr>
        <tr>
            

        <tr>
            <td colspan="2">
                <input type="submit" value="Add Student"> 
            </td>
        </tr>


    </table>

    </frm:form>




    </body> 
</html>