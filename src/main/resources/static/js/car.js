function getCarById(id) {
    var url = "/car/" + id;
    window.location.href = url;
}

function selectRentalOption(id) {
    var rentals = document.getElementsByClassName("rental-rate-option");
    for(var i=0; i < rentals.length; i++) {
        if(rentals[i].getAttribute("id") === id.toString()) {
            rentals[i].style.background= "linear-gradient(360deg, #ceced7, #1F9836FF)";
            document.getElementById("rental_id").value = id;
        }
        else {
            rentals[i].style.background= "linear-gradient(360deg, #ceced7, #e1b81b)";
        }
    }
}

function sendDataToOrder() {

    var car_id = document.getElementById("car_id").value;
    var rental_id = document.getElementById("rental_id").value;

    if(rental_id === "") {
        alert("Please choose one rental")
        return;
    }
    fetch("/order/create", {
        method: "POST",
        body: JSON.stringify({ car_id: car_id, rental_id: rental_id}),
        headers: { "Content-type": "application/json; charset=UTF-8", },
    }).then(response => {
        if(response.status === 409) {
            alert("Car is taken");
        }
        if (response.status === 403) {
            alert("Please login");
        }
        if (response.status === 200) {
            alert("thank for using our service");
        }
    })
}