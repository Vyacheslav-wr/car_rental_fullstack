function changePageTo2() {

    var div1 = document.getElementsByClassName("first_page").item(0);
    var div2 = document.getElementsByClassName("second_page").item(0);
    var backButton = document.getElementsByClassName("back_button").item(0);
    var nextButton = document.getElementsByClassName("next_button").item(0);
    var regButton = document.getElementsByClassName("reg_button").item(0);
    var username = document.getElementById("username");
    var pass = document.getElementById("password");
    var rep_pass = document.getElementById("repeat_password");
    var email = document.getElementById("email");

    if (username.value == "") {
        toastr.options.positionClass = "toast-bottom-right";
        toastr.warning("Username must not be null");
        return false;
    }
    if (pass.value == "") {
        toastr.options.positionClass = "toast-bottom-right";
        toastr.warning("Password must not be null");
        return false;
    }

    if (email.value == "") {
        toastr.options.positionClass = "toast-bottom-right";
        toastr.warning("Email must not be null");
        return false;
    }

    if (pass.value !== rep_pass.value) {
        toastr.options.positionClass = "toast-bottom-right";
        toastr.warning("Passwords must equal");
        return false;
    }


    div1.style.visibility = "hidden";
    div1.style.position = "absolute";
    div2.style.visibility = "visible";
    div2.style.position = "relative";
    backButton.style.visibility = "visible";
    nextButton.style.visibility = "hidden";
    regButton.style.visibility = "visible";
    backButton.style.position = "relative";
    regButton.style.position = "relative";
    nextButton.style.position = "absolute";

    return true;
}

function changePageTo1() {

    var div1 = document.getElementsByClassName("first_page").item(0);
    var div2 = document.getElementsByClassName("second_page").item(0);
    var backButton = document.getElementsByClassName("back_button").item(0);
    var nextButton = document.getElementsByClassName("next_button").item(0);
    var regButton = document.getElementsByClassName("reg_button").item(0);

    div2.style.visibility = "hidden";
    div2.style.position = "absolute";
    div1.style.visibility = "visible";
    div1.style.position = "relative";
    backButton.style.visibility = "hidden";
    nextButton.style.visibility = "visible";
    regButton.style.visibility = "hidden";
    backButton.style.position = "absolute";
    regButton.style.position = "absolute";
    nextButton.style.position = "relative";
}