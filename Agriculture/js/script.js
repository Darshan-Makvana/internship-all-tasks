// Search Functionality for Products Page
document.addEventListener("DOMContentLoaded", () => {
    const searchBar = document.getElementById("searchBar");
    if (searchBar) {
        searchBar.addEventListener("keyup", function () {
            let filter = this.value.toLowerCase();
            let products = document.querySelectorAll(".product");
            products.forEach(product => {
                let text = product.innerText.toLowerCase();
                product.style.display = text.includes(filter) ? "" : "none";
            });
        });
    }
});
