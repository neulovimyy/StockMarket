function onload() {
    let stockValue = document.getElementById('stockValue').val();
    let min = 10;
    let max = 40;
    let stockValue;
    let randomDecision = Math.random() * (2 - 1) + 1;

    switch (randomDecision) {
        case 1:
            stockValue -= (Math.random() * (max - min + 1));
            break;
        case 2:
            stockValue += (Math.random() * (max - min + 1))
            break;
        default:
            console.log("weird");
            break;
    }

    document.getElementById('stockValue').value = stockValue;
}