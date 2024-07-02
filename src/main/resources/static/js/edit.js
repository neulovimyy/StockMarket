document.addEventListener('DOMContentLoaded', function() {
    // Function to generate a random number within a range
    function getRandomNumber(min, max) {
        return Math.ceil(Math.random() * (max - min + 1) + min);
    }

    // Set a random value to the stockValue input field
    let value = document.getElementById('stockValue').value;
    let randomStockValue = getRandomNumber(50, 1000); // Example: Random number between 1 and 100

    console.log(Number((Number(value) + Number(randomStockValue)) % 2));
    console.log(Number((Number(value) + Number(randomStockValue)) % 2));
    document.getElementById('stockValue').value = Number(randomStockValue) % 2 === 0 ?
        Number(value) + Number(randomStockValue) : Number(value) - Number(randomStockValue);

    // Automatically submit the form after 2 seconds
    setTimeout(function() {
        document.getElementById('stockForm').submit();
    }, 100); // 2000 milliseconds = 2 seconds
});