function sendDataToFinish() {

    var order_id = document.getElementById("order-id").value;
    var auth_id = document.getElementById("auth-id").value;

    fetch("/order/finish", {
        method: "POST",
        body: JSON.stringify({ order_id: order_id}),
        headers: { "Content-type": "application/json; charset=UTF-8", },
    }).then( response => {
        if(response.status === 200) {
            toastr.options.positionClass = "toast-bottom-right";
            toastr.success("Order finally done");
            setTimeout(() => { location.reload() }, 1000);
        }
    })
}