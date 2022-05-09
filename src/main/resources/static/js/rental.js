function minutesClick() {

    var measurement = document.getElementById("measurement");
    var minute = document.getElementById("minutes_header");
    var hour = document.getElementById("hours_header");
    var day = document.getElementById("days_header");
    var allItems = document.getElementsByClassName("rental-rate-row")

    measurement.textContent = "minutes";
    minute.style.color="white";
    hour.style.color="#383456";
    day.style.color="#383456";

    for(var i=0; i<allItems.length; i++) {
        if(allItems[i].getAttribute("name") === "minutes") {
            allItems[i].style.visibility="visible";
            allItems[i].style.position="relative";
        }
        else {
            allItems[i].style.visibility="hidden";
            allItems[i].style.position="absolute";
        }
    }
}

function hoursClick() {

    var measurement = document.getElementById("measurement");
    var minute = document.getElementById("minutes_header");
    var hour = document.getElementById("hours_header");
    var day = document.getElementById("days_header");
    var allItems = document.getElementsByClassName("rental-rate-row")

    measurement.textContent = "hours";
    hour.style.color="white";
    minute.style.color="#383456";
    day.style.color="#383456";

    for(var i=0; i<allItems.length; i++) {
        if(allItems[i].getAttribute("name") === "hours") {
            allItems[i].style.visibility="visible";
            allItems[i].style.position="relative";
        }
        else {
            allItems[i].style.visibility="hidden";
            allItems[i].style.position="absolute";
        }
    }
}

function daysClick() {

    var measurement = document.getElementById("measurement");
    var minute = document.getElementById("minutes_header");
    var hour = document.getElementById("hours_header");
    var day = document.getElementById("days_header");
    var allItems = document.getElementsByClassName("rental-rate-row")

    measurement.textContent = "days";
    day.style.color="white";
    minute.style.color="#383456";
    hour.style.color="#383456";

    for(var i=0; i<allItems.length; i++) {
        if(allItems[i].getAttribute("name") === "days") {
            allItems[i].style.visibility="visible";
            allItems[i].style.position="relative";
        }
        else {
            allItems[i].style.visibility="hidden";
            allItems[i].style.position="absolute";
        }
    }
}