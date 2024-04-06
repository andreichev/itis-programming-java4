<html lang="en">

<head>
    <title>Welcome to AHMED!</title>
    <link rel="stylesheet" href="/res/style.css">
</head>

<body>
<h1>SIGN IN</h1>
<#if error?? && error=='true'>
    <div class="error">AHMED!</div>
</#if>
<form method="post">
    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password">
    <input type="submit" value="SUBMIT">
</form>

<a href="/sign-up">SIGN UP</a>
</body>