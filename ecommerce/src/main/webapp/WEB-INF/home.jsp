<%@ taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>  
<html>
<head>
<title> Checkout </title>
<style>
li{ display: inline-flex;
padding: 25px
}
section{
background-color: #607D8B;
width: 79%;
position: absolute;
height: 150px;
}
article{
width: 79%;
background-color: #607d8bc7;
position: absolute;
top: 368px;
height: 150px;
}
aside{
background-color: #607d8bde;
width: 20%;
position: absolute;
left: 80%;
height: 300px;
}
h2 , p {
text-align: center;
color: #fff;
}
ul{
text-align: center;
}
details {
margin-top: 330px;
width: 100%;
padding-top: 10px;
padding-bottom: 50px;
padding-left: 15px;
background-color: #607d8bdb;
}
details p {
font-size: 18px;
}
summary {
color: white;
font-size: 22px;
}
</style>
<link
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"  
        
      />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<header style = "height: 100px; width: 100%; background-color: #607D8B;" >
<h1 style=" color: #fff; text-align: center; padding-top: 25px; font-size: 30px;" class="animate__animated animate__backInRight" > Nesan Ecommerce Website </h1>
</header>
<nav style = "background-color: #607d8b9c;" >
<ul>
<li > <a  href = "" > Payment Details </a> </li>
<li> <a href = ""> Billing Details </a> </li>
<li> <a href = ""> Order Confirmation </a> </li>
</ul>
</nav>
<div class = "main">
<frm:form modelAttribute="mycustomer" method="post" action="/order" >  
<section>
<h2> Personal Details </h2>
   
    <table>
        <tr>
            <td>
                Age
            </td>
            <td>
                <frm:input path="age"/>
                
            </td>
        </tr>
        <tr>
            <td>
                Name
            </td>
            <td>
                <frm:input path="name" />
                <frm:errors path="name"  style=" color: rgb(255, 0, 0);"  />
            </td>
            <tr>
                <td colspan="2">
                   
                </td>
            </tr>


    </table>


<!-- <p> Some Text </p> -->
</section>
<article>
<h2> Billing Details</h2>
    
    <table>
        <tr>
            <td>
                Address
            </td>
            <td>
                <frm:input path="address"/>
                <frm:errors path="address"  style=" color: rgb(255, 0, 0);"  />
            </td>
        </tr>
        <tr>
            <td>
                Pincode
            </td>
            <td>
                <frm:input path="pincode"/>
                <frm:errors path="pincode"  style=" color: rgb(255, 0, 0);"  />
            </td>
        <tr>
            <td colspan="2">
               
            </td>
        </tr>

    </table>


</article>
<aside>
<h2> Cart </h2>
<p> This following Items will be sent to the submitted billing address </p>
<input type="checkbox" id="vehicle1" name="vehicle1" value="Bike" >
<label for="vehicle1"> Sony Bluetooth Headphones</label><br>
<input type="checkbox" id="vehicle2" name="vehicle2" value="Car">
<label for="vehicle2"> Iphone 10</label><br>
<input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
<label for="vehicle3">Samsung Powerbank</label><br>
</aside>
</div>
<details>
<summary> Summary: click here to show details </summary>
<p>
    <pre>


              ITEM                     COST 
    Sony Bluetooth Headphones -      3000  rs
    Iphone 10                 -    70,000  rs
    Samsung Powerbank         -      1000  rs

    Total Cost:                    74,000  rs
    </pre>
<input type="submit"  value="Proceed to Purchase"  class="btn btn-primary"> 
</frm:form>
</details>
<footer style = " height: 100px; background-color:#607D8B; width: 100%; text-align: center;">
<h3 style = " color: #fff; text-align: center; padding-top: 10px; font-size: 30px; " >${companyname}</h3>
<p> © Copyright 2021 </p>
</footer>
</body>
</html>